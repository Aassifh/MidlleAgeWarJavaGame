/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.core;

import java.awt.Point;
import java.util.Collections;
import java.util.Iterator;

import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.GameMovableDriver;
import gameframework.core.Overlappable;
import gameframework.moves_rules.SpeedVector;
import observer_util.ObservableAbstract;

public abstract class UnitSimple extends ObservableAbstract<Unit>
                                 implements Unit, Drawable, GameEntity, Overlappable {
/**
 * Brigde pattern to add GameMovable
 */
	private BehaviorSoldier behavior;
	private String name;
	private GameMovable gameMovable;
	public UnitSimple(String name, BehaviorSoldier behavior,GameMovable g) {
		this.behavior = behavior;
		this.name = name;
		this.gameMovable=g;
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
	public void setPosition(Point p) {
		this.gameMovable.setPosition(p);
	}

	public Point getPosition() {
		return this.gameMovable.getPosition();
	}
	/**
	 * (non-Javadoc)
	 * @see gameframework.core.Movable#setSpeedVector(gameframework.moves_rules.SpeedVector)
	 */
	public void setSpeedVector(SpeedVector speedVector) {
		this.gameMovable.setSpeedVector(speedVector);
	}

	public SpeedVector getSpeedVector() {
		return this.gameMovable.getSpeedVector();
	}
	
	public void setDriver(GameMovableDriver driver) {
		this.gameMovable.setDriver(driver);
	}

	public GameMovableDriver getDriver() {
		return this.gameMovable.getDriver();
	}

	public void oneStepMove() {
		this.gameMovable.oneStepMove();
	}
	
}
