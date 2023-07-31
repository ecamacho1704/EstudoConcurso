package br.estudo.concurso.serpro;

public class DAOTeste {

	public static void main(String[] args) {
		DAO dao = new DAO();
		String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?,?)";
		
		System.out.println(dao.incluir(sql, "Joao da Silva", 100));
		System.out.println(dao.incluir(sql, "Ana Julia", 101));
		System.out.println(dao.incluir(sql, "Djalma Pereira", 102));
		dao.close();
	}
}
