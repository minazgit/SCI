package Operations;

import models.ItemMaster;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import models.PersonMaster;
import org.json.JSONArray;

public class ItemMasterOperations {

    ServletContext ctx;
    Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;

    public ItemMasterOperations(ServletContext ctx) {
        this.ctx = ctx;
    }

    public String insertItem(ItemMaster imobj) {

        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();

                if (imobj != null) {

                    stmt.executeUpdate("insert into item_master(itemname, item_category, sub_category, reorder_level) values('" + imobj.getItemname() + "','" + imobj.getItemCategory() + "','" + imobj.getSubCategory() + "','"+imobj.getReorder()+"')");

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
 
    public ArrayList<ItemMaster> getItemDetails() {

        ArrayList<ItemMaster> itemdetails = new ArrayList<ItemMaster>();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select * from item_master");

            while (rs.next()) {
                ItemMaster itemobj = new ItemMaster();

                int itemid = rs.getInt(1);
                String itemname = rs.getString(2);
                String item_category = rs.getString(3);
                String sub_category = rs.getString(4);
                String reorder=rs.getString(5);
                itemobj.setItemid(itemid);
                itemobj.setItemname(itemname);
                itemobj.setItemCategory(item_category);
                itemobj.setSubCategory(sub_category);
                itemobj.setReorder(reorder);
                itemdetails.add(itemobj);

            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return itemdetails;
    }

    public String deleteItem(int itemid) {
        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
            stmt.executeUpdate("delete from  item_master where itemid=" + itemid + "");
            msg = "success";
            stmt.close();
            rs.close();
        } catch (Exception e) {
            msg = "error";
            System.out.println(e.getMessage());
        }
        return msg;
    }

    public String changeCustomer(ItemMaster itemobj) {

        try {

            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            stmt.executeUpdate("update item_master set itemname='" + itemobj.getItemname() + "',item_category='" + itemobj.getItemCategory() + "' ,sub_category='" + itemobj.getSubCategory() + "' where itemid=" + itemobj.getItemid() + "");
            System.out.println("118=====op");
            return "success";
        } catch (Exception e) {
            System.out.println("msg======" + e.getMessage());
            return "error";
        }
    }
    
    
        //SELECT itemname  FROM `sci_security`.`item_master` where itemid in (select itemid from sci_security.person_item where pid=3) ;

    public JSONArray getItemNames(int psid) {
        JSONArray ja = new JSONArray();

        try {
            String iname = "";
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT itemname  FROM item_master where itemid in (select itemid from person_item where pid=" + psid + ")");

            while (rs.next()) {
               

                iname = rs.getString(1).trim();
               
                ja.put(iname);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ja;
    }

//@yogesh sir: this method will return name of item based on item id
    public String getItemName(int itd) {
        String iname = "";

        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select itemname from item_master where itemid='" + itd + "'");

            rs.next();

            iname = rs.getString(1);

        } catch (Exception e) {
            System.out.println("157"+e.getMessage());
        }

        return iname;
    }
 public int getItemId(String iname) {
        int itd =0;
     System.out.println("---"+iname);
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
            String sql="select itemid from item_master where itemname='" + iname.trim() + "'";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);

            rs.next();

            itd = rs.getInt(1);

        } catch (Exception e) {
            System.out.println("176"+e.getMessage());
        }

        return itd;
    }

    //@ yogesh sir :end of method  

}
