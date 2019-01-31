package Operations;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletContext;
import models.ItemInwardDetails;
import models.ItemMaster;
import models.ItemOutwardDetails;
import models.ItemOutwardMaster;
import models.ItemOutwards;
import org.json.JSONArray;
import org.json.JSONObject;

public class ItemOutwardOperations {

    ServletContext ctx;
    Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;

    public ItemOutwardOperations(ServletContext ctx) {
        this.ctx = ctx;
    }

    public String insertItemOutward(ItemOutwardMaster iobj) {

        String msg = "";
        PreparedStatement pstmt = null;
        String item_index = "";
        String x = "";
        Statement stmtbal = null;
        String sql = "insert into item_outward_master(date, pid,payment) values(?,?,?)";
        try {
            con = (Connection) ctx.getAttribute("con");
            stmtbal = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            if (con != null) {

                stmt = con.createStatement();
                System.out.println("37");
                if (iobj != null) {
                    pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                    pstmt.setDate(1, new java.sql.Date(iobj.getDate().getTime()));
                    pstmt.setInt(2, iobj.getPersonMaster().getPid());
                    pstmt.setString(3, iobj.getPayment());
                    pstmt.executeUpdate();
                    ResultSet rs = pstmt.getGeneratedKeys();
                    System.out.println("45");
                    while (rs.next()) {
                        item_index = rs.getString(1);
                    }
                    Set<ItemOutwardDetails> s = iobj.getItemOutwardDetailses();
                    Iterator it = s.iterator();
                    while (it.hasNext()) {
                        System.out.println("52");

                        ItemOutwardDetails id = (ItemOutwardDetails) it.next();
                        System.out.println("----" + iobj.getPersonMaster().getPid());
                        System.out.println("+++" + id.getItemMaster().getItemid());
                        Long qtn = Long.parseLong(String.valueOf(id.getQty()));
                        ResultSet rsbal = stmtbal.executeQuery("SELECT  date,pid,balance,itemid,inward_detail_index,id.inward_master_index from item_inward_master im inner join item_inward_details id on im.inward_index=id.inward_master_index where  itemid=" + id.getItemMaster().getItemid() + " and balance !=0 order by date asc");
                        System.out.println("55");
                        String index = "";
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
                                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                                stmt.executeUpdate("insert into item_outward_details(outward_master_index,itemid,qty,selling_price) values(" + item_index + "," + id.getItemMaster().getItemid() + "," + id.getQty() + "," + id.getSellingPrice() + ")");
                                break;
                            }
                        }
                        //select itm.outward_master_index,itm.date,itm.pid,itm.remark,iid.itemid,iid.qty,iid.selling_price,iid.inward_index FROM `item_outward_master`itm inner join item_outward_details iid on itm.outward_master_index=iid.outward_master_index
                        //stmt.executeUpdate("insert into item_outward_details(outward_master_index,itemid,qty,selling_price) values(" + item_index + "," + id.getItemMaster().getItemid() + "," + id.getQty() + "," + id.getSellingPrice() + ")");

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

        return item_index;
    }

    public String updatebalance(int pid, int itemid, long qtn) {
        String x = "";
        Statement stmtbal = null;

        try {
            con = (Connection) ctx.getAttribute("con");
            stmtbal = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            if (con != null) {
                stmt = con.createStatement();

                if (pid != 0) {
                    ResultSet rsbal = stmtbal.executeQuery("SELECT  date,pid,balance,itemid,inward_detail_index from item_inward_master im inner join item_inward_details id on im.inward_index=id.inward_master_index where pid=" + pid + " and itemid=" + itemid + " and balance !=0 order by date asc");
                    while (rsbal.next()) {
                        long bal_sum = 0;
                        Long balance = rsbal.getLong(3);
                        bal_sum = bal_sum + balance;
                        System.out.println("--96---" + bal_sum);
                        System.out.println("+_+_" + rsbal.getInt(4));
                        if (bal_sum <= qtn) {
                            System.out.println("--99-" + bal_sum);
                            stmt.executeUpdate("update item_inward_details set balance=0 where itemid=" + rsbal.getInt(4) + " and inward_detail_index=" + rsbal.getInt(5) + "");
                            qtn = qtn - bal_sum;
                            System.out.println("-102-" + qtn);
                            System.out.println("balance " + rsbal.getString(3));
                        } else {
                            System.out.println("-107-" + bal_sum);
                            bal_sum = bal_sum - qtn;
                            System.out.println("-109-" + bal_sum);
                            stmt.executeUpdate("update item_inward_details set balance=" + bal_sum + " where itemid=" + rsbal.getInt(4) + " and inward_detail_index=" + rsbal.getInt(5) + "");
                            break;
                        }
                    }

                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return x;
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

            stmt.executeUpdate("update item_outwards set itemid=" + iobj.getItemMaster().getItemid() + ", qty=" + iobj.getQty() + ", pid=" + iobj.getPersonMaster().getPid() + ", selling_price=" + iobj.getSellingPrice() + "," + iobj.getItemInwards().getInwardindex() + ", remark='" + iobj.getRemark() + "' where outward_index=" + iobj.getOutwardIndex() + " ");

            return "success";
        } catch (Exception e) {
            System.out.println("msg======" + e.getMessage());
            return "error";
        }
    }

    public JSONArray getItemOutwardDetailsView() {

        JSONArray ja = new JSONArray();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select itm.outward_master_index,date,pid,payment,itemid,qty,selling_price,inward_index FROM item_outward_master itm inner join item_outward_details iid on itm.outward_master_index=iid.outward_master_index");
//  SELECT qty FROM sci_security.item_inward_master iim inner join sci_security.item_inward_details iid on iim.inward_index=iid.inward_master_index and
// iim.date BETWEEN '2019-01-01' AND '2019-01-19';

//            SELECT sum(qty) FROM sci_security.item_inward_master iim inner join sci_security.item_inward_details iid on iim.inward_index=iid.inward_master_index and
// iim.date <= '2019-01-30' and iid.itemid=26;
            while (rs.next()) {
                JSONArray je = new JSONArray();

                long outward_index = rs.getLong(1);
                String inward_date = rs.getString(2);
                int pid = rs.getInt(3);
                String payment = rs.getString(4);
                int itemid = rs.getInt(5);
                //double purchaseprice=rs.getDouble(6);
                int qty = rs.getInt(6);
                Double sell_price = rs.getDouble(7);
                int inward_index = rs.getInt(8);
                je.put(outward_index + "");
                je.put(inward_date);
                je.put(pid + "");
                je.put(payment + "");
                je.put(itemid + "");
                je.put(qty + "");
                je.put(sell_price + "");
                je.put(inward_index);
                ja.put(je);
            }

            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ja;
    }

     public JSONArray getItemOutwardDetailsReport(String index) {

        JSONArray ja = new JSONArray();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select itm.outward_master_index,date,pid,payment,itemid,qty,selling_price,inward_index FROM item_outward_master itm inner join item_outward_details iid on itm.outward_master_index=iid.outward_master_index and itm.outward_master_index="+index+"");
//  SELECT qty FROM sci_security.item_inward_master iim inner join sci_security.item_inward_details iid on iim.inward_index=iid.inward_master_index and
// iim.date BETWEEN '2019-01-01' AND '2019-01-19';

//            SELECT sum(qty) FROM sci_security.item_inward_master iim inner join sci_security.item_inward_details iid on iim.inward_index=iid.inward_master_index and
// iim.date <= '2019-01-30' and iid.itemid=26;
            while (rs.next()) {
                JSONArray je = new JSONArray();

                long outward_index = rs.getLong(1);
                String inward_date = rs.getString(2);
                int pid = rs.getInt(3);
                PersonMasterOperations pmo=new PersonMasterOperations(ctx);
               String pname= pmo.getPersonName(pid);
                String payment = rs.getString(4);
                int itemid = rs.getInt(5);
                ItemMasterOperations imo=new ItemMasterOperations(ctx);
                String iname=imo.getItemName(itemid);
                //double purchaseprice=rs.getDouble(6);
                int qty = rs.getInt(6);
                Double sell_price = rs.getDouble(7);
                int inward_index = rs.getInt(8);
                je.put(outward_index + "");
                je.put(inward_date);
                je.put(pname + "");
                je.put(payment + "");
                je.put(iname + "");
                je.put(qty + "");
                je.put(sell_price + "");
                je.put(inward_index);
                ja.put(je);
            }

            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ja;
    }
    public JSONArray getOpeningBalance(ArrayList<ItemMaster> al, String date) {
        String msg = "";

        JSONArray ja = new JSONArray();
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();

                if (al != null) {
                    System.out.println("283");
int qty=0;
                        int qty1=0;
                        int p_price=0;
                        int s_price;
                    Iterator<ItemMaster> it = al.iterator();
                    while (it.hasNext()) {
                        int inward = 0;
                        int outward = 0;
                        JSONArray je = new JSONArray();
                        int x=0;
                        ItemMaster im = (ItemMaster) it.next();

                        ResultSet rs = stmt.executeQuery(" SELECT qty,purchase_price FROM item_inward_master iim inner join item_inward_details iid on iim.inward_index=iid.inward_master_index and iim.date <= '" + date + "' and iid.itemid=" + im.getItemid() + "");
                        int sum;
                        
                        while (rs.next()) {
                            
                            System.out.println("))))"+im.getItemid());
                            qty = rs.getInt(1);
                            System.out.println("in_qty=="+qty);
                            p_price = rs.getInt(2);
                            System.out.println("price-"+p_price);
                            if(p_price !=0)
                            {
                            sum = qty * p_price;
                            }
                            else
                            {
                                System.out.println("else1");
                                x=1;
                                sum=qty*1;
                            }
                            inward = inward + sum;
                            
                        }
                System.out.println("+++in" + inward);
                        ResultSet rs1 = stmt.executeQuery(" SELECT qty,selling_price FROM item_outward_master iim inner join item_outward_details iid on iim.outward_master_index=iid.outward_master_index and iim.date <= '" + date + "' and iid.itemid=" + im.getItemid() + "");
                        int sum1;
                        while (rs1.next()) {
                            System.out.println("(((("+im.getItemid());
                            qty1 = rs1.getInt(1);
                            System.out.println("out_qty=="+qty1);
                            s_price = rs1.getInt(2);
                            System.out.println("sell_price=="+s_price);
                            if(s_price!=0)
                            {
                            sum1 = qty1 * s_price;
                            }
                            else
                            {
                                System.out.println("else");
                                x=2;
                                sum1=qty1*p_price;
                            }
                            outward = outward + sum1;
                            
                        }
                           System.out.println("+++out"+outward);
                       
                       
                        
                     //   System.out.println("opening balance=" + open_bal);
                      //  System.out.println("closing balance="+close_bal);
                        System.out.println("--++");
                        je.put(im.getItemid());
                        je.put(im.getItemname());
                        int qty2=qty-qty1;
                         if(x==1)
                         {
                             int open_bal = inward - outward;
                            
                           int close_bal = open_bal + inward - outward;
                           String show="qty ="+qty2+" price ="+p_price+" amount="+open_bal;
                           je.put(show);
                            je.put(inward+" unit");
                           je.put(outward); 
                            
                            je.put(close_bal);
                         }
                         else if(x==2)
                         {
                              int open_bal = inward;
                        int close_bal = open_bal + inward-outward;
                         String show="qty ="+qty2+" price ="+p_price+" amount="+open_bal;
                        je.put(show);
                             je.put(inward);
                        je.put(outward);
                        
                        je.put(close_bal);
                         }
                         else
                         {
                              int open_bal = inward - outward;
                            int close_bal = open_bal + inward - outward;
                             String show="qty ="+qty2+" price ="+p_price+" amount="+open_bal;
                             je.put(show);
                               je.put(inward);
                           je.put(outward); 
                           
                            
                            je.put(close_bal);
                         }
                        
                        ja.put(je);
                    }
                    System.out.println("==="+ja);
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

        return ja;
    }
    public JSONArray getItemOutwardDetailsReport(String from, String till) {

       JSONArray ja=new JSONArray();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
            System.out.println("from");
             rs = stmt.executeQuery("SELECT pid,date,payment,itemid,qty,selling_price FROM item_outward_master iim inner join item_outward_details iid on iim.outward_master_index=iid.outward_master_index and iim.date between '"+from+"' and '"+till+"'");
            while (rs.next()) {
               JSONObject jo=new JSONObject();

                int pid = rs.getInt(1);
                System.out.println("---"+pid);
                String date = rs.getString(2);  
                String payment = rs.getString(3);
                 
                 int itemid = rs.getInt(4);
                 int qty=rs.getInt(5);
                 int selling_price=rs.getInt(6);
                 
              PersonMasterOperations pmo=new PersonMasterOperations(ctx);
              String person_name=pmo.getPersonName(pid);
               
              ItemMasterOperations imo=new ItemMasterOperations(ctx);
             String Itemname= imo.getItemName(itemid);
                //String remark = rs.getString(8);
                jo.put("person_name",person_name);
                jo.put("date", date);
                jo.put("payment",payment);
                jo.put("item_name",Itemname);
                jo.put("qty",qty);
                jo.put("selling_price",selling_price);
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
}
