package app;

import java.util.Arrays;

import logic.*;
import model.FastLaneModelCreator;
import model.HebrewConvertor;
import model.LangConvertor;
import model.ModelCreator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public DataCollector dataCollector() {
        return new SiteDataCollector();
    }

    @Bean
    public ModelCreator modelCreator() {
        return new FastLaneModelCreator();
    }

    @Bean(initMethod="init")
    public LangConvertor langConvertor() {
        return new HebrewConvertor();
    }

    @Bean
    public SchemaConvertor schemaConvertor() {
        return new JsonConvertor();
    }

    @Bean
    public DataFollower dataFollower() {
        return new RabbitMqDataFollower();
    }

}