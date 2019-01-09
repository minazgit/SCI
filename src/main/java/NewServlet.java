/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

/**
 *
 * @author Minaz
 */
public class NewServlet extends HttpServlet {

 

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
        PrintWriter out= response.getWriter();
        try {
            
             JSONObject jo= new JSONObject();
             jo.put("value","10");
             jo.put("empno","10");
             jo.put("fname","sneh");
             jo.put("middlename","rajeshbhai");
             jo.put("lastname","patel");
        JSONObject joo= new JSONObject();
        joo.put("value","11");
             joo.put("empno","11");
             joo.put("fname","ronak");
             joo.put("middlename","dayaram");
             joo.put("lastname","patel");
             JSONArray ja= new JSONArray();
             ja.put(jo);
             ja.put(joo);
             JSONObject je=new JSONObject();
             je.put("data",ja);
              
              out.println(je);
//            JSONArray ja=new JSONArray();
//             ja.put("jeans");
//             ja.put("shirt");
//             ja.put("t_shirt");
//             ja.put("socks");
//             out.println(ja);
        } catch (Exception e) {
        }
 
       
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
