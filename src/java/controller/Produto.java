/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDao;
import dto.ProdutoDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author internet
 */
@WebServlet(name = "Produto", urlPatterns = {"/Produto"})
public class Produto extends HttpServlet {

    private ProdutoDao dao = new ProdutoDao();
    private ProdutoDto dto = new ProdutoDto();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String flag = request.getParameter("flag");
       
       if(flag.equals("buscarTodos")){
           buscarTodos();
       } else if(flag.equals("buscarUm")){
           int id = Integer.parseInt(request.getParameter("id"));
           buscarProduto(id);
       } else if(flag.equals("inserir")){
           dto.setNome(request.getParameter("nome"));
           dto.setPreco(Float.parseFloat(request.getParameter("preco")));
           dto.setDesconto(Float.parseFloat(request.getParameter("desconto")));
           dto.setSecao(request.getParameter("secao"));
           dto.setUnd_desconto(Integer.parseInt(request.getParameter("unidades_desconto")));
           dto.setUnidades(Integer.parseInt(request.getParameter("unidades")));
           
           inserirProduto(dto);
       } else if(flag.equals("atualizar")){
           dto.setId(Integer.parseInt(request.getParameter("id")));
           dto.setNome(request.getParameter("nome"));
           dto.setPreco(Float.parseFloat(request.getParameter("preco")));
           dto.setDesconto(Float.parseFloat(request.getParameter("desconto")));
           dto.setSecao(request.getParameter("secao"));
           dto.setUnd_desconto(Integer.parseInt(request.getParameter("unidades_desconto")));
           dto.setUnidades(Integer.parseInt(request.getParameter("unidades")));
           
           atualizarProduto(dto);
       } else if(flag.equals("deletar")){
           apagarProduto(Integer.parseInt(request.getParameter("id")));
       }
    }

    private void buscarTodos(){
        String list = dao.listar();
        request.setAttribute("lista", list);
        RequestDispatcher disp = request.getRequestDispatcher("exibirProduto.jsp");
        disp.forward(request, response);
    }
    
    private void buscarProduto(long id){
        String produto = dao.pesquisarId(id);
        request.setAttribute("produto", produto);
        RequestDispatcher disp = request.getRequestDispatcher("buscar.jsp");
        disp.forward(request, response);
    }
    
    private void inserirProduto(ProdutoDto produto){
        dao.inserir(produto);
    }
    
    private void atualizarProduto(ProdutoDto produto){
        dao.atualizar(produto);
    }
    
    private void apagarProduto(int id){
        dao.remover(id);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
