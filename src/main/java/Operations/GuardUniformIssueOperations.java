package Operations;

import models.GuardUniformIssue;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import models.ItemInwards;
import models.ItemMaster;
import models.Securityguard;

public class GuardUniformIssueOperations {
    
    ServletContext ctx;
    Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;
    
    public GuardUniformIssueOperations(ServletContext ctx) {
        this.ctx = ctx;
    }
    
    public String insertUniformIssue(GuardUniformIssue iobj) {
        
        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();
                
                if (iobj != null) {
                  
                    stmt.executeUpdate("insert into guard_uniform_issue(issuedate, sgid, itemid, qty, remark, inward_index) values(" + iobj.getIssuedate() + "," + iobj.getSecurityguard().getEmpcode() + "," + iobj.getItemMaster().getItemid() + "," + iobj.getQty() + ",'" + iobj.getRemark() + "'," + iobj.getItemInwards().getInwardindex() + ",)");
                    
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
    
    public ArrayList<GuardUniformIssue> getItemInwardDetails() {
        
        ArrayList<GuardUniformIssue> issueDetails = new ArrayList<GuardUniformIssue>();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
            
            rs = stmt.executeQuery("select * from guard_uniform_issue");
            
            while (rs.next()) {
                GuardUniformIssue iobj = new GuardUniformIssue();
                
                long index = rs.getLong(1);
                Date issuedate = rs.getDate(2);
                long sgid = rs.getLong(3);
                int itemid = rs.getInt(4);
                int qty = rs.getInt(5);
                String remark = rs.getString(6);
                long inward_index = rs.getLong(7);
                
                Securityguard sgobj = new Securityguard();                
                sgobj.setEmpcode(sgid);
                ItemInwards inwdobj = new ItemInwards();
                inwdobj.setInwardindex(inward_index);
                ItemMaster imobj = new ItemMaster();
                imobj.setItemid(itemid);
                
                iobj.setIndex(index);
                iobj.setIssuedate(issuedate);
                iobj.setSecurityguard(sgobj);
                iobj.setItemMaster(imobj);
                iobj.setQty(qty);
                iobj.setRemark(remark);
                iobj.setItemInwards(inwdobj);
                
                issueDetails.add(iobj);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return issueDetails;
    }
    
    public String deleteIssueDetails(int indx) {
        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
            stmt.executeUpdate("delete from  guard_uniform_issue where index=" + indx + "");
            msg = "success";
            stmt.close();
            rs.close();
        } catch (Exception e) {
            msg = "error";
            System.out.println(e.getMessage());
        }
        return msg;
    }
    
    public String changeIssueDetails(GuardUniformIssue sgobj) {
        
        try {
            
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
                                                                                                                                                                
            stmt.executeUpdate("update guard_uniform_issue set  issuedate='"+sgobj.getIssuedate()+"',"+sgobj.getSecurityguard().getEmpcode()+", itemid=" + sgobj.getItemMaster().getItemid() + ", qty=" + sgobj.getQty() + ",remark='" + sgobj.getRemark() + "'," + sgobj.getItemInwards().getInwardindex() + ",  where index=" + sgobj.getIndex() + " ");
            
            return "success";
        } catch (Exception e) {
            System.out.println("msg======" + e.getMessage());
            return "error";
        }
    }
    
}
