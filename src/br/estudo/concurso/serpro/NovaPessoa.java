package br.estudo.concurso.serpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
	
	public static void main(String[] args) throws SQLException{
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o seu nome: ");
		String nome = entrada.nextLine();//entrada.next();
		
		Connection  conexao = FabricaDeConexao.getConexao();
				
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		System.out.println(nome); 
		stmt.setString(1, nome); 
		//stmt.setInt(2,10); 
		stmt.execute();
		System.out.println("Pessoa incluida com sucesso !");
		entrada.close();
	}

}
