package br.estudo.concurso.serpro;

public class DAOTeste {

	public static void main(String[] args) {
		DAO dao = new DAO();
		String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?,?)";
		
		System.out.println(dao.incluir(sql, "Urias da Silva", 106));
		System.out.println(dao.incluir(sql, "Beatriz Julia", 107));
		System.out.println(dao.incluir(sql, "Getulio Silva Pereira", 108));
		dao.close();
	}
}
