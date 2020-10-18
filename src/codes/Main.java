package codes;

public class Main {
	//
	static final int TOTAL_THREADS = 3;
	
	public static void main(String[] args) {
		//
		Thread[] threads = new Thread[TOTAL_THREADS];
		Die die = new Die();
		ScoreBoard scores = new ScoreBoard();
		//
		for (int i = 0; i < TOTAL_THREADS; i++) {
			threads[i] = new Thread(new Task(die, scores));
		}
		//
		for (int i = 0; i < TOTAL_THREADS; i++) {
			threads[i].start();
		}
		//
		try {
			for (int i = 0; i < TOTAL_THREADS; i++) {
				threads[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println("------- Error de ejecucion -------");
		}
		//
		scores.showDieThrows();
		scores.showTotalScore();		
	}
}
