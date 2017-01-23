package Game.entities;

import java.awt.Canvas;
import java.awt.Graphics;

import gameframework.core.SpriteManagerDefaultImpl;

public class Soldier extends UnitEntity {

	public Soldier(Canvas canvas) {
		super(canvas, "elite.gif");
		this.spriteManager = new SpriteManagerDefaultImpl("images/elite.gif", canvas, RENDERING_SIZE, 3);
		this.spriteManager.setTypes("down", "left", "right", "up" // Moves
				);
	}
	public void draw (Graphics g){
		super.draw(g);
	}
	public void oneStepMoveAddedBehavior(){
		super.oneStepMoveAddedBehavior();
	}
}
