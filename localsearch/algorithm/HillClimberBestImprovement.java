package localsearch.algorithm;

import java.io.IOException;

import localsearch.problem.KnapSack;

public class HillClimberBestImprovement extends Algo {

	public HillClimberBestImprovement(KnapSack kp, int nbEvalMax) {
		super(kp, nbEvalMax);
	}

	@Override
	public void run() throws IOException {
		float eval = kp.eval();
		float eval_neighbor = 0;
		boolean stop = false;
		int indiceSave = 0;
		int nbEval = 0;

		/*
		 * Search the optimum local
		 */
		while(!stop){
			/*
			 * Search the best neighbor solution
			 */
			
			for (int i = 0; i < kp.getSolution().length; i++) {
				KnapSack kp_neighbor = new KnapSack(kp.getFileName());
				kp_neighbor.setSolutionByCopy(kp.getSolution());
				kp_neighbor.getSolution()[i] = (kp_neighbor.getSolution()[i] == 1)? 0 : 1;
				
				if(eval_neighbor < kp_neighbor.eval()){
					eval_neighbor = kp_neighbor.eval();
					indiceSave = i;
				}
			}
			
			/*
			 * Test the best neighbor solution with the actual best solution
			 */
			if(eval < eval_neighbor && nbEval < nbEvalMax){
				eval = eval_neighbor;
				kp.setSolution(indiceSave,(kp.getSolution()[indiceSave] == 1)? 0 : 1);
			}else{
				stop = true;
			}
			nbEval++;
		}
		System.out.println("The best solution founded is "+eval+" after "+nbEval+" evaluations");
	}

}
