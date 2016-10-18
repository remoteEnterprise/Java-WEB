package exemplo;

import org.ayty.webee.Acao;
import org.ayty.webee.Requisicao;
import org.ayty.webee.Resposta;

import CONTROLLER.UsuarioDAOImpl;
import MODEL.Date;
import MODEL.Usuario;

public class CadastrarUsuarioServlet extends Acao {
	
	@Override
	protected void executar(Requisicao requisicao, Resposta resposta) {
		Usuario usuario = new Usuario();
		usuario.setPrimeiroNome(requisicao.getParametro("primeiroNome"));
		usuario.setUltimoNome(requisicao.getParametro("ultimoNome"));
		usuario.setIdade(requisicao.getInt("idade"));
		usuario.setNascimento(new Date(requisicao.getParametro("nascimento")));
		usuario.setCpf(requisicao.getParametro("cpf"));
		
		if(UsuarioDAOImpl.getInstance().create(usuario)) {
			resposta.println("Usuario Criado com sucesso!\n"+usuario);
		} else {
			resposta.println("Falha ao cadastrar usuario!");
		}
		
		resposta.println("<form action='/CadastroTesteProject/index.jsp'>");
		resposta.println("<input type='submit' value='Menu'></form>");
	}

}
