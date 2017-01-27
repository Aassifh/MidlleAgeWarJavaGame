package Game.rules;


import gameframework.moves_rules.IllegalMoveException;

import gameframework.moves_rules.MoveBlockerRulesApplierDefaultImpl;
import soldier.core.Unit;

public class UnitMoveBlockers extends MoveBlockerRulesApplierDefaultImpl{

	// definir les regles de blockage phase conception 
	/* idéé:
	 * 
	 */
	
	public UnitMoveBlockers() {
		
	}
	public void moveBlockerRule(Unit i , Unit j) throws IllegalMoveException{
		if (i.alive()&& j.alive())
			throw new IllegalMoveException();
	}
	

}
