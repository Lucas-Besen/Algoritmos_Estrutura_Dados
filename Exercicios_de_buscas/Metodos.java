package exercicio;


public class Metodos {
	//metodos de ordemacao
	
	int j=0;
	double eleitoSalario=0;
	String eleitoN="",eleitoS;
	
	//Crescente
	public void Crescente(String[][]matriz){
		
		for ( int i= 1; i < matriz.length ; i++){

			 eleitoSalario=Double.parseDouble(matriz[i][1]);
			 eleitoN=matriz[i][0];
			 j=i-1;
		     while(j>=0 && Double.parseDouble(matriz[j][1])>eleitoSalario ) 
		     {
		    	matriz[j+1][1]= matriz[j][1];
		    	matriz[j+1][0] =matriz[j][0];
		        j--;
		         
		     }
		     matriz[j+1][1] = Double.toString(eleitoSalario);
		     matriz[j+1][0] = eleitoN;
		}
	}

	//Decrescente
	public void Decrescente(String[][]matriz) {
		
		for ( int i= 1; i < matriz.length ; i++){

			 eleitoSalario=Double.parseDouble(matriz[i][1]);
			 eleitoN=matriz[i][0];
			 j=i-1;
		     while(j>=0 && Double.parseDouble(matriz[j][1])<eleitoSalario ) 
		     {
		    	matriz[j+1][1]= matriz[j][1];
		    	matriz[j+1][0] =matriz[j][0];
		        j--;
		         
		    }
		    matriz[j+1][1] = Double.toString(eleitoSalario);
		    matriz[j+1][0] = eleitoN;
		}
	}
	
	//Alfabetica
	public void Alfabetica(String[][]matriz) {
		
		for ( int i= 1; i < matriz.length ; i++){

			 eleitoS=matriz[i][0];
			 eleitoN=matriz[i][1];
			 j=i-1;
			 while(j>=0 && (matriz[j][0].compareToIgnoreCase(eleitoS))>0) {
			
					matriz[j+1][0]= matriz[j][0];
			    	matriz[j+1][1] =matriz[j][1];
			        j--;
				
			}
		    matriz[j+1][0] = eleitoS;
		    matriz[j+1][1] = eleitoN;
		}
		
	}
		
			
			
	
}