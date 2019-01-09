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
      <script src="assets/js/mycontrol.js"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
      <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
           $(document).ready(function(){
               alert("hello");
                 $("#select").change(function(event){
                     event.preventDefault();
         var type=$("#select option:selected").val();
         alert(type);
         $("#d1").remove();
        ItemOutward(type);
           });
       });
       
       function ItemOutward(type){
        $.post("<%=application.getContextPath()%>/SerItemOutwards",{"type":type},function(responseText,statusText,xhr){
                     // var header=["Item List","Quantity"];
                      obj=JSON.parse(responseText);
                     // alert(obj);
if(type==="tailor")
          {
          var header=["type","quantity"];
         // alert(header);
          }
      if(type==="unitlocation")
          {
          var header=["type","quantity","selling price"];
         }
                      var mydiv=createDiv('d1');
                     
                       var mytabel=createTable('t1');
                     //  var thead=createThead('th1');
                      alert(mytabel);
                      var myrow=createRow('r1');
                     // myrow.append("</tr>");
                      //mytabel.append(myrow);
                      //mydiv.append(mytabel);
                      
      for(j=0;j<header.length;j++)
      {
      var head=createHeader1(header[j]);
      //alert(head);
       myrow.append(head.append(header[j]+"</th>"));
      }
      myrow.append("</tr>");
     // myrow.append("</thead>");
     // thead.append(myrow);
      mytabel.append(myrow);
    
    
     
     // var tbody=createTbody('tb1');
                      for(i=0;i<obj.length;i++)
                      {
                        var myrow1=createRow(obj[i]);
                      
                       var  data1=createHeader(obj[i]);
                             myrow1.append(data1.append(obj[i]+"</th>"));
                         for(k=1;k<header.length;k++)
                        {
                           var data=createData(header[k]);
                          var text= createTextbox1(obj[i]+" "+header[k]);
                         //  $("#row1").append(text);
                           data.append(text);
                           myrow1.append(data);
                        }
                        myrow1.append("</tr>");
                     //    myrow1.append("</tbody>");
                       // tbody.append(myrow1);
                         mytabel.append(myrow1);
                      }
                       mydiv.append(mytabel);
      $("#row").append(mydiv);
     
                      });
                  
       
       
       }
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
                                    <strong>Item outwards</strong> 
                                </div>
                                <div class="card-body card-block">
                                    <form action="" method="post" class="form-horizontal">
  <div class="row form-group">
                                            <div class="col col-md-3"><label for="select" class=" form-control-label">Person</label></div>
                                            <div class="col-12 col-md-9">
                                                <select name="select" id="select" class="form-control">
                                                    <option value="0"> select person</option>
                                                    <option value="Hitesh">Hitesh Bhai</option>
                                                    <option value="tailor">AAA</option>
                                                    <option value="unitlocation">XXX</option>
                                                    <option value="3">GGG</option>
                                                </select>
                                            </div>
                                             <div class="col col-md-3"><label for="hf-password" class=" form-control-label">Date</label></div>
                                            <div class="col-12 col-md-9"><input type="date"  id="text-input" name="text-input" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                     
                                        </div>

                                     
                                        <div class="row form-group">
                                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Remark</label></div>
                                            <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>                         
                                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">inward index</label></div>
                                            <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="Auto generate" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                        </div>
                                        <div class="row" id="row">
                                          </div>
                                    </form>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary btn-sm">
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

