/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.units;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.core.GameMovable;
import soldier.core.BehaviorSoldierStd;
import soldier.core.BreakingRuleException;
import soldier.core.UnitRider;
import soldier.core.UnitVisitor;
import soldier.core.Weapon;

public class UnitHorseMan extends UnitRider {

	public UnitHorseMan(String soldierName,GameMovable g) {
		super(soldierName, new BehaviorSoldierStd(20, 120),g);
	}

	@Override
	public void accept(UnitVisitor v) {
		v.visit(this);
	}

	/**
	 * A HorseMan can only have two equipments, and one of each kind
	 */
	@Override
	public void addEquipment(Weapon w) {
		int nbW = nbWeapons();
		if (nbW > 1)
			throw new BreakingRuleException();
		if (nbW == 1 && getWeapons().next().getClass() == w.getClass())
			throw new BreakingRuleException();
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
