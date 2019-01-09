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
                                    <strong class="card-title">Security Guard Uniform Issue Details</strong>
                                </div>
                                <div class="card-body">
                                    <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Index</th>
                                                <th>Inward-Index</th>
                                                 <th>Item</th>
                                                <th>Date-of-issue</th>
                                                <th>Unit/Qty</th>
                                                <th>Guard Name</th>                                               
                                                <th>Remark</th>                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>101</td>
                                                <td>shirt</td>
                                                <td>01/12/18</td>
                                                <td>1</td>
                                                <td>Ritesh</td>                                              
                                                <td>-</td>
                                                                                                                                          
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>1</td>
                                                <td>pent</td>
                                                <td>01/12/18</td>
                                                <td>1</td>
                                                <td>Ritesh</td>                                              
                                                <td>nfgtor</td>
                                                                                                                                          
                                            </tr>
                                           <tr>
                                                <td>3</td>
                                                 <td>101</td>
                                                <td>pent</td>
                                                <td>11/12/18</td>
                                                <td>1</td>
                                                <td>Nilay</td>                                              
                                                <td></td>
                                                                                                                                          
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                 <td>101</td>
                                                <td>Shirt</td>
                                                <td>11/12/18</td>
                                                <td>1</td>
                                                <td>Nilay</td>                                              
                                                <td></td>
                                                                                                                                          
                                            </tr>
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
