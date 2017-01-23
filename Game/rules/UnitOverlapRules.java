package Game.rules;

import java.awt.Point;
import java.util.Vector;

import gameframework.core.GameUniverse;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.Overlap;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;
import soldier.core.UnitSimple;

public class UnitOverlapRules extends OverlapRulesApplierDefaultImpl {
	protected GameUniverse universe;
	// here we define game spefications and extra rules and bonuses
	protected Point AllyUnitStartPos;
	protected Point EnemyUnitStartPos;
	protected boolean managedUnitDeath;
	private final ObservableValue<Integer> score;
	private final ObservableValue<Integer> life;
	private final ObservableValue<Boolean> endOfGame;
	private int firstAidKits=0;

	// begining with only a set of allies
	public UnitOverlapRules(Point AUnitPos, ObservableValue<Integer> life, ObservableValue<Integer> score,
			ObservableValue<Boolean> endOfGame) {
		this.AllyUnitStartPos = (Point) AUnitPos;
		this.life = life;
		this.endOfGame = endOfGame;
		this.score = score;
	}

	@Override
	public void setUniverse(GameUniverse universe) {
		this.universe = universe;

	}
	public void setFirstAidKits(int firstAidKits){
		this.firstAidKits=firstAidKits;
		
	}
	public void addEnemy(UnitSimple u){
		// composite pattern
		//faire un Unit group 
	}
	@Override
	public void applyOverlapRules(Vector<Overlap> overlappables){
		//gerer la mort du soldats 
		super.applyOverlapRules(overlappables);
	}
	public void overlapRule(UnitSimple u ,UnitSimple i){
		
	}

}
