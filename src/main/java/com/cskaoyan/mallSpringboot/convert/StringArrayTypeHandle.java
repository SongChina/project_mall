package com.cskaoyan.mallSpringboot.convert;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.json.JSONArray;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes({String[].class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class StringArrayTypeHandle extends BaseTypeHandler<String[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer();
        for (String value : strings) {
            sb.append(value).append(",");
        }
        String substring = sb.substring(0, sb.length() - 1);
        preparedStatement.setString(i, substring);
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return transferString2StringArray(string);
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return transferString2StringArray(string);
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return transferString2StringArray(string);
    }

    private String[] transferString2StringArray(String string){
        String substring = string.substring(1, string.length() - 1);
        String[] strings = substring.split(",");
        return strings;
    }
}
