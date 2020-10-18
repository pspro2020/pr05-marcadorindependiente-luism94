package codes;

public class Task implements Runnable {
	//
	static final int TOTAL_THROWS = 10000;
	//
	private Die die;
	//
	private ScoreBoard scores;
	//
	public Task(Die die, ScoreBoard scores) {
		this.die = die;
		this.scores = scores;
	}
	//
	@Override
	public void run() {
		for (int i = 0; i < TOTAL_THROWS; i++) {
			try {
				System.out.println("Tirando...");
				scores.updateScores(die.scoreThrow());
				Thread.sleep(10);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
