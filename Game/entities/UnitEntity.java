package Game.entities;

import java.awt.*;

import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;
import gameframework.core.SpriteManagerDefaultImpl;
import gameframework.moves_rules.MoveBlocker;
import soldier.core.Unit;

public abstract class UnitEntity extends GameMovable implements Drawable, GameEntity, Overlappable {
	// protected final no polymorphism !
	protected  SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 40;
	protected boolean movable = true;
	protected Unit Soldier;
	

	public UnitEntity(Canvas canvas, String s ) {
		
				//"static", // static ?
				//"dead");
	}

	public void draw(Graphics g) {
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();
		// intégrer le mode combat après le test
		//if (this.Soldier.alive()) {
			if (tmp.getX() == 1)
				spriteType += "right";
			else if (tmp.getX() == -1)
				spriteType += "left";
			else if (tmp.getY() == 1)
				spriteType += "down";
			else if (tmp.getY() == -1)
				spriteType += "up";
			else {
				spriteType = "right";
				spriteManager.reset();
				movable = false;

			}
		//}
		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());

	}

	public void oneStepMoveAddedBehavior() {
		if (movable)
			this.spriteManager.increment();
	}

	public Rectangle getBoundingBox() {
		return (new Rectangle(this.getPosition().x, this.getPosition().y, RENDERING_SIZE, RENDERING_SIZE));
	}

	public Unit getSoldier() {
		return Soldier;
	}

}
