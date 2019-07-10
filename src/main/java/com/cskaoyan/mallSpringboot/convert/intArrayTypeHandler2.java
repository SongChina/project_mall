package com.cskaoyan.mallSpringboot.convert;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class intArrayTypeHandler2 implements TypeHandler<int[]> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, int[] ints1, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer();
        if (ints1.length == 0){
            preparedStatement.setString(i, "[]");
        }
        else {
            for (int ints : ints1) {
                sb.append(ints).append(",");

            }
            String substring = sb.substring(0, sb.length() - 1);
            preparedStatement.setString(i, substring);
        }

    }

    @Override
    public int[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return transString2IntArray(string);
    }

    @Override
    public int[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return transString2IntArray(string);
    }

    @Override
    public int[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return transString2IntArray(string);
    }

    private int[] transString2IntArray(String string) {
        if ("[]".equals(string)){
            return new int[0];
        }
        else{
        //String s = string.toString().replace("[", "");
        //String replace = s.toString().replace("]", "");
        //String[] ints1 = replace.split(",");
        String[] ints1 = string.split(",");

        int[] ints = new int[ints1.length];
        for (int i = 0; i < ints1.length; i++) {
            ints[i] = Integer.parseInt(ints1[i]);
        }
        return ints;}
    }
}
