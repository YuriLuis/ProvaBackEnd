package com.provabackend.provabackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.provabackend.provabackend.classes.Project;
import com.provabackend.provabackend.classes.tot.Tot;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	
	@Query(value ="select new com.provabackend.provabackend.classes.tot.Tot(p.name_project, sum(p.budget)) "
			+ " from Area a "
			+ " inner join a.name_project p "
			+ " group by m.nome", nativeQuery = true)
	public List<Tot> findTot();
	
	public Project findByBudget(Double budget);
}
