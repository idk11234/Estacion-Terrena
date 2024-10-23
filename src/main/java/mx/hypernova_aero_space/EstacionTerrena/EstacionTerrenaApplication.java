package mx.hypernova_aero_space.EstacionTerrena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;



@SpringBootApplication
public class EstacionTerrenaApplication {

	public static void main(String[] args){
		System.out.println(SpringVersion.getVersion());
		 
		SpringApplication.run(EstacionTerrenaApplication.class, args);
	}

}
