package com.cskaoyan.mallSpringboot.security;

import com.cskaoyan.mallSpringboot.utils.MD5Util;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encodePassword(String s, Object o) throws DataAccessException {
        return MD5Util.encode(s);
    }

    @Override
    public boolean isPasswordValid(String s, String s1, Object o) throws DataAccessException {
        return s1.equals(MD5Util.encode(s));
    }
}
