package Operations;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import models.GuardIssueDetail;
import models.GuardIssueMaster;
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
    
    public String insertUniformIssueMaster(GuardIssueMaster iobj) {
        
        String msg = "";
        String item_index=null;
         PreparedStatement pstmt=null;
        String sql="insert into guard_issue_master( issue_date, empcode) values(?,?)";       
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();
      
                   if (iobj != null) {
                  pstmt=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                   pstmt.setDate(1,new java.sql.Date(iobj.getIssueDate().getTime()));
                   pstmt.setInt(2,iobj.getSecurityguard().getEmpcode().intValue());
                pstmt.executeUpdate();
                   // stmt.executeUpdate("insert into item_inward_master(date, bill_no, pid) values(" + iobj.getDate() + "," + iobj.getBillNo() + "," + iobj.getPersonMaster().getPid() + ")",Statement.RETURN_GENERATED_KEYS);
                    ResultSet rs = pstmt.getGeneratedKeys();
                    while (rs.next()) {
                     item_index = rs.getString(1);
                    }
                   // stmt.executeUpdate("insert into guard_issue_master( issue_date, empcode) values(" + iobj.getIssueDate() + "," + iobj.getSecurityguard().getEmpcode() + "," + iobj.getItemMaster().getItemid() + "," + iobj.getQty() + ",'" + iobj.getRemark() + "'," + iobj.getItemInwards().getInwardindex() + ",)");
                    
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
        
        return item_index;
    }
     public String insertUniformIssueDetail(GuardIssueDetail pobj) {

        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();

                if (pobj != null) {

                   // stmt.executeUpdate("insert into guard_issue_detail(itemid, qty,issue_index, selling_price, inward_index) values('" + pobj.getItemid() + "'," + pobj.getQty() + ",'" + pobj.getGuardIssueMaster().getIssueIndex() + "', '" + pobj.getSellingPrice()+ "','"+pobj.getInwardIndex()+"')");
         
                    //item_inward
                    long qtn=Long.parseLong(pobj.getQty());
                    ResultSet rsbal = stmt.executeQuery("SELECT  date,pid,balance,itemid,inward_detail_index,id.inward_master_index from item_inward_master im inner join item_inward_details id on im.inward_index=id.inward_master_index where itemid=" + pobj.getItemid() + " and balance !=0 order by date asc");
                        System.out.println("55");
                        String index="";
                        while (rsbal.next()) {
                            long bal_sum = 0;
                            Long balance = rsbal.getLong(3);
                           index = index + rsbal.getInt(6);
                            bal_sum = bal_sum + balance;
                            System.out.println("60");
                         
                            System.out.println("--96---" + bal_sum);
                            System.out.println("+_+_" + rsbal.getInt(4));
                            if (bal_sum <= qtn) {
                                System.out.println("--99-" + bal_sum);
                                stmt.executeUpdate("update item_inward_details set balance=0 where itemid=" + rsbal.getInt(4) + " and inward_detail_index=" + rsbal.getInt(5) + "");
                                //stmt.executeUpdate("insert into item_outward_details(outward_master_index,itemid,qty,selling_price) values(" + item_index + "," + id.getItemMaster().getItemid() + "," + id.getQty() + "," + id.getSellingPrice() + ")");
                                qtn = qtn - bal_sum;
                                System.out.println("-102-" + qtn);
                                System.out.println("balance " + rsbal.getString(3));
                            } else {
                                System.out.println("-107-" + bal_sum);
                                bal_sum = bal_sum - qtn;
                                System.out.println("-109-" + bal_sum);
                                stmt.executeUpdate("update item_inward_details set balance=" + bal_sum + " where itemid=" + rsbal.getInt(4) + " and inward_detail_index=" + rsbal.getInt(5) + "");
                       //        stmt.executeUpdate("insert into item_outward_details(outward_master_index,itemid,qty,selling_price) values(" + Integer.parseInt(index) + "," + id.getItemMaster().getItemid() + "," + id.getQty() + "," + id.getSellingPrice() + ")");
                         stmt.executeUpdate("insert into guard_issue_detail(itemid, qty,issue_index, selling_price, inward_index) values('" + pobj.getItemid() + "'," + pobj.getQty() + ",'" + pobj.getGuardIssueMaster().getIssueIndex() + "', '" + pobj.getSellingPrice()+ "','"+index+"')");
                                break;
                            }
                        }
                        ////inward index over

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
    
  /*  public ArrayList<GuardUniformIssue> getItemInwardDetails() {
        
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
    */
}
