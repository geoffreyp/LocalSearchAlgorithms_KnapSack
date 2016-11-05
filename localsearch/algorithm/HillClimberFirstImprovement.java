package localsearch.algorithm;

import java.io.IOException;
import java.util.Random;

import localsearch.problem.KnapSack;

public class HillClimberFirstImprovement extends Algo {

	public HillClimberFirstImprovement(KnapSack kp, int nbEvalMax) {
		super(kp, nbEvalMax);
	}

	@Override
	public void run() throws IOException {
		float eval = kp.eval();
		float best_eval_neighbor = 0;
		int indiceSave = 0;
		int nbEval = 0;

		/*
		 * Search the optimum local
		 */
		while (nbEval < nbEvalMax) {
			/*
			 * Search a better neighbor solution than the actual solution
			 */
			boolean betterSolutionFounded = false;
			
			do {
				// Take a random neighbor solution
				KnapSack kp_neighbor = new KnapSack(kp.getFileName());
				kp_neighbor.setSolutionByCopy(kp.getSolution());
				int randomIndice = randomIndice();
				nbEval++;
				kp_neighbor.setSolution(randomIndice, (kp_neighbor.getSolution()[randomIndice] == 1) ? 0 : 1);
				
				//System.out.println("Debug : "+nbEval+".) "+best_eval_neighbor+" < "+kp_neighbor.eval());
				
				// Test the random neighbor solution
				if (best_eval_neighbor < kp_neighbor.eval()) {
					best_eval_neighbor = kp_neighbor.eval();
					betterSolutionFounded = true;
					indiceSave = randomIndice;
				}

			} while (!betterSolutionFounded && nbEval < nbEvalMax);
			
			
			/*
			 * Test the best neighbor solution with the actual best solution
			 */
			if (eval < best_eval_neighbor) {
				System.out.println("ca passe");
				eval = best_eval_neighbor;
				kp.setSolution(indiceSave, (kp.getSolution()[indiceSave] == 1) ? 0 : 1);
			}
		}
		
		
		System.out.println("The best solution founded is " + eval);
	}

	private int randomIndice() {
		Random r = new Random();
		return r.nextInt((kp.getSolution().length));
	}

}
