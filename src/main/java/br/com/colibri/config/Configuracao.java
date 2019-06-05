package br.com.colibri.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "br.com.colibri.config","br.com.colibri.controllers","br.com.colibri.repositories","br.com.colibri.models","br.com.colibri.services"})
@ComponentScan({"br.com.colibri.config","br.com.colibri.controllers","br.com.colibri.repositories","br.com.colibri.models","br.com.colibri.services","br.com.colibri.dao"})
@Import({SecurityConfigurations.class})
@EntityScan("br.com.colibri.models")
@EnableJpaRepositories("br.com.colibri.repositories")
@EnableAutoConfiguration
public class Configuracao{

	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
}
