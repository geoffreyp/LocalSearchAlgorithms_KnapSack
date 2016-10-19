package localsearch.algorithm;

import java.io.IOException;

import localsearch.problem.KnapSack;

public class RandomWalk extends Algo {

	public RandomWalk(KnapSack kp, int nbEvalMax) {
		super(kp, nbEvalMax);
	}

	@Override
	public void run() throws IOException {
		float evalTemp, evalMax = kp.eval();

		for (int i = 0; i < this.nbEvalMax; i++) {
			changeVoisinAlea();
			evalTemp = kp.eval();
			
			if(evalMax < evalTemp)
				evalMax = evalTemp;
		}
		
		System.out.println("The best solution after "+nbEvalMax+" evaluations is "+evalMax);

	}
	
	private void changeVoisinAlea() throws IOException{
		int voisin = (int) (Math.random() * (this.kp.getSolution().length));
		if(this.kp.getSolution()[voisin]==0)
			this.kp.getSolution()[voisin] = 1;
		else
			this.kp.getSolution()[voisin] = 0;
	}

}
