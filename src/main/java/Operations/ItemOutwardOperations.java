package Operations;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletContext;
import models.ItemInwardDetails;
import models.ItemOutwardDetails;
import models.ItemOutwardMaster;
import models.ItemOutwards;

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
        String sql = "insert into item_outward_master(date, pid,remark) values(?,?,?)";
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
                    pstmt.setString(3, iobj.getRemark());
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
                        System.out.println("----"+iobj.getPersonMaster().getPid());
                        System.out.println("+++"+id.getItemMaster().getItemid());
                         Long qtn = Long.parseLong(String.valueOf(id.getQty()));
                        ResultSet rsbal = stmtbal.executeQuery("SELECT  date,pid,balance,itemid,inward_detail_index,id.inward_master_index from item_inward_master im inner join item_inward_details id on im.inward_index=id.inward_master_index where pid=" + iobj.getPersonMaster().getPid() + " and itemid=" + id.getItemMaster().getItemid() + " and balance !=0 order by date asc");
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
                               stmt.executeUpdate("insert into item_outward_details(outward_master_index,itemid,qty,selling_price) values(" + Integer.parseInt(index) + "," + id.getItemMaster().getItemid() + "," + id.getQty() + "," + id.getSellingPrice() + ")");
                                break;
                            }
                        }
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

        return msg;
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

}
