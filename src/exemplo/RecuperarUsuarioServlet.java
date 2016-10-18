package exemplo;

import java.util.List;

import org.ayty.webee.Acao;
import org.ayty.webee.Requisicao;
import org.ayty.webee.Resposta;

import CONTROLLER.UsuarioDAOImpl;
import MODEL.Usuario;

public class RecuperarUsuarioServlet extends Acao {

	@Override
	protected void executar(Requisicao requisicao, Resposta resposta) {
		List<Usuario> usuarios = UsuarioDAOImpl.getInstance().retrieve();
		resposta.println("<form action='RecuperarUsuarioServlet.bee' method='POST'>");
		for(Usuario usuario: usuarios) {
			resposta.println("<input type='radio' name='usuario' value='"+usuario.toStringGET()
			+"' checked/>"+usuario.getPrimeiroNome()+" "+usuario.getUltimoNome()+"</br>");
		}
		
		resposta.println("</br><input type='submit' name='verInfos' value='Ver Informações'/></br>");
		resposta.println("</br><input type='submit' name='update' value='Atualizar Informacoes'/></br>");
		resposta.println("</br><input type='submit' name='menu' value='Menu'/></br>");
		resposta.println("</form>");
		
		if(requisicao.getParametro("verInfos") != null) {
			resposta.println(requisicao.getParametro("usuario"));
		}
		
		if(requisicao.getParametro("update") != null) {
			resposta.redirecionarPara("/cadastro.jsp?update=true&"+requisicao.getParametro("usuario"));
			//TODO PASSAR PARAMETROS COM O GET ?PARAMETRO=VALOR&PAREMTRO=VALOR...
		}
		
		if(requisicao.getParametro("menu") != null) {
			resposta.redirecionarPara("/index.jsp");
		}
	}

}
