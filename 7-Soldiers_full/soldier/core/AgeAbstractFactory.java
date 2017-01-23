/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.core;

import java.awt.Canvas;

import gameframework.core.GameMovable;

public interface AgeAbstractFactory {
	//to much params going for the builder pattern ?
	Unit infantryUnit(Canvas canvas ,String name,GameMovable g);

	Unit riderUnit(Canvas canvas ,String name , GameMovable g );

	Weapon attackWeapon();

	Weapon defenseWeapon();
}
