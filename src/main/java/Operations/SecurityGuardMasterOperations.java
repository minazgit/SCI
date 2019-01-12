package Operations;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import models.Securityguard;
import org.json.JSONArray;
import org.json.JSONObject;

public class SecurityGuardMasterOperations {

    ServletContext ctx;
    Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;

    public SecurityGuardMasterOperations(ServletContext ctx) {
        this.ctx = ctx;
    }

    public String insertPerson(Securityguard sobj) {

        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();

                if (sobj != null) {

                    stmt.executeUpdate("insert into securityguard(empcode, firstname, midname, lastname, contactno, unit_location, refname, unit_name) values(" + sobj.getEmpcode() + ",'" + sobj.getFirstname() + "','" + sobj.getMidname() + "','" + sobj.getLastname() + "'," + sobj.getContactno() + ",'" + sobj.getUnitLocation() + "','" + sobj.getRefname() + "','" + sobj.getUnitname() + "')");

                    msg = "success";

                } else {
                    msg = "error";
                }
            } else {
                msg = "error";
            }
            stmt.close();

        } catch (Exception e) {
            msg = "error";
            System.out.println(e.getMessage());
        }

        return msg;
    }

    public ArrayList<Securityguard> getSecurityGuardDetails() {

        ArrayList<Securityguard> securityguarddetails = new ArrayList<Securityguard>();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select * from securityguard");

            while (rs.next()) {
                Securityguard sobj = new Securityguard();

                long empcode = rs.getLong(1);
                String firstname = rs.getString(2);
                String midname = rs.getString(3);
                String lastname = rs.getString(4);
                Long contactno = rs.getLong(5);
                String unit_location = rs.getString(6);
                String refname = rs.getString(7);
                String unit_name = rs.getString(8);

                sobj.setEmpcode(empcode);
                sobj.setFirstname(firstname);
                sobj.setMidname(midname);
                sobj.setLastname(lastname);
                sobj.setContactno(contactno);
                sobj.setUnitLocation(unit_location);
                sobj.setRefname(refname);
                sobj.setUnitname(unit_name);
                
                securityguarddetails.add(sobj);

            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return securityguarddetails;
    }

    public String deleteSecurityGuard(int ecode) {
        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
            stmt.executeUpdate("delete from  securityguard where empcode=" + ecode + "");
            msg = "success";
            stmt.close();
            rs.close();
        } catch (Exception e) {
            msg = "error";
            System.out.println(e.getMessage());
        }
        return msg;
    }

    public String changeSecurityGuard(Securityguard sobj) {

        try {

            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
                                                                                                                                                                                                                    
            stmt.executeUpdate("update securityguard set firstname='" + sobj.getFirstname() + "',midname='" + sobj.getMidname() + "', lastname='" + sobj.getLastname() + "', contactno=" + sobj.getContactno() + ", unit_location='"+sobj.getUnitLocation()+"', unitname='"+sobj.getUnitname()+"'  where empcode=" + sobj.getEmpcode() + " ");
            
            return "success";
        } catch (Exception e) {
            System.out.println("msg======" + e.getMessage());
            return "error";
        }
    }
    public JSONArray getUnitName()
    {
        JSONArray ja=new JSONArray();
        
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select unit_name from securityguard");

            while (rs.next()) {
                
                String unit_name = rs.getString(1);

                  ja.put(unit_name);

            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return ja;
    }

    public  JSONObject getSecurityNameEmpNo(String unitname) {

        JSONObject obj =new JSONObject();
        
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select empcode,firstname,midname,lastname from securityguard where unit_name='" + unitname + "'");
              
                JSONArray ja=new JSONArray();
            while (rs.next()) {
                long empcode = rs.getLong(1);
                String firstname = rs.getString(2);
                String middlename = rs.getString(3);
                String lastname = rs.getString(4);
                  JSONObject jo=new JSONObject();
                  jo.put("value",empcode);
                jo.put("empcode",empcode);
                jo.put("firstname",firstname);
                jo.put("middlename",middlename);
                jo.put("lastname",lastname);
                ja.put(jo);
            }
            
            
            obj.put("data",ja);
            System.out.println("+++++"+obj);
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
 public  JSONObject getAllSecurityNameEmpNo(String empcode) {
 
     JSONObject jo=new JSONObject();
        
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select empcode,firstname,midname,lastname from securityguard where empcode='" + empcode + "'");
              
               
            while (rs.next()) {
                long empcode1 = rs.getLong(1);
                String firstname = rs.getString(2);
                String middlename = rs.getString(3);
                String lastname = rs.getString(4);
                  
                  jo.put("value",empcode1);
                jo.put("empcode",empcode1);
                jo.put("firstname",firstname);
                jo.put("middlename",middlename);
                jo.put("lastname",lastname);
                
            }
            
            
           
          
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jo;
    }
     public JSONArray getItemName()
    {
        JSONArray ja=new JSONArray();
        
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select itemname from item_master");

            while (rs.next()) {
                
                String itemname = rs.getString(1);

                  ja.put(itemname);

            }
            System.out.println("-----"+ja);
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return ja;
    }
}
