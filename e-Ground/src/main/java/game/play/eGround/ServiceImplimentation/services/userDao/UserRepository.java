package game.play.eGround.ServiceImplimentation.services.userDao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import game.play.eGround.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
