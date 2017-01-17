/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.core;

import gameframework.core.GameMovable;

public abstract class UnitInfantry extends UnitSimple {

	public UnitInfantry(String name, BehaviorSoldier behavior,GameMovable g) {
		super(name, behavior,g);
	}

	@Override
	public void accept(UnitVisitor v) {
		v.visit(this);
	}
}
