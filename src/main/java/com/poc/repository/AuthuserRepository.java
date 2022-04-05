package com.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.model.Authuser;

@Repository
public interface AuthuserRepository extends JpaRepository<Authuser, Long>{

	Authuser findByUsername(String username);

}
