/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agencia.DAO;

import ConectaBanco.ConnectionDB;
import agencia.model.Destino;
import agencia.model.Passagem;
import agencia.model.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PassagemDAO {
	Usuario usuario = new Usuario();
	Destino destino = new Destino();
	UsuarioDAO udao = new UsuarioDAO();
	DestinoDAO ddao = new DestinoDAO();
	
	public void save(Passagem passagem){

        String sql = "INSERT INTO passagem(pacotePromo,dataViagem,idUsuario,idDestino)" + " VALUES(?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        
        usuario = passagem.getUsuario();
        destino = passagem.getDestino();

        try {
            //Cria uma conexão com o banco
            conn = ConnectionDB.createConnectionToMySQL();

            //Cria um PreparedStatement, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parametro da sql
            pstm.setInt(1, passagem.getPacotePromo());
            pstm.setDate(2, new Date(passagem.getDataViagem().getTime()));
            pstm.setInt(3, usuario.getId());
            pstm.setInt(4, destino.getId());


            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e){
            e.printStackTrace();
        } finally{
            //fecha as conexões
            
            try{
                if(pstm !=null) pstm.close();
                
                if(conn !=null) conn.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    }
    
    public void removedById(int id){
        String sql = "DELETE FROM passagem WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionDB.createConnectionToMySQL();
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, id);
            
            pstm.execute();  
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try{
                if(pstm != null) pstm.close();
                if(conn != null) conn.close();
                
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public void update(Passagem passagem){
        String sql = "UPDATE passagem SET pacotePromo = ?, dataViagem = ?, idUsuario = ?, idDestino = ? " + "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        usuario = passagem.getUsuario();
        destino = passagem.getDestino();
        
        try{
            //Cria uma conexão com o banco de dados
            conn = ConnectionDB.createConnectionToMySQL();
            
            //Cria uma PreparedStatement, classe usada oara executar a query
            pstm = conn.prepareStatement(sql);
            
            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setInt(1, passagem.getPacotePromo());
            pstm.setDate(2, new Date(passagem.getDataViagem().getTime()));
            pstm.setInt(3, usuario.getId());
            pstm.setInt(4, destino.getId());
            pstm.setInt(5, passagem.getId());
            
            //Executa a sql para inserção dos dados
            pstm.execute();
            
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            //fecha as conexões
            try{
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public List<Passagem> getPassagens(){
        
        String sql = "SELECT * FROM passagem";
        
        List<Passagem> passagens = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
           
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;
        
        try{
            conn = ConnectionDB.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            //Enquanto existir dados no banco de dados, faça
            while(rset.next()){
             Passagem passagem = new Passagem();
             
             //Recupera o id do banco e atribui ele ao objeto
             passagem.setId(rset.getInt("id"));
             passagem.setPacotePromo(rset.getInt("pacotePromo"));
             passagem.setDataViagem(rset.getDate("dataViagem"));
             usuario = udao.getUsuarioById(rset.getInt("idUsuario"));
             passagem.setUsuario(usuario);
             destino = ddao.getDestinoById(rset.getInt("idDestino"));
             passagem.setDestino(destino);
             
             
             //Adiciono o contato recuperado, a lista de contatos
             passagens.add(passagem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            
            try{
                if (rset != null) rset.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return passagens;
    }
    
    public Passagem getPassagemById(int id) {
		String sql = "SELECT * FROM passagem where id = ?";

		Passagem passagem = new Passagem();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionDB.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();

			 passagem.setId(rset.getInt("id"));
             passagem.setPacotePromo(rset.getInt("pacotePromo"));
             passagem.setDataViagem(rset.getDate("dataViagem"));
             usuario = udao.getUsuarioById(rset.getInt("idUsuario"));
             passagem.setUsuario(usuario);
             destino = ddao.getDestinoById(rset.getInt("idDestino"));
             passagem.setDestino(destino);

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
		return passagem;

	}
}
