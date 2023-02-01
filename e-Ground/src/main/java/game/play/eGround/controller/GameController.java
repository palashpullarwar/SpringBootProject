package game.play.eGround.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/getGame/{gameId}")
	public ResponseEntity<Games> getGamebyId(@PathVariable int gameId){
		
		Games gId = gameService.getGameById(gameId);
		
		return ResponseEntity.ok(gId);
	}
	
	@PostMapping("/addGame")
	public ResponseEntity<Games> addGame(@RequestBody Games game){
		
		Games saveGame = this.gameService.addGame(game);
		
		return ResponseEntity.ok(saveGame);
	}
	
	@PutMapping("/updateGame")
	public ResponseEntity<Games> updateGameDetails(@RequestBody Games game){
		
		Games updateGame = this.gameService.updateGameDetails(game);
		
		return ResponseEntity.ok(updateGame);
		
	}
	
	@DeleteMapping("/deleteGame/{gameId}")
	public ResponseEntity<String> deleteGame(@PathVariable int gameId){
		
		this.gameService.deleteGame(gameId);
		
		return ResponseEntity.ok("game deleted successfully");
		
	}
	
}
