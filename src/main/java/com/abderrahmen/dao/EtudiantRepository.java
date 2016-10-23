package com.abderrahmen.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abderrahmen.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	public Etudiant findByNom(String nom);
	public Page<Etudiant> findByNom(String nom, Pageable pageable);
	
	
	@Query("select e from Etudiant e where e.nom like :x ")
	public Page<Etudiant> chercherEtudiants(@Param("x") String mc,  Pageable pageable);
	
}
