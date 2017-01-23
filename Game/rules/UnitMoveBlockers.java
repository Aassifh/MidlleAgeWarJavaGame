package Game.rules;

import java.util.Vector;

import Game.entities.UnitEntity;
import gameframework.core.Movable;
import gameframework.moves_rules.IllegalMoveException;
import gameframework.moves_rules.MoveBlocker;
import gameframework.moves_rules.MoveBlockerCheckerDefaultImpl;
import gameframework.moves_rules.MoveBlockerRulesApplier;
import gameframework.moves_rules.MoveBlockerRulesApplierDefaultImpl;
import soldier.core.Unit;

public class UnitMoveBlockers extends MoveBlockerRulesApplierDefaultImpl{

	public UnitMoveBlockers() {
		
	}
	public void moveBlockerRule(UnitEntity i , UnitEntity j) throws IllegalMoveException{
		if (i.getSoldier().alive()&& j.getSoldier().alive())
			throw new IllegalMoveException();
	}
	

}
