package game.play.eGround.ServiceImplimentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import game.play.eGround.ServiceImplimentation.services.GameService;
import game.play.eGround.ServiceImplimentation.services.userDao.GamesRepository;
import game.play.eGround.entity.Games;
import game.play.eGround.exceptions.ResourceNotFoundException;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	private GamesRepository gameRepo;
	
	@Override
	public List<Games> getListOfGames() {
		
		return gameRepo.findAll();
	}
	
	
	public Games getGameById(int id){
		
		try {
			Optional<Games> gameId = gameRepo.findById(id);
			return gameId.get();
			
		} catch (Exception e) {
			throw new ResourceNotFoundException(e);
		}
		
		
	}
	

	@Override
	public Games addGame(Games game) {
		gameRepo.save(game);
		return game;
	}
	
	
    public Games updateGameDetails(Games game) {
    	
    	Games g = gameRepo.findById(game.getId()).orElse(null);
    	
    	g.setDeveloper(game.getDeveloper());
    	g.setGameTitle(game.getGameTitle());
    	g.setGenre(game.getGenre());
    	g.setPrice(game.getPrice());
    	
    	return gameRepo.save(g);
    	
    }

	@Override
	public void deleteGame(int id) {

		gameRepo.deleteById(id);
			
	}

	
	
}
