/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.core;

import Game.UnitGameMovable;


public abstract class UnitRider extends UnitSimple {

	public UnitRider(String name, BehaviorSoldier behavior,UnitGameMovable g) {
		super(name, behavior,g);
	}

	@Override
	public void accept(UnitVisitor v) {
		v.visit(this);
	}
}
