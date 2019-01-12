/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import Operations.ItemMasterOperations;
import Operations.ItemOutwardOperations;
import Operations.PersonMasterOperations;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ItemInwardDetails;
import models.ItemMaster;
import models.ItemOutwardDetails;
import models.ItemOutwardMaster;
import models.PersonMaster;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author Shravan
 */
public class SerItemOutwards extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");

        ServletContext scx = this.getServletContext();
        if (op.equals("xyz")) {
            System.out.println("-----111");
            ItemMasterOperations imo = new ItemMasterOperations(scx);
            int pid = Integer.parseInt(request.getParameter("person"));
            JSONArray items = imo.getItemNames(pid);
            System.out.println(items);
            out.println(items);
//        if(request.getParameter("person").equals("AAA"))
        } else if (op.equals("pn1")) {
            PersonMasterOperations pmobj = new PersonMasterOperations(scx);
            JSONArray fullnamelist = pmobj.getPersonFullNameOutward();
            HttpSession hs = request.getSession(true);
            hs.setAttribute("nid1", fullnamelist);

            response.sendRedirect(scx.getContextPath() + "/UserPannelDesign/ItemOutwardsInsert.jsp");
        } else if (op.equals("ins")) {
            System.out.println("-----");
            String pid = request.getParameter("personid");
            String ptype = request.getParameter("persontype");
            String date = request.getParameter("date");
            String remark = request.getParameter("remark");
            String json = request.getParameter("json");
            String index = request.getParameter("index");
            System.out.println(pid);
            System.out.println(json);
            System.out.println(remark);
            System.out.println(date);
            System.out.println(ptype);
            System.out.println(index);

            //ItemOutwardOperations ioo=new ItemOutwardOperations(scx);
         //   ioo.updatebalance(13,28,1000);
           // System.out.println("-----end");
            JSONTokener tokener = new JSONTokener(json);
            try {
                ItemMasterOperations itmo = new ItemMasterOperations(scx);
                JSONArray jsonarray = new JSONArray(tokener);
                ItemOutwardOperations ioo=new ItemOutwardOperations(scx);
                ItemOutwardMaster iom = new ItemOutwardMaster();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = formatter.parse(date);
                iom.setDate(date1);   //
                iom.setRemark(remark);  //  
                PersonMaster pm = new PersonMaster();
                pm.setPid(Integer.parseInt(pid));
                iom.setPersonMaster(pm);  //

                Set<ItemOutwardDetails> st = new HashSet<ItemOutwardDetails>();

                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobj = (JSONObject) jsonarray.get(i);
                    ItemOutwardDetails iod = new ItemOutwardDetails();
                    String item_name = jsonobj.getString("in");
                    String qty = jsonobj.getString("q");
                    String selling = jsonobj.getString("selling");
                    System.out.println("++"+selling);
                    int item_id = itmo.getItemId(item_name);

                    iod.setQty(Integer.parseInt(qty)); //
                    if(ptype.equals("Remote Person") || ptype.equals("Reference Person"))
                    {
                        System.out.println("----");
                    iod.setSellingPrice(Double.parseDouble(selling));
                    }//
                    ItemMaster im = new ItemMaster();
                    im.setItemid(item_id); //
                    iod.setItemMaster(im);
                    System.out.println("++++");
                    st.add(iod);

                }
                System.out.println("77777");
                iom.setItemOutwardDetailses(st);
               ioo.insertItemOutward(iom);
                System.out.println("88989");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // SELECT date,pid,balance,itemid from sci_security.item_inward_master im inner join sci_security.item_inward_details id on im.inward_index=id.inward_master_index where pid=9 and itemid=19 and balance !=0 order by date asc;
        }
    }
}
