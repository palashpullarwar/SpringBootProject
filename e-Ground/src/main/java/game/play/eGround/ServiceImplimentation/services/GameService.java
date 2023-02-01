package game.play.eGround.ServiceImplimentation.services;

import java.util.List;

import game.play.eGround.entity.Games;

public interface GameService {

	public List<Games> getListOfGames();
	
	public Games addGame(Games game);

	public Games getGameById(int gameId);
	
	public Games updateGameDetails(Games game);
	
	public void deleteGame(int gameId);
}
