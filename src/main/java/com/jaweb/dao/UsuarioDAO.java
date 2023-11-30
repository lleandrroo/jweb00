package com.jaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jaweb.entidadeDTO.UsuarioDTO;

public class UsuarioDAO {
	private Connection conexao;

	public UsuarioDAO() {
		this.conexao = FabricaConexao.conectar();
	}

	public void cadastrar(UsuarioDTO usuario) {
		try {
			PreparedStatement st = conexao.prepareStatement("insert into usuario(nome,login,senha) values(?,?,?)");
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getLogin());
			st.setString(3, usuario.getSenha());
			st.execute();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Bucar de registro pelo número do id
	 * @param id é um inteiro que representa o número do id do usuário
	 * @return
	 */
	
	public UsuarioDTO buscarId(int id) {
		try(PreparedStatement ps = conexao.prepareStatement("select * from usuario where id=?")) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UsuarioDTO dto = new UsuarioDTO();
				dto.setId(rs.getInt("id"));
				dto.setNome(rs.getString("nome"));
				dto.setLogin(rs.getString("login"));
				dto.setSenha(rs.getString("senha"));
				return dto;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	public List<UsuarioDTO> listarUsuarios() {
		List<UsuarioDTO> lista = new ArrayList<>();
		try (PreparedStatement ps = conexao.prepareStatement("Select * from usuario")) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UsuarioDTO dto = new UsuarioDTO();
				dto.setNome(rs.getString("nome"));
				dto.setLogin(rs.getString("login"));
				dto.setSenha(rs.getString("senha"));
				dto.setId(rs.getInt("id"));
				lista.add(dto);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void alterar(UsuarioDTO usuario) {
		try (PreparedStatement ps = conexao.prepareStatement("update usuario set nome=?, login=?, senha=? where id=?")) {
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(UsuarioDTO usuario) {
		try (PreparedStatement ps = conexao.prepareStatement("delete from usuario where id=?")) {
			ps.setInt(1, usuario.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvar(UsuarioDTO usuario) {
		if(usuario.getId() != 0) {
			alterar(usuario);
		}else {
			cadastrar(usuario);
		}
	}
	
	

}
