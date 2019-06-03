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

@WebServlet(name="salvarAtor", description="Controla Alteração de Ator", urlPatterns = {"/salvarAtor"})
public class SalvarAtorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalvarAtorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String nomeAtor = request.getParameter("nomeAtor");
		String idadeAtor = request.getParameter("idadeAtor");
		int codigoAtor = Integer.parseInt(request.getParameter("codigoAtor"));
		
		AtorModel objAtorModel = new AtorModel();
		objAtorModel.setNome_ator(nomeAtor);
		objAtorModel.setIdade_ator(idadeAtor);
		objAtorModel.setIdator(codigoAtor);
		
		try 
		{
			AtorDAO objAtorDAO = new AtorDAO();
			objAtorDAO.atualizaAtor(codigoAtor, objAtorModel);
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h1> Ator atualizado com sucesso! </h1>");
			out.println("<hr>");
			out.println("<a href='http://localhost:8080/Cinema/alteraAtor.html'>Voltar</a>");
			out.println("</body>");
			out.println("</html>");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}

}
