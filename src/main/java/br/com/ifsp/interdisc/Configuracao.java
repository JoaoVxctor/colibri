package br.com.ifsp.interdisc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "br.com.ifsp.interdisc","br.com.ifsp.interdisc.controllers","br.com.ifsp.interdisc.repositories","br.com.ifsp.interdisc.models"})
@ComponentScan({"br.com.ifsp.interdisc","br.com.ifsp.interdisc.controllers","br.com.ifsp.interdisc.repositories","br.com.ifsp.interdisc.models"})
@Import({SecurityConfigurations.class})
@EntityScan("br.com.ifsp.interdisc.models")
@EnableJpaRepositories("br.com.ifsp.interdisc.repositories")
public class Configuracao extends SpringBootServletInitializer{
	
	
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
}
