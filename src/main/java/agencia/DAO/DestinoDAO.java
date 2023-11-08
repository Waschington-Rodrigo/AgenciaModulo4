/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConectaBanco.ConnectionDB;
import agencia.model.Destino;

/**
 *
 * @author Waschington Rodrigo
 */
public class DestinoDAO {

	public void save(Destino destino) {

		String sql = "INSERT INTO destino(cidade,estado,localDestino,valor)" + " VALUES(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionDB.createConnectionToMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parametro da sql
			pstm.setString(1, destino.getCidade());
			pstm.setString(2, destino.getEstado());
			pstm.setString(3, destino.getLocalDestino());
			pstm.setFloat(4, destino.getValor());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conexões

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void removedById(int id) {
		String sql = "DELETE FROM destino WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionDB.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void update(Destino destino) {
		String sql = "UPDATE destino SET cidade = ?, estado = ?, localDestino = ?, valor= ?" + "WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco de dados
			conn = ConnectionDB.createConnectionToMySQL();

			// Cria uma PreparedStatement, classe usada oara executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, destino.getCidade());
			pstm.setString(2, destino.getEstado());
			pstm.setString(3, destino.getLocalDestino());
			pstm.setFloat(4, destino.getValor());

			pstm.setInt(5, destino.getId());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public List<Destino> getDestinos() {

		String sql = "SELECT * FROM destino";

		List<Destino> destinos = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionDB.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Destino destino = new Destino();

				// Recupera o id do banco e atribui ele ao objeto
				destino.setId(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				destino.setCidade(rset.getString("cidade"));

				// Recupera a idade do banco e atribui ele ao objeto
				destino.setEstado(rset.getString("estado"));

				// Recupera a data do banco e atribui ele ao objeto
				destino.setLocalDestino(rset.getString("localDestino"));
				
				destino.setValor(rset.getFloat("valor"));
				// Adiciono o contato recuperado, a lista de contatos
				destinos.add(destino);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return destinos;
	}

	public Destino getDestinoById(int id) {
		String sql = "SELECT * FROM destino where id = ?";

		Destino destino = new Destino();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionDB.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			destino.setId(rset.getInt("id"));
			destino.setEstado(rset.getString("estado"));
			destino.setCidade(rset.getString("cidade"));
			destino.setLocalDestino(rset.getString("localDestino"));
			destino.setValor(rset.getFloat("valor"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rset != null)
					rset.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return destino;

	}
}
