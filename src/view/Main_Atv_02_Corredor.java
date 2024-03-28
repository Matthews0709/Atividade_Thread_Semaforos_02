package view;

import java.util.concurrent.Semaphore;
import controller.Controller_Atv_02_Corredor;

public class Main_Atv_02_Corredor 
{
	public static void main(String[]args)
	{
		int permissao = 4;
		
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int Pessoa = 0; Pessoa < 4; Pessoa ++)
		{
			Thread TPessoa = new Controller_Atv_02_Corredor(Pessoa,semaforo);
			TPessoa.start();
			
		}
		
	}
	
	
}
