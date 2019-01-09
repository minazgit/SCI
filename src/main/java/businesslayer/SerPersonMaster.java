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
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.PersonMaster;

/**
 *
 * @author Chiman Patel
 */
public class SerPersonMaster extends HttpServlet {


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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out=response.getWriter();
            String firstname=request.getParameter("firstname");
            String middlename=request.getParameter("middlename");
            String lastname=request.getParameter("lastname");
            String  persontype=request.getParameter("persontype");
            String itemlist=request.getParameter("item");
         String[] itemarray = itemlist.split(",");
         
           // String organizationname=request.getParameter("organizationname");
            String contactnumber=request.getParameter("contactnumber");
            String addressline1=request.getParameter("addressline1");
            String addressline2=request.getParameter("addressline2");
            String city=request.getParameter("city");
            String state=request.getParameter("state");
            String pincode=request.getParameter("pincode");
           // System.out.println(firstname+middlename+lastname+persontype+itemlist+organizationname+contactnumber+addressline1+addressline2+city+state);
        PersonMasterOperations pmo=new PersonMasterOperations(scx);
        PersonMaster pm=new PersonMaster();
       
        pm.setFirstname(firstname);
        pm.setMidname(middlename);
        pm.setLastname(lastname);
        pm.setPersontype(persontype);
        pm.setAddline1(addressline1);
        pm.setAddline2(addressline2);
        pm.setCity(city);
        pm.setContactno(Long.parseLong(contactnumber));
        pm.setPincode(Integer.SIZE);
       pm.setState(state);
      String pid=pmo.insertPerson(pm);
        System.out.println(pid);
      String msg= pmo.insertPersonItem(pid, itemarray);
      out.println(msg);
       // pm.setPincode();
        //pm.set
            System.out.println("Success");
        
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
