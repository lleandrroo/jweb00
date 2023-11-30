package com.jaweb;

import java.util.List;

import com.jaweb.dao.UsuarioDAO;
import com.jaweb.entidadeDTO.UsuarioDTO;

public class TesteDAO {
	public static void main(String[] arg) {

		UsuarioDTO u = new UsuarioDTO();
		u.setNome("Ricardo");
		u.setLogin("ri");
		u.setSenha("123");

		UsuarioDAO dao = new UsuarioDAO();
		// dao.cadastrar(u);
		// System.out.println("Cadastrado com Sucsso!");
		// dao.alterar(u);
		// System.out.println("Alterado com Sucsso!");
		// u.setId(5);
		//List<UsuarioDTO> lista = dao.listarUsuarios();
		//for(UsuarioDTO a : lista) {
		//	System.out.println(a);
		//}
		//Busa por ID
		System.out.println(dao.buscarId(4));
		
		// dao.excluir(u);
		// System.out.println("Excluido com Sucsso!");
		u = new UsuarioDTO();
		u.setId(4);
		u.setNome("Fernando");
		u.setLogin("fer");	
		u.setSenha("123");
		dao.salvar(u);
		System.out.println("Salvo com sucesso!!");
		
		
	}
}
