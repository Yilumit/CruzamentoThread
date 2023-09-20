package controller;

import java.util.concurrent.Semaphore;

public class Principal {

	public static void main(String[] args) {
		String sentido[] = {"Norte", "Sul","Leste","Oeste"};
		int permicoes = 1;
		
		Semaphore semaforo = new Semaphore(permicoes);
		
		for (int idCarro = 1; idCarro <= 4; idCarro++) {
			ThreadCarro cruzar = new ThreadCarro(idCarro, sentido[idCarro-1], semaforo);
			cruzar.start();
		}
		
	}

}
