/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class ProdutoDao {
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
            rs = st.executeQuery("SELECT * FROM produto ORDER BY ID");
            while (rs.next()) {
                lista += "ID " + rs.getInt("ID") + " Nome:" + rs.getString("nome") + " seção: " + rs.getString("secao") +" preço: "+rs.getFloat("preco") + "unidades: "+ rs.getInt("unidade") + "desconto" + rs.getFloat("desconto") + "unidades para desconto: " + rs.getInt("und_desconto")+"\n";
            }
        } catch (SQLException e) {
            System.out.println("Falha na consulta: " + e.getMessage());
        }
        return lista;
    }
    
    
    public String pesquisarId(int id) {
        String lista = "";
        try {
            rs = st.executeQuery("SELECT * FROM produto WHERE ID=" + id);
            if(rs.next()){
              lista += "ID " + rs.getInt("ID") + " Nome:" + rs.getString("nome") + " seção: " + rs.getString("secao") +" preço: "+rs.getFloat("preco") + "unidades: "+ rs.getInt("unidade") + "desconto" + rs.getFloat("desconto") + "unidades para desconto: " + rs.getInt("und_desconto")+"\n";
            }
                
        } catch (SQLException e) {
            System.out.println("Falha ao pesquisar\n" + e.getMessage());
        }
        return lista;
    }
    
    public void inserir(ProdutoDto produto){
        try {
            st.executeUpdate("INSERT INTO PRODUTO(NOME,secao,PRECO, unidade, desconto, und_desconto) VALUES('"+produto.getNome()+"','"+produto.getSecao()+"',"+produto.getPreco()+"',"+produto.getUnidades()+"',"+produto.getUnd_desconto()+")");
        } catch (SQLException e) {
            System.out.println("Falha ao inserir!\n"+e.getMessage());
        }
    }
    
    public void remover(int id){
        try{
            st.execute("DELETE FROM PRODUTO WHERE ID=" + id);
        } catch(SQLException e){
            System.out.print("Falha ao apagar!\n"+e.getMessage());
        }
    }
    
    public void atualizar(ProdutoDto produto){
        try{
            st.execute("UPDATE PRODUTO SET PRECO=" + produto.getPreco() + "WHERE ID=" + produto.getId());
        } catch(SQLException e){
            System.out.println("Falha ao inserir!\n"+e.getMessage());
        }
    }
    
    public void atualizarUnidades(int id, int unidades){
        try{
            st.execute("UPDATE PRODUTO SET unidade=" + unidades + "WHERE ID=" + id);
        } catch(SQLException e){
            System.out.println("Falha ao inserir!\n"+e.getMessage());
        }
    }
    
    public ProdutoDto pesquisarProduto(int id){
    ProdutoDto produto = new ProdutoDto();
        try {
            rs = st.executeQuery("SELECT * FROM produto WHERE ID=" + id);
            if(rs.next()){
              produto.setId(rs.getInt("ID"));
              produto.setNome(rs.getString("nome"));
              produto.setSecao(rs.getString("secao"));
              produto.setPreco(rs.getFloat("preco"));
              produto.setUnidades(rs.getInt("unidade"));
              produto.setDesconto(rs.getFloat("desconto"));
              produto.setUnd_desconto(rs.getInt("und_desconto"));
            }
                
        } catch (SQLException e) {
            System.out.println("Falha ao pesquisar\n" + e.getMessage());
        }
        return produto;
    }    
    
}
