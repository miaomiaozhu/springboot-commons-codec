package com.example.springbootcommonscodec.test;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName TestCodec
 * @Author Jumy
 * @Description //TODO
 * @Date 2019/6/14 10:31
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCodec {
    //可逆
    @Test
    public void testBase64(){
        System.out.println("==========Base64==========");
        //假设密码为123456abc+
        byte[] passwd = "123456abc+".getBytes();
        //编码
        String enPasswd = Base64.encodeBase64String(passwd);
        System.out.println("编码后：" + enPasswd);
        //解码
        String dePasswd = new String(Base64.decodeBase64(enPasswd));
        System.out.println("解码后：" + dePasswd);
    }
    //不可逆
    @Test
    public void testMD5(){
        System.out.println("==========MD5==========");
        String enPasswd = DigestUtils.md5Hex("123456abc+");
        System.out.println("加密后：" + enPasswd);
    }
    //可逆
    @Test
    public void testURLCodec(){
        System.out.println("==========URLCodec==========");
        URLCodec urlCodec = new URLCodec();
        String data = "陈某某abc+";
        try {
            String encode = urlCodec.encode(data, "UTF-8");
            System.out.println("加密后：" + encode);
            String decode = urlCodec.decode(encode, "UTF-8");
            System.out.println("解密后：" + decode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
