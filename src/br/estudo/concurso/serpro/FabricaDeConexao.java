package br.estudo.concurso.serpro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class FabricaDeConexao {

	public static Connection getConexao () {
 
		try {
			// Cria a instância para obter os valores necessários para realizar a conexão
				Properties prop = getProperties();
				
			//Valoriza as variáveis para a conexão
				final String url = prop.getProperty("banco.url"); //"jdbc:mysql://localhost/curso_java?verifyServerCertificate=false&useSSL=true";
				final String usuario = prop.getProperty("banco.usuario");  //"root";  
				final String senha = prop.getProperty("banco.senha");      //"123456"; 
				
			// Executa a conexão
				return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException | IOException e ) {
			throw new RuntimeException(e);
		}
	}
	
	// Método resposável por carregar o arquivo de properties e obter os valores
	private static Properties getProperties() throws IOException {
		
		Properties prop = new Properties();
		String caminho="/conexao.properties";
		prop.load(FabricaDeConexao.class.getResourceAsStream(caminho));
		
		return prop;
	}
}
