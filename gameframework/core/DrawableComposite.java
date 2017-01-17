package gameframework.core;

import java.awt.Graphics;
import java.util.Vector;

public class DrawableComposite implements Drawable {
	/**
	 * Drawable Composite Design pattern Composite des Drawables
	 */
	protected Vector<Drawable> drawables = new Vector<Drawable>();

	/**
	 * Add Drawable to the composite
	 * 
	 * @param Drawable
	 * 
	 * @return void
	 * 
	 * @see Drawable
	 */
	public void add(Drawable e) {
		drawables.addElement(e);
	}

	/**
	 * remove Drawable from the composite
	 * 
	 * @param Drawable
	 * 
	 * @return void
	 * 
	 * @see Drawable
	 */
	public void remove(Drawable e) {
		drawables.removeElement(e);
	}
	/**
	 * Draw function implementesd from Drawable interface
	 * 
	 * @param Graphics
	 * 
	 * @see gameframework.core.Drawable#draw(java.awt.Graphics)
	 */

	public void draw(Graphics g) {
		for (Drawable elem : drawables) {
			elem.draw(g);
		}
	}
}
