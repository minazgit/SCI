/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslayer;

import Operations.ItemMasterOperations;
import Operations.PersonMasterOperations;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
          String op=request.getParameter("op");
  
  ServletContext scx=this.getServletContext();
  if(op.equals("xyz"))
  {
          System.out.println("-----111");
           ItemMasterOperations imo=new ItemMasterOperations(scx);
      int pid=Integer.parseInt(request.getParameter("person"));
      JSONArray items=imo.getItemNames(pid);
      System.out.println(items);
       out.println(items);
//        if(request.getParameter("person").equals("AAA"))
  }
  else if(op.equals("pn1"))
  {
       PersonMasterOperations pmobj=new PersonMasterOperations(scx);
        JSONArray fullnamelist=pmobj.getPersonFullNameOutward();
         HttpSession hs= request.getSession(true);
         hs.setAttribute("nid1",fullnamelist);
       
        response.sendRedirect(scx.getContextPath()+"/UserPannelDesign/ItemOutwardsInsert.jsp");
  }
   else if(op.equals("ins"))
  {
      System.out.println("-----");
      String pid= request.getParameter("personid");
       String ptype= request.getParameter("persontype");
     String date=request.getParameter("date");
     String billno=request.getParameter("billno");
     String json=request.getParameter("json");
      String index=request.getParameter("index");
      System.out.println(pid);
      System.out.println(json);
      System.out.println(billno);
      System.out.println(date);
      System.out.println(ptype);
      System.out.println(index);
     // SELECT date,pid,balance,itemid from sci_security.item_inward_master im inner join sci_security.item_inward_details id on im.inward_index=id.inward_master_index where pid=9 and itemid=19 and balance !=0 order by date asc;
  }
        }
        }
           
          

