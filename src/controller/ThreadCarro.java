package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	private int idCarro;
	private String sentido;
	private static Semaphore semaforo;

	public ThreadCarro(int idCarro, String sentido, Semaphore semaforo){
		this.idCarro = idCarro;
		this.sentido = sentido;	
		ThreadCarro.semaforo = semaforo;

	}
	
	@Override
	public void run(){
		carroParado();
		try{
			semaforo.acquire();
		cruzarFarol();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void cruzarFarol() {
		try {
//			sleep(1);
			System.out.println("O semáforo abriu para o sentido "+sentido);
			System.out.println("O carro "+idCarro+" está cruzando o semáforo indo em direção à zona "+sentido);
			sleep(2000);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O carro "+idCarro+" fez o cruzamento \nO semáforo fechou");
	
	}

	private void carroParado(){
		System.out.println("O carro "+idCarro+" está parado no farol");
		
	}

	
}
