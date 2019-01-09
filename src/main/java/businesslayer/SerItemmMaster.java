/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslayer;

import Operations.ItemMasterOperations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ItemMaster;

/**
 *
 * @author Shravan
 */
public class SerItemmMaster extends HttpServlet {
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
          doPost(request,response); 
      }
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ItemMasterOperations imo=new ItemMasterOperations(scx);
             ItemMaster im=new ItemMaster();
          PrintWriter out=response.getWriter();
          System.out.println("-----");
//          String id=request.getParameter("id");
//            System.out.println(id);
          if(request.getParameter("op")!=null)
          {
            ArrayList<ItemMaster> getitem =imo.getItemDetails();
              HttpSession hs= request.getSession(true);
              hs.setAttribute("getitemlist",getitem);
              response.sendRedirect(scx.getContextPath()+"/UserPannelDesign/PersonMasterInsert.jsp");
          }
          else  if(request.getParameter("op1")!=null)      
          {
            ArrayList<ItemMaster> getitem =imo.getItemDetails();
              HttpSession hs= request.getSession(true);
              hs.setAttribute("getitemlist",getitem);
              response.sendRedirect(scx.getContextPath()+"/UserPannelDesign/ItemMasterView.jsp");
          }
          else
          {
            String item_name= request.getParameter("item_name");
           System.out.println(item_name);
            String category=request.getParameter("category");
            System.out.println(category);
           String sub_category= request.getParameter("sub_category");
           System.out.println(sub_category);
           
        
       
           im.setItemname(item_name);
           im.setSubCategory(sub_category);
           im.setItemCategory(category);
           
          String msg= imo.insertItem(im);
          out.println(msg);
          //  response.sendRedirect(scx.getContextPath()+"/UserPannelDesign/ItemMasterInsert.jsp?msg="+msg);
          }
           System.out.println("success");
  }
   
}
