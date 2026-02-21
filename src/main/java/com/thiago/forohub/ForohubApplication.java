package com.thiago.forohub;

import com.thiago.forohub.domain.topico.Topico;
import com.thiago.forohub.domain.topico.TopicoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.thiago.forohub.domain")
public class ForohubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForohubApplication.class, args);
    }

    @Bean
    CommandLineRunner init(TopicoRepository repository) {
        return args -> {

            Topico topico = new Topico("Primer tópico", "Mensaje de prueba");
            repository.save(topico);
            System.out.println("Tópico guardado en la base de datos!");
        };
    }
}