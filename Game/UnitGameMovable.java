package Game;

import java.awt.Rectangle;

import gameframework.core.GameMovable;

public class UnitGameMovable  extends GameMovable{

	@Override
	// sucks 
	public Rectangle getBoundingBox() {
		return (new Rectangle(this.getPosition().x, this.getPosition().y, 50, 50));
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		
	}

}
