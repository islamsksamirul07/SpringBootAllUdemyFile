package com.example.demo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="UserDetails")
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long>{
	
	List <UserDetails> findByRole(String role);
	

}
