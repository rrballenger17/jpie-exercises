import java.util.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;


public interface HighScoreService {
	List<String> getTopFivePlayers();
	boolean saveHighScore(int score, String playerName);
}