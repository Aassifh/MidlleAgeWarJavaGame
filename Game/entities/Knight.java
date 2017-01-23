package Game.entities;

import java.awt.Canvas;
import java.awt.Graphics;

import gameframework.core.SpriteManagerDefaultImpl;
import soldier.core.Unit;

public class Knight extends UnitEntity{

	// use unit 
	public Knight(Canvas canvas) {
		super(canvas,"sniper2.gif" );
		this.spriteManager = new SpriteManagerDefaultImpl("images/sniper2.gif", canvas, RENDERING_SIZE, 6);
		this.spriteManager.setTypes("down", "left", "right", "up" // Moves
				);
	}
	public void draw (Graphics g){
		super.draw(g);
	}
	public void oneStepMoveAddedBehavior(){
		super.oneStepMoveAddedBehavior();
	}
	// gerer les armes (weapon)
	
}
