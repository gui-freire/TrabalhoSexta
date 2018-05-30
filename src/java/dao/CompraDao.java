/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CompraDto;
import dto.ProdutoDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gui-f
 */
public class CompraDao {
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mysql://localhost:3306/empresa";
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public void conectar() {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            st = con.createStatement();
            System.out.println("Sucesso na conexão!!");
        } catch (SQLException e) {
            System.out.println("Falha na conexão: " + e);
        }
    }
    
    public String listar(){
        String lista = "";
        try {
            rs = st.executeQuery("SELECT * FROM Compra ORDER BY ID");
            while (rs.next()) {
                lista += "ID " + rs.getInt("ID") + " preço total:" + rs.getFloat("precoTotal") + " desconto: " + rs.getFloat("desconto") + "\n";
            }
        } catch (SQLException e) {
            System.out.println("Falha na consulta: " + e.getMessage());
        }
        return lista;
    }
    
    
    public String pesquisarId(int id) {
        String lista = "";
        try {
            rs = st.executeQuery("SELECT * FROM Compra WHERE ID=" + id);
            if(rs.next()){
              lista += "ID " + rs.getInt("ID") + " preço total:" + rs.getFloat("precoTotal") + " desconto: " + rs.getFloat("desconto") + "\n";
            }
                
        } catch (SQLException e) {
            System.out.println("Falha ao pesquisar\n" + e.getMessage());
        }
        return lista;
    }
    
    public void inserir(CompraDto compra){
        try {
            st.executeUpdate("INSERT INTO Compra(precoTotal,Desconto) VALUES('"+ compra.getPrecoTotal()+"','"+compra.getDesconto()+")");
        } catch (SQLException e) {
            System.out.println("Falha ao inserir!\n"+e.getMessage());
        }
    }
    
    public void remover(int id){
        try{
            st.execute("DELETE FROM Compra WHERE ID=" + id);
        } catch(SQLException e){
            System.out.print("Falha ao apagar!\n"+e.getMessage());
        }
    }
}
