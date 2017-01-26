package Game.rules;

import java.awt.Canvas;
import java.awt.Point;
import java.util.Random;

import Game.entities.power;
import gameframework.core.GameUniverse;

public class PowerRule extends Thread{
	
	protected GameUniverse universe;
	protected Canvas canvas;
	protected int[][] tab;
	protected power pw;

	Random random = new Random();
	int i, j ;
	
	public PowerRule(GameUniverse universe, Canvas canvas, int[][] tab) {
		super();
		this.universe = universe;
		this.canvas = canvas;
		this.tab = tab;
	}

	public void run() {
		while(true){
			try {
				sleep(2000);
				i = random.nextInt(15);
				j = random.nextInt(15);
				pw = new power(canvas, new Point(j * 16, i * 16));
				if (tab[i][j] == 5)
				universe.addGameEntity(pw);
				sleep(6000);
				universe.removeGameEntity(pw);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	}
}
