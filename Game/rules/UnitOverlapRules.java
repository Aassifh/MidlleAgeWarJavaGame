package Game.rules;

import java.awt.Point;
import java.util.Vector;
import gameframework.core.GameMovableDriverDefaultImpl;
import gameframework.core.GameUniverse;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.MoveBlockerChecker;
import gameframework.moves_rules.MoveStrategyRandom;
import gameframework.moves_rules.Overlap;
import gameframework.moves_rules.OverlapRulesApplierDefaultImpl;
import soldier.ages.AgeFutureFactory;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.units.UnitCenturion;
import soldier.units.UnitRobot;
import java.awt.Canvas;
import Game.entities.power;
import Game.entities.tresor;

public class UnitOverlapRules extends OverlapRulesApplierDefaultImpl {
	
	protected GameUniverse universe;
	protected Canvas canvas;
	protected MoveBlockerChecker moveBlockerChecker;
	protected Vector<UnitCenturion> Ennemi = new Vector<UnitCenturion>();
	static final int Power_DURATION = 20;
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

	public void overlapRule(UnitRobot p, UnitCenturion g) {

		universe.removeGameEntity(g);
		score.setValue(score.getValue()+1);
		Ennemi.remove(Ennemi.size()-1);
		isEnd();

	}
	
	private void isEnd() {
		// TODO Auto-generated method stub
		if(Ennemi.size()==0)
		endOfGame.setValue(true);
	}

	public void overlapRule(UnitRobot p, power pw) {
		
		universe.removeGameEntity(pw);
		
		for (UnitCenturion ennemi : Ennemi) {
			ennemi.setWeak(Power_DURATION);
		}
	}

	public void overlapRule(UnitCenturion g, power pw) {
		
		universe.removeGameEntity(pw);
		AgeAbstractFactory fact3 = AgeMiddleFactory.getInstance();
		
		for (int i = 0; i < 2; i++) {
			UnitCenturion unit4=(UnitCenturion) fact3.infantryUnit(canvas, "C"+i);
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
		AgeAbstractFactory fact2 = AgeFutureFactory.getInstance();
		
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

}

	