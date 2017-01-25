package Game.rules;

import java.util.Vector;


import gameframework.core.Movable;
import gameframework.moves_rules.IllegalMoveException;
import gameframework.moves_rules.MoveBlocker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.MoveBlockerRulesApplier;
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
