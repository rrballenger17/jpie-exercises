
import java.util.*;
import java.lang.ref.WeakReference;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.concurrent.*;
import java.io.*;
import com.fasterxml.jackson.databind.*;

public class JacksonJsonTest{

	static class Team {
		private String name;
		private List<Player> players;

		public void setName(String name){
			this.name = name;
		}

		public String getName(){
			return name;
		}

		public void setPlayers(List<Player> players){
			this.players = players;
		}

		public List<Player> getPlayers(){
			return players;
		}

	}

	static class Player {
		private String name;
		private String position;
	 // include getters and setters 

		public void setName(String name){
			this.name = name;
		}

		public String getName(){
			return name;
		}

		public void setPosition(String position){
			this.position = position;
		}

		public String getPosition(){
			return position;
		}

	}




	@Test
	public void writeJson() throws IOException {
		final Player p1 = new Player(); 
		p1.setName("Louise Mills"); 
		p1.setPosition("Coach");

		final Player p2 = new Player(); 
		p2.setName("Liam Turner"); 
		p2.setPosition("Attack");
		
		final Team team = new Team(); 
		team.setPlayers(Arrays.asList(p1, p2));
		
		final ObjectMapper mapper = new ObjectMapper(); 
		mapper.writeValue(new File("newteam.json"), team);
	}



	@Test
	public void readJson() throws IOException {
		final ObjectMapper mapper = new ObjectMapper(); 
		final String json ="newteam.json"; 
		final Team team = mapper.readValue(
			getClass().getResourceAsStream(json), Team.class);

		assertEquals(2, team.getPlayers().size()); 

		System.out.println(team.getPlayers().get(1).getName());
	}







}