package Game;

import java.awt.Rectangle;

import gameframework.core.GameMovable;
import gameframework.core.SpriteManager;
import soldier.core.Unit;

public class UnitGameMovable  extends GameMovable{
	protected boolean movable = true;
	protected  SpriteManager spriteManager;
	public boolean isMovable() {
		return movable;
	}

	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	public SpriteManager getSpriteManager() {
		return spriteManager;
	}

	public void setSpriteManager(SpriteManager spriteManager) {
		this.spriteManager = spriteManager;
	}

	
	@Override
	// sucks 
	public Rectangle getBoundingBox() {
		return (new Rectangle(this.getPosition().x, this.getPosition().y, Unit.RENDERING_SIZE, Unit.RENDERING_SIZE));
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		if(movable)
			this.spriteManager.increment();
		
	}

	

}
