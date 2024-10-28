package com.neshy;

import com.neshy.utils.stringutils.Console;
import com.neshy.utils.stringutils.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import com.google.gson.Gson;

class SqliteElements {

    private String[] columns = null;
    private Gson gson = new Gson();
    private String json = null;

    public SqliteElements(Sqlite instance) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("database/database.json"));

            SqliteElements unserializedSqlite = gson.fromJson(reader, SqliteElements.class);

            this.columns = unserializedSqlite.columns;

            Console.print(columns);

        } catch(IOException e) {
            Console.printf("error: '%s'", e.getMessage());
            this.writeJson("");
        }
    }

    void writeJson(String json) {
            
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("database/database.json"));
            writer.write(json);
            writer.close();

        } catch(IOException e) {
            Console.printf("error: '%s'", e.getMessage());
        }

    }
}

public class Sqlite {
    
    private boolean connected = false;
    private Connection con = null;
    
    private final SqliteElements elements;

    public Sqlite(String databaseName) {

        String url = "jdbc:sqlite:" + databaseName;

        try {
            this.con = DriverManager.getConnection(url);
            if (con != null) {
                Console.printf("Connected to the database");
                this.connected = true;
            }
        } catch (Exception e) {
            Console.printf("SQLITE error: '%s'", e.getMessage());
        }

        elements = new SqliteElements(this);
    }

    public boolean isConnected() {
        return this.connected;
    }

    public boolean newTable(String name, String columns) throws SQLException
    {
        String query = String.format("CREATE TABLE %s (%s);", name, columns);

        Console.printf("executing query '%s'", query);

        Statement stmt = con.createStatement();

        try {

            stmt.execute(query);
            Console.printf("query '%s' successfully executed", query);
            return true;

        } catch(SQLException e) {

            Console.printf("sql error: '%s'", e.getMessage());
            e.printStackTrace();
            return false;

        }
    }

    public boolean insert(String table, String columns, Object... values) throws SQLException
    {
        String query = String.format("INSERT INTO %s (%s) VALUES (%s);", table, columns, StringUtils.repeat("?", StringUtils.COMMA, values.length));
        
        return true;
    }

    public ResultSet query(String q) throws SQLException
    {
        Console.printf("executing query '%s'", q);

        Statement stmt = con.createStatement();

        try {

            ResultSet result = stmt.executeQuery(q);
            Console.printf("query '%s' successfully executed", q);
            return result;

        } catch(SQLException e) {

            Console.printf("sql error: '%s'", e.getMessage());
            e.printStackTrace();
            return null;

        }
    }

    public ResultSet query(String query, Object... args) throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement(query);
        
        int parameterCount = 0;

        for(Object obj : args) {

            if(obj instanceof String) {
                stmt.setString(++parameterCount, (String) obj);
            } else if(obj instanceof Integer) {
                stmt.setInt(++parameterCount, (int) obj);
            } else if(obj instanceof Double) {
                stmt.setDouble(++parameterCount, (double) obj);
            } else if(obj instanceof Float) {
                stmt.setFloat(++parameterCount, (float) obj);
            } else if(obj instanceof Long) {
                stmt.setLong(++parameterCount, (long) obj);
            } else if(obj instanceof Boolean) {
                stmt.setBoolean(++parameterCount, (boolean) obj);
            } else {
                Console.printf("error: unknown type '%s'", obj.getClass().getName());
            }
        }

        return stmt.executeQuery();
    }

    public void printresult(ResultSet rs) throws SQLException
    {
        while (rs.next()) {
            Console.printf("id: %d, name: %s, age: %d", rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
        }
    }
}
