package Operations;

import models.ItemInwards;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;

public class ItemInwardOperations {

    ServletContext ctx;
    Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;

    public ItemInwardOperations(ServletContext ctx) {
        this.ctx = ctx;
    }

    public String insertItemInward(ItemInwards iobj) {

        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();

                if (iobj != null) {

                    stmt.executeUpdate("insert into item_inwards(itemid, inward_date, qty, pid, billno, bying_price, remark) values(" + iobj.getItemMaster().getItemid() + ",'" + iobj.getInwardDate() + "'," + iobj.getQty() + "," + iobj.getPersonMaster().getPid() + "," + iobj.getBillno() + "," + iobj.getByingPrice() + ",'" + iobj.getRemark() + "')");

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

}
