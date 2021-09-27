package com.banlv.road.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/8/31 15:52
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Configuration
public class PasswordConfig implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
