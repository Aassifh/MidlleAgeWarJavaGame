package soldier.util;

import java.util.Observer;

public interface observable {

		void addObserver(observer ob);

		void removeObserver(observer ob);

		void notifyObservers();
	}