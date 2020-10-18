package codes;

public class Task implements Runnable {
	//Clase Tarea que representa el hilo secundario del programa
	
	//Constante que determina la cantidad de tiradas totales
	static final int TOTAL_THROWS = 10000;
	//Objeto Dado asociado al hilo
	private Die die;
	//Objeto Marcador asociado a las tiradas de dado del hilo actual
	private ScoreBoard scores;
	
	//Metodo constructor de la clase Tarea que recibe un objeto Dado y un objeto Marcador por parametro
	public Task(Die die, ScoreBoard scores) {
		this.die = die;
		this.scores = scores;
	}
	
	//Metodo implementado de la Interfaz Runnable y sobreescrito por la clase Tarea para que el hilo
	//realice el bloque de codigo que se escriba dentro cuando sea iniciado por el hilo principal
	@Override
	public void run() {
		for (int i = 0; i < TOTAL_THROWS; i++) {
			try {
				System.out.println("Tirando...");
				scores.updateScores(die.scoreThrow());
				Thread.sleep(10);	//El hilo queda en espera despues de tirar el dado
			} catch (InterruptedException e) {
				System.out.printf("%s -- ERROR DE EJECUCION\n", Thread.currentThread().getName());
				return;
			}
		}
	}

}
