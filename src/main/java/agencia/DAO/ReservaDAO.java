/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agencia.DAO;

import ConectaBanco.ConnectionDB;
import agencia.model.Hospedagem;
import agencia.model.Reserva;
import agencia.model.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ReservaDAO {
	Usuario usuario = new Usuario();
	Hospedagem hospedagem = new Hospedagem();
	
	UsuarioDAO udao = new UsuarioDAO();
	HospedagemDAO hdao = new HospedagemDAO();

    public void save(Reserva reserva) {
        /*
         * Isso é uma sql comum, os ? são os parametros que nós vamos adicionar na base de dados
         */

        String sql = "INSERT INTO reserva(qtdDias,dataReserva,pacotePromo,valorTotal,idHospedagem,idUsuario)" + " VALUES(?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        
        usuario = reserva.getUsuario();
        hospedagem = reserva.getHospedagem();

        try {
            //Cria uma conexão com o banco
            conn = ConnectionDB.createConnectionToMySQL();

            //Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parametro da sql
            pstm.setInt(1, reserva.getQtdDias());
            pstm.setDate(2, new Date(reserva.getDataReserva().getTime()));
            pstm.setInt(3, reserva.getPacotePromo());
            pstm.setFloat(4, reserva.getValorTotal());
            pstm.setInt(5, hospedagem.getId());
            pstm.setInt(6, usuario.getId());

            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fecha as conexões

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
        String sql = "DELETE FROM reserva WHERE id = ?";

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

    public void update(Reserva reserva) {
        String sql = "UPDATE reserva SET qtdDias = ?, dataReserva = ?, pacotePromo = ?, valorTotal = ?, idHospedagem = ?, idUsuario = ? " + "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        
        usuario = reserva.getUsuario();
        hospedagem = reserva.getHospedagem();

        try {
            //Cria uma conexão com o banco de dados
            conn = ConnectionDB.createConnectionToMySQL();

            //Cria uma PreparedStatement, classe usada oara executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setInt(1, reserva.getQtdDias());
            pstm.setDate(2, new Date(reserva.getDataReserva().getTime()));
            pstm.setInt(3, reserva.getPacotePromo());
            pstm.setFloat(4, reserva.getValorTotal());
            pstm.setInt(5, hospedagem.getId());
            pstm.setInt(6, usuario.getId());

            pstm.setInt(7, reserva.getId());

            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fecha as conexões
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

    public List<Reserva> getReservas() {

        String sql = "SELECT * FROM reserva";

        List<Reserva> reservas = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConnectionDB.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {
                Reserva reserva = new Reserva();

                //Recupera o id do banco e atribui ele ao objeto
                reserva.setId(rset.getInt("id"));
                reserva.setQtdDias(rset.getInt("qtdDias"));
                reserva.setDataReserva(rset.getDate("dataReserva"));
                reserva.setPacotePromo(rset.getInt("pacotePromo"));
                reserva.setValorTotal(rset.getFloat("valorTotal"));
                hospedagem = hdao.getHospedagemById(rset.getInt("idHospedagem"));
                reserva.setHospedagem(hospedagem);
                usuario = udao.getUsuarioById(rset.getInt("idUsuario"));
                reserva.setUsuario(usuario);

                reservas.add(reserva);
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
        return reservas;
    }
    
    public Reserva getReservaById(int id) {
		String sql = "SELECT * FROM reserva where id = ?";

		Reserva reserva = new Reserva();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionDB.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			reserva.setId(rset.getInt("id"));
            reserva.setQtdDias(rset.getInt("qtdDias"));
            reserva.setDataReserva(rset.getDate("dataReserva"));
            reserva.setPacotePromo(rset.getInt("pacotePromo"));
            reserva.setValorTotal(rset.getFloat("valorTotal"));
            hospedagem = hdao.getHospedagemById(rset.getInt("idHospedagem"));
            reserva.setHospedagem(hospedagem);
            usuario = udao.getUsuarioById(rset.getInt("idUsuario"));
            reserva.setUsuario(usuario);

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
		return reserva;

}
}
