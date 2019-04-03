
import java.util.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;


public class GameTestWithStub {




	private static class StubHighScoreService implements HighScoreService {

		@Override
		public List<String> getTopFivePlayers() {
			return Arrays.asList( "Alice","Bob", "Charlie", "Dave", "Elizabeth");
		}


		@Override
		public boolean saveHighScore(int score, String playerName) {
			throw new UnsupportedOperationException("saveHighScore not implemented for this test");
		}	 
	}



	@Test
	public void highScoreDisplay() {

		final String expectedPlayerList = "1. Alice\n" +
			"2. Bob\n" +
			"3. Charlie\n" + 
			"4. Dave\n" +
			"5. Elizabeth\n";

		final HighScoreService stubbedHighScoreService = new StubHighScoreService();

		final Game gameUnderTest = new Game(stubbedHighScoreService);

		assertEquals( expectedPlayerList,gameUnderTest.displayHighScores());
	
	} 




}
