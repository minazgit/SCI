
 package Operations;


import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;

import models.ItemMaster;
import models.Securityguard;
 

public class GuardUniformReturnOperations {
    
    ServletContext ctx;
    Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;
    
    public GuardUniformReturnOperations(ServletContext ctx) {
        this.ctx = ctx;
    }
    
    public String insertUniformReturn(GuardUniformReturn grobj) {
        
        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();
                
                if (grobj != null) {
                                                                                                                                                    
                    stmt.executeUpdate("insert into guard_uniform_return(returndate, sgid, itemid, qty, issueindex, remark) values('" + grobj.getReturndate()+ "'," + grobj.getSecurityguard().getEmpcode() + "," + grobj.getItemMaster().getItemid() + "," + grobj.getQty() + "," + grobj.getGuarduniformissue().getIndex() + ",'" + grobj.getRemark() + "')");
                    
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
    
    public ArrayList<GuardUniformReturn> getItemInwardDetails() {
        
        ArrayList<GuardUniformReturn> returnDetails = new ArrayList<GuardUniformReturn>();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
                
            rs = stmt.executeQuery("select * from guard_uniform_return");
            
            while (rs.next()) {
                GuardUniformReturn grobj = new GuardUniformReturn();
                
                long return_index = rs.getLong(1);
                Date returndate = rs.getDate(2);
                long sgid = rs.getLong(3);
                int itemid = rs.getInt(4);
                int qty = rs.getInt(5);
                 long issueindex = rs.getLong(6);
                String remark = rs.getString(7);
               
                
                Securityguard sgobj = new Securityguard();                
                sgobj.setEmpcode(sgid);
                ItemMaster imobj = new ItemMaster();
                imobj.setItemid(itemid);
                GuardUniformIssue guobj =new GuardUniformIssue();
                guobj.setIndex(issueindex);
                
                grobj.setReturnIndex(return_index);
                grobj.setReturndate(returndate);
                grobj.setSecurityguard(sgobj);
                grobj.setItemMaster(imobj);
                grobj.setQty(qty);
                grobj.setRemark(remark);
                grobj.setGuarduniformissue(guobj);
                
                returnDetails.add(grobj);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return returnDetails;
    }
    
    public String deleteReturnDetails(int indx) {
        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
            stmt.executeUpdate("delete from  guard_uniform_return where return_index=" + indx + "");
            msg = "success";
            stmt.close();
            rs.close();
        } catch (Exception e) {
            msg = "error";
            System.out.println(e.getMessage());
        }
        return msg;
    }
    
    public String changeReturnDetails(GuardUniformReturn grobj) {
        
        try {
            
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
                                                                                                                                                                                                                                    //return_index, returndate, sgid, itemid, qty, issueindex, remark                                                                                      
            stmt.executeUpdate("update guard_uniform_return set  returndate='"+grobj.getReturndate()+"',"+grobj.getSecurityguard().getEmpcode()+", itemid=" + grobj.getItemMaster().getItemid() + ", qty=" + grobj.getQty() + "," + grobj.getGuarduniformissue().getIndex() + ",remark='" + grobj.getRemark() + "'  where index=" + grobj.getReturnIndex() + " ");
            
            return "success";
        } catch (Exception e) {
            System.out.println("msg======" + e.getMessage());
            return "error";
        }
    }
    
}
