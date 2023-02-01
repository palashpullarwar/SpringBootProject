package game.play.eGround.ServiceImplimentation.services;

import java.util.List;


import java.util.Optional;

import game.play.eGround.dto.LoginDTO;
import game.play.eGround.entity.User;
import game.play.eGround.exceptions.ResourceNotFoundException;

public interface UserService {
public List<User> getUsers();
	
	public User getUserById(int userId);
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(int userId);
	
	public User login(LoginDTO userLogin);
}
