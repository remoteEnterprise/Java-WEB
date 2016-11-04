package exemplo;

import org.ayty.webee.Acao;
import org.ayty.webee.Requisicao;
import org.ayty.webee.Resposta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		usuario.setNascimento(requisicao.getParametro("nascimento"));
		usuario.setCpf(requisicao.getParametro("cpf"));
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		resposta.println("<form action='/CadastroTesteProject/index.jsp'>");
		resposta.println("<input type='submit' value='Menu'></form>");
	}

}
