import java.util.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;


public class Game {
	private final HighScoreService highScoreService;

	public Game(HighScoreService highScoreService) { 
		this.highScoreService = highScoreService;
	}


	public String displayHighScores() { 
		final List<String> topFivePlayers =highScoreService.getTopFivePlayers(); 
		final StringBuilder sb = new StringBuilder();

		for (int i = 0; i < topFivePlayers.size(); i++) { 
			String player = topFivePlayers.get(i); 
			sb.append(String.format("%d. %s%n", i+1, player));
		}

		return sb.toString(); 
	}


}
