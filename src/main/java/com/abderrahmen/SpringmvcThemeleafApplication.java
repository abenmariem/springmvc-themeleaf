package com.abderrahmen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcThemeleafApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(SpringmvcThemeleafApplication.class, args);

		/*
		ApplicationContext ctx = SpringApplication.run(SpringmvcThemeleafApplication.class, args);
		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
	    
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Etudiant e1 = null;
		Etudiant e2 = null;
		Etudiant e3 = null;
		try {
			e1 = new Etudiant("ali", "Ben ali", df.parse("1987-06-16"), "ali@gmail.com", "ali.jpg");
			e2 = new Etudiant("saleh", "Ben saleh", df.parse("1987-06-16"), "saleh@gmail.com", "saleh.jpg");
			e3 = new Etudiant("mohamed", "Ben mohamed", df.parse("1987-06-16"), "mohamed@gmail.com", "mohamed.jpg");
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		etudiantRepository.save(e1);
		etudiantRepository.save(e2);
		etudiantRepository.save(e3);
		
		
		
		Page<Etudiant> etds = etudiantRepository.findAll(new PageRequest(0, 5));
		
		etds.forEach(e->{System.out.println(e.getNom());});
		
		*/
	
	}
}
