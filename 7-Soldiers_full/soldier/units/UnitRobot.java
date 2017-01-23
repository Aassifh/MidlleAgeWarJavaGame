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
import soldier.core.BreakingRuleException;
import soldier.core.UnitInfantry;
import soldier.core.Weapon;

public class UnitRobot extends UnitInfantry {

	public UnitRobot(Canvas canvas,String soldierName,GameMovable g) {
		super(soldierName, new BehaviorSoldierHealthBased( 50, 100),g);
		this.spriteManager = new SpriteManagerDefaultImpl("images/elite.gif", canvas, RENDERING_SIZE, 3);
		this.spriteManager.setTypes("down", "left", "right", "up" // Moves
				);
	}

	/**
	 * A Robot can have at most four equipments
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons()>3) throw new BreakingRuleException();
		super.addEquipment(w);
	}

	
	@Override
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

	
	

}
