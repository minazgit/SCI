<%@page import="org.json.JSONArray"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>

        <%@include file="headerfiles.jsp" %>
 <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">

        <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
<script src="assets/js/mycontrol.js"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
      <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
 <script>
        $(document).ready(function() {
           
      //  alert("hello");
        
        $("#tab").hide();
        $("#submit").click(function(){
            
            from=$("#from").val();
            till=$("#till").val();
            alert(from);
            alert(till);
            $("#tab").show();
               if ( $.fn.dataTable.isDataTable( '#example' ) )

                        {

                            table = $('#example').DataTable();
                            
                            table.destroy();
                            
                        } 
           var   table=$('#example').DataTable( {
        "ajax": {"url":"<%=application.getContextPath()%>/SerItemOutwards?op=geti",
        "data":{
            "from":from,
            "till":till
                    },
          
         "type":"POST"},
        "columns": [
    
            { "data": "person_name" },
            { "data": "date" },
            { "data": "payment" },
            { "data": "item_name" },
             { "data": "qty" },
              { "data": "selling_price" }
        ]
    
                });
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
                                    <strong class="card-title">Issue Report</strong>
                                </div>
                               <div class="col-md-9">
                                   <form action="" method="post" class="form-horizontal">
                                      
                                       
                                 From:  <input type="date" id="from" /> 
                                 Till:  <input type="date" id="till" /><br>  
                                   </form>
                                </div>
                                <div id="tab" class="card-body">
                                     <table id="example" class="display" style="width:100%">   <thead>
                                          
                                         <thead>
                                             <tr>
                                                <th>person_name</th>
                                                 <th>Date</th>
                                                <th>payment</th>
                                                <th>item_name</th>
                                                <th>qty</th>                                               
                                                <th>selling_Price</th>
                                               
                                                <!--<th>Remark</th>-->
                                            </tr>
                                        </thead>
                                        
                                     </table>
                                
                                </div>
                                <div class="card-footer">
                                    <button type="submit" id="submit" class="btn btn-primary btn-sm">
                                        <i class="fa fa-dot-circle-o"></i> Submit
                                    </button>

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

