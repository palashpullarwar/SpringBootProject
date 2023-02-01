package game.play.eGround.ServiceImplimentation;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import game.play.eGround.ServiceImplimentation.services.UserService;
import game.play.eGround.ServiceImplimentation.services.userDao.UserRepository;
import game.play.eGround.dto.LoginDTO;
import game.play.eGround.entity.User;
import game.play.eGround.exceptions.AlreadyExistsException;
import game.play.eGround.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int userId){
		
//			Optional<User> user = userRepo.findById(userId);
//			System.out.println(user.get());
//				 if(user.isEmpty()) {
//					 throw new ResourceNotFoundException("User not found");
//				 }
//				 return user.get();
				 
				 try {
						Optional<User> user = userRepo.findById(userId);
						return user.get();
					} catch (Exception e) {
						throw new ResourceNotFoundException(e);
					}
				
	}

	@Override
	public User addUser(User user) {
		List<User> users = userRepo.findAll();
		
		for(User u : users) {
			if(u.getEmail().equals(user.getEmail())) {
				throw new AlreadyExistsException("User already exists");
			}
		}
		
		userRepo.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		User u = userRepo.findById(user.getId()).orElse(null);
		
		System.out.println();
		u.setUserName(user.getUserName());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setEmail(user.getEmail());
		u.setContact(user.getContact());
		u.setAge(user.getAge());
          return userRepo.save(u);
	}
	
	@Override
	public void deleteUser(int userId) {
		userRepo.deleteById(userId);
	}

	@Override
	public User login(LoginDTO userLogin) {
		
		User user = userRepo.findByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword());
		if(user != null) {
			return user;
		}else {
			throw new ResourceNotFoundException("User not found");
		}
	
	}
	
	
	
}
