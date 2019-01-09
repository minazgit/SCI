/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

/**
 *
 * @author Shravan
 */
public class SerItemOutwards extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          doPost(request, response);
      }
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          PrintWriter out=response.getWriter();
          System.out.println("-----111");
//        if(request.getParameter("person").equals("AAA"))
String type= request.getParameter("type");
       System.out.println(type);
            try{
               
             JSONArray ja=new JSONArray();
             ja.put("shirt");
             ja.put("pant");
             ja.put("cap");
             out.println(ja);
                System.out.println(ja);
            }catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
             System.out.println("success");
        }
           
          
}
