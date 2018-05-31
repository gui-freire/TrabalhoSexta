/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ClienteDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gui-f
 */
public class ClienteDao {
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
            rs = st.executeQuery("SELECT * FROM Cliente ORDER BY ID");
            while (rs.next()) {
                lista += "ID " + rs.getInt("ID") + "Nome: " + rs.getString("Nome") + "idade:" + rs.getInt("idade") + "cpf" + rs.getString("cpf")+ "\n";
            }
        } catch (SQLException e) {
            System.out.println("Falha na consulta: " + e.getMessage());
        }
        return lista;
    }
    
    
    public String pesquisarCpf(String cpf) {
        String lista = "";
        try {
            rs = st.executeQuery("SELECT * FROM Cliente WHERE cpf=" + cpf);
            if(rs.next()){
              lista += "ID " + rs.getInt("ID") + "Nome: " + rs.getString("Nome") + "idade:" + rs.getInt("idade") + "cpf" + rs.getString("cpf")+ "\n";
            }
                
        } catch (SQLException e) {
            System.out.println("Falha ao pesquisar\n" + e.getMessage());
        }
        return lista;
    }
    
    public void inserir(ClienteDto cliente){
        try {
            st.executeUpdate("INSERT INTO Cliente(Nome,idade,cpf) VALUES('"+ cliente.getNome()+"','"+cliente.getIdade()+"','"+cliente.getCpf()+"')");
        } catch (SQLException e) {
            System.out.println("Falha ao inserir!\n"+e.getMessage());
        }
    }
    
    public void remover(int id){
        try{
            st.execute("DELETE FROM Cliente WHERE cpf=" + id);
        } catch(SQLException e){
            System.out.print("Falha ao apagar!\n"+e.getMessage());
        }
    }
    
    public void atualizar(ClienteDto cliente){
        try{
            st.execute("UPDATE Cliente SET nome='" + cliente.getNome() + "', idade='" + cliente.getIdade() + "'cpf='" + cliente.getCpf() + "' WHERE ID=" + cliente.getId());
        } catch(SQLException e){
            System.out.println("Falha ao inserir!\n"+e.getMessage());
        }
    }
}
