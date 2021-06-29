package com.controleAtividades.equipe;

import com.controleAtividades.equipe.entity.ControlOfTeamActivities;
import com.controleAtividades.equipe.entity.TipoStatus;
import com.controleAtividades.equipe.repository.ControlOfTeamActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EquipeApplication implements CommandLineRunner {

	@Autowired
	private ControlOfTeamActivitiesRepository repository;




	public static void main(String[] args) {
		SpringApplication.run(EquipeApplication.class, args);
	}


	public void run(String... args) throws Exception {
		repository.save(new ControlOfTeamActivities("Teste","Teste", TipoStatus.TESTANDO,"24/06/2021",null,null,null,null,null,null));

	}

}
