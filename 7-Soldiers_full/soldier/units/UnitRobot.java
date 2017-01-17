/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.units;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.core.GameMovable;
import soldier.core.BreakingRuleException;
import soldier.core.UnitInfantry;
import soldier.core.Weapon;

public class UnitRobot extends UnitInfantry {

	public UnitRobot(String soldierName, GameMovable g) {
		super(soldierName, new BehaviorSoldierHealthBased( 50, 100),g);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundingBox() {
		// TODO Auto-generated method stub
		return null;
	}


}
