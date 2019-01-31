<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <%@include file="headerfiles.jsp" %>
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
                        <div class="col-lg-8">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title">Security Person </strong>
                                </div>
                                <div class="card-body">
                                    <!-- Credit Card -->
                                    <div id="pay-invoice">
                                        <div class="card-body">
                                            <div class="card-title">
                                                <h3 class="text-center">Personal Details</h3>
                                            </div>
                                            <hr>

                                            <form action="" method="post" class="form-horizontal">

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">First Name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Middle Name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Last Name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>
                                                
                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label class=" form-control-label">Gender</label></div>
                                                    <div class="col col-md-9">
                                                        <div class="form-check-inline form-check">
                                                            <label for="inline-radio1" class="form-check-label ">
                                                                <input type="radio" id="inline-radio1" name="inline-radios" value="option1" class="form-check-input">Male  
                                                            </label>
                                                            <label for="inline-radio2" class="form-check-label ">
                                                                <input type="radio" id="inline-radio2" name="inline-radios" value="option2" class="form-check-input">Female
                                                            </label>

                                                        </div>
                                                    </div>
                                                </div>

                                                
                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Father Name</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label"> Contact Number</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Email</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Birth Date</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>


                                                
                                                <div class="card-title">
                                                    <h3 class="text-center">Professional Details</h3>
                                                </div>
                                                <hr>
                                                
                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="select" class=" form-control-label">Qualification</label></div>
                                                    <div class="col-12 col-md-9">
                                                        <select name="select" id="select" class="form-control">
                                                            <option value="0"> select</option>
                                                            <option value="1">opt1</option>
                                                            <option value="2">opt2</option>
                                                            <option value="3">opt3</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                
                                                
                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label class=" form-control-label">Status</label></div>
                                                    <div class="col col-md-9">
                                                        <div class="form-check">
                                                            <div class="radio">
                                                                <label for="radio1" class="form-check-label ">
                                                                    <input type="radio" id="radio1" name="radios" value="" class="form-check-input">On Service
                                                                </label>
                                                            </div>
                                                            <div class="radio">
                                                                <label for="radio2" class="form-check-label ">
                                                                    <input type="radio" id="radio2" name="radios" value="" class="form-check-input">Ex-employee
                                                                </label>
                                                            </div>
                                                            <div class="radio">
                                                                <label for="radio3" class="form-check-label ">
                                                                    <input type="radio" id="radio3" name="radios" value="" class="form-check-input">New
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                
                                                
                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label class=" form-control-label">S-Type</label></div>
                                                    <div class="col col-md-9">
                                                        <div class="form-check">
                                                            <div class="radio">
                                                                <label for="radio1" class="form-check-label ">
                                                                    <input type="radio" id="radio1" name="radios" value="" class="form-check-input">HRS SHIFT
                                                                </label>
                                                            </div>
                                                            <div class="radio">
                                                                <label for="radio2" class="form-check-label ">
                                                                    <input type="radio" id="radio2" name="radios" value="" class="form-check-input">EX-SERVICEMEN
                                                                </label>
                                                            </div>
                                                            <div class="radio">
                                                                <label for="radio3" class="form-check-label ">
                                                                    <input type="radio" id="radio3" name="radios" value="" class="form-check-input">CIVILIAN TRAINED
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="select" class=" form-control-label">POST</label></div>
                                                    <div class="col-12 col-md-9">
                                                        <select name="select" id="select" class="form-control">
                                                            <option value="0">select</option>
                                                            <option value="">Gunmen</option>
                                                            <option value="">Body Guard</option>
                                                            <option value="">Security Officers</option>
                                                            <option value="">Security Supervisors</option>
                                                            <option value="">Security Guards</option>                                                            
                                                            <option value="">Lady Searcher</option>
                                                        </select>
                                                    </div>
                                                </div>


                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label class=" form-control-label">Nationality</label></div>
                                                    <div class="col col-md-9">
                                                        <div class="form-check-inline form-check">
                                                            <label for="inline-radio1" class="form-check-label ">
                                                                <input type="radio" id="inline-radio1" name="inline-radios" value="option1" class="form-check-input">One
                                                            </label>
                                                            <label for="inline-radio2" class="form-check-label ">
                                                                <input type="radio" id="inline-radio2" name="inline-radios" value="option2" class="form-check-input">Two
                                                            </label>

                                                        </div>
                                                    </div>
                                                </div>

                                                
                                                <div class="card-title">
                                                    <h3 class="text-center">Other Details</h3>
                                                </div>
                                                <hr>

                                                <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Bank Account Number</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>
                                                
                                                  <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Nearest Railway Station</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>
                                                
                                                  <div class="row form-group">
                                                    <div class="col col-md-3"><label for="text-input" class=" form-control-label">Nearest Police Station</label></div>
                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                </div>
                                                
                                                
                                                <div class="card-title">
                                                    <h3 class="text-center">Experience  Details</h3>
                                                </div>
                                                <hr>
 <!-- for YOGI-->                                              
<!--Add dynamic control her -->                                                
                                                
                                                <div class="card-title">
                                                    <h3 class="text-center">Address  Details</h3>
                                                </div>
                                                <hr>
                                                
 <!-- for YOGI-->                                              
<!--Add dynamic control her -->  
<!-- if both address will be same enter only one address & address tye : current, permanent, both same-->

                                                <div>
                                                    <button id="payment-button" type="submit" class="btn btn-lg btn-info btn-block">
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
