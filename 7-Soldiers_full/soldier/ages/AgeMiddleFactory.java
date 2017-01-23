/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.ages;

import java.awt.Canvas;

import gameframework.core.GameMovable;
import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.Weapon;
import soldier.units.UnitCenturion;
import soldier.units.UnitHorseMan;
import soldier.weapon.WeaponShield;
import soldier.weapon.WeaponSword;

public class AgeMiddleFactory implements AgeAbstractFactory {

	@Override
	public Unit infantryUnit(Canvas canvas,String name, GameMovable g) {
		return new UnitCenturion(canvas,name,g);
	}

	@Override
	public Unit riderUnit(Canvas canvas,String name,GameMovable g) {
		return new UnitHorseMan(canvas,name,g);
	}

	@Override
	public Weapon attackWeapon() {
		return new WeaponSword();
	}

	@Override
	public Weapon defenseWeapon() {
		return new WeaponShield();
	}
}
