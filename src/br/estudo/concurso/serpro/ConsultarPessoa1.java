package br.estudo.concurso.serpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ConsultarPessoa1 {

	public static void main(String[] args) throws SQLException{
		
		// Conexão usando a fábrica de conexão
			Connection conexao = FabricaDeConexao.getConexao();
		
		// Cria as instruções (comandos sql) de consulta e executa.
			String sql = "SELECT * FROM pessoas";
			//Statement stmt = conexao.createStatement();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//ResultSet resultado = stmt.executeQuery(sql);
			ResultSet resultado = stmt.executeQuery();
		
		// Obtém os dados do resultado e cria o objeto Pessoa
			List<Pessoa> pessoas = new ArrayList<>();
			while(resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String nome = resultado.getString("nome");
				pessoas.add(new Pessoa(codigo, nome));
			}
			
		// Mostra os dados obtidos na consulta
			for(Pessoa p: pessoas) {
				System.out.println(p.getCodigo() + " ==> " + p.getNome());
			}
			
		// Fecha as conexões.
			stmt.close();
			conexao.close();
	}
}
