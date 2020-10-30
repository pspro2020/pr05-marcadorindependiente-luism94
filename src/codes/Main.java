package codes;

public class Main {
	//Constante que define el numero total de hilos secundarios
	static final int TOTAL_THREADS = 3;
	
	public static void main(String[] args) {
		//Array de hilos secundarios
		Thread[] threads = new Thread[TOTAL_THREADS];
		//Objeto Dado comun a todos los hilos
		Die die = new Die();
		//Objeto Marcador comun a todos los hilos que cuenta las tiradas de dado de cada hilo
		ScoreBoard scores = new ScoreBoard();
		//Creo los hilos y les asigno el dado y el marcador
		for (int i = 0; i < TOTAL_THREADS; i++) {
			threads[i] = new Thread(new Task(die, scores));
		}
		//Inicio la ejecucion de los hilos
		for (int i = 0; i < TOTAL_THREADS; i++) {
			threads[i].start();
		}
		//Fuerzo al hilo principal a que espere la ejecucion de los hilos secundarios
		try {
			for (int i = 0; i < TOTAL_THREADS; i++) {
				threads[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println("------- Error de ejecucion -------");
		}
		//Muestro los resultados de las tiradas
		scores.showDieThrows();
		scores.showTotalScore();		
	}
}
