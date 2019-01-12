/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import Operations.ItemInwardOperations;
import Operations.ItemMasterOperations;
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
import models.ItemInwardMaster;
import models.ItemInwards;
import models.ItemMaster;
import models.PersonMaster;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author Chiman Patel
 */
public class SerItemInward extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");

        ServletContext scx = this.getServletContext();

        System.out.println(op);
        if (op.equals("pn")) {
            PersonMasterOperations pmobj = new PersonMasterOperations(scx);
            JSONArray fullnamelist = pmobj.getPersonFullName();
            HttpSession hs = request.getSession(true);
            hs.setAttribute("nid", fullnamelist);

            response.sendRedirect(scx.getContextPath() + "/UserPannelDesign/ItemInwardsInsert.jsp");
        } else if (op.equals("maketable")) {
            System.out.println("hello");
            ItemMasterOperations imo = new ItemMasterOperations(scx);
            int pid = Integer.parseInt(request.getParameter("person"));
            JSONArray items = imo.getItemNames(pid);
            System.out.println(items);
            out.println(items);
        } else if (op.equals("ins")) {
            String pid = request.getParameter("person");
            String date = request.getParameter("date");
            String billno = request.getParameter("billno");
            String json = request.getParameter("json");

            System.out.println("++++"+pid);
            System.out.println(json);
            System.out.println("----"+billno);
            System.out.println("++++"+date);
            Set<ItemInwardDetails> st = new HashSet<ItemInwardDetails>();
            JSONTokener tokener = new JSONTokener(json);
            try {
                JSONArray jsonarray = new JSONArray(tokener);
                ItemMasterOperations itmo = new ItemMasterOperations(scx);
                ItemInwardOperations inward = new ItemInwardOperations(scx);

                ItemInwardMaster itm = new ItemInwardMaster();
                itm.setBillNo(Long.parseLong(billno));
                System.out.println("before"+date);
                 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                 Date date1 = formatter.parse(date);
                 System.out.println("after"+date1);
                itm.setDate(date1);
                PersonMaster pm = new PersonMaster();
                pm.setPid(Integer.parseInt(pid));
                itm.setPersonMaster(pm);

                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobj = (JSONObject) jsonarray.get(i);
                    String itn = jsonobj.getString("in");
                    String q = jsonobj.getString("q");
                    String bp = jsonobj.getString("bp");
                    String sp = jsonobj.getString("sp");
                    String rm = jsonobj.getString("rm");

                    int itemid = itmo.getItemId(itn);

                    ItemInwardDetails iid = new ItemInwardDetails();
                    iid.setBalance(Long.parseLong(q));
                    iid.setQty(Integer.parseInt(q));
                    iid.setPurchasePrice(Double.parseDouble(bp));
                    iid.setRemark(rm);

                    ItemMaster it = new ItemMaster();
                    it.setItemid(itemid);

                    iid.setItemMaster(it);
                    st.add(iid);

                }
                itm.setItemInwardDetailses(st);

                ItemInwardOperations io = new ItemInwardOperations(scx);
                String msg = io.insertItemInward(itm);
                System.out.println(msg);
            } catch (JSONException exp) {
                System.out.println("112" + exp.getMessage());
            } catch (Exception ex) {
                System.out.println("116" + ex.getMessage());
            }

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
