package controller;

import java.util.concurrent.Semaphore;

public class Controller_Atv_02_Corredor extends Thread
{
	private int Pessoa;
	private Semaphore semaforo;
	
	public Controller_Atv_02_Corredor(int Pessoa,Semaphore semaforo) 
	{
		this.Pessoa= Pessoa;
		this.semaforo = semaforo;
		
	}
	
		public void run() 
		{
			corredor();
			
			try {
				semaforo.acquire();
				porta();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
			
			
		}

			private void corredor() 
			{
				int movimento;
				int corredor = 200;
				
				movimento = (int)((Math.random()*2)+4);
				
				while(movimento < corredor) 
				{
					movimento = movimento +(int)((Math.random()*2)+4);
					
				}
			
			}

				private void porta() 
				{
					int tempo;
					int abrir = 0;
				
					tempo =(int)(Math.random()*3);
					
					while(abrir < tempo) 
					{
						abrir = abrir + 1;
					}	
					System.out.println("A pessoa acaba de cruzar a porta no fim do corredor" + Pessoa);
				}
	
	
	
}
