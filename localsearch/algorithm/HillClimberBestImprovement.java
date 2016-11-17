package localsearch.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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

	@Override
	public void writeLog(String file) throws IOException {
		// TODO Auto-generated method stub
			String chaine="";
			try{
				InputStream ips=new FileInputStream(file); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;
				while ((ligne=br.readLine())!=null){
					System.out.println(ligne);
					chaine+=ligne+"\n";
				}
				br.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter (fw);
				PrintWriter fichierSortie = new PrintWriter (bw); 
				fichierSortie.println(chaine); 
				fichierSortie.close();
			}
			catch (Exception e){
				System.out.println(e.toString());
			}		
		}
}
