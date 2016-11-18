package localsearch.algorithm;

import java.io.IOException;

import localsearch.problem.KnapSack;

public abstract class Algo {

	protected int		nbEvalMax;
	protected KnapSack	kp;
	
	public Algo(KnapSack kp, int nbEvalMax) {
		this.nbEvalMax = nbEvalMax;
		this.kp = kp;
	}

	public abstract void run() throws IOException;
	public abstract void writeLog(String file) throws IOException;
}
