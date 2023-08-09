package br.estudo.concurso.serpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteJdbc {

	public static void main(String[] args) throws SQLException{
		
		// Dados para acesso à Base de Dados: todas as urls abaixo funcionam
			final String url = "jdbc:mysql://localhost";
			//final String url = "jdbc:mysql://localhost/mysql";
			//final String url = "jdbc:mysql://localhost:3306/mysql";
			//final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
			final String usuario = "root"; 
			final String senha = "123456"; 
		
		// Interface java para realizar o acesso à Base de Dados.
			Connection conexao = DriverManager.
							getConnection(url, usuario, senha);
		
		// Senão houve nenhum erro essa mensagem será mostrada na console
			System.out.println("Conexao efetuada com sucesso");
			
		//Fecha a conexão
		conexao.close();
		 
	}
}
