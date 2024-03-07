package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		 RedesController rc = new RedesController();
		 int busca=0;
		 while(busca!= 4) {
			 busca = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n 1 - Nome do Sistema Operacional \n 2 - Nome do adaptador e IPv4 \n 3 - Calcular media do ping no Google \n 4 - Encerrar busca"));
			 switch(busca) {
			 		case 1:  rc.os();
			 				 break;
			 		case 2:  String process = "ipconfig";
			 				 rc.ip(process);
			 				 break;
			 		case 3:  String proc = "ping -4 -n 10 www.google.com.br";
					 		 rc.ping(proc);
					 		 break;
			 		case 4:  JOptionPane.showMessageDialog(null,"Programa finalizado");
			 				 break;
			 		default: JOptionPane.showMessageDialog(null,"Opção Inválida");
			 }
		 }
	}
}
