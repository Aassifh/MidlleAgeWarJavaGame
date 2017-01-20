package Game.entities;

import java.awt.*;




import gameframework.core.Drawable;
import gameframework.core.GameEntity;
import gameframework.core.GameMovable;
import gameframework.core.Overlappable;
import gameframework.core.SpriteManager;
import gameframework.core.SpriteManagerDefaultImpl;
import gameframework.moves_rules.MoveBlocker;
import soldier.core.Unit;

public abstract class UnitEntity extends GameMovable implements Drawable ,GameEntity,Overlappable  {
	protected final SpriteManager spriteManager;
	public static final int RENDERING_SIZE=16;
	protected boolean movable=true;
	protected Unit Soldier;
	public UnitEntity(Canvas canvas,Unit u){
		this.spriteManager= new SpriteManagerDefaultImpl("images/Horseman.gif", canvas, RENDERING_SIZE, 4);
		this.spriteManager.setTypes("right","left","up","down",// Moves
				"static",//static ?
				"dead");
	}
	
public void draw (Graphics g){
	String spriteType="";
	Point tmp = getSpeedVector().getDirection();
	// intégrer le mode combat après le test 
	if(this.Soldier.alive())
	{
		if (tmp.getX()==1)
			spriteType+="right";
		else if (tmp.getX()==-1)
			spriteType+="left";
		else if (tmp.getY()==1)
			spriteType+="down";
		else if (tmp.getY()==-1)
			spriteType+="up";
		else {
			spriteType="static";
			spriteManager.reset();
			movable=false;
			
		}
	}
	spriteManager.setType(spriteType);
	spriteManager.draw(g, getPosition());
	
	
}
public void oneStepMoveAddedBehavior(){
	if (movable)
		this.spriteManager.increment();
}
public Rectangle getBoundingBox(){
	return (new Rectangle(this.getPosition().x,this.getPosition().y,RENDERING_SIZE,RENDERING_SIZE));
}

}
