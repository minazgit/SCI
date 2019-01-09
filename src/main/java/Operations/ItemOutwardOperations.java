package Operations;

import models.ItemOutwards;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;

public class ItemOutwardOperations {

    ServletContext ctx;
    Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;

    public ItemOutwardOperations(ServletContext ctx) {
        this.ctx = ctx;
    }

    public String insertItemOutward(ItemOutwards iobj) {

        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();

                if (iobj != null) {

                    stmt.executeUpdate("insert into item_outwards(itemid, qty, pid, selling_price, inwardindex, date, remark) values(" + iobj.getItemMaster().getItemid() + "," + iobj.getQty() + ", " + iobj.getPersonMaster().getPid() + "," + iobj.getSellingPrice() + "," + iobj.getItemInwards().getInwardindex() + ",'" + iobj.getDate() + "','" + iobj.getRemark() + "')");

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

    public ArrayList<ItemOutwards> getItemInwardDetails() {

        ArrayList<ItemOutwards> itemOutwardsDetails = new ArrayList<ItemOutwards>();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select * from item_outwards");

            while (rs.next()) {
                ItemOutwards iobj = new ItemOutwards();
                
                long outward_index = rs.getLong(1);
                int itemid = rs.getInt(2);
                int qty = rs.getInt(3);
                int pid = rs.getInt(4);
                double selling_price = rs.getDouble(5);
                long inwardindex = rs.getLong(6);
                Date date = rs.getDate(7);
                String remark = rs.getString(8);

                iobj.setOutwardIndex(outward_index);
                iobj.getItemMaster().setItemid(itemid);
                iobj.setQty(qty);
                iobj.getPersonMaster().setPid(pid);
                iobj.setSellingPrice(selling_price);
                iobj.getItemInwards().setInwardindex(inwardindex);
                iobj.setDate(date);
                iobj.getRemark();
                
                itemOutwardsDetails.add(iobj);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return itemOutwardsDetails;
    }

    public String deleteItemOutwards(int indx) {
        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
            stmt.executeUpdate("delete from  item_outwards where outward_index=" + indx + "");
            msg = "success";
            stmt.close();
            rs.close();
        } catch (Exception e) {
            msg = "error";
            System.out.println(e.getMessage());
        }
        return msg;
    }

    public String changeItemOutwards(ItemOutwards iobj) {

        try {

            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
                                                                                                                                                                                                                                                    
            stmt.executeUpdate("update item_outwards set itemid=" + iobj.getItemMaster().getItemid() + ", qty=" + iobj.getQty() + ", pid=" + iobj.getPersonMaster().getPid() + ", selling_price=" + iobj.getSellingPrice() + ","+iobj.getItemInwards().getInwardindex()+", remark='" + iobj.getRemark() + "' where outward_index=" + iobj.getOutwardIndex() + " ");

            return "success";
        } catch (Exception e) {
            System.out.println("msg======" + e.getMessage());
            return "error";
        }
    }

}
