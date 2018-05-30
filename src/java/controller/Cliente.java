/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDao;
import dto.ClienteDto;
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

@WebServlet(name = "Cliente", urlPatterns = {"/Cliente"})
public class Cliente extends HttpServlet {
    
    private ClienteDao dao = new ClienteDao();
    private ClienteDto dto = new ClienteDto();

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
           String cpf = request.getParameter("cpf");
           buscarCliente(cpf);
       } else if(flag.equals("cadastrar")){
           String cpf = request.getParameter("cpf");
           String nome = request.getParameter("nome");
           int idade = Integer.parseInt(request.getParameter("idade"));
           
       } else if(flag.equals("atualizar")){
           
       }
    }

    private void buscarTodos(){
        //TODO: chamar dao com SELECT *
        String list = dao.listar();
        request.setAttribute("lista", list);
        RequestDispatcher disp = request.getRequestDispatcher("exibir.jsp");
        disp.forward(request, response);
    }
    
    private void buscarCliente(String cpf){
        String cliente = dao.pesquisarCpf(cpf);
        request.setAttribute("cliente", cliente);
        RequestDispatcher disp = request.getRequestDispatcher("buscar.jsp");
        disp.forward(request, response);
    }
    
    private void cadastrarCliente(ClienteDto cliente){
        String cpf = 
    }
    
    private void atualizarProduto(Produto produto){
        
    }
    
    private void apagarProduto(Produto produto){
        
        
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
