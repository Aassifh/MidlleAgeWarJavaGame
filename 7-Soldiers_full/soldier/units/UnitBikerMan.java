/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.units;

import java.awt.Canvas;
import java.awt.Graphics;

import soldier.core.BehaviorSoldierStd;
import soldier.core.BreakingRuleException;
import soldier.core.UnitRider;
import soldier.core.Weapon;

public class UnitBikerMan extends UnitRider  {

	public UnitBikerMan(Canvas canvas,String soldierName) {
		super(soldierName, new BehaviorSoldierStd(20, 120));
	}

	/**
	 * A BikerMan can have at most one equipment
	 */
	@Override
	public void addEquipment(Weapon w) {
		if (nbWeapons() > 0)
			throw new BreakingRuleException();
		super.addEquipment(w);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	
	


}
