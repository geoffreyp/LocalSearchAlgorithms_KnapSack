import java.io.IOException;

import localsearch.algorithm.HillClimberBestImprovement;
import localsearch.algorithm.HillClimberFirstImprovement;
import localsearch.algorithm.RandomSearch;
import localsearch.algorithm.RandomWalk;
import localsearch.problem.KnapSack;

public class Run {

	public static void main(String[] args) {
		try {
//				KnapSack kp1 = new KnapSack("ks_1000.dat");
//				System.out.println("Random Search :");
//				RandomSearch rs = new RandomSearch(kp1, 100000);
//				rs.run();
//
//				KnapSack kp2 = new KnapSack("ks_1000.dat");
//				System.out.println("Random Walk :");
//				RandomWalk rw = new RandomWalk(kp2, 100000);
//				rw.run();	
				

//				KnapSack kp3 = new KnapSack("ks_1000.dat");
//				System.out.println("HC Best Improvement:");
//				HillClimberBestImprovement hcb = new HillClimberBestImprovement(kp3, 0);
//				hcb.run();
				
			
			KnapSack kp4 = new KnapSack("ks_1000.dat");
			System.out.println("HC First Improvement:");
			HillClimberFirstImprovement hcf = new HillClimberFirstImprovement(kp4, 2000);
			hcf.run();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
