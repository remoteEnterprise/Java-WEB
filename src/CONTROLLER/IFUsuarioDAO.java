package CONTROLLER;

import java.util.List;

import MODEL.Usuario;

public interface IFUsuarioDAO{
	public boolean create(Usuario usuario);
	public List<Usuario> retrieve();
	public boolean update(Usuario usuario);
	public boolean delete(Usuario usuario);
}
