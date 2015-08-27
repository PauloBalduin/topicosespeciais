

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet({ "/TrataRequisicao", "/HelloWorld", "/ola", "/servlets/hello", "/ola.html" })
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		PrintWriter saida = response.getWriter();
		saida.print("<h1>Hello World!</h1>");
		saida.print("Esse é um servlet servindo HTML como response");
		
		
		
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		RequestDispatcher despachante = request.getRequestDispatcher("saida.jsp");
		
		
		String usuario = request.getParameter("nmusuario");
		String senha =  request.getParameter("nmsenha");
		
		if (usuario.equals("joao") && senha.equals("123")){
			
			sessao.setAttribute("attrMensagem", "Usuário Logado com sucesso");
		}else {
			
			sessao.setAttribute("attrMensagem", "Usuário ou senha incorreta!");
		}
		
		
		despachante.forward(request, response);
		
		
		System.out.print("O usuário" + usuario);
		System.out.print("com a senha " + senha);
		System.out.print("Acabou de logar");
		
		
		// TODO Auto-generated method stub
	}

}
