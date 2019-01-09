<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <%@include file="headerfiles.jsp" %>
         <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
         <script type = "text/javascript" 
                 src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
     
      </script>
      <style>
        
th {
    width:150px;
    
}
div.dataTables_wrapper {
        width: 1200px;
        margin: 0 auto;
    }

          
      </style>
      <script src="assets/js/mycontrol.js"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
      <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
          <script>
        $(document).ready(function() {  
               <%
              JSONArray arreno=(JSONArray)session.getAttribute("empno");
              JSONArray jcolumn=(JSONArray)session.getAttribute("column");
        %>
      $('#example').DataTable({
          "scrollY":"400px",
          "scrollX":true
          
      });
      
      
//              
//            });
     });
       
//       function UniformIssue(unit){
//        $.post("<>/NewServlet",{"unit":unit},function(responseText,statusText,xhr){
//                      var header=["Refrence No","Firstname","Middle Name","Last Name"," "];
//                      obj=JSON.parse(responseText);
//                      alert(obj);
//                      $.each(obj,function(index,value){
//                          alert(value.fname);
//                          alert(index);
////                         // $.each(value,function(innm,v)
////                          {
////                              alert(innm+"  "+v);
////                          });
//                      }
//                              
             //   );
//alert(responseText);
//                      var mydiv=createDiv('d1');
//                     
//                       var mytabel=createTable('t1');
//                       
//                      var myrow=createRow('r1');
//                      
//      for(j=0;j<header.length;j++)
//      {
//      var head=createHeader(header[j]);
//     
//       myrow.append(head.append(header[j]+"</th>"));
//       
//      }
//      myrow.append("</tr>");
//      
//      mytabel.append(myrow);
//    
//     
//      
//                      for(i=0;i<obj.length;i++)
//                      {
//                        var myrow1=createRow(obj[i]);
//                       $.each(obj,function(index,value){
//                          alert(value.fname);
//                          alert(index);
//                          if(index===i)
//                          {
// var  data1=createHeader(value);
//                             myrow1.append(data1.append(value.refrenceno+"</th>"));
//                      
//                      
//                             //alert(header.length);
//                         for(k=1;k<header.length;k++)
//                        {
//                           
//                           if(k===(header.length-1))
//                           {
//                               var check=createCheckBox(obj[i]);
//                               myrow1.append(check);
//                           }
//                           else
//                           {
//                              // alert(k);
//                               var data=createData(header[k]);
//                               if(k===1)
//                               {
//                                 data.append(value.fname+"</td>")  ;
//                               }
//                             //  var check=createCheckBox(obj[i]);
//                         // var text= createTextbox1(obj[i]+" "+header[k]);
//                           //$("#row1").append(text);
//                          // data.append(check);
//                           myrow1.append(data);
//                           }
//                        }
//                        myrow1.append("</tr>");
//                         mytabel.append(myrow1);
//                                
//                         }
//                      }
//                              
//                );
//                      }
//                       mydiv.append(mytabel);
//    //  $('#row').animate({height:'72px'}, 500);
//      $("#row").append(mydiv);
//     
//                      });
//      		
//         }
//               
        </script>
    </head>
    <body>
        <!-- Left Panel -->

        <!-- /#left-panel -->
        <%@include file="leftpanel.jsp" %>
     
        <!-- Left Panel -->

        <!-- Right Panel -->

        <div id="right-panel" class="right-panel">

            <!-- Header-->
            <%@include file="header.jsp" %>
            <!-- Header-->

            <div class="content mt-3">
                <div class="animated fadeIn">


                    <div class="row">


                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-header">
                                    <strong>Uniform Return</strong> 
                                </div>
                                <div class="card-body card-block">
                                    <form action="<%=application.getContextPath()%>/Practice"  method="get" class="form-horizontal">


                                        
                                      <table id="example" class="display "  style="width:100%">

                                       
                                          <thead>
                                    <tr>
                                       <!--<th><input type="checkbox" name="select_all" value="1" id="example-select-all"></th>-->
                                       <th >Employee Number</th>
                                       <th>Name</th>
                                         <% for(int i=0;i<jcolumn.length();i++)
                                            {
                                           %> 
                                        <th><%=(String)jcolumn.get(i)%></th>
                                        <%  }%>
                                    </tr>
                                        </thead>
                <tbody>
                    <% for(int i=0;i<arreno.length();i++)
                    {
                      JSONObject jo=arreno.getJSONObject(i);
                     
                   %>
                   <tr>
                    
                       <td><%=(String)jo.get("empno")%></td>
                        <td><%=(String) jo.get("name")%></td>
                        <% for(int j=0;j<jcolumn.length();j++)
                    {
                   %> 
                   <td><input style="width:60px;" type="text"/></td>
                <%  }%>
                       
                
            </tr>
            <%}%>
                </tbody>
                
        
        </table>
                                      
                               
                                <div class="card-footer">
                                    <button type="submit" id="submit" class="btn btn-primary btn-sm">
                                        <i class="fa fa-dot-circle-o"></i> Submit
                                    </button>
                                 </div>
                                    </form>
                                </div>
                            </div>


                        </div>

                    </div>


                </div><!-- .animated -->
            </div><!-- .content -->


        </div><!-- /#right-panel -->

        <!-- Right Panel -->


        <%@include file="footerfiles.jsp" %>


    </body>
</html>

