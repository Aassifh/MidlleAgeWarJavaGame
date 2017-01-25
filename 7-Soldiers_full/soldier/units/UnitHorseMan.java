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
import soldier.core.UnitRider;
import soldier.core.UnitVisitor;
import soldier.core.Weapon;

public class UnitHorseMan extends UnitRider {

	public UnitHorseMan(Canvas canvas,String soldierName) {
		super(soldierName, new BehaviorSoldierStd(15, 100));
		
		this.spriteManager = new SpriteManagerDefaultImpl("images/horsman.gif", canvas, 32, 6);
		this.spriteManager.setTypes("down", "left", "right", "up" // Moves
		);
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
	

	

}
