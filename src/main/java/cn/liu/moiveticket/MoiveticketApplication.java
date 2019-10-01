package cn.liu.moiveticket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan(value = "cn.liu.moiveticket.dao")
public class MoiveticketApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoiveticketApplication.class, args);
    }
}
