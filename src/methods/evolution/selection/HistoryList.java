/**
 * 
 */
package methods.evolution.selection;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author iskoulis ekontogi
 *
 */
public class HistoryList extends LinkedList<Double> {
	
	private static final long serialVersionUID = -4964516675117737045L;
	int size;
	boolean changed;
	double worst;
	
	public HistoryList (int size) {
		this.size = size;
	}
	/**
	 *@param: value to be pushed into the list
	 */
	public void push(Double value) {
		if (super.size() == this.size) {
			super.pollLast();
			super.push(value);
		} else {
			super.push(value);
		}
		changed = true;
	}
	/**
	 *@return: worst value in the list
	 */
	public double getWorst() {
		if (changed) {
			Iterator<Double> it = this.iterator();
			double worst = this.getFirst();
			while(it.hasNext()) {
				double cur = it.next();
				if (cur > worst) {
					worst = cur;
				}
			}
			this.worst = worst;
			changed = false;
			return this.worst;
		} else {
			return this.worst;
		}
	}
}
