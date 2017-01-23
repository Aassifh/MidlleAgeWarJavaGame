/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.core;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.Iterator;

import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.GameMovableDriver;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;
import gameframework.moves_rules.SpeedVector;
import observer_util.ObservableAbstract;

public abstract class UnitSimple extends ObservableAbstract<Unit>
                                 implements Unit,Drawable, GameEntity, Overlappable{

	private BehaviorSoldier behavior;
	private String name;
	protected  SpriteManager spriteManager;
	public static final int RENDERING_SIZE = 40;
	protected boolean movable = true;
	/* 
	 * bridge pattern because we dont have multiple inherintence
	 */
	protected GameMovable gamemove;
	
	public UnitSimple(String name, BehaviorSoldier behavior, GameMovable game) {
		this.behavior = behavior;
		this.name = name;
		this.gamemove=game;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getHealthPoints() {
		return behavior.getHealthPoints();
	}

	@Override
	public boolean alive() {
		return behavior.alive();
	}

	@Override
	public void heal() {
		behavior.heal();
	}

	@Override
	public float parry(float force) {
		float result = behavior.parry(force);
		notifyObservers(this);
		return result;
	}

	@Override
	public float strike() {
		float result = behavior.strike();
		return result;
	}

	@Override
	public void addEquipment(Weapon w) {
		behavior = w.createExtension(behavior);
	}

	@Override
	public void removeEquipment(Weapon w) {
		BehaviorSoldier current = behavior;
		BehaviorSoldier previous = behavior;
		while (current instanceof BehaviorExtension
				&& ((BehaviorExtension) current).getOwner() != w) {
			previous = current;
			current = ((BehaviorExtension) current).parent();
		}
		if (((BehaviorExtension) current).getOwner() == w) {
			((BehaviorExtension) previous)
					.reparent(((BehaviorExtension) previous).parent());
		}
	}

	@Override
	public Iterator<Weapon> getWeapons() {
		return new Iterator<Weapon>() {
			BehaviorSoldier current = behavior;

			@Override
			public boolean hasNext() {
				return current instanceof BehaviorExtension;
			}

			@Override
			public Weapon next() {
				Weapon tmp = ((BehaviorExtension) current).getOwner();
				current = ((BehaviorExtension) current).parent();
				return tmp;
			}
		};
	}

	@Override
	final public Iterator<Unit> subUnits() {
		return Collections.emptyIterator();
	}

	@Override
	final public void addUnit(Unit au) {
		throw new UnsupportedOperationException();
	}

	@Override
	final public void removeUnit(Unit au) {
	}

	public int nbWeapons() {
		int result = 0;
		for (Iterator<Weapon> it = getWeapons(); it.hasNext(); it.next())
			++result;
		return result;
	}
	@Override
	public Rectangle getBoundingBox() {
		return (new Rectangle(this.getPosition().x, this.getPosition().y, RENDERING_SIZE, RENDERING_SIZE));
	}


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getPosition() {
		return this.gamemove.getPosition();
	}
	public void setPosition(Point p) {
		this.gamemove.setPosition(p);
	}

	
	
	public void setSpeedVector(SpeedVector speedVector) {
		this.gamemove.setSpeedVector(speedVector);
	}

	public SpeedVector getSpeedVector() {
		return this.gamemove.getSpeedVector();
	}
	
	public void setDriver(GameMovableDriver driver) {
		this.gamemove.setDriver(driver);
	}

	public GameMovableDriver getDriver() {
		return this.gamemove.getDriver();
	}

	public void oneStepMove() {
		this.gamemove.oneStepMove();
	}
	
	
	
}
