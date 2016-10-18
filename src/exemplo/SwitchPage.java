package exemplo;

import org.ayty.webee.Acao;
import org.ayty.webee.Requisicao;
import org.ayty.webee.Resposta;

public class SwitchPage extends Acao {

	@Override
	protected void executar(Requisicao requisicao, Resposta resposta) {
		switch(requisicao.getParametro("switch")) {
		case("Cadastrar Usuario"):
			resposta.redirecionarPara("/cadastro.jsp");
		break;
		case("Recuperar Usuario"):
			resposta.redirecionarPara("/recuperar.jsp");
		break;
		case("Atualizar Usuario"):
			resposta.redirecionarPara("/atualizar.jsp");
		break;
		case("Deletar Usuario"):
			resposta.redirecionarPara("/deletar.jsp");
		break;
		}
	}

}
