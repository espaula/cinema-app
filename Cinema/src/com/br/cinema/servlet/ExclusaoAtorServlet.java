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

@WebServlet(name="exclusaoAtor", 
			description="Controla Form de Exclusao", 
			urlPatterns = {"/exclusaoAtor"})
public class ExclusaoAtorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public ExclusaoAtorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeAtor = request.getParameter("nomeAtor");
		PrintWriter out = response.getWriter(); 
	
		if ( !nomeAtor.isEmpty()){
			
			AtorDAO objAtorDAO = new AtorDAO();
			AtorModel objAtorModel = new AtorModel();
			
			try 
			{
				objAtorModel = objAtorDAO.consultaAtor(nomeAtor);
				
				if ( objAtorModel.getNome_ator() != null ){
					 objAtorDAO.deleteAtor(objAtorModel);	
					 
					out.println("<html>");
					out.println("<body>");
					out.println("<h1> Ator excluido com sucesso! </h1>");
					out.println("<hr>");
					out.println("<a href='http://localhost:8080/Cinema/exclusaoAtor.html'>Voltar</a>");
					out.println("</body>");
					out.println("</html>");
				}
				else 
				{
					out.println("<html>");
					out.println("<body>");
					out.println("<h1> Ops! Dados de Consulta do ator incorretos! </h1>");
					out.println("<hr>");
					out.println("<a href='http://localhost:8080/Cinema/exclusaoAtor.html'>Voltar</a>");
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
