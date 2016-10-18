package CONTROLLER;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import MODEL.Date;
import MODEL.Usuario;
import PERSISTENCE.ConexaoImpl;

public class UsuarioDAOImpl implements IFUsuarioDAO {
	private volatile static UsuarioDAOImpl uniqueInstance;
	private ConexaoImpl conexao;
	
	private UsuarioDAOImpl() {
		this.conexao = new ConexaoImpl();
	}

	@Override
	public boolean create(Usuario usuario) {
		String sql = "";
		if(this.conexao.getConnection()) {
			sql = "INSERT INTO usuarios (primeiro_nome, ultimo_nome, idade,"
					+ "nascimento, cpf)"
					+ " VALUES(?,?,?,?,?)";
			try {
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				statement.setString(1, usuario.getPrimeiroNome());
				statement.setString(2, usuario.getUltimoNome());
				statement.setInt(3, usuario.getIdade());
				statement.setString(4, usuario.getNascimento().toString());
				statement.setString(5, usuario.getCpf());
				statement.execute();
				this.conexao.close();
				return true;
			} catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
		
	}

	@Override
	public List<Usuario> retrieve() {
		String sql = "";
		List<Usuario> usuarios = new LinkedList<>();
		if(this.conexao.getConnection()) {
			try {
				sql = "SELECT * FROM usuarios";
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery();
				while(resultSet.next()) {
					Usuario usuario = new Usuario();
					usuario.setPrimeiroNome(resultSet.getString(2));
					usuario.setUltimoNome(resultSet.getString(3));
					usuario.setIdade(resultSet.getInt(4));
					usuario.setNascimento(new Date(resultSet.getString(5)));
					usuario.setCpf(resultSet.getString(6));
					usuarios.add(usuario);
				}
				return usuarios;
			} catch(SQLException e) {
				e.printStackTrace();
				return usuarios;
			}
		}
		return usuarios;
	}

	@Override
	public boolean update(Usuario usuario) {
		String sql = "";
		if(this.conexao.getConnection()) {
			sql = "UPDATE usuarios SET primeiro_nome=?, ultimo_nome=?, idade=?,"
					+ "nascimento=?, cpf=? WHERE cpf=?";
			try {
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				statement.setString(1, usuario.getPrimeiroNome());
				statement.setString(2, usuario.getUltimoNome());
				statement.setInt(3, usuario.getIdade());
				statement.setString(4, usuario.getNascimento().toString());
				statement.setString(5, usuario.getCpf());
				statement.setString(6, usuario.getCpf());
				statement.execute();
				this.conexao.close();
				return true;
			} catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
		
	}

	@Override
	public boolean delete(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
		
	}
	
	public static UsuarioDAOImpl getInstance() {
		if(UsuarioDAOImpl.uniqueInstance == null) {
			synchronized(UsuarioDAOImpl.class) {
				if(UsuarioDAOImpl.uniqueInstance == null) {
					UsuarioDAOImpl.uniqueInstance = new UsuarioDAOImpl();
				}
			}
		}
		return UsuarioDAOImpl.uniqueInstance;
	}

}
