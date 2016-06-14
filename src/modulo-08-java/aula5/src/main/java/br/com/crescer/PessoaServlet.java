/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diuly.barreto
 */
@WebServlet (name = "pessoa", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(response, request);
    }

    private void process(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter();) {
            out.println("<html>");
            out.println("<head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'></head>");
            out.println("<body>");
            out.println("<table class='table table-striped'><tr><td>Nome: " + request.getParameter("pessoa.nome") + "</td></tr><tr><td>Idade: " + request.getParameter("idade") + "</td></tr><tr><td>Sexo: " + request.getParameter("sexo") + "</td></tr></table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
}
