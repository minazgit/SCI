package Operations;

import models.PersonMaster;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import org.json.JSONArray;
import org.json.JSONObject;

public class PersonMasterOperations {

    ServletContext ctx;
    Statement stmt;
    Connection con;
    String sql;
    ResultSet rs;

    public PersonMasterOperations(ServletContext ctx) {
        this.ctx = ctx;
    }

    public String insertPerson(PersonMaster pobj) {

        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();

                if (pobj != null) {

                    stmt.executeUpdate("insert into person_master(firstname, midname, lastname, persontype, contactno, addline1, addline2, city, state, pincode) values('" + pobj.getFirstname() + "','" + pobj.getMidname() + "','" + pobj.getLastname() + "', '" + pobj.getPersontype() + "'," + pobj.getContactno() + ",'" + pobj.getAddline1() + "','" + pobj.getAddline2() + "','" + pobj.getCity() + "','" + pobj.getState() + "'," + pobj.getPincode() + ")", Statement.RETURN_GENERATED_KEYS);
                    ResultSet rs = stmt.getGeneratedKeys();
                    while (rs.next()) {
                        msg = rs.getString(1);
                    }

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

    public String insertPersonItem(String pid, String item[]) {

        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            if (con != null) {
                stmt = con.createStatement();
                if (pid != null) {
                    for (int i = 0; i < item.length; i++) {

                        stmt.executeUpdate("insert into person_item(pid, itemid) values('" + pid + "','" + item[i] + "')");
                        msg = "success";
                    }

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

    //@yogesh sir this method will return person id and concated name in array list
    public ArrayList<PersonMaster> getPersonIdNameDetails() {

        ArrayList<PersonMaster> persondetails = new ArrayList<PersonMaster>();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select * from person_master");

            while (rs.next()) {
                PersonMaster pobj = new PersonMaster();
                int pid = rs.getInt(1);
                String firstname = rs.getString(2);
                String midname = rs.getString(3);
                String lastname = rs.getString(4);
                String persontype = rs.getString(5);
                Long contactno = rs.getLong(6);
                String addline1 = rs.getString(7);
                String addline2 = rs.getString(9);
                String city = rs.getString(10);
                String state = rs.getString(11);
                int pincode = rs.getInt(12);

                pobj.setPid(pid);
                pobj.setFirstname(firstname);
                pobj.setMidname(midname);
                pobj.setLastname(lastname);
                pobj.setPersontype(persontype);
                pobj.setContactno(contactno);
                pobj.setContactno(contactno);
                pobj.setAddline1(addline1);
                pobj.setAddline2(addline2);
                pobj.setCity(city);
                pobj.setState(state);
                pobj.setPincode(pincode);

                persondetails.add(pobj);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return persondetails;
    }

    //@ yogesh sir enod of method
    public ArrayList<PersonMaster> getPersonDetails() {

        ArrayList<PersonMaster> persondetails = new ArrayList<PersonMaster>();
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select * from person_master");

            while (rs.next()) {
                PersonMaster pobj = new PersonMaster();
                int pid = rs.getInt(1);
                String firstname = rs.getString(2);
                String midname = rs.getString(3);
                String lastname = rs.getString(4);
                String persontype = rs.getString(5);
                Long contactno = rs.getLong(6);
                String addline1 = rs.getString(7);
                String addline2 = rs.getString(9);
                String city = rs.getString(10);
                String state = rs.getString(11);
                int pincode = rs.getInt(12);

                pobj.setPid(pid);
                pobj.setFirstname(firstname);
                pobj.setMidname(midname);
                pobj.setLastname(lastname);
                pobj.setPersontype(persontype);
                pobj.setContactno(contactno);
                pobj.setContactno(contactno);
                pobj.setAddline1(addline1);
                pobj.setAddline2(addline2);
                pobj.setCity(city);
                pobj.setState(state);
                pobj.setPincode(pincode);

                persondetails.add(pobj);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return persondetails;
    }

    public String deletePerson(int prid) {
        String msg = "";
        try {
            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();
            stmt.executeUpdate("delete from  person_master where pid=" + prid + "");
            msg = "success";
            stmt.close();
            rs.close();
        } catch (Exception e) {
            msg = "error";
            System.out.println(e.getMessage());
        }
        return msg;
    }

    public String changePerson(PersonMaster pobj) {

        try {

            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            stmt.executeUpdate("update person_master set firstname='" + pobj.getFirstname() + "',midname='" + pobj.getMidname() + "', lastname='" + pobj.getLastname() + "', persontype='" + pobj.getPersontype() + "',  contactno=" + pobj.getContactno() + ",addline1='" + pobj.getAddline1() + "' ,addline2='" + pobj.getAddline2() + "', city='" + pobj.getCity() + "', state='" + pobj.getState() + "',  pincode=" + pobj.getPincode() + "  where pid=" + pobj.getPid() + "");
            System.out.println("118=====op");
            return "success";
        } catch (Exception e) {
            System.out.println("msg======" + e.getMessage());
            return "error";
        }
    }

    public JSONArray getPersonFullName() {
        JSONArray jnames = new JSONArray();
        int pid;
        String fname = "";
        String mname = "";
        String lname = "";
        String fullname="";
        try {

            con = (Connection) ctx.getAttribute("con");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select pid, firstname, midname, lastname from person_master");

            while (rs.next()) {
                JSONObject jnameobj=new JSONObject();
                pid = rs.getInt(1);
                fname = rs.getString(2);
                mname = rs.getString(3);
                lname = rs.getString(4);
                fullname=fname+" "+mname+" "+lname;
                jnameobj.put("pid", pid);
                jnameobj.put("fm", fullname);
                
                jnames.put(jnameobj);
                
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jnames;
    }

}
