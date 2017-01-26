/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.ages;

import java.awt.Canvas;



import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.Weapon;
import soldier.units.UnitCenturion;
import soldier.units.UnitHorseMan;
import soldier.weapon.WeaponShield;
import soldier.weapon.WeaponSword;


public class AgeMiddleFactory implements AgeAbstractFactory {
	private static AgeAbstractFactory Instance;
	private  AgeMiddleFactory() {
		// TODO Auto-generated constructor stub
	}
	public synchronized static AgeAbstractFactory getInstance(){
		if (Instance==null)
			return new AgeMiddleFactory();
		return Instance;
	}

	@Override
	public Unit infantryUnit(Canvas canvas,String name) {
		return new UnitCenturion(canvas,name);
	}

	@Override
	public Unit riderUnit(Canvas canvas,String name) {
		return new UnitHorseMan(canvas,name);
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
