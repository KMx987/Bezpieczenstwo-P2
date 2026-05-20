package org.projekt2.tool;

import org.projekt2.config.SecurityUtil;

public class EncryptorTool {

    public static void main(String[] args) throws Exception {

        System.out.println(SecurityUtil.encrypt("postgres", "1234567890ABCDEF"));
        System.out.println(SecurityUtil.encrypt("postgres", "1234567890ABCDEF"));
    }
}