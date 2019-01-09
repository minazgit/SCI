package Operations;

import models.Securityguard;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;

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

}
