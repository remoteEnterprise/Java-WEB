<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>
<%	
if(request.getParameter("update") != null) {
	out.println("<h1>Atualizar Dados do Usuario</h1>");
} else {
	out.println("<h1>Cadastrar Novo Usuário</h1>");
}

if(request.getParameter("menu") != null) {
	response.sendRedirect("/CadastroTesteProject/index.jsp");
}
%>
</head>
<body>
	<form action="CadastrarUsuarioServlet.bee" method="POST">
	<%
		if(request.getParameter("update") != null) {
			out.println("<input type='text' name='primeiroNome' placeholder='Primeiro nome' value='"+request.getParameter("primeiroNome")+"' required></br>");
			out.println("</br><input type='text' name='ultimoNome' placeholder='Último nome' value='"+request.getParameter("ultimoNome")+"' required></br>");
			out.println("</br><input type='number' name='idade' min=1 max=100 placeholder='Idade' value='"+request.getParameter("idade")+"' required/></br>");
			out.println("</br><input type='text' name='nascimento' maxlength= 10 placeholder='Nascimento' title='aaaa-mm-dd' pattern='[0-9]{4}-[0-9]{2}-[0-9]{2}$' value='"+request.getParameter("nascimento")+"' required></br>");
			out.println("</br><input type='text' name='cpf' maxlength=14 placeholder='CPF' title='123.456.789-00' pattern='[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$' value='"+request.getParameter("cpf")+"' required></br>");
		} else {
			out.println("<input type='text' name='primeiroNome' placeholder='Primeiro nome' required></br>");
			out.println("</br><input type='text' name='ultimoNome' placeholder='Último nome' required></br>");
			out.println("</br><input type='number' name='idade' min=1 max=100 placeholder='Idade' required/></br>");
			out.println("</br><input type='text' name='nascimento' maxlength= 10 placeholder='Nascimento' title='aaaa-mm-dd' pattern='[0-9]{4}-[0-9]{2}-[0-9]{2}$' required></br>");
			out.println("</br><input type='text' name='cpf' maxlength=14 placeholder='CPF' title='123.456.789-00' pattern='[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$' required></br>");
			//TODO CADASTRAR AQUI E ATUALIZAR ALI EM CIMA.
		}
	%>
		</br><input type="submit" value="Cadastrar"/></br>
		
	</form>
	<form>
		</br><input type="submit" name="menu" value="Menu"/>
	</form>
</body>
</html>