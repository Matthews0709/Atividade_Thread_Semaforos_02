package view;

import controller.Controller_Atv_03_Banco;
import java.util.concurrent.Semaphore;

public class Main_Atv_03_Banco
{
	public static void main(String[]args)
	{
		int permissao = 20;
		
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int clientes = 0; clientes < 20; clientes++)
		{
			Thread Tcliente = new Controller_Atv_03_Banco(clientes, semaforo);
			Tcliente.start();
		}
	}
		
}
