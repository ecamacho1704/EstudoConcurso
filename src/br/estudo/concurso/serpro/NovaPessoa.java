package br.estudo.concurso.serpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
	
	public static void main(String[] args) throws SQLException{
		 
		//Objeto utilizado para solicitar a entrada do usuário
			Scanner entrada = new Scanner(System.in); 
			System.out.println("Informe o seu nome: ");
			String nome = entrada.nextLine();//entrada.next();
			
		//Criando a conexao com o banco de dados
			Connection  conexao = FabricaDeConexao.getConexao();
			 
		//Prepara a execução da inserão no banco
			String sql = "INSERT INTO pessoas (nome) VALUES (?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nome); 
			//stmt.setInt(2,10); 
			
		//Executa a inserção no banco de dados
			stmt.execute();
		
			System.out.println("Pessoa incluida com sucesso !");
		
		//Fecha a conexão
			entrada.close();
	}

}
