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

@WebServlet(name="adicionaAtor", 
				  description = "Gerencia Inser��o de Atores", 
				  urlPatterns = { "/adicionaAtor" })

public class InsereAtorServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
       
    public InsereAtorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String nomeAtor  = request.getParameter("nomeAtor");
		String idadeAtor = request.getParameter("idadeAtor");
		
		if (nomeAtor.isEmpty() || idadeAtor.isEmpty()){
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h1> Ops! Dados do ator incorretos! </h1>");
			out.println("<hr>");
			out.println("<a href='http://localhost:8080/Cinema/insereAtor.html'>Voltar</a>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			
			AtorModel objAtorModel = new AtorModel();
			objAtorModel.setNome_ator(nomeAtor);
			objAtorModel.setIdade_ator(idadeAtor);

			try 
			{
				AtorDAO objAtorDao = new AtorDAO();
				objAtorDao.insereAtor(objAtorModel);
				
				out.println("<html>");
				out.println("<body>");
				out.println("<h1> Dados do ator inseridos! </h1>");
				out.println("<hr>");
				out.println("<a href='http://localhost:8080/Cinema/insereAtor.html'>Voltar</a>");
				out.println("</body>");
				out.println("</html>");
				
			} 
			catch (ClassNotFoundException e) 
			{
				out.println("<html>");
				out.println("<body>");
				out.println("<h1> Ao Inserir Dados do ator! </h1>");
				out.println("</body>");
				out.println("</html>");
			}
						
		}
		
	}

}
