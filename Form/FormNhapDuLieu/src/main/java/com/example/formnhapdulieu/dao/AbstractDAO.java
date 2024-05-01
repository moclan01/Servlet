package com.example.formnhapdulieu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractDAO<T> {
    public String table;
    public String sql;
    public ConnectDB jdbi;

    public Connection connection;

    public AbstractDAO(String table) {
        this.table = table;
        this.sql = "";
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public ConnectDB getJdbi() {
        return jdbi;
    }

    public void setJdbi(ConnectDB jdbi) {
        this.jdbi = jdbi;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void insert(T model) {
        try {
            jdbi.getJdbi().useHandle(handle -> {
                String sql = "INSERT INTO " + getTable() + "(";
                Map<String, Object> values = getValuesFromModel(model);
                List<String> columns = new ArrayList<String>();
                boolean result;
                boolean isHaveIsField = false;

                for (String column : values.keySet()) {
                    if (!column.equals("id")) {
                        sql += column + ", ";
                        columns.add(column);
                    } else if (isHaveIsField) {
                        isHaveIsField = true;
                    }
                }

                sql = sql.substring(0, sql.length() - 2) + ") values (";
                int size = isHaveIsField ? values.size() - 1 : values.size();
                for (int i = 0; i < size; i++) {
                    sql += "?, ";
                }

                sql = sql.substring(0, sql.length() - 2) + ")";

                PreparedStatement stmt = null;
                try {
                    stmt = handle.getConnection().prepareStatement(sql);
                    for(int i = 0; i < columns.size();i++){
                        stmt.setObject(i+1, values.get(columns.get(i)));
                    }
                    stmt.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected abstract Map<String, Object> getValuesFromModel(T model);
}
