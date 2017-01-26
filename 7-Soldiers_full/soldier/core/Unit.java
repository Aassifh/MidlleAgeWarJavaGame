/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.core;

import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import observer_util.Observable;
import observer_util.Observer;
import gameframework.core.*;

public abstract class Unit extends GameMovable implements Drawable, GameEntity, Overlappable, Observable<Unit> {
	protected SpriteManager spriteManager;
	protected boolean movable = true;
	private List<Observer<Unit>> observersOrdered = new LinkedList<Observer<Unit>>();
	private Set<Observer<Unit>> observersSet = new HashSet<Observer<Unit>>();

	@Override
	public void addObserver(Observer<Unit> obs) {
		if (!observersSet.contains(obs)) {
			observersOrdered.add(obs);
			observersSet.add(obs);
		}
	}

	@Override
	public void removeObserver(Observer<Unit> obs) {
		observersOrdered.remove(obs);
		observersSet.remove(obs);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void notifyObservers(Unit s) {
		Object[] copy = observersOrdered.toArray();
		for (Object u : copy)
			((Observer<Unit>) u).update(s);
	}

	/**
	 * Unit methods
	 */
	public abstract String getName();

	public abstract float getHealthPoints();

	public abstract boolean alive();

	public abstract void heal();

	public abstract float parry(float force);

	public abstract float strike();

	/**
	 * Behavior extensions
	 */
	public abstract void addEquipment(Weapon w);

	public abstract void removeEquipment(Weapon w);

	public abstract Iterator<Weapon> getWeapons();

	/**
	 * Composite methods
	 */
	public abstract Iterator<Unit> subUnits();

	public abstract void addUnit(Unit au);

	public abstract void removeUnit(Unit au);

	/**
	 * Visitor method
	 */
	public abstract void accept(UnitVisitor v);

	/**
	 * Game Cst and methods
	 */
	public static final int RENDERING_SIZE = 50;

	@Override
	public Rectangle getBoundingBox() {
		return (new Rectangle(this.getPosition().x, this.getPosition().y, Unit.RENDERING_SIZE, Unit.RENDERING_SIZE));
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		if (movable)
			this.spriteManager.increment();

	}
}
