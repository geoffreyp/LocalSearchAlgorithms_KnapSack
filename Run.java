import localsearch.algorithm.HillClimberBestImprovement;
import localsearch.algorithm.HillClimberFirstImprovement;
import localsearch.algorithm.RandomSearch;
import localsearch.algorithm.RandomWalk;
import localsearch.problem.KnapSack;

public class Run {

	public static void main(String[] args) {
		try {
			KnapSack kp = new KnapSack("ks_1000.dat");

			switch (args[0]) {
			case "rs":
				System.out.println("Random Search");
				RandomSearch rs = new RandomSearch(kp, 100000);
				rs.run();
				break;
			case "rw":
				System.out.println("Random Walk");
				RandomWalk rw = new RandomWalk(kp, 100000);
				rw.run();
				break;
			case "hcb":
				System.out.println("Hill Climber Best Improvement");
				HillClimberBestImprovement hcb = new HillClimberBestImprovement(kp, 0);
				hcb.run();
				break;
			case "hcf":
				System.out.println("Hill Climber First Improvement");
				HillClimberFirstImprovement hcf = new HillClimberFirstImprovement(kp, 10000);
				hcf.run();
				break;

			default:
				System.err.println("The algorithm " + args[0] + " is incorrect. Please use as first argument :");
				System.err.println("rs : Random Search");
				System.out.println("rw :Random Walk");
				System.out.println("hcb :Hill Climber Best Improvement");
				System.out.println("hcf :Hill Climber First Improvement");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
