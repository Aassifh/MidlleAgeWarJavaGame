package Game;

import java.util.ArrayList;

import gameframework.core.GameDefaultImpl;
import gameframework.core.GameLevel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameDefaultImpl g = new GameDefaultImpl();
		ArrayList<GameLevel> levels = new ArrayList<>();
		//levels.add(GameLevelOne(g));
		
		g.setLevels(levels);
		g.start();
	}

}
