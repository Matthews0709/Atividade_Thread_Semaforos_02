package view;

import java.util.concurrent.Semaphore;

import controller.Controller_Atv_01_Cruzamento;

public class Main_Atv_01_Cruzamento 
{
	public static void main (String[]args)
	{
		int permissao = 4;
		
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int carro = 0; carro < 4; carro++)
		{
			Thread Tcarro = new Controller_Atv_01_Cruzamento(carro,semaforo);
			Tcarro.start();
		}
	}
	
	
}
