package game.play.eGround.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import game.play.eGround.ServiceImplimentation.services.GameService;
import game.play.eGround.entity.Games;

@RestController
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping("/getGames")
	public ResponseEntity<List<Games>> listOfGames(){
		
		List<Games> getGames = this.gameService.getListOfGames();
		
		return ResponseEntity.ok(getGames);
		
	}
	
	@PostMapping("/addGame")
	public ResponseEntity<Games> addGame(@RequestBody Games game){
		
		Games saveGame = this.gameService.addGame(game);
		
		return ResponseEntity.ok(saveGame);
	}
	
}
