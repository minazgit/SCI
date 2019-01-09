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

/**
 *
 * @author Chiman Patel
 */
public class demo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
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
        PrintWriter out=response.getWriter();
        System.out.println("Hello");
        String s=request.getParameter("person");
        System.out.println(s);
     
         try {
             
    if(request.getParameter("person").equals("AAA"))
    {
        JSONObject jn=new JSONObject();
        jn.put("item","Shirt");
        
        JSONObject j1=new JSONObject();
        j1.put("item","jeans");
      
//        JSONObject j=new JSONObject();
//        j.put("st1",jn);
//        j.put("st2", j1);
//        j.put("st3", j2);
            JSONArray ja=new JSONArray();
            ja.put(jn);
            ja.put(j1);
         
         JSONObject je=new JSONObject();
         je.put("data",ja);
        out.println(je);
            System.out.println(je);
    }
    if(request.getParameter("person").equals("XXX"))
    {
        JSONObject jn=new JSONObject();
        jn.put("item","Cap");
        
        JSONObject j1=new JSONObject();
        j1.put("item","Belt");
      
//        JSONObject j=new JSONObject();
//        j.put("st1",jn);
//        j.put("st2", j1);
//        j.put("st3", j2);
            JSONArray ja=new JSONArray();
            ja.put(jn);
            ja.put(j1);
         
         JSONObject je=new JSONObject();
         je.put("data",ja);
        out.println(je);
            System.out.println(je);
    }
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
