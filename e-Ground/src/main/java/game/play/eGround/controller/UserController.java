package game.play.eGround.controller;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import game.play.eGround.ServiceImplimentation.services.UserService;
import game.play.eGround.dto.LoginDTO;
import game.play.eGround.entity.User;
import game.play.eGround.exceptions.ResourceNotFoundException;

@RestController
public class UserController {

	@Autowired
	public UserService userService;

	  @GetMapping("/users")
      public List<User> getUserList(){
    	  return this.userService.getUsers();
      }
	  
	 
	 @GetMapping("/users/{userId}")
     public User getUserById(@PathVariable int userId) {
   	      return this.userService.getUserById(userId);
     }

	 
	  
	  @PostMapping("/users")
	  public User addUser(@RequestBody User user) {
		  return userService.addUser(user);
	  }
	  
	  @PutMapping("/updateUser")
	  public User updateUser(@RequestBody User user) {
		  return this.userService.updateUser(user);
	  }
	  
	  @DeleteMapping("/users/{userId}")
	  public ResponseEntity<HttpStatus> deleteUser(@PathVariable int userId){
		  try {
			this.userService.deleteUser(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	  
	  @PostMapping("/login")
	  public ResponseEntity<?> login(@RequestBody LoginDTO login, HttpServletRequest request){
		
		  User user = userService.login(login);
		  System.out.println(request.getSession().toString());
		  System.out.println(user.toString() + "777777777777777777777777777");
		  request.setAttribute("user", user);
		  return ResponseEntity.ok(user);  
		  
	  }
	  
	  @GetMapping("/logout")
	  public ResponseEntity<?> logout(HttpServletRequest request){
		  
		  User u = (User) request.getAttribute("user");
		  System.out.println(request.getSession().toString());
		   
		  //Invalidating session to logout
		  request.getSession().invalidate();
		  System.out.println(request.getSession().toString() + "pppppppppppppppppppppppppppppppppppppp");
		  return ResponseEntity.ok(u);  
		  
	  }
	
}
