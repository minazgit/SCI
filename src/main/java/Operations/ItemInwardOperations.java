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
import org.json.JSONObject;

public class ItemInwardOperations {

    ServletContext ctx;
    Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;
    ResultSet rs1;

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
                     stmt.executeUpdate("insert into item_inward_details(inward_master_index, itemid, qty, purchase_price, balance) values(" + item_index + "," + id.getItemMaster().getItemid() + "," + id.getQty() + "," + id.getPurchasePrice() + ","+id.getBalance()+")");
                   
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
                //String remark = rs.getString(8);
                
                iobj.setInwardindex(inwardindex);
                iobj.getItemMaster().setItemid(itemid);
                iobj.setInwardDate(inward_date);
                iobj.setQty(qty);
                iobj.getPersonMaster().setPid(pid);
                iobj.setBillno(billno);
                iobj.setByingPrice(bying_price);
               // iobj.setRemark(remark);
                
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

            rs = stmt.executeQuery("select itm.inward_index,date,pid,bill_no,itemid,purchase_price,qty FROM `item_inward_master`itm inner join item_inward_details iid on itm.inward_index=iid.inward_master_index");

            while (rs.next()) {
               JSONArray je=new JSONArray();

                long inwardindex = rs.getLong(1);
                String inward_date = rs.getString(2);  
                int pid = rs.getInt(3);
                 long billno = rs.getLong(4);
                 int itemid = rs.getInt(5);
                 double purchaseprice=rs.getDouble(6);
                int qty = rs.getInt(7);
                //String remark = rs.getString(8);
                je.put(inwardindex+"");
                je.put(inward_date);
                je.put(pid+"");
                je.put(billno+"");
                je.put(itemid+"");
                je.put(purchaseprice+"");
                je.put(qty+"");
                //je.put(remark);
               ja.put(je);
            }
            
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ja;
    }
 public JSONArray getItemInwardDetailsReport(String from, String till) {

       JSONArray ja=new JSONArray();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

             rs = stmt.executeQuery(" SELECT pid,date,bill_no,itemid,qty,purchase_price FROM item_inward_master iim inner join item_inward_details iid on iim.inward_index=iid.inward_master_index and iim.date  between '"+from+"' and '"+till+"'");
            while (rs.next()) {
               JSONObject jo=new JSONObject();

                int pid = rs.getInt(1);
                String date = rs.getString(2);  
                int billno = rs.getInt(3);
                 
                 int itemid = rs.getInt(4);
                 int qty=rs.getInt(5);
                 int purchase_price=rs.getInt(6);
                 
              PersonMasterOperations pmo=new PersonMasterOperations(ctx);
              String person_name=pmo.getPersonName(pid);
               
              ItemMasterOperations imo=new ItemMasterOperations(ctx);
             String Itemname= imo.getItemName(itemid);
                //String remark = rs.getString(8);
                jo.put("person_name",person_name);
                jo.put("date", date);
                jo.put("billno",billno);
                jo.put("item_name",Itemname);
                jo.put("qty",qty);
                jo.put("purchase_price",purchase_price);
                //je.put(remark);
               ja.put(jo);
            }
            
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ja;
    }
 public  JSONArray getReorder()
 {
       JSONArray ja=new JSONArray();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
ArrayList<Integer> al=new ArrayList<Integer>();
ArrayList<Integer> al1=new ArrayList<Integer>();
             rs = stmt.executeQuery("select itemid,reorder_level from item_master");
            while (rs.next()) {
              

                int itemid = rs.getInt(1);
                int reorder=rs.getInt(2);
                al1.add(reorder);
              al.add(itemid);
            }
            
            for(int i=0;i<al.size();i++)
            {
                    rs1 = stmt.executeQuery("select itemid,sum(balance) from sci_security.item_inward_details where itemid="+al.get(i)+"");
            while (rs1.next()) {
                 JSONArray je=new JSONArray();
             int itemid1 = rs1.getInt(1);
             int balance =rs1.getInt(2);
            
                System.out.println("---id"+itemid1);
             if(balance<= al1.get(i))
             {
                 ItemMasterOperations imo=new ItemMasterOperations(ctx);
             String Itemname= imo.getItemName(itemid1);
                je.put(Itemname);
                je.put(balance);
                 ja.put(je);
                 System.out.println("---"+ja);
             }
                
            }
            }
          
            
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ja;
 }
}
