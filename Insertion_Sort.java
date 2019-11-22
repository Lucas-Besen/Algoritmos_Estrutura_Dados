import javax.swing.JOptionPane;

public class Insertion_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String retorno ="  ";
 		int tamanho,j,escolha;
 		double eleito;

		tamanho = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o tamanho do vetor ?","DADOS",JOptionPane.QUESTION_MESSAGE));
		double vetor [] = new double [tamanho];

		for (int i=0;i<tamanho;i++ ) 
		{

			vetor[i] = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o "+(i+1)+"º numero","DADOS",JOptionPane.QUESTION_MESSAGE));
		}
		String[] opt = { "Crescente", "Decrescente" };
		escolha = JOptionPane.showOptionDialog(null, "Escolha umas das opçoes para continuar", "OPÇOES",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);
		switch(escolha)
		{

			case 0:
				for ( int i= 1; i < tamanho ; i++)
				 {
					 eleito = vetor[i];
					 j=i-1;
				     while(j>=0 && vetor[j]>eleito ) 
				     {
				        vetor[j+1] = vetor[j];
				        j--;
				         
				      }
				       vetor[ j+1] = eleito;
				 }
			break;
			default:
				for ( int i= 1; i < tamanho ; i++)
			    {
				    eleito = vetor[i];
				    j=i-1;
			     	while(j>=0 && vetor[j]<eleito ) 
			      	{
			        	 vetor[j+1] = vetor[j];
			        	 j--;
			         
			      	}
			        vetor[ j+1] = eleito;
			    }
				
		}

		for (int i=0;i<tamanho;i++)
		{
			Double.toString(vetor[i]);
			retorno+=vetor[i]+"    ";
		}
			if(escolha==0)
			JOptionPane.showMessageDialog(null," Seu Vetor Ordenado Crescente é: \n"+retorno);
			else 
			JOptionPane.showMessageDialog(null," Seu Vetor Ordenado Decrescente é: \n"+retorno);
		
	



	}
}
