package game.play.eGround.ServiceImplimentation.services.userDao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import game.play.eGround.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.email = ?1 and u.password= ?2")
	User findByEmailAndPassword(String email, String password);

}
 