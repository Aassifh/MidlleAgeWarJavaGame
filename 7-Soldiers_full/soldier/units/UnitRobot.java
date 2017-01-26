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
import observer_util.Observer;
import soldier.core.BreakingRuleException;
import soldier.core.Unit;
import soldier.core.UnitInfantry;
import soldier.core.Weapon;

public class UnitRobot extends UnitInfantry {

	public UnitRobot(Canvas canvas, String soldierName) {
		super(soldierName, new BehaviorSoldierHealthBased(50, 100));

		this.spriteManager = new SpriteManagerDefaultImpl("images/sniper4.gif", canvas, 40, 6);
		this.spriteManager.setTypes("down", "left", "right", "up", "static", 
				"strike-up","strike-down","strike-left","strike-right" ,
				"dead"// Moves
		);

	}

	/**
	 * A Robot can have at most four equipments
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons() > 3)
			throw new BreakingRuleException();
		super.addEquipment(w);
	}

	@Override
	public void draw(Graphics g) {
		String spriteType = "";
		Point tmp = getSpeedVector().getDirection();
		if (alive()) {
			if (tmp.getX() == 1)
				spriteType += "right";
			else if (tmp.getX() == -1)
				spriteType += "left";
			else if (tmp.getY() == 1)
				spriteType += "down";
			else if (tmp.getY() == -1)
				spriteType += "up";
			else if (tmp.getX() == 2)
				spriteType += "strike-up";
			else if (tmp.getX() == 3)
				spriteType += "strike-down";
			else if (tmp.getX() == 4)
				spriteType += "strike-left";
			else if (tmp.getX() == 5)
				spriteType += "strike-right";
			else {
				spriteType = "static";
				spriteManager.reset();
				this.movable = false;

			}
		}
		if (!alive()) {
			spriteType += "dead";
		}

		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());

	}
}
