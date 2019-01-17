/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslayer;

import Operations.GuardUniformIssueOperations;
import Operations.ItemMasterOperations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.GuardIssueDetail;
import models.GuardIssueMaster;
import models.Securityguard;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author Yogesh Chaudhary
 */
public class SerUniformReturnPerson extends HttpServlet {

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
       System.out.println("hello");
           GuardIssueMaster gim=new GuardIssueMaster();
          
           GuardUniformIssueOperations guio=new GuardUniformIssueOperations(scx);
      HttpSession session=request.getSession(true);
      JSONArray arreno=(JSONArray)session.getAttribute("empno");
           System.out.println("++++");
      JSONArray jcolumn=(JSONArray)session.getAttribute("column");
           System.out.println("0909");
      String mes=request.getParameter("mes");
           System.out.println("[[[[");
           System.out.println(mes);
   
     out.println("--otwarddetail---");
       JSONTokener tokener = new JSONTokener(mes);
        JSONArray james,jamesdet;
        Date date=new Date();
        String dt=(date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate();
        
        try
        {
          james = new JSONArray(tokener);
        
         
                              System.out.println("48--"+arreno.length());

            for(int i=0;i<arreno.length();i++)
        {
              
                   JSONObject objempno=(JSONObject)arreno.get(i);
                  
                   String empno=objempno.getString("empcode");
                  
                    
                          jamesdet=james.getJSONArray(i);
                   for(int j=0;j<jcolumn.length();j++)
                   {   int qtn=Integer.parseInt((String)jamesdet.getString(j));
                       if(qtn!=0)
                       {
                           ItemMasterOperations imo=new ItemMasterOperations(this.getServletContext());
                           int itemid=imo.getItemId(jcolumn.getString(j));
                           
                           out.println(dt+"  "+empno+" "+itemid+" "+jamesdet.getString(j)+" ");
                        
                        
                        
                       }
                   }

                   
              
        } 
           
        }  catch (JSONException ex) {
            System.out.println("63--"+ex.getMessage());
              // Logger.getLogger(SerUniformIssuePerson.class.getName()).log(Level.SEVERE, null, ex);
           }
       
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
   }

}
