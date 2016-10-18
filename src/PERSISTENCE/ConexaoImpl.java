package PERSISTENCE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoImpl implements ConexaoIF {
	private Connection conexao;
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String DBNAME = "cadastrousuarios";
	private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME+"?autoReconnect=true&useSSL=false";
	private final String LOGIN = "root";
	private final String PASSWORD = "root";
	
	public Connection getConexao() {
		return this.conexao;
	}

	@Override
	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			this.conexao = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			return true;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void close() {
		try {
			this.conexao.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
}
