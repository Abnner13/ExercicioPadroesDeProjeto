package dio.lab_padroes_de_projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableFeignClients
@SpringBootApplication
public class LabPadroesDeProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesDeProjetoApplication.class, args);
	}

}
