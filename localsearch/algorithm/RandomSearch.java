package localsearch.algorithm;

import java.io.IOException;

import localsearch.problem.KnapSack;

public class RandomSearch extends Algo{

	public RandomSearch(KnapSack kp, int nbEvalMax) {
		super(kp, nbEvalMax);
	}

	@Override
	public void run() throws IOException {
		float evalTemp, evalMax = kp.eval();
		
		for (int i = 0; i < this.nbEvalMax; i++) {
			KnapSack kp_tmp = new KnapSack(kp.getFileName());
			evalTemp = kp_tmp.eval();
			
			if(evalMax < evalTemp){
				evalMax = evalTemp;
				kp.setSolutionByReference(kp_tmp.getSolution());
			}
		}
		
		System.out.println("The best solution after "+nbEvalMax+" evaluations is "+evalMax);
	}

	@Override
	public void writeLog(String file) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
