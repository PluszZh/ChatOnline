package org.lf.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author: PengZH
 * @Date: 2020/3/12 19:54
 * @Description:
 */
@SpringBootApplication

public class WebChat {

    public static void main(String[] args) {
        SpringApplication.run(WebChat.class, args);
    }


}