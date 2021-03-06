/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.ages;

import java.awt.Canvas;



import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.Weapon;
import soldier.units.UnitBikerMan;
import soldier.units.UnitRobot;
import soldier.weapon.WeaponGun;
import soldier.weapon.WeaponShield;

public class AgeFutureFactory implements AgeAbstractFactory {
	private static AgeAbstractFactory Instance;
	private  AgeFutureFactory() {
		// TODO Auto-generated constructor stub
	}
	public synchronized static AgeAbstractFactory getInstance(){
		if (Instance==null)
			return new AgeFutureFactory();
		return Instance;
	}
	@Override
	public Unit infantryUnit(Canvas canvas,String name) {
		return new UnitRobot(canvas,name);
	}

	@Override
	public Unit riderUnit(Canvas canvas ,String name) {
		return new UnitBikerMan(canvas,name);
	}

	@Override
	public Weapon attackWeapon() {
		// TODO Auto-generated method stub
		return new WeaponGun();
	}

	@Override
	public Weapon defenseWeapon() {
		
		return new WeaponShield();
	}

}
