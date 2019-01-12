/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import Operations.SecurityGuardMasterOperations;
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
import models.Securityguard;
import org.json.JSONArray;

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
        doPost(request,response);
       // processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //    processRequest(request, response);
          PrintWriter out=response.getWriter();
          System.out.println("-----");
          String op=request.getParameter("op");
          System.out.println("----"+op);
           SecurityGuardMasterOperations scg=new SecurityGuardMasterOperations(scx);
          if(op.equals("insert"))
          {
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
           sg.setMidname(middlename);
           sg.setRefname(refname);
           sg.setUnitLocation(unitlocation);
           sg.setUnitname(unitname);
          
       String msg=sgo.insertPerson(sg);
       out.println(msg);
         System.out.println("success");
          }
          else if(op.equals("unitname")){
             
              JSONArray ja= scg.getUnitName();
              HttpSession hs=request.getSession(true);
              hs.setAttribute("unitname", ja);
              response.sendRedirect(scx.getContextPath()+"/UserPannelDesign/SgUniformIssueInsert.jsp");
          }
          else if(op.equals("2")){
              ArrayList<Securityguard>view=scg.getSecurityGuardDetails();
              HttpSession hs= request.getSession(true);
              hs.setAttribute("securityguard",view);
                 System.out.println("++++");
              response.sendRedirect(scx.getContextPath()+"/UserPannelDesign/SecurityGuardView.jsp");
              
          }
          else if(op.equals("delete")){
              scg.deleteSecurityGuard(Integer.parseInt(request.getParameter("id")));
               response.sendRedirect(scx.getContextPath()+"/SerSecurityGuard?op=2");
          }
         
    }

}
