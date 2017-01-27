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
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.SpriteManagerDefaultImpl;
import gameframework.moves_rules.MoveStrategy;
import gameframework.moves_rules.MoveStrategyStraightLine;
import gameframework.moves_rules.SpeedVector;
import soldier.core.BehaviorSoldierStd;
import soldier.core.BreakingRuleException;
import soldier.core.Unit;
import soldier.core.UnitInfantry;
import soldier.core.Weapon;
import soldier.util.observer;

public class UnitCenturion extends UnitInfantry implements observer{
	
	
	protected int weakTimer = 0;
	protected int maxWeakTimer = 0;
	protected MoveStrategyStraightLine moveStrat;
	GameMovableDriverDefaultImpl UnitDriver4;
	
	public UnitCenturion(Canvas canvas,String soldierName){
		super(soldierName, new BehaviorSoldierStd(50, 100));
		
		this.spriteManager = new SpriteManagerDefaultImpl("images/soldat6.png", canvas, 30, 4);
		this.spriteManager.setTypes("down", "left", "right", "up" // Moves
		);
		UnitDriver4= new GameMovableDriverDefaultImpl();
		UnitDriver4.setStrategy(this.getMoveStrategy(this.getPosition(), new Point(0,0)));
		this.setDriver(UnitDriver4);
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
	
	public void changeDirection(SpeedVector m) {
		Point direction = m.getDirection();
		if (direction.getX() == 1)
			this.spriteManager.setType("right");
		else if (direction.getX() == -1)
			this.spriteManager.setType("left");
		else if (direction.getY() == 1)
			this.spriteManager.setType("down");
		else if (direction.getY() == -1)
			this.spriteManager.setType("up");
	}

	@Override
	public void draw(Graphics g) {
		
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
	
	
	public MoveStrategyStraightLine getMoveStrategy(Point pos, Point goal) {
		return new MoveStrategyStraightLine(pos, goal);
	}
	

	public boolean isWeak() {
		return weakTimer > 0;
	}
	
	public void setWeak(int timer) {
		maxWeakTimer = weakTimer = timer;
	}
	
	@Override
	public void update(UnitRobot s) {
		// TODO Auto-generated method stub
		UnitDriver4.setStrategy(this.getMoveStrategy(this.getPosition(), s.getPosition()));
	}

	public GameMovableDriverDefaultImpl getUnitDriver4() {
		return UnitDriver4;
	}

	public void setMoveStrat(MoveStrategyStraightLine moveStrat) {
		this.moveStrat = moveStrat;
	}
	
}
