/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDao;
import dao.CompraDao;
import dao.ProdutoDao;
import dto.CompraDto;
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
 * @author gui-f
 */
@WebServlet(name = "Compra", urlPatterns = {"/Compra"})
public class Compra extends HttpServlet {

    private CompraDao dao = new CompraDao();
    private CompraDto dto = new CompraDto();
    
    private ClienteDao clienteDao = new ClienteDao();
    private ProdutoDao produtoDao = new ProdutoDao();
    
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
       } else if(flag.equals("buscar")){
           int id = Integer.parseInt(request.getParameter("id"));
           buscar(id);
       } else if(flag.equals("inserir")){
           float precoTotal = request.getParameter("preco_total");
           float desconto = 0;
           
           if(precoTotal >= 100 && precoTotal < 200){
               desconto = 0.95f; //5% de desconto
           } else if(precoTotal >= 200 && precoTotal < 300){
               desconto = 0.9f;//10% de desconto
           } else if(precoTotal >= 300){
               desconto = 0.85f;//15% de desconto
           }
           
           String cpf = request.getParameter("cpf");
           if(cpf != null && !cpf.isEmpty()){
               String cliente = clienteDao.pesquisarCpf(cpf);
               if(cliente != null && !cliente.isEmpty() && !cliente.equals("")){
                   desconto = desconto - 0.05f;//5% de desconto para cliente cadastrado
               }
           }
           
           dto.setDesconto(desconto);
           dto.setPrecoTotal(precoTotal);
           dto.setPrecoComDesconto(precoTotal*desconto);
           
           inserir(dto);
       } else if(flag.equals("adicionarProduto")){
           int id = Integer.parseInt(request.getParameter("produtoId"));
           int qntd = Integer.parseInt(request.getParameter("quantidade"));
           ProdutoDto produto = produtoDao.pesquisarProduto(id);
           
           if(qntd == produto.getUnd_desconto()){
               
           }
       }
    }

    private void buscarTodos(){
        //TODO: chamar dao com SELECT *
        String list = dao.listar();
        request.setAttribute("lista", list);
        RequestDispatcher disp = request.getRequestDispatcher("exibirCliente.jsp");
        disp.forward(request, response);
    }
    
    private void buscar(int id){
        String compra = dao.pesquisarId(id);
        request.setAttribute("compra", compra);
        RequestDispatcher disp = request.getRequestDispatcher("buscar.jsp");
        disp.forward(request, response);
    }
    
    private void inserir(CompraDto dto){
        dao.inserir(dto);
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
