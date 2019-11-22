package exercicio;

import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		int tamanhoI,escolha;
		String nome,salario,tamanhoS,total="";
		
		do{
			//tamanho do vetor
			do{
				tamanhoS=JOptionPane.showInputDialog(null," Digite o numero de funcionarios a ser cadastrado","DADOS",JOptionPane.QUESTION_MESSAGE);
				if (tamanhoS.equals(""))//menssagem de erro
				 {
					JOptionPane.showMessageDialog(null, "NUMERO NAO INFORMADO ", "ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}while(tamanhoS.equals(""));//verificaçao de vazio
			tamanhoI=Integer.parseInt(tamanhoS);//de string para int

			if (tamanhoI<=0) //menssagem de erro
			{
				JOptionPane.showMessageDialog(null, "NUMERO NAO INFORMADO ", "ERRO",JOptionPane.ERROR_MESSAGE);
			}
		}while(tamanhoI<=0);//verificaçao de tamanho
		
		String [][]dados =new String[tamanhoI][2] ;//vetor
		
		for(int i=0;i<tamanhoI;i++)//repetir
		{
			//nome
			do {
				nome=JOptionPane.showInputDialog(null," Digite o nome do funcionario","DADOS",JOptionPane.QUESTION_MESSAGE);
				if(nome.equals(""))//menssagem de erro
				{
					JOptionPane.showMessageDialog(null, "NOME NAO INFORMADO ", "ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}while(nome.equals(""));//verificaçao
			
			//salario
			do{
				salario=JOptionPane.showInputDialog(null,"digite o salario do "+nome+" ","DADOS",JOptionPane.QUESTION_MESSAGE);
				if(salario.equals("")||Double.parseDouble(salario)<998.00)//menssagem de erro
				{
					JOptionPane.showMessageDialog(null, "SALARIO MAIOR OU IGUAL A UM SALARIO MINIMO", "ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}while(salario.equals("")||Double.parseDouble(salario)<998.00);//verificaçao
			
			// colocando dados na matriz
			dados[i][0]=nome;
			dados[i][1]=salario;
		}
		
		Metodos ordenar =new Metodos();//chamando outra classe
		
		String[] opt = { "Crescente", "Decrescente","Alfabetica" };
		escolha = JOptionPane.showOptionDialog(null, "Escolha umas das opçoes para continuar", "OPÇOES",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);
		switch(escolha)
		{
			case 0:
				ordenar.Crescente(dados);
			 break;

			case 1:
				ordenar.Decrescente(dados);
			break;

			default:
				ordenar.Alfabetica(dados);
		}
		

		for(int i=0;i<tamanhoI;i++)//colocando tudo em uma String para exibir melhor
		{
			total+="Funcionario : "+dados[i][0]+"  R$ : "+Double.parseDouble(dados[i][1])+"\n";
		}

		//messagem personalizada conforme a escolha
		if(escolha==0) {
			JOptionPane.showMessageDialog(null, "Salario ordenado em ordem crescente:\n"+total+"", "DADOS",JOptionPane.INFORMATION_MESSAGE);
		}
		else if (escolha==1) 
		{
			JOptionPane.showMessageDialog(null, "Salario ordenado em ordem decrescente:\n"+total+"", "DADOS",JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Funcionarios ordenado em ordem Alfabetica:\n"+total+"", "DADOS",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
