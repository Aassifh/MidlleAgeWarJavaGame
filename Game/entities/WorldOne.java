package Game.entities;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;

import gameframework.core.Drawable;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import gameframework.moves_rules.MoveBlocker;

public class WorldOne implements Drawable,MoveBlocker,GameEntity {
	protected static DrawableImage image =null;
	int x,y ; 
	public static final int RENDERING_SIZE=50;
	 public WorldOne(Canvas canvas, int x ,int y) {
		 image=new DrawableImage("images/screen_cap_1.png", canvas);
		 this.x=x;
		 this.y=y;
	}
	@Override
	public Rectangle getBoundingBox() {
		return (new Rectangle(x-10, y, RENDERING_SIZE-10, RENDERING_SIZE-40));
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, RENDERING_SIZE, RENDERING_SIZE,
				null);
		
	}

}
