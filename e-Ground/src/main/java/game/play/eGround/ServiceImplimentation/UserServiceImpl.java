package game.play.eGround.ServiceImplimentation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import game.play.eGround.ServiceImplimentation.services.UserService;
import game.play.eGround.ServiceImplimentation.services.userDao.UserRepository;
import game.play.eGround.entity.User;
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
	public User getUserById(int userId) {
			try {
				 
				 Optional<User> user = userRepo.findById(userId);
				 if(user.get().equals(null)) {
					 throw new ResourceNotFoundException();
				 }
				 return user.get();
			} catch (Exception e) {
				throw new ResourceNotFoundException(e);
			}
			
	}

	@Override
	public User addUser(User user) {
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
	
}
