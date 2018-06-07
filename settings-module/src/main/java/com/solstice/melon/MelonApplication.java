package com.solstice.melon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/05/11
 * @Time 10:19
 * @Description
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@MapperScan("com.solstice.melon.dao*")
@ComponentScan("com.solstice.melon")
public class MelonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MelonApplication.class,args);
    }

}
