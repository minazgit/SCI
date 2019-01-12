<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.ItemMaster"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <%@include file="headerfiles.jsp" %>
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
         <script>     
        
        $(document).ready(function(){
           $("#submit").click(function(e){  
                e.preventDefault();
                var firstname=$('#fname').val();
                var middlename=$('#mname').val();
                var lastname=$('#lname').val();
                var persontype=$("#persontype option:selected").text();
                 var itemlist = [];
                $.each($("#itemlist option:selected"), function(){            
            itemlist.push($(this).val());
        });
                
                
               // var organizationname=$('#organization_name').val();
               var pincode=$('#pincode').val();
                var contactnumber=$('#contact_number').val();
                var addressline1=$('#addressline1').val();
                var addressline2=$('#addressline2').val();
                var city=$("#city option:selected").text();
                var state=$("#state option:selected").text();
             $.ajax( {
                  url:'<%=application.getContextPath()%>/SerPersonMaster?item='+itemlist+'&op=insert',
                  success:function(responseText,statusText,xmlHttp) {
                      alert(responseText);
                      $("#msg").html(responseText);
                  },
                  type:"POST",
                  data:{
                      "firstname":firstname,
                      "middlename":middlename,
                      "lastname":lastname,
                      "persontype":persontype,
                      "itemlist":itemlist,
                      //"organizationname":organizationname,
                      "contactnumber":contactnumber,
                      "addressline1":addressline1,
                      "addressline2":addressline2,
                      "city":city,
                      "state":state,
                      "pincode":pincode
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
                                    <strong class="card-title">Person Master </strong>
                                </div>
                                <div class="card-body">
                                    <!-- Credit Card -->
                                    <div id="pay-invoice">
                                        <div class="card-body">
                                            <div class="card-title">
                                                <h3 class="text-center">Personal Details</h3>
                                                <div id="msg"></div>
                                            </div>
                                            <hr>

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
                                                    <div class="col col-md-3"><label for="select" class=" form-control-label">Person Type</label></div>
                                                    <div class="col-12 col-md-9">
                                                        <select name="select" id="persontype" class="form-control">
                                                            <option value="0"> select</option>
                                                            <option value="1">Cloth Supplier</option>
                                                            <option value="2">Article Supplier</option>
                                                            <option value="3">Tailor</option>
                                                            <option value="3">Remote Person</option>
                                                        </select>
                                                    </div>
                                                </div>
                                <div class="row form-group">
                                  <div class="col col-md-3"><label for="select" class=" form-control-label">Items List</label></div>
                                                    <div class="col-12 col-md-9">
                                                            <select id="itemlist" class="multiselect-ui form-control" multiple="multiple">
                                                                <% ArrayList<ItemMaster> getitem = (ArrayList<ItemMaster>)session.getAttribute("getitemlist");
                                                                Iterator it=getitem.iterator();
                                                                while(it.hasNext())
                                                                {
                                                             ItemMaster im=(ItemMaster)it.next();
                                                            
                                                                %>
                                                                <option value="<%= im.getItemid()%>"><%= im.getItemname()%></option>
                                                          <%  }
                                                                %>
                                                        </select>
                                                    </div>      
                                </div> 
                                

                                                <div class="card-title">
                                                    <h3 class="text-center">Contact Details</h3>
                                                </div>
                                                <hr>

<!--                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label"> Organization Name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="organization_name" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>-->

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label"> Contact Number</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="contact_number" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>


                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Address Line 1</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="addressline1" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label"> Address Line 2</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="addressline2" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>
                                             <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Pin Code</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="pincode" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>


                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="select" class=" form-control-label">City</label></div>
                                                    <div class="col-12 col-md-9">
                                                        <select name="select" id="city" class="form-control">
                                                            <option value="0"> select</option>
                                                            <option value="1">opt1</option>
                                                            <option value="2">opt2</option>
                                                            <option value="3">opt3</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="select" class=" form-control-label">State</label></div>
                                                    <div class="col-12 col-md-9">
                                                        <select name="select" id="state" class="form-control">
                                                            <option value="0"> select</option>
                                                            <option value="1">opt1</option>
                                                            <option value="2">opt2</option>
                                                            <option value="3">opt3</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <hr>
                                                <div>
                                                    <button type="submit" id="submit" class="btn btn-lg btn-info btn-block">
                                                        <span id="submit1">SUBMIT</span>
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
