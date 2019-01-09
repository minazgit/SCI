/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

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
       System.out.println(unit);
       StringTokenizer st=new StringTokenizer(a);
       JSONArray ja=new JSONArray();
       int i=0;
       
       while(st.hasMoreTokens())
       {
            JSONObject jno=new JSONObject();
           String empno=st.nextToken();
           
               String name="shravan patel"+i;
               jno.put("empno",empno);
           jno.put("name",name);
           
           ja.put(jno);
           i++;
           System.out.println(""+empno);
       }
       JSONArray jc=new JSONArray();
       jc.put("shirt");
       jc.put("pent");
       jc.put("belt");
       jc.put("jacket");
       jc.put("sweater");
       jc.put("ddfd");
       jc.put("ddfd");
       jc.put("ddfd");
       jc.put("ddfd");
       jc.put("ddfd");
       jc.put("ddfd");
       jc.put("ddfd");
       jc.put("ddfd");
       jc.put("ddfd");
       jc.put("ddfd");
       HttpSession  hs=request.getSession(true);
       hs.setAttribute("empno", ja);
       hs.setAttribute("column", jc);
       response.sendRedirect(scx.getContextPath()+"/UserPannelDesign/UniformReturnPerson.jsp");
           }catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
      }
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out= response.getWriter();
        try {
              JSONArray ja= new JSONArray();
            for(int i=0;i<15;i++)
                    {
             JSONObject jo= new JSONObject();
             jo.put("value","10"+i);
             jo.put("empno","10"+i);
             jo.put("fname","sneh"+i);
             jo.put("middlename","rajeshbhai"+i);
             jo.put("lastname","patel"+i);
             ja.put(jo);
                    }
           
             
           
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
 
       
           
           System.out.println("success");
  }

}
