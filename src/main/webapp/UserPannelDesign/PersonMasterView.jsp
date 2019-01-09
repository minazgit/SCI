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
                                                <th>Person Type</th>
                                                <th>Organization </th>
                                                <th>Contact No.</th>
                                                <th>Add Line 1</th>
                                                <th>Add Line 2</th>
                                                <th>City</th>
                                                <th>State</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Jisan</td>
                                                <td>M</td>
                                                <td>Patel</td>
                                                <td>Cloth Supplier</td>
                                                 <td>ABC ltd</td>
                                                <td>9988998899</td>
                                                <td>19, abc complex</td>
                                                <td>new vip road</td>
                                                <td>Vadodara</td>
                                                <td>Gujarat </td>                                                                                               
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>jinit</td>
                                                <td>K</td>
                                                <td>Murti</td>
                                                <td>Article Supplier</td>
                                                <td>XXX </td>
                                                <td>7766776677</td>
                                                <td>2, aviskar society</td>
                                                <td>Nizampura</td>
                                                <td>Vadodara</td>
                                                <td>Gujarat</td>                                                                                               
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Hitesh</td>
                                                <td>S</td>
                                                <td>Dixit</td>
                                                <td>Tailor</td>
                                                 <td>yyy</td>
                                                <td>4455445544</td>
                                                <td>7, navjot park</td>
                                                <td>ring road</td>
                                                <td>Surat</td>
                                                <td>Gujarat</td>                                                                                               
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
