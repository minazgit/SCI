<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <%@include file="headerfiles.jsp" %>
         <script type = "text/javascript" 
                 src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
     
      </script>
      <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
      <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script>
           $(document).ready(function(){
                 $("#submit").click(function(e){
                           e.preventDefault();
         
         var firstname=$("#fname").val();
       //  alert(firstname);
         var middlename=$("#mname").val();
        // alert(middlename);
         var lastname=$("#lname").val();
         //alert(lastname);
         var unitname=$("#unitname").val();
          var refname=$("#refname").val();
         var unitlocation=$("#unitlocation").val();
         var empno=$("#empno").val();
         var contactnumber=$("#contactno").val();
        alert(contactnumber);
        $.ajax( {
            url:'<%=application.getContextPath()%>/SerSecurityGuard?op=insert',
                 
                  type:"post",
                  data:{
                      
              "firstname":firstname,
              "middlename":middlename,
              "lastname":lastname,
              "unitname":unitname,
              "unitlocation":unitlocation,
              "empno":empno,
              "contactnumber":contactnumber,
              "refname":refname
              
                  },
                   success:function(responseText,statusText,xmlHttp) {
                     alert(responseText);
                        $("#msg").html(responseText);
                  }
               });
           });
       });
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
                        <div class="col-lg-9">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title">Security Guard Master </strong>
                                    <div id="msg"></div>
                                </div>
                                <div class="card-body">
                                    <!-- Credit Card -->
                                    <div id="pay-invoice">
                                        <div class="card-body">
<!--                                            <div class="card-title">
                                                <h3 class="text-center">Personal Details</h3>
                                            </div>
                                            <hr>-->

                                            <form action="" method="post" class="form-horizontal">

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">First Name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="fname" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Middle Name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="mname" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Last Name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="lname" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>
                                                 <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Reference Name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="refname" name="text-input" placeholder="Unit Name" class="form-control"><small class="form-text text-muted">Enter ref name</small></div>
                                                </div> 
                                                         <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Unit Name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="unitname" name="text-input" placeholder="Unit Name" class="form-control"><small class="form-text text-muted">Enter Unit Location</small></div>
                                                </div> 
                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Unit Location</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="unitlocation" name="text-input" placeholder="Unit Location" class="form-control"><small class="form-text text-muted">Enter Unit Location</small></div>
                                                </div> 
                                                 <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Employee No</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="empno" name="text-input" placeholder="Employee Number" class="form-control"><small class="form-text text-muted">Enter Reference number</small></div>
                                                </div>      
<!--                                                <div class="card-title">
                                                    <h3 class="text-center">Contact Details</h3>
                                                </div>
                                                <hr>-->



                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label"> Contact Number</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="contactno" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>


<!--                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">House no. / Flat no.</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label"> Society name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="select" class=" form-control-label">City</label></div>
                                                    <div class="col-12 col-md-9">
                                                        <select name="select" id="select" class="form-control">
                                                            <option value="0"> select</option>
                                                            <option value="1">opt1</option>
                                                            <option value="2">opt2</option>
                                                            <option value="3">opt3</option>
                                                        </select>
                                                    </div>
                                                </div>-->

                                                
                                         <hr>
                                       <div>
                                                    <button id="submit" type="submit" class="btn btn-lg btn-info btn-block">
                                                        <span id="payment-button-amount">SUBMIT</span>
                                                        <span id="payment-button-sending" style="display:none;">Sending?</span>
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>

                                </div>
                            </div> <!-- .card -->

                        </div><!--/.col-->
                    </div>
                </div><!-- .animated -->
            </div><!-- .content -->
        </div><!-- /#right-panel -->

        <!-- Right Panel -->
        <%@include file="footerfiles.jsp" %>
    </body>
</html>
