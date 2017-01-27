package soldier.util;



public interface observable {

		void addObserver(observer ob);

		void removeObserver(observer ob);

		void notifyObservers();
	}