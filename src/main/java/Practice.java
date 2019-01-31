/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chiman Patel
 */
public class Practice extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           PrintWriter out= response.getWriter();
       System.out.println("hello");
       String mes=request.getParameter("mes");
      String sp= request.getParameter("sp");
       out.println(mes+"<br>");
       out.println(sp+"<br>");
      /* StringTokenizer st=new StringTokenizer(a);
       while(st.hasMoreTokens())
       {
           String empno=st.nextToken();
           System.out.println(""+empno);
       }
   System.out.println(a);*/
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
   }

   
}
