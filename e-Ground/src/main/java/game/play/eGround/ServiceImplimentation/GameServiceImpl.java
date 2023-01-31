package game.play.eGround.ServiceImplimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import game.play.eGround.ServiceImplimentation.services.GameService;
import game.play.eGround.ServiceImplimentation.services.userDao.GamesRepository;
import game.play.eGround.entity.Games;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	private GamesRepository gameRepo;
	
	@Override
	public List<Games> getListOfGames() {
		
		return gameRepo.findAll();
	}

	@Override
	public Games addGame(Games game) {
		
		gameRepo.save(game);
		
		return game;
	}

	
	
}
