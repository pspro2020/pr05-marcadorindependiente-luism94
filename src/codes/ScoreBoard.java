package codes;

public class ScoreBoard {
	//Clase Marcador que contiene los resultados de las tiradas de dado de los hilos secundarios
	
	//Variables contador de cada cara del dado
	private int oneThrows = 0;
	private int twoThrows = 0;
	private int threeThrows = 0;
	private int fourThrows = 0;
	private int fiveThrows = 0;
	private int sixThrows = 0;

	//Metodos get de cada contador
	public int getOneThrows() {
		return oneThrows;
	}
	public int getTwoThrows() {
		return twoThrows;
	}
	public int getThreeThrows() {
		return threeThrows;
	}
	public int getFourThrows() {
		return fourThrows;
	}
	public int getFiveThrows() {
		return fiveThrows;
	}
	public int getSixThrows() {
		return sixThrows;
	}
	
	//Metodos que calculan el valor de cada tirada por el numero de tiradas y el valor del numero del dado
	public int getOneScore() {
		return getOneThrows();
	}
	public int getTwoScore() {
		return getTwoThrows() * 2;
	}
	public int getThreeScore() {
		return getThreeThrows() * 3;
	}
	public int getFourScore() {
		return getFourThrows() * 4;
	}
	public int getFiveScore() {
		return getFiveThrows() * 5;
	}
	public int getSixScore() {
		return getSixThrows() * 6;
	}
	
	/*Metodo SINCRONIZADO que se encarga de añadir una tirada mas al contador del valor recibido del dado
	**Evita que se alteren los resultados forzando a que los demas hilos tengan que esperar al que llegue
	**primero para modificar el contador oportuno
	*/
	public synchronized void updateScores(int throwScore) {
		switch (throwScore) {
		case 1:
			oneThrows++;
			break;
		case 2:
			twoThrows++;
			break;
		case 3:
			threeThrows++;
			break;
		case 4:
			fourThrows++;
			break;
		case 5:
			fiveThrows++;
			break;
		case 6:
			sixThrows++;
			break;
		}
	}
	//Metodo que muestra el resultado de la ejecucion de todos los hilos mostrando el valor de cada contador
	public void showDieThrows() {
		System.out.println(" --- RESULTADO TIRADAS ---");
		System.out.println();
		System.out.println("Tiradas 1: " + getOneThrows());
		System.out.println("Tiradas 2: " + getTwoThrows());
		System.out.println("Tiradas 3: " + getThreeThrows());
		System.out.println("Tiradas 4: " + getFourThrows());
		System.out.println("Tiradas 5: " + getFiveThrows());
		System.out.println("Tiradas 6: " + getSixThrows());
		
		System.out.printf("Total tiradas: %d + %d + %d + %d + %d + %d = %d\n", getOneThrows(), getTwoThrows(),
				getThreeThrows(), getFourThrows(), getFiveThrows(), getSixThrows(),
				getOneThrows() + getTwoThrows() + getThreeThrows() + getFourThrows() + getFiveThrows() + getSixThrows());
	}
	//Metodo que muestra la puntuacion final dependiendo del valor del dado
	public void showTotalScore() {
		System.out.println("--- RESULTADO PUNTUACION ---");
		System.out.println();
		System.out.println("Total resultado 1: " + getOneScore());
		System.out.println("Total resultado 2: " + getTwoScore());
		System.out.println("Total resultado 3: " + getThreeScore());
		System.out.println("Total resultado 4: " + getFourScore());
		System.out.println("Total resultado 5: " + getFiveScore());
		System.out.println("Total resultado 6: " + getSixScore());
		
		System.out.printf("Total tiradas: %d + %d + %d + %d + %d + %d = %d\n", getOneScore(), getTwoScore(),
				getThreeScore(), getFourScore(), getFiveScore(), getSixScore(),
				getOneScore() + getTwoScore() + getThreeScore() + getFourScore() + getFiveScore() + getSixScore());
	}
	
}
