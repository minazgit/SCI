package Operations;

import models.ItemInwards;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletContext;
import models.ItemInwardDetails;
import models.ItemInwardMaster;
import org.json.JSONArray;

public class ItemInwardOperations {

    ServletContext ctx;
    Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;

    public ItemInwardOperations(ServletContext ctx) {
        this.ctx = ctx;
    }
    
    
    

    public String insertItemInward(ItemInwardMaster iobj) {

        String msg = "";
        String item_index="";
        PreparedStatement pstmt=null;
        String sql="insert into item_inward_master(date, bill_no, pid) values(?,?,?)";
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();

                if (iobj != null) {
                    pstmt=con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                    pstmt.setDate(1,new java.sql.Date(iobj.getDate().getTime()));
                    pstmt.setLong(2,iobj.getBillNo());
                    pstmt.setInt(3, iobj.getPersonMaster().getPid());
                    pstmt.executeUpdate();
                   // stmt.executeUpdate("insert into item_inward_master(date, bill_no, pid) values(" + iobj.getDate() + "," + iobj.getBillNo() + "," + iobj.getPersonMaster().getPid() + ")",Statement.RETURN_GENERATED_KEYS);
                    ResultSet rs = pstmt.getGeneratedKeys();
                    while (rs.next()) {
                     item_index = rs.getString(1);
                    }
                  Set<ItemInwardDetails> s=  iobj.getItemInwardDetailses();
                  Iterator it=s.iterator();
                  while(it.hasNext())
                  {
                     ItemInwardDetails id=(ItemInwardDetails)it.next();
                     stmt.executeUpdate("insert into item_inward_details(inward_master_index, itemid, qty, purchase_price, balance, remark) values(" + item_index + "," + id.getItemMaster().getItemid() + "," + id.getQty() + "," + id.getPurchasePrice() + ","+id.getBalance()+",'"+id.getRemark()+"')");
                   
                  }
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

    public ArrayList<ItemInwards> getItemInwardDetails() {

        ArrayList<ItemInwards> itemInwardDetails = new ArrayList<ItemInwards>();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select * from item_inwards");

            while (rs.next()) {
                ItemInwards iobj = new ItemInwards();

                long inwardindex = rs.getLong(1);
                int itemid = rs.getInt(2);
                String inward_date = rs.getString(3);                                               
                int qty = rs.getInt(4);
                int pid = rs.getInt(5);
                long billno = rs.getLong(6);
                double bying_price = rs.getDouble(7);
                String remark = rs.getString(8);
                
                iobj.setInwardindex(inwardindex);
                iobj.getItemMaster().setItemid(itemid);
                iobj.setInwardDate(inward_date);
                iobj.setQty(qty);
                iobj.getPersonMaster().setPid(pid);
                iobj.setBillno(billno);
                iobj.setByingPrice(bying_price);
                iobj.setRemark(remark);
                
                itemInwardDetails.add(iobj);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return itemInwardDetails;
    }

    public String deleteItemInward(int indx) {
        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
            stmt.executeUpdate("delete from  item_inwards where inwardindex=" + indx + "");
            msg = "success";
            stmt.close();
            rs.close();
        } catch (Exception e) {
            msg = "error";
            System.out.println(e.getMessage());
        }
        return msg;
    }

    public String changeItemInward(ItemInwards iobj) {

        try {

            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
                                                                                                                                                                  
            stmt.executeUpdate("update item_inwards set itemid=" + iobj.getItemMaster().getItemid() + ",inward_date='" + iobj.getInwardDate() + "', qty=" + iobj.getQty() + ", pid=" + iobj.getPersonMaster().getPid() + ", billno=" + iobj.getBillno() + ", bying_price=" + iobj.getByingPrice() + ", remark='"+iobj.getRemark()+"' where empcode=" + iobj.getInwardindex()+ " ");

            return "success";
        } catch (Exception e) {
            System.out.println("msg======" + e.getMessage());
            return "error";
        }
    }
    public JSONArray getItemInwardDetailsView() {

       JSONArray ja=new JSONArray();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select itm.inward_index,date,pid,bill_no,itemid,purchase_price,qty,remark FROM `item_inward_master`itm inner join item_inward_details iid on itm.inward_index=iid.inward_master_index");

            while (rs.next()) {
               JSONArray je=new JSONArray();

                long inwardindex = rs.getLong(1);
                String inward_date = rs.getString(2);  
                int pid = rs.getInt(3);
                 long billno = rs.getLong(4);
                 int itemid = rs.getInt(5);
                 double purchaseprice=rs.getDouble(6);
                int qty = rs.getInt(7);
                String remark = rs.getString(8);
                je.put(inwardindex+"");
                je.put(inward_date);
                je.put(pid+"");
                je.put(billno+"");
                je.put(itemid+"");
                je.put(purchaseprice+"");
                je.put(qty+"");
                je.put(remark);
               ja.put(je);
            }
            
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ja;
    }

}
