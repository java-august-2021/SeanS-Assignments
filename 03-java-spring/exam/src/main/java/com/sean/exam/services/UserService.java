package com.sean.exam.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.exam.models.User;
import com.sean.exam.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public List<User> allUsers(){
		return this.uRepo.findAll();
	}
	
	public User findOneUser(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	
	public User registerUser(User user) {
		// Generate a Hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
        return this.uRepo.save(user);
	}
	
	// authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = this.uRepo.findByEmail(email);
        
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        }
        
        // if the passwords match, return true, else, return false
        return BCrypt.checkpw(password, user.getPassword());         
    }
    
    public User getByEmail(String email) {
    	return this.uRepo.findByEmail(email);
    }
    
    public User getSingleUser(Long id) {
    	return this.uRepo.findById(id).orElse(null);
    }

}
