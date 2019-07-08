package com.cskaoyan.mallSpringboot.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {
    //将String[]转化成String
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
       // strings.toString()
        StringBuffer stringBuffer = new StringBuffer();

        for (String string : strings) {
            stringBuffer.append(string).append(",");
        }
        String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
        preparedStatement.setString(i, substring);

    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String q = resultSet.getString(s);
        return transferString2StringArray(q);
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String q = resultSet.getString(i);
        return transferString2StringArray(q);
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String q = callableStatement.getString(i);
        return transferString2StringArray(q);
    }

    private String[] transferString2StringArray(String string)
    {
        String[] split = string.split(",");
        return split;
    }


}
