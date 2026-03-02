package com.example.q8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseballService {
	@Autowired
	private BaseballRepository repository;
	
	public BaseballDomain load(Integer id){
		return repository.load(id);
	}
	
	public List<BaseballDomain> findAll(){
		return repository.findAll();
	}
	
	public BaseballDomain save (BaseballDomain baseballDomain){
		return repository.save(baseballDomain);
	}

	public void delete (Integer id){
		repository.delete(id);
	}

}
