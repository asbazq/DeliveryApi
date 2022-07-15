package com.sparta.springcore;

import com.sparta.springcore.model.Contents;
import com.sparta.springcore.repository.ContentsRepository;
import com.sparta.springcore.model.Contents;
import com.sparta.springcore.repository.ContentsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class SpringcoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoreApplication.class, args);
    }

    @PostConstruct
    public void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    @Bean
    public CommandLineRunner demo(ContentsRepository repository) {
        return (args) -> {
            repository.save(new Contents("항해99", "선원1", "어푸어푸"));
        };
    }
}
