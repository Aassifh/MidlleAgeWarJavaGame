/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.units;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


import gameframework.core.GameMovable;
import gameframework.core.SpriteManagerDefaultImpl;
import soldier.core.BehaviorSoldierStd;
import soldier.core.BreakingRuleException;
import soldier.core.UnitInfantry;
import soldier.core.Weapon;

public class UnitCenturion extends UnitInfantry {
	
	boolean alive;
	
	public UnitCenturion(Canvas canvas,String soldierName){
		super(soldierName, new BehaviorSoldierStd(15, 100));
		
		this.spriteManager = new SpriteManagerDefaultImpl("images/soldat6.png", canvas, 30, 4);
		this.spriteManager.setTypes("down", "left", "right", "up" // Moves
		);
	}

	/**
	 * A Centurion can have at most two equipments
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons() > 1)
			throw new BreakingRuleException();
		super.addEquipment(w);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();

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
			this.movable=false;

		}

		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());
	}

	public void setAlive(boolean b) {
		// TODO Auto-generated method stub
		this.alive = b;
		
	}
	

	

}
