package Game.rules;

import java.awt.Point;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverse;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveStrategyRandom;
import gameframework.moves_rules.MoveStrategyStraightLine;
import gameframework.moves_rules.Overlap;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;
import soldier.ages.AgeFutureFactory;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.UnitInfantry;
import soldier.core.UnitSimple;
import soldier.units.UnitCenturion;
import soldier.units.UnitRobot;

import java.awt.Canvas;
import java.awt.Point;
import java.util.Vector;

import Game.entities.power;
import Game.entities.tresor;

import gameframework.moves_rules.Overlap;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;
import soldier.core.UnitSimple;

public class UnitOverlapRules extends OverlapRulesApplierDefaultImpl {
	protected GameUniverse universe;
	protected Canvas canvas;
	protected MoveBlockerChecker moveBlockerChecker;
	
	protected Vector<UnitCenturion> Ennemi = new Vector<UnitCenturion>();
	
	static final int Power_DURATION = 60;
	protected Point UnitStartPos;
	protected Point EnnemiStartPos;
	protected boolean Death;
	private final ObservableValue<Integer> score;
	private final ObservableValue<Integer> life;
	private final ObservableValue<Boolean> endOfGame;
	

	public UnitOverlapRules(Point pacPos, Point gPos,
			ObservableValue<Integer> life, ObservableValue<Integer> score,
			ObservableValue<Boolean> endOfGame) {
		UnitStartPos = (Point) pacPos.clone();
		EnnemiStartPos = (Point) gPos.clone();
		this.life = life;
		this.score = score;
		this.endOfGame = endOfGame;
	}

	public void setCanvas(Canvas canvas) {
		// TODO Auto-generated method stub
		this.canvas=canvas;
	}

	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
	}
	
	public void setMoveBlockerChecker(MoveBlockerChecker moveBlockerChecker) {
		this.moveBlockerChecker = moveBlockerChecker;
	}
	
	public void setEnnemi(Vector<UnitCenturion> ennemi) {
		Ennemi = ennemi;
	}
	
	@Override
	public void applyOverlapRules(Vector<Overlap> overlappables) {
		Death = true;
		super.applyOverlapRules(overlappables);
	}

//	public void overlapRule(UnitRobot p, UnitCenturion g) {
//		if (!p.alive()) {
//			if (g.alive()) {
//				g.setAlive(false);
//				MoveStrategyStraightLine strat = new MoveStrategyStraightLine(
//						g.getPosition(), EnnemiStartPos);
//				GameMovableDriverDefaultImpl ghostDriv = (GameMovableDriverDefaultImpl) g
//						.getDriver();
//				ghostDriv.setStrategy(strat);
//
//			}
//		} else {
//			if (g.alive()) {
//				if (Death) {
//					life.setValue(life.getValue() - 1);
//					p.setPosition(UnitStartPos);
////					for (Ghost ghost : vGhosts) {
////						ghost.setPosition(ghostStartPos);
////					}
//					Death = false;
//				}
//			}
//		}
//	}
	
	public void overlapRule(UnitRobot p, power pw) {
		
		universe.removeGameEntity(pw);
		//p.setInvulnerable(INVULNERABLE_DURATION);
		//for (Ghost ghost : vGhosts) {
		//	ghost.setAfraid(INVULNERABLE_DURATION);
		//}
	}

	public void overlapRule(UnitCenturion g, power pw) {
		
		universe.removeGameEntity(pw);
		AgeAbstractFactory fact3 = new AgeMiddleFactory();
		
		for (int i = 0; i < 2; i++) {
			UnitCenturion unit4=(UnitCenturion) fact3.infantryUnit(canvas, "Centurion");
			Ennemi.addElement(unit4);
			GameMovableDriverDefaultImpl UnitDriver4= new GameMovableDriverDefaultImpl();
			MoveStrategyRandom key = new MoveStrategyRandom();
			UnitDriver4.setStrategy(key);
			UnitDriver4.setmoveBlockerChecker(moveBlockerChecker);
			unit4.setDriver(UnitDriver4);
			unit4.setPosition(new Point((14+i)*16,15*16));
			universe.addGameEntity(unit4);
		}
		
	}


	public void overlapRule(UnitRobot p, tresor tresor) {
		
		universe.removeGameEntity(tresor);
		AgeAbstractFactory fact2 = new AgeFutureFactory();
		
		for (int i = 0; i < 2; i++) {
			
			UnitRobot unit3=(UnitRobot) fact2.infantryUnit(canvas, "myArmy");
			GameMovableDriverDefaultImpl UnitDriver3= new GameMovableDriverDefaultImpl();
			MoveStrategyRandom key = new MoveStrategyRandom();
			UnitDriver3.setStrategy(key);
			UnitDriver3.setmoveBlockerChecker(moveBlockerChecker);
			unit3.setDriver(UnitDriver3);
			unit3.setPosition(new Point(13*16,25*16));
			universe.addGameEntity(unit3);
		}

	}
	
//	public void setFirstAidKits(int firstAidKits){
//		this.firstAidKits=firstAidKits;
//		
//	}
//	public void addEnemy(UnitSimple u){
//		// composite pattern
//		//faire un Unit group 
//	}
//	
//	@Override
//	public void applyOverlapRules(Vector<Overlap> overlappables){
//		//gerer la mort du soldats 
//		super.applyOverlapRules(overlappables);
//	}
//	public void overlapRule(UnitSimple u ,UnitSimple i){
//		
//	}

}

	