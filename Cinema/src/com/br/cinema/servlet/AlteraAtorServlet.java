package com.br.cinema.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.cinema.dataAcessObject.AtorDAO;
import com.br.cinema.model.AtorModel;

@WebServlet(name="alteraAtor", 
			description="Controle de requests da pagina", 
			urlPatterns= {"/alteraAtor"})

public class AlteraAtorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlteraAtorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String nomeAtor = request.getParameter("nomeAtor");
		
		if ( nomeAtor.isEmpty())
		{
			out.println("<html>");
			out.println("<body>");
			out.println("<h1> Ops! Nome do ator a pesquisar invalido! </h1>");
			out.println("<hr>");
			out.println("<a href='http://localhost:8080/Cinema/alteraAtor.html'>Voltar</a>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
		
			AtorModel objAtorRetorno = new AtorModel();
			
			try 
			{
				AtorDAO objAtorDao = new AtorDAO();
				objAtorRetorno = objAtorDao.consultaAtor(nomeAtor);
				
				if (objAtorRetorno.getNome_ator() != null)
				{
					out.println("<form action='salvarAtor' method='post'>");
					out.println("<h1>Alteração de Cadastro de Ator</h1>");
					out.println("</hr>");

					out.println("<p>");
					out.println("<label style='width: 120px'>ID Ator</label></br>");
					out.println("<input type='text' name='codigoAtor' readonly='readonly' value=" + objAtorRetorno.getIdator() + ">" + "</input>");
					out.println("</p>");
					
					out.println("<p>");
					out.println("<label style='width: 120px'>Nome Ator</label></br>");
					out.println("<input type='text' name='nomeAtor' readonly='readonly' value=" + objAtorRetorno.getNome_ator() + ">" + "</input>");
					out.println("</p>");
					
					out.println("<p>");
					out.println("<label style='width: 120px'>Idade Ator</label></br>");
					out.println("<input type='text' name='idadeAtor'/>");
					out.println("</p>");
					out.println("<input type='submit' value='Salvar Ator'/>");
					out.println("</form>");						
				}
				else 
				{
					out.println("<html>");
					out.println("<body>");
					out.println("<h1> Ops! Ator não encontrado! </h1>");
					out.println("<hr>");
					out.println("<a href='http://localhost:8080/Cinema/alteraAtor.html'>Voltar</a>");
					out.println("</body>");
					out.println("</html>");
				}
			} 
			catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			}
		}
	}
}
