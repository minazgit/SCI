/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslayer;

import Operations.ItemInwardOperations;
import Operations.ItemMasterOperations;
import Operations.PersonMasterOperations;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ItemInwardDetails;
import models.ItemInwardMaster;
import models.ItemMaster;
import models.PersonMaster;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author Shravan
 */
public class SerPurchaseOrder extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");
        System.out.println("op="+op);
        ServletContext scx = this.getServletContext();

        if(op.equals("pn1"))
        {
            PersonMasterOperations pmo=new PersonMasterOperations(scx);
            
         JSONArray ja=pmo.getPersonFullName();
            System.out.println("---"+ja);
          HttpSession hs = request.getSession(true);
            hs.setAttribute("name", ja);

            response.sendRedirect(scx.getContextPath()+"/UserPannelDesign/PurchaseOrder.jsp");       
        }
        else if (op.equals("ins")) {
           
        try{
            String pid = request.getParameter("person");
            String date = request.getParameter("date");
            String terms = request.getParameter("terms");
            String delivery_method=request.getParameter("dmethod");
            String json = request.getParameter("json");

            System.out.println("++++"+pid);
            System.out.println(json);
            System.out.println("----"+terms);
            System.out.println("++++"+date);
           
            	SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
	
        
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
          LocalDate localDate = LocalDate.now();
                 Date SystemDate = formatter.parse(localDate.toString());
     
	//2016/11/16
        
       // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                 Date date1 = formatter.parse(date);
                 PreparedStatement pstmt=null;
                  Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;
    String  item_index="" ;
    
                   sql="insert into purchase_order_master(date, pid, delivery_method, terms, delivery_date) values(?,?,?,?,?)";
       
            con = (Connection) scx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();

                System.out.println("111");
                    pstmt=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                    pstmt.setDate(1,new java.sql.Date(SystemDate.getTime()));
                    pstmt.setString(2,pid);
                    pstmt.setString(3,delivery_method );
                    pstmt.setString(4,terms);
                    pstmt.setDate(5,new java.sql.Date(date1.getTime()));
                    pstmt.executeUpdate();
                   // stmt.executeUpdate("insert into item_inward_master(date, bill_no, pid) values(" + iobj.getDate() + "," + iobj.getBillNo() + "," + iobj.getPersonMaster().getPid() + ")",Statement.RETURN_GENERATED_KEYS);
                    rs = pstmt.getGeneratedKeys();
                    while (rs.next()) {
                     item_index = rs.getString(1);
                    }
                System.out.println("124");
         //   Set<ItemInwardDetails> st = new HashSet<ItemInwardDetails>();
            JSONTokener tokener = new JSONTokener(json);
            
                JSONArray jsonarray = new JSONArray(tokener);
                
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobj = (JSONObject) jsonarray.get(i);
                    String itn = jsonobj.getString("in");
                    String q = jsonobj.getString("q");
                    String bp = jsonobj.getString("bp");
                   // String sp = jsonobj.getString("sp");
                    //String rm = jsonobj.getString("rm");
ItemMasterOperations itmo=new ItemMasterOperations(scx);
                    int itemid = itmo.getItemId(itn);

                   stmt.executeUpdate("insert into purchase_order_detail(item_id, qty,po_no, unit_price) values(" +itemid +"," +Integer.parseInt(q)+ "," +Integer.parseInt( item_index )+ "," + bp + ")");
                 }  
        

        }
        }
        catch(Exception e)
        {
            System.out.println("--"+e.getMessage());
        }
        
        }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    }

  }