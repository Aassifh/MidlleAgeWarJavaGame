package Game;

import java.util.ArrayList;

import gameframework.core.GameDefaultImpl;
import gameframework.core.GameLevel;

public class Main {

	public static void main(String[] args) {
		
		
		GameDefaultImpl g = new GameDefaultImpl();
		ArrayList<GameLevel> levels = new ArrayList<GameLevel>();
		levels.add(new GameUnitLevelOne(g));
		
		g.setLevels(levels);
		g.start();
	}

}
