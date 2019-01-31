/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslayer;

import Operations.ItemOutwardOperations;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import models.ItemOutwardDetails;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Yogesh Chaudhary
 */
public class ExcelSheet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String from= request.getParameter("from");
       String till=request.getParameter("till");
       
       System.out.println("from--"+from);
         XSSFWorkbook workbook = new XSSFWorkbook(); 
ServletContext scx = this.getServletContext();
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");

      //Create row object
      XSSFRow row;

       ItemOutwardOperations ioo=new ItemOutwardOperations(scx);
       JSONArray ja= ioo.getItemOutwardDetailsExcel(from,till);
        Map < String, Object[] > e = 
      new TreeMap < String, Object[] >();
      e.put( "1", new Object[] { "person name", "date", "mode of payment" ,"no. of qty","selling price","name of unit"});
     int j=2;
       for(int i=0;i<ja.length();i++)
       {
           try{
           JSONObject jo=ja.getJSONObject(i);
               System.out.println("name==="+jo.getString("person_name"));
           e.put(String.valueOf(j), new Object[]{jo.getString("person_name"),jo.getString("date"),jo.getString("payment"),jo.getString("qty"),jo.getString("selling_price"),jo.getString("unit")});
          j++;
           }catch(Exception ea)
           {
               System.out.println(ea.getMessage());
           }
       }
      //This data needs to be written (Object[])
//      Map < String, Object[] > empinfo = 
//      new TreeMap < String, Object[] >();
//      empinfo.put( "1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
//      empinfo.put( "2", new Object[] { "tp01", "Gopal", "Technical Manager" });
//      empinfo.put( "3", new Object[] { "tp02", "Manisha", "Proof Reader" });
//      empinfo.put( "4", new Object[] { "tp03", "Masthan", "Technical Writer" });
//      empinfo.put( "5", new Object[] { "tp04", "Satish", "Technical Writer" });
//      empinfo.put( "6", new Object[] { "tp05", "Krishna", "Technical Writer" });
//      
      //Iterate over data and write to sheet
      Set < String > keyid = e.keySet();
      int rowid = 0;

      for (String key : keyid) {
         row = spreadsheet.createRow(rowid++);
         Object [] objectArr = e.get(key);
         int cellid = 0;

         for (Object obj : objectArr) {
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
         }
      }

      //Write the workbook in file system
       System.out.println(scx.getRealPath("/")+"/Writesheet.xlsx");
      File f=new File(scx.getRealPath("/")+"/Writesheet.xlsx");
      f.createNewFile();
      FileOutputStream out = new FileOutputStream(f);
      workbook.write(out);
      out.close();
       FileInputStream fis = new FileInputStream(f);
       byte[]byteStream=new byte[fis.available()];
       fis.read(byteStream);
      System.out.println("Writesheet.xlsx written successfully");
   response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sh");
                OutputStream outStream = response.getOutputStream();
                String headerKey = "Content-Disposition";
             String fn="Writesheet.xlsx";
                String headerValue = String.format("attachment; filename=\"%s\"",fn);
                response.setHeader(headerKey, headerValue);
                response.setContentLength(byteStream.length);
                outStream.write(byteStream, 0, byteStream.length);
    }
}
