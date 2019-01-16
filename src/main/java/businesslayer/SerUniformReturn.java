/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import Operations.SecurityGuardMasterOperations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Chiman Patel
 */
public class SerUniformReturn extends HttpServlet {

   
ServletContext scx;
public void init(ServletConfig sc) throws ServletException 
     {        
System.out.println("hiii");
         super.init(sc);
         scx = getServletContext();

        try {          
            scx = sc.getServletContext();                                 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           PrintWriter out= response.getWriter();
          try{
       System.out.println("hello");
       String a=request.getParameter("empno");
      String unit= request.getParameter("unit");
      String op=request.getParameter("op");
       System.out.println(unit);
               System.out.println("----"+a);
       StringTokenizer st=new StringTokenizer(a);
       JSONArray ja=new JSONArray();
       
       if(op.equals("unit"))
       {
       while(st.hasMoreTokens())
       {
            JSONObject jno=new JSONObject();
           String empno=st.nextToken();
           SecurityGuardMasterOperations sg=new SecurityGuardMasterOperations(scx);
           jno=sg.getAllSecurityNameEmpNo(empno);
           ja.put(jno);
          
           System.out.println(""+empno);
       }
           
      
      SecurityGuardMasterOperations sc=new SecurityGuardMasterOperations(scx);      
       HttpSession  hs=request.getSession(true);
       JSONArray jc=new JSONArray();
       jc=sc.getItemName();
       hs.setAttribute("empno", ja);
       hs.setAttribute("column", jc);
       response.sendRedirect(scx.getContextPath()+"/UserPannelDesign/UniformReturnPerson.jsp");
           
           }
           }catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
      }
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out= response.getWriter();
      
        try {
              SecurityGuardMasterOperations sg=new SecurityGuardMasterOperations(scx);
             String unit= request.getParameter("unit");
              
              JSONObject  jo= sg.getSecurityNameEmpNo(unit);
              System.out.println("-------"+jo);
              out.println(jo);
        } catch (Exception e) {
        }
 
       
           
           System.out.println("success");
  }

}
