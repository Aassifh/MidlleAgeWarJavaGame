package Game;

import java.awt.Canvas;

import gameframework.core.Game;
import gameframework.core.GameLevelDefaultImpl;

public class GameLevelOne extends GameLevelDefaultImpl {
	Canvas canvas;
	
	protected void init() {
		
	}
	
	public GameLevelOne(Game g){
		super(g);
		canvas = g.getCanvas();
	}

}
