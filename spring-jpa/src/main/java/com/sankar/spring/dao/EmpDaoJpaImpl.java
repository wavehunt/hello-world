package com.sankar.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sankar.spring.entity.Emp;

@Repository
public class EmpDaoJpaImpl implements EmpDao {
	
	@PersistenceContext
	//Will be autowired automatically with the above annotation.. without declaring the EntityManager instance anywhere
	EntityManager em;
	
	@Override
	public String save(Emp e) {
		em.persist(e);
		return "emp saved - JPA";
	}

	@Override
	public String delete(int id) {
		
		return null;
	}

	@Override
	public Emp findById(int id) {
		Emp e = em.find(Emp.class, id);
		return e;
	}

	@Override
	public List<Emp> getAll() {
		//jpql - object oriented queries; 
		//select e from Emp e;
		Query query=em.createQuery("select e from Emp e");
			
		return query.getResultList();
	}

}
