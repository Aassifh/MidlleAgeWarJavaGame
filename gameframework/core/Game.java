package gameframework.core;

import java.awt.Canvas;

public interface Game {
	//factory
	public void createGUI();

	public Canvas getCanvas();

	public void start();

	public void restore();

	public void save();

	public void pause();

	public void resume();
	/** 
	 * Observer 
	 * @return
	 */

	public ObservableValue<Integer>[] score();

	public ObservableValue<Integer>[] life();

	public ObservableValue<Boolean> endOfGame();
}
