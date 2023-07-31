package br.estudo.concurso.serpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ConsultarPessoa2 {
	public static void main(String[] args) throws SQLException{
	
		// Objeto para obter a entrada dos dados pelo usuário
			Scanner entrada = new Scanner(System.in);
			System.out.println("Informe o valor pra pesquisa: ");
			String valor = entrada.nextLine();
			
		// Cria a conexão com o banco
			Connection conexao = FabricaDeConexao.getConexao();
			
		//Prepara a execução da consulta
			String sql = "SELECT * FROM pessoas WHERE nome like ?";	
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, "%" + valor + "%");
			
		//Executa a consulta
			ResultSet resultado = stmt.executeQuery();
			
		//Obtém os dados do resultado e valoriza o objeto Pessoa
			List<Pessoa> pessoas = new ArrayList<>();
			while(resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String nome = resultado.getString("nome");
				pessoas.add(new Pessoa(codigo, nome));
			}
		//Mostra os dados
			for(Pessoa p: pessoas) {
				System.out.println(p.getCodigo() + " ==> " + p.getNome());
			}
		//Fecha conexões e objetos.
			stmt.close(); conexao.close(); entrada.close();
	}
}
