/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.ages;

import gameframework.core.GameMovable;
import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.Weapon;
import soldier.units.UnitBikerMan;
import soldier.units.UnitRobot;
import soldier.weapon.WeaponGun;
import soldier.weapon.WeaponShield;

public class AgeFutureFactory implements AgeAbstractFactory {
	// Game Movable adding 
	@Override
	public Unit infantryUnit(String name ) {
		return new UnitRobot(name);
	}

	@Override
	public Unit riderUnit(String name) {
		return new UnitBikerMan(name);
	}

	@Override
	public Weapon attackWeapon() {
		return new WeaponGun();
	}

	@Override
	public Weapon defenseWeapon() {
		return new WeaponShield();
	}
}
