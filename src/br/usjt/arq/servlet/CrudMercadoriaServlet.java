package br.usjt.arq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.usjt.arq.model.Mercadoria;
import br.usjt.arq.service.MercadoriaService;

/**
 * Servlet implementation class CrudMercadoriaServlet
 */
@WebServlet("/CrudMercadoriaServlet")
public class CrudMercadoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudMercadoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo =Integer.parseInt(request.getParameter("codigo"));
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		String descricao =request.getParameter("descricao");
		double preco =Double.parseDouble(request.getParameter("preco"));

		
		Mercadoria mercadoria = new Mercadoria(codigo, tipo, descricao, preco);
		
		

		String opcao = request.getParameter("opcao");
		
		MercadoriaService service = new MercadoriaService();
			switch (opcao){
				case "Cadastrar": 
					service.cadastrar(mercadoria);
					break; 
				case "Consultar":
					 service.consultar(mercadoria);
					

					break; 
				case "Alterar": 

					service.alterar(mercadoria);
					
					
					break; 	
					
				case "Remover": 
					service.excluir(mercadoria);
					break; 
					

					
					
			}
			
			PrintWriter out = response.getWriter(); 
			out.println("Operação realizada com sucesso");




	}
	
	

}
