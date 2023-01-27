package com.acn.learnspringdatarest.learndatarest;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.acn.learnspringdatarest.learndatarest.entity.UserEntity;
import com.acn.learnspringdatarest.learndatarest.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

	private UserRepository userRepository;
	
	public Runner(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("saving users...");
		
		this.userRepository.saveAll((Iterable<UserEntity>) 
			List.of(
					UserEntity.builder()
						.email("mino.pluto@libero.it")
						.firstname("Mino")
						.lastname("Pluto")
						.build(),
					UserEntity.builder()
						.email("mino.paperino@libero.it")
						.firstname("Mino")
						.lastname("Paperino")
						.build(),
					UserEntity.builder()
						.email("mino.topolino@libero.it")
						.firstname("Mino")
						.lastname("Topolino")
						.build(),
					UserEntity.builder()
						.email("mino.qui@libero.it")
						.firstname("Mino")
						.lastname("Qui")
						.build(),
					UserEntity.builder()
						.email("mino.quo@libero.it")
						.firstname("Mino")
						.lastname("Quo")
						.build(),
					UserEntity.builder()
						.email("mino.qua@libero.it")
						.firstname("Mino")
						.lastname("Qua")
						.build()
				)
		);
	}

}
