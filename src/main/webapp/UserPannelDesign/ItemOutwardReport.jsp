<%@page import="org.json.JSONArray"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>

        <%@include file="headerfiles.jsp" %>

        <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">


    </head>
    <body>
        <!-- Left Panel -->       
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

                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title">Item-outwards Details</strong>
                                </div>
                                <div class="card-body">
                                    
                                     
                                  <%
                          JSONArray getinward = (JSONArray)session.getAttribute("getreport");
                           JSONArray im=null;
                                                               for(int i=0;i<getinward.length();i++){
                                                               im=(JSONArray)getinward.get(i);
                                                               
                            %>
         
                            
                            
                            
                            <tr>  <td>Outward Index</td> <td><%=im.get(0)%></td> </tr>
                            <tr>  <td>Date</td>    <td><%=im.get(1)%></td> </tr>,
                             <tr>  <td>Person Name</td>   <td><%=im.get(2)%></td> </tr>,
                             <tr>  <td>Mode Of Payment</td>    <td><%=im.get(3)%></td> </tr>,
                             <tr>  <td>Item name</td>         <td><%=im.get(4)%></td></tr>,
                             <tr>  <td>Qty</td>      <td><%=im.get(5)%></td> </tr>,
                            <tr>  <td>Selling Price</td>      <td><%=im.get(6)%></td> </tr>,
                             <!--<tr>  <td>inward_index</td>    <td><%=im.get(7)%></td> </tr>-->
                           <br>
                            <%  } %>
                                       
                                </div>
                            </div>
                        </div>


                    </div>
                </div><!-- .animated -->
                
             <form action="<%= application.getContextPath()%>/IssueNoteReportServlet" method="get">   
                <input type="hidden" name="ino"  value="<%=im.get(0)%>"/>
            <input type="submit" value="issue report" name="btn1" />
        </form>
            </div><!-- .content -->


        </div><!-- /#right-panel -->

        <!-- Right Panel -->


        <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/main.js"></script>


        <script src="assets/js/lib/data-table/datatables.min.js"></script>
        <script src="assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
        <script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
        <script src="assets/js/lib/data-table/jszip.min.js"></script>
        <script src="assets/js/lib/data-table/pdfmake.min.js"></script>
        <script src="assets/js/lib/data-table/vfs_fonts.js"></script>
        <script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.print.min.js"></script>
        <script src="assets/js/lib/data-table/buttons.colVis.min.js"></script>
        <script src="assets/js/lib/data-table/datatables-init.js"></script>


        <script type="text/javascript">
            $(document).ready(function() {
                $('#bootstrap-data-table-export').DataTable();
            });
        </script>


    </body>
</html>
