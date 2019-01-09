/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import Operations.SecurityGuardMasterOperations;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Securityguard;

/**
 *
 * @author Administrator
 */
public class SerSecurityGuard extends HttpServlet {

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
       // processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //    processRequest(request, response);
          PrintWriter out=response.getWriter();
          System.out.println("-----");
          String firstname=request.getParameter("firstname");
            System.out.println(firstname);
            
            String middlename= request.getParameter("middlename");
           System.out.println(middlename);
            String lastname=request.getParameter("lastname");
            System.out.println(lastname);
            String unitname=request.getParameter("unitname");
            System.out.println(unitname);
            String unitlocation=request.getParameter("unitlocation");
            System.out.println(unitlocation);
            String empno=request.getParameter("empno");
             String refname=request.getParameter("refname");
            System.out.println(empno);
           String contactnumber= request.getParameter("contactnumber");
           System.out.println(contactnumber);
           
           SecurityGuardMasterOperations sgo=new SecurityGuardMasterOperations(scx);
           Securityguard sg=new Securityguard();
           
           sg.setEmpcode(Long.parseLong(empno));
           sg.setContactno(Long.parseLong(contactnumber));
           sg.setFirstname(firstname);
           sg.setLastname(lastname);
           sg.setMidname(unitname);
           sg.setRefname(refname);
           sg.setUnitLocation(unitlocation);
           sg.setUnitname(unitname);
          
       String msg=sgo.insertPerson(sg);
       out.println(msg);
         System.out.println("success");
    }

}
