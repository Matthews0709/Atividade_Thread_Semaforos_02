package controller;

import java.util.concurrent.Semaphore;

public class Controller_Atv_01_Cruzamento extends Thread
{
	private int carro;
	private Semaphore semaforo;
	
	public Controller_Atv_01_Cruzamento(int carro, Semaphore semaforo) 
	{
		this.carro = carro;
		this.semaforo = semaforo;
	}
	
		public void run() 
		{
			try{
			semaforo.acquire();
			cruzamento();
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
		}

			private void cruzamento() 
			{
				 String sentido = null;
				 int s = 0;
				 s = (int)(Math.random()*3);
				 
				 if(s == 0)
				 {
					 sentido = ("oeste");
				 }else if(s == 1)
				 {
					 sentido = ("norte");
				 }if(s == 2)
				 {
					 sentido = ("leste");
				 }else if(s == 3)
				 {
					 sentido = ("sul");
				 }
				 
				 
				 System.out.println( "O carro " + carro + " no sentido " + sentido + " do cruzamento");
			}
	
}
