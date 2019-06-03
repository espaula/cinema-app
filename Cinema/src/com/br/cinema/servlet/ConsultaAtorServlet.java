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

@WebServlet(name="consultaAtor", 
			description="Consulta Cadastro Ator", urlPatterns = { "/consultaAtor" })

public class ConsultaAtorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultaAtorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		String nomeAtor = request.getParameter("nomeAtor");
		String idadeAtor = request.getParameter("idadeAtor");

		if (nomeAtor.isEmpty() || idadeAtor.isEmpty()){
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h1> Ops! Dados de Consulta do ator incorretos! </h1>");
			out.println("<hr>");
			out.println("<a href='http://localhost:8080/Cinema/consultaAtor.html'>Voltar</a>");
			out.println("</body>");
			out.println("</html>");
		}
		else 
		{
			AtorModel objAtorModel = new AtorModel();
			objAtorModel.setNome_ator(nomeAtor);
			objAtorModel.setIdade_ator(idadeAtor);
			
			AtorModel objAtorRetorno = new AtorModel();
			
			try 
			{
				AtorDAO objAtorDao = new AtorDAO();
				objAtorRetorno = objAtorDao.consultaAtor(objAtorModel);
				
				if ( objAtorRetorno.getNome_ator() != null)
				{
					out.println("<html>");
					out.println("<body>");
					out.println("<h1> Dados de Cadastro Recuperados </h1>");
					out.println("<hr>");
					out.println("<label>Ator Cadastrado:  </label>");
					out.println("<label>" + objAtorRetorno.getNome_ator() + "</label></br>");
					out.println("<label>Idade Ator:  </label>");
					out.println("<label>" + objAtorRetorno.getIdade_ator() + "</label>");
					out.println("<hr>");
					out.println("<a href='http://localhost:8080/Cinema/consultaAtor.html'>Voltar</a>");
					out.println("</body>");
					out.println("</html>");
				}
				else 
				{
					out.println("<html>");
					out.println("<body>");
					out.println("<h1> Dados de cadastro solicitados não encontrados </h1>");
					out.println("<hr>");
					out.println("<a href='http://localhost:8080/Cinema/consultaAtor.html'>Voltar</a>");
					out.println("</body>");
					out.println("</html>");
				}
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
