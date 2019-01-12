<%@page import="java.util.Iterator"%>
<%@page import="models.Securityguard"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>

        <%@include file="headerfiles.jsp" %>

        <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
        <script>
$(document).ready(function(){
              
            $("#d1").click(function(event)
            {      
              event.preventDefault();
  var txt;
  if (confirm("do u want to delete?")) 
  {   
    location.href=this.href;
  }
  else
  {
    txt = "Canceled";
  }
 
});
                 
        });
</script>
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
                                    <strong class="card-title">Person Details</strong>
                                </div>
                                <div class="card-body">
                                    <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>First name</th>
                                                <th>Mid name</th>
                                                <th>Last name</th>                                               
                                                <th>Contact No.</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                            ArrayList<Securityguard>view=(ArrayList<Securityguard>)session.getAttribute("securityguard");
                                             Iterator it=view.iterator();
                                                                while(it.hasNext())
                                                                {
                                                               Securityguard sg=(Securityguard)it.next();
                                            %>
                                            <tr>
                                                <td><%=sg.getEmpcode()%></td>
                                                <td><%=sg.getFirstname()%></td>
                                                <td><%=sg.getMidname()%></td>
                                                <td><%=sg.getLastname()%></td>
                                                <td><%=sg.getContactno()%></td>
                                                 <td><a href="<%=application.getContextPath()%>/SerSecurityGuard?id=<%=sg.getEmpcode()%>"  id="e1"><img src="<%=application.getContextPath()%>/UserPannelDesign/images/Edit.png"  height="50px"></a></td>
                                                  <td><a href="<%=application.getContextPath()%>/SerSecurityGuard?op=delete&id=<%=sg.getEmpcode()   %>"  id="d1"><img src="<%=application.getContextPath()%>/UserPannelDesign/images/Cross.png" height="50px"></a></td>
                                            </tr>
                                             <%  }   %>
                                        </tbody> 
                                    </table>
                                </div>
                            </div>
                        </div>


                    </div>
                </div><!-- .animated -->
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
