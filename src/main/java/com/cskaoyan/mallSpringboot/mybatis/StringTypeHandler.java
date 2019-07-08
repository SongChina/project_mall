package com.cskaoyan.mallSpringboot.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//目的：其是要将数据库中的Boolean类型转化为String类型，将传送过来的String类型
public class StringTypeHandler extends BaseTypeHandler<String> {


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
      if("true".equals(s)){
          preparedStatement.setBoolean(i, true);
      }else if("false".equals(s)){
          preparedStatement.setBoolean(i, false);
      }

    }

    //其是要将从数据库中取出，然后转化成String类型
    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
