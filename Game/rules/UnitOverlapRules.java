package Game.rules;

import java.awt.Point;
import java.util.Random;
import java.util.Vector;
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
import soldier.core.BehaviorSoldier;
import soldier.core.Unit;
import soldier.core.UnitGroup;
import soldier.units.UnitCenturion;
import soldier.units.UnitHorseMan;
import soldier.units.UnitRobot;
import java.awt.Canvas;
import Game.entities.power;
import Game.entities.tresor;

public class UnitOverlapRules extends OverlapRulesApplierDefaultImpl {

	protected GameUniverse universe;
	protected Canvas canvas;
	protected MoveBlockerChecker moveBlockerChecker;
	protected UnitGroup army;
	protected UnitGroup MyArmy;
	static final int Power_DURATION = 20;
	protected Point UnitStartPos;
	protected Point EnnemiStartPos;
	protected boolean Death;
	Random rm = new Random();
	boolean tour;
	private final ObservableValue<Integer> score;
	private final ObservableValue<Integer> life;
	private final ObservableValue<Boolean> endOfGame;
	// private final ObservableValue<BehaviorSoldier> behavior;

	public UnitOverlapRules(Point pacPos, Point gPos, ObservableValue<Integer> life, ObservableValue<Integer> score,
			ObservableValue<Boolean> endOfGame) {
		UnitStartPos = (Point) pacPos.clone();
		EnnemiStartPos = (Point) gPos.clone();
		this.life = life;
		this.score = score;
		this.endOfGame = endOfGame;
		tour=true;
	}

	public void setCanvas(Canvas canvas) {
		// TODO Auto-generated method stub
		this.canvas = canvas;
	}

	public void setUniverse(GameUniverse universe) {
		this.universe = universe;
	}

	public void setMoveBlockerChecker(MoveBlockerChecker moveBlockerChecker) {
		this.moveBlockerChecker = moveBlockerChecker;
	}

	public void setEnnemi(UnitGroup ennemi) {
		army = ennemi;
	}

	public void setMyArmy(UnitGroup Myarmy) {
		MyArmy = Myarmy;
	}

	@Override
	public void applyOverlapRules(Vector<Overlap> overlappables) {
		Death = true;
		this.life.setValue((int) this.MyArmy.getHealthPoints());
		super.applyOverlapRules(overlappables);
	}

	public void overlapRule(UnitRobot p, UnitCenturion g) {
		p.parry(g.strike());
		g.parry(p.strike());
		
		life.setValue((int)p.getHealthPoints());
		if(!g.alive()){
			universe.removeGameEntity(g);
		}
			
		

	}
	public void overlapRule(UnitRobot p, UnitHorseMan g) {
		p.parry(g.strike());
		g.parry(p.strike());
		
		life.setValue((int)p.getHealthPoints());
		if(!g.alive()){
			universe.removeGameEntity(g);
		}
			
		

	}

	public void overlapRule(UnitRobot p, power pw) {

		universe.removeGameEntity(pw);
		MyArmy.heal();
		tour=true;
	}

	public void overlapRule(UnitCenturion g, power pw) {

		universe.removeGameEntity(pw);
		AgeAbstractFactory fact3 = AgeMiddleFactory.getInstance();

		for (int i = 0; i < 2; i++) {
			UnitHorseMan unit4 = (UnitHorseMan) fact3.riderUnit(canvas, "HORSEMAN");
			this.army.addUnit(unit4);
			GameMovableDriverDefaultImpl UnitDriver4 = new GameMovableDriverDefaultImpl();
			MoveStrategyRandom key = new MoveStrategyRandom();
			UnitDriver4.setStrategy(key);
			UnitDriver4.setmoveBlockerChecker(moveBlockerChecker);
			unit4.setDriver(UnitDriver4);
			unit4.setPosition(new Point((14 + i) * 16, 15 * 16));
			universe.addGameEntity(unit4);
		}

	}

	public void overlapRule(UnitRobot p, tresor tresor) {

		universe.removeGameEntity(tresor);
		AgeAbstractFactory fact2 = AgeFutureFactory.getInstance();

		for (int i = 0; i < 2; i++) {

			UnitRobot unit3 = (UnitRobot) fact2.infantryUnit(canvas, "myArmy");
			this.MyArmy.addUnit(unit3);
			GameMovableDriverDefaultImpl UnitDriver3 = new GameMovableDriverDefaultImpl();
			MoveStrategyRandom key = new MoveStrategyRandom();
			UnitDriver3.setStrategy(key);
			UnitDriver3.setmoveBlockerChecker(moveBlockerChecker);
			unit3.setDriver(UnitDriver3);
			unit3.setPosition(new Point(5 * 16, 25 * 16));
			universe.addGameEntity(unit3);
		}
		tour=true;

	}

}
