package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	
	
	public void os() {
		String os  = System.getProperty("os.name");
		System.out.println("Nome so: " + os);
	}
	
	public void ip (String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				if(linha.contains("Adaptador")) {
					String[] vetor = linha.split(":");
					int length = vetor.length;
					for(int i=0; i<length;i++) {
						System.out.println(linha);		
					}
				}
				if(linha.contains("IPv4")) {
						String[] vetor = linha.split(":");
						int length = vetor.length;
						for(int i=1; i<length;i++) {
							System.out.println("numero: " + vetor[1]);		
						}
				}
				linha = buffer.readLine();
				
				
				
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void ping(String proc) {
		try {
			Process p = Runtime.getRuntime().exec(proc);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			double temp =0.0;
			double med = 0.0;
			while(linha != null) {
				if(linha.contains("tempo")){
					String [] vetor = linha.split("tempo=");
					String [] vt = vetor[1].split("ms");
					System.out.println("tempo: " + vt[0]);
					temp = Double.parseDouble(vt[0]);
					med= temp + med;
			
					linha = buffer.readLine();
				}else {
				linha = buffer.readLine();
				}	
			}
			med= med/10;
			System.out.println("Media = " + med);
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	 

}
