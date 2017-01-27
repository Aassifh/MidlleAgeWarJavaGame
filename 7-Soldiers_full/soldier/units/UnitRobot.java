/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.units;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

import gameframework.core.GameMovable;
import gameframework.core.SpriteManagerDefaultImpl;
import soldier.core.BreakingRuleException;
import soldier.core.Unit;
import soldier.core.UnitInfantry;
import soldier.core.Weapon;
import soldier.util.observable;
import soldier.util.observer;


public class UnitRobot extends UnitInfantry implements observable{
 	
	private List<observer> observersOrdered = new LinkedList<observer>();
	
	public UnitRobot(Canvas canvas, String soldierName) {
		super(soldierName, new BehaviorSoldierHealthBased(50, 100));

		this.spriteManager = new SpriteManagerDefaultImpl("images/sniper5.gif", canvas, 40, 6);
		this.spriteManager.setTypes("down", "left", "right", "up", "static", 
				"strike-left","strike-right","strike-up","strike-down" ,
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
			else if (tmp.getY() == 2)
				spriteType += "strike-down";
			else if (tmp.getY() == -2)
				spriteType += "strike-up";
			else if (tmp.getX() == -2)
				spriteType += "strike-left";
			else if (tmp.getX() == 2)
				spriteType += "strike-right";
			else {
				spriteType = "static";
				spriteManager.reset();
				this.movable = false;

			}
		}
		if (!alive()) {
			spriteType = "dead";
			this.movable = false;
		}

		spriteManager.setType(spriteType);
		spriteManager.draw(g, getPosition());
		notifyObservers();
	}

	@Override
	public void addObserver(observer ob) {
		// TODO Auto-generated method stub
		observersOrdered.add(ob);
	}

	@Override
	public void removeObserver(observer ob) {
		// TODO Auto-generated method stub
		observersOrdered.remove(ob);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (observer observer : observersOrdered) {
			observer.update(this);
		}
	}
	
	public void oneStepMoveAddedBehavior() {
		if (movable){
			this.spriteManager.increment();
			//notifyObservers();
		}

	}
}
