package br.usjt.arq.service;


import br.usjt.arq.dao.MercadoriaDAO;
import br.usjt.arq.model.Mercadoria;

public class MercadoriaService {
	
	MercadoriaDAO dao = new MercadoriaDAO();

	
	public void cadastrar(Mercadoria mercadoria)
	{
		dao.cadastra(mercadoria);

	}
	
	
	
	public void alterar(Mercadoria mercadoria)
	{
		dao.alterar(mercadoria);

	}
	
	public void excluir(Mercadoria mercadoria)
	{
		dao.excluir(mercadoria);
	}
	
	public Mercadoria consultar(Mercadoria mercadoria)
	{
		return dao.consultar(mercadoria);
	}

}
