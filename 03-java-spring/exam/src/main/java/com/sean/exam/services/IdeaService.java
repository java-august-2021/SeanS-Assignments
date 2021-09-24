package com.sean.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.exam.models.Idea;
import com.sean.exam.repositories.IdeaRepository;

@Service
public class IdeaService {
	@Autowired
	private IdeaRepository iRepo;
	
	public List<Idea> getAllIdeas() {
		return this.iRepo.findAll();
	}
	
	public Idea getOneIdea(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	
	public void deleteIdea(Long id) {
		this.iRepo.deleteById(id);
	}
	
	public Idea createIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
	
	// Update
	public Idea updateIdea(Idea updatedIdea) {
		return this.iRepo.save(updatedIdea);
	}
		

}
