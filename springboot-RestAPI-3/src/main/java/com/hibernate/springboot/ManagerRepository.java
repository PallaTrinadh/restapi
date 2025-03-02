package com.hibernate.springboot;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> 
{
	public abstract Optional<Manager> findByName(String name);
	

}
