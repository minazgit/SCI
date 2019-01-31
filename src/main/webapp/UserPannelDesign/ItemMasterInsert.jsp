<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <%@include file="headerfiles.jsp" %>
         <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
           <%String msg= request.getParameter("msg");
                                    if(msg==null)
                                    {
                                        msg="";
                                    }
                                    %>
          <script>
        $(document).ready(function() {
           
        $("#submit").click(function(){
            var id= $("#id").val();
            var item_name=$("#item_name").val();
          
            var category=$("#select option:selected").text();
       
            var sub_category=$("input[name='radios']:checked").val();
           var reorder=$("#reorder").val();
           
          $.ajax( {
                  url: "<%=application.getContextPath()%>/SerItemmMaster",
                  type: 'POST',
                  data:{"id":id,
                       "item_name":item_name,
                       "category":category,
                       "sub_category":sub_category,
                       "reorder":reorder
            },
                  success:function(data) {
                    
                     $("#msg").html(data);
                     $("#msg").fadeOut(3000);
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


                        <div class="col-lg-8">
                            <div class="card">
                                <div class="card-header">
                                    <strong>Uniform Item Master</strong> Form
                                </div>
                                <div>
                                  
                                    <div>
                                        <h3 id="msg" style="color:brown;" align="center"></h3>
                                    </div>
                                </div>
                                <div class="card-body card-block">
                                    <form action="" method="post" class="form-horizontal">
                                        <!--                                        <div class="row form-group">
                                                                                    <div class="col col-md-3"><label for="hf-email" class=" form-control-label">Mid</label></div>
                                                                                    <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                                                                </div>-->
<!--                                        <div class="row form-group">
                                            <div class="col col-md-3"><label for="hf-password" class=" form-control-label">Id</label></div>
                                            <div class="col-12 col-md-9"><input type="text" id="id" name="id" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                        </div>-->
                                        <div class="row form-group">
                                            <div class="col col-md-3"><label for="hf-password" class=" form-control-label">Item name</label></div>
                                            <div class="col-12 col-md-9"><input type="text" id="item_name" name="item_name" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                        </div>
                                      <div class="row form-group">
                                            <div class="col col-md-3"><label for="hf-password" class=" form-control-label">Reorder Level</label></div>
                                            <div class="col-12 col-md-9"><input type="number" id="reorder" name="reorder" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                        </div>
                                         <div class="row form-group">
                                                    <div class="col col-md-3"><label for="select" class=" form-control-label">Item Category</label></div>
                                                    <div class="col-12 col-md-9">
                                                        <select name="select" id="select" class="form-control">
                                                            <option value="0"> select category</option>
                                                            <option value="1">cloth</option>
                                                            <option value="2">article</option>
                                                            <option value="3">uniform</option>
                                                        </select>
                                                    </div>
                                                </div>
                                               <div class="row form-group">
                                                    <div class="col col-md-3"><label class=" form-control-label">Sub Category</label></div>
                                                    <div class="col col-md-9">
                                                        <div class="form-check">
                                                            <div class="radio">
                                                                <label for="radio1" class="form-check-label ">
                                                                    <input type="radio" id="radio1" name="radios" value="security" class="form-check-input">security 
                                                                </label>
                                                            </div>
                                                            <div class="radio">
                                                                <label for="radio2" class="form-check-label ">
                                                                    <input type="radio" id="radio1" name="radios" value="non security" class="form-check-input">non security 
                                                                </label>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>
                                                </div>
                                        

                                    </form>
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


        <%@include file="footerfiles.jsp" %>


    </body>
</html>

