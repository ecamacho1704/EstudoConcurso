package br.estudo.concurso.serpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

	public static void main(String[] args) throws SQLException{
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o codigo:");
		int codigo = entrada.nextInt();
		
		Connection conexao = FabricaDeConexao.getConexao();
		String sql = "DELETE FROM pessoas WHERE codigo=?";
		//String sql = "DELETE FROM pessoas WHERE codigo > ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codigo);
		
		//int contador = stmt.executeUpdate();
		
		if(stmt.executeUpdate() > 0) {
		//if(contador > 0) {
			System.out.println("Pessoa excluida com sucesso!");
		}else {
			System.out.println("Nada feito !");
		}
		//System.out.println("Linha afetadas: " + contador);
		conexao.close();
		entrada.close();
		stmt.close();
	}
}
