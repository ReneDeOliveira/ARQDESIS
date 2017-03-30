package br.usjt.arq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arq.model.Mercadoria;



public class MercadoriaDAO {


		public void cadastra(Mercadoria mercadoria) {
			String sqlInsert = "INSERT INTO mercadoria(id, tipo, descricao, preco) VALUES (?, ?, ?, ?)";

			
			try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

				
					stm.setInt(1, mercadoria.getCodigo());


					stm.setInt(2, mercadoria.getTipo());

					
					stm.setString(3, mercadoria.getDescricao());

					
					
					stm.setDouble(4, mercadoria.getPreco());

					
					stm.execute();



					
					String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						mercadoria.setCodigo(rs.getInt(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public void alterar(Mercadoria mercadoria) {
			String sqlUpdate = "UPDATE mercadoria SET tipo=?, descricao=?, preco=? WHERE id=?";
	
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

				stm.setInt(1, mercadoria.getCodigo());
				stm.setInt(2, mercadoria.getTipo());
				stm.setString(3, mercadoria.getDescricao());
				stm.setDouble(4, mercadoria.getPreco());
				
				stm.execute();
			} catch (Exception e) {
				
				System.out.println("Depois"); 
				e.printStackTrace();
			}
		}

		public void excluir(Mercadoria mercadoria) {
			String sqlDelete = "DELETE FROM mercadoria WHERE id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, mercadoria.getCodigo());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		


		public Mercadoria consultar(Mercadoria mercadoria) {
			//Mercadoria mercadoria = new Mercadoria();
			//mercadoria.setCodigo(id);
			String sqlSelect = "SELECT tipo, descricao, preco FROM mercadoria WHERE mercadoria.id = ?";
			

			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, mercadoria.getCodigo());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						mercadoria.setCodigo(rs.getInt("codigo"));
						mercadoria.setTipo(rs.getInt("tipo"));
						mercadoria.setDescricao(rs.getString("descricao"));
						mercadoria.setPreco(rs.getDouble("preco"));
					} else {
						mercadoria.setCodigo(-1);
						mercadoria.setTipo(1);
						mercadoria.setDescricao(null);
						mercadoria.setPreco(-1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return mercadoria;
		}

	
	
	
	

}
