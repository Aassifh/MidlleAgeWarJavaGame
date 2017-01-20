package Game.entities;

import java.awt.Canvas;
import java.awt.Graphics;

import soldier.core.Unit;

public class Knight extends UnitEntity{

	public Knight(Canvas canvas, Unit u) {
		super(canvas, u);
	
	}
	public void draw (Graphics g){
		super.draw(g);
	}
	public void oneStepMoveAddedBehavior(){
		super.oneStepMoveAddedBehavior();
	}
	// gerer les armes (weapon)
	
}
