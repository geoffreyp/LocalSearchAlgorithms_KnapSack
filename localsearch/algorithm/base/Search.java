package localsearch.algorithm.base;

import localsearch.problem.base.Problem;

public abstract class Search {
	Problem p;
	
	public Search(Problem p) {
		this.p = p;
	}
	
	public abstract void run();
}
