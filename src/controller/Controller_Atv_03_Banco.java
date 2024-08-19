package controller;

import java.util.concurrent.Semaphore;

public class Controller_Atv_03_Banco extends Thread
{
	private int cliente;
	private Semaphore semaforo;
	private float selec;
	private String cdg;
	private Double saldo = 0.0;
	private Double valor = 0.0;
	
	public Controller_Atv_03_Banco(int cliente, Semaphore semaforo) 
	{
		this.cliente = cliente;
		this.semaforo = semaforo;
		
	}
	
		public void run() 
		{
			selecao();
			if(selec == 0) {
				try {
					semaforo.acquire();
					saques();
					}catch(InterruptedException e){
						e.printStackTrace();
					}finally{
						semaforo.release();
					}
			}else if(selec == 1) {
				try {
					semaforo.acquire();
					depositos();
				}catch(InterruptedException e1){
					e1.printStackTrace();
				}finally {
					semaforo.release();
				}
			}
		}
		

		private void depositos() 
		{
			if( cdg != null && saldo != null && valor != null) 
			{
				saldo = saldo + valor;
				System.out.println("Deposito realizado com sucesso na conta " + cdg + " saldo atual " + saldo);
			}
			
		}

		private void saques() 
		{
			if( cdg != null && saldo != null && valor != null) 
			{
				if(valor <= saldo)
				{
					saldo = saldo - valor;
					System.out.println("Saque realizado com sucesso na conta " + cdg + " no valor de " + valor + " saldo atual " + saldo);
				}else {
					System.out.println("Saldo insuficiente");
				}
			}
			
			
		}

		private void selecao() 
		{
			selec = (int) (Math.random()*1);
			
			cdg = Integer.toString((int) (Math.random()*99));
			saldo = (Double) (Math.random()*999);
			valor = (Double) (Math.random()*999);
		}
	
}
