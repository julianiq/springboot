package com.todotic.contactlistapi;

import com.todotic.contactlistapi.entity.Contact;
import com.todotic.contactlistapi.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactlistapiApplication.class, args);
	}

	//Luego de crear la parte del controlador, se crea este método...
	@Bean
	CommandLineRunner runner(ContactRepository contactRepository){
		return  args-> {

				List<Contact> contacts= Arrays.asList(
						new Contact("Luis","luis@mail.com", LocalDateTime.now()),
						new Contact("Juan","juan@mail.com", LocalDateTime.now()),
						new Contact("Carlos","carl@mail.com", LocalDateTime.now()),
						new Contact("Jesus","Jesu@mail.com", LocalDateTime.now()),
						new Contact("Pedro","pepe@mail.com", LocalDateTime.now())
				);
				contactRepository.saveAll(contacts);

		};
	};
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
