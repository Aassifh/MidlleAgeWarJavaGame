package Game.entities;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.moves_rules.MoveBlocker;

public class Grass implements Drawable,GameEntity {
	protected static DrawableImage image =null;
	int x,y ; 
	public static final int RENDERING_SIZE=18;
	 public Grass(Canvas canvas, int x ,int y) {
		 image=new DrawableImage("images/Grass.gif", canvas);
		 this.x=x;
		 this.y=y;
	}
	

	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, RENDERING_SIZE, RENDERING_SIZE,
				null);
		
	}

}
