
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
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
      <style>
          .table-wrapper-scroll-y {
display: block;
max-height: 200px;
overflow-y: auto;
-ms-overflow-style: -ms-autohiding-scrollbar;
}
          
      </style>
      <script src="assets/js/mycontrol.js"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
      <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
           $(document).ready(function(){
               alert("hello");
                 $("#person").change(function(event){
                     event.preventDefault();
                     
         var person=$("#person option:selected").val();
        var date;
        var jsondata;
        var billno;
         $("#d1").remove();
        ItemInward(person);
    
           });
            $("#submit").click(function(event){
                     event.preventDefault();
                     person=$("#person option:selected").val();
                    // var person=$("#select option:selected").text();
                      date=$("#date").val();
                    terms=$("#terms").val();
                      dmethod=$("#dmethod").val();
                     //alert(date);
                  // alert(billno);
        ctrlitemname=$(".itemname");
        ctrlquantity=$(".c1");
        ctrlbuying=$(".c2");
       // ctrlselling=$(".c3");
       // ctrlremark=$(".c4");
        //alert(ctrlitemname.length);
       jsondata="[";
        for(i=0;i<ctrlitemname.length;i++)
        {
            itemname=$(ctrlitemname[i]).html();
            quantity=$(ctrlquantity[i]).val();
            buying=$(ctrlbuying[i]).val();
            //selling=$(ctrlselling[i]).val();
            //remark=$(ctrlremark[i]).val();
           
            jsondata=jsondata+"{\"in\":\""+itemname+"\",\"q\":\""+quantity+"\",\"bp\":\""+buying+"\"},";
         
            
        }
        jsondata=jsondata.slice(0,jsondata.length-1);
        jsondata=jsondata+"]";
      //  alert(person);
        //alert(billno);
        //alert(date);
        $.ajax({url: "<%=application.getContextPath()%>/SerPurchaseOrder",
            data:{
                "op":"ins",
                "person":person,
                "terms":terms,
                "date":date,
                "dmethod":dmethod,
                "json":jsondata
                
            },
            type: 'POST',
        success: function(result){
            alert(result);
    
  }});
       
             });    
       });
       function ItemInward(person){
        $.post("<%=application.getContextPath()%>/SerItemInward?op=maketable",{"person":person},function(responseText,statusText,xhr){
                      var header=["Item List","Quantity","Unit Price"];
                   //   alert(responseText);
                      obj=JSON.parse(responseText);
    // alert(obj[0]+"  "+obj.length);
                      var mydiv=createDiv('d1');
                     
                       var mytabel=createTable('t1');
                       
                      var myrow=createRow('r1');
                     // myrow.append("</tr>");
                      //mytabel.append(myrow);
                      //mydiv.append(mytabel);
                      
      for(j=0;j<header.length;j++)
      {
      var head=createHeader1(header[j]);
     
       myrow.append(head.append(header[j]+"</th>"));
       
      }
      myrow.append("</tr>");
      
      mytabel.append(myrow);
    
     
      
                      for(i=0;i<obj.length;i++)
                      {
                        var myrow1=createRow(obj[i]);
                      
                       var  data1=createHeaderItemInward(obj[i],"itemname");
                             myrow1.append(data1.append(obj[i]+"</th>"));
                         for(k=1;k<header.length;k++)
                        {
                           var data=createData(header[k]);
                          var text= createTextbox1ItemInward(obj[i],"c"+k);
                           $("#row1").append(text);
                           data.append(text);
                           myrow1.append(data);
                        }
                        myrow1.append("</tr>");
                         mytabel.append(myrow1);
                      }
                       mydiv.append(mytabel);
    //  $('#row').animate({height:'72px'}, 500);
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


                        <div class="col-lg-10">
                            <div class="card">
                                <div class="card-header">
                                    <strong>Item Inwards</strong> Form
                                </div>
                                <div class="card-body card-block">
                                    <form action="" method="post" class="form-horizontal">
                                                                          
                                        <div class="row form-group">
                                            <div class="col col-md-3"><label for="select" class=" form-control-label">Person</label></div>
                                            <div class="col-12 col-md-9">
                                                
                                                <select name="select" id="person" class="form-control">
                                                    <option value="-1">SELECT PERSON NAME </option>
                                                    <% JSONArray ja=(JSONArray)session.getAttribute("name");
                                                        for(int i=0;i< ja.length();i++)
                                                        {
                                                           JSONObject jo= ja.getJSONObject(i);
                                                      
                                                        
                                                %>
                                                    <option value="<%=jo.getString("pid")%>"><%=jo.getString("fm")%> ( <%=jo.getString("ptype")%> )</option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>


                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3"><label for="hf-password" class=" form-control-label">Delivery Date</label></div>
                                            <div class="col-12 col-md-9"><input type="date" id="date" name="text-input"  class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                        </div>

                                        <div class="row form-group">
                                            <div class="col col-md-3"><label for="hf-password" class=" form-control-label">Terms</label></div>
                                            <div class="col-12 col-md-9"><input type="text" id="terms" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                        </div>
                                                
                                                 <div class="row form-group">
                                            <div class="col col-md-3"><label for="hf-password" class=" form-control-label">Delivery Method </label></div>
                                            <div class="col-12 col-md-9"><input type="text" id="dmethod" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                        </div>
                                             
                                     <div  id="row">
                                     
                                     
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

v