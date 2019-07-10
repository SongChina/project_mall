package com.cskaoyan.mallSpringboot.converter;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class stringArrayTypeHandler implements TypeHandler<String[]> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] string1, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer();
        for (String s : string1) {
            sb.append(s).append(",");

        }
        String substring = sb.substring(0, sb.length() - 1);
        preparedStatement.setString(i, substring);

    }

    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return transString2StringArray(string);
    }

    @Override
    public String[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return transString2StringArray(string);
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return transString2StringArray(string);
    }

    private String[] transString2StringArray(String string) {
        String s = string.toString().replace("[", "");
        String replace = s.toString().replace("]", "");
        String[] s1 = replace.split(",");

        return s1;
    }
}
