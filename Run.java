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
				RandomSearch rs = new RandomSearch(kp, new Integer(args[1]));
				rs.run();
				break;
			case "rw":
				System.out.println("Random Walk");
				RandomWalk rw = new RandomWalk(kp, new Integer(args[1]));
				rw.run();
				break;
			case "hcb":
				System.out.println("Hill Climber Best Improvement");
				HillClimberBestImprovement hcb = new HillClimberBestImprovement(kp, new Integer(args[1]));
				hcb.run();
				break;
			case "hcf":
				System.out.println("Hill Climber First Improvement");
				HillClimberFirstImprovement hcf = new HillClimberFirstImprovement(kp, new Integer(args[1]));
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
			System.err.println("First arg : algo ; Second arg : number of evaluations");
		}

	}

}
