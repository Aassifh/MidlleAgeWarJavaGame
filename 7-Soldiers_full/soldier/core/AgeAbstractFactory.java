/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.core;

import java.awt.Canvas;




public interface AgeAbstractFactory {
	//to much params going for the builder pattern ?
	Unit infantryUnit(Canvas canvas ,String name);

	Unit riderUnit(Canvas canvas ,String name );

	Weapon attackWeapon();

	Weapon defenseWeapon();
	 
}
