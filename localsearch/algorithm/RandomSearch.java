package localsearch.algorithm;

import java.io.IOException;

import localsearch.problem.KnapSack;

public class RandomSearch {

	private final int		nbEvalMax;
	private final KnapSack	kp;

	public RandomSearch(KnapSack kp, int nbEvalMax) {
		this.nbEvalMax = nbEvalMax;
		this.kp = kp;
	}

	public void run() throws IOException {
		float evalTemp, evalMax = kp.eval();
		
		for (int i = 0; i < this.nbEvalMax; i++) {
			KnapSack kp_tmp = new KnapSack(kp.getFileName());
			evalTemp = kp_tmp.eval();
			
			if(evalMax < evalTemp){
				evalMax = evalTemp;
				kp.setSolution(kp_tmp.getSolution());
			}
		}
		
		System.out.println("The best solution after "+nbEvalMax+" evaluation is "+evalMax);
	}

}
