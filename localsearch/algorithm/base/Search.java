package localsearch.algorithm.base;

import java.io.PrintStream;

import localsearch.solution.base.Solution;

public abstract class Search {
	private Solution sol;

	public Search(Solution s) {
		this.sol = s;
	}

	public Solution getSol() {
		return sol;
	}
	
	/**
	 * @Resum Run the algorithm of local search with the current solution 
	 * @param p : PrintStream to print the solution
	 */
	public abstract void run(PrintStream p);
}
