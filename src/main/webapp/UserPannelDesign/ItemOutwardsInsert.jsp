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
      <script src="assets/js/mycontrol.js"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
      <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
           $(document).ready(function(){
               $("#pay").hide();
               //alert("hello");
                 $("#select").change(function(event){
                     event.preventDefault();
                     var   persontype=$("#select option:selected").val();
         var type=$("#select option:selected").val();
         //alert(persontype);
         
         if(persontype ==="Remote Person" || persontype==="Reference Person")
         {
             $("#pay").show();
         }
          if(persontype ==="Tailor")
         {
             $("#pay").hide();
         }
          var person=$("#select option:selected").attr('id');
         $("#d1").remove();
        ItemOutward(type,person);
           });
               $("#submit").click(function(event){
                     event.preventDefault();
                    var   persontype=$("#select option:selected").val();
                     var person=$("#select option:selected").attr('id');
                      date=$("#date").val();
                    remark=$("#remark").val();
                   // index=$("#index").val();
                    payment=$('input[name=payment]:checked').val();
                    rupees=$("#rupees").val();
                    
                    if(persontype==="Tailor")
                    {
                        payment="";
                    }
                    alert(payment);
//                    alert(persontype);
//                    alert(person);
//                    alert(date);
//                    alert(billno);
//                    alert(index);
                     var ctrlselling="";
                     var selling="";
                      ctrlheader=$(".d");
                      ctrlitemname=$(".itemname");
                 //    alert(ctrlheader.length);
                      for(i=1;i<=ctrlheader.length-1;i++)
                      {
                          if(i===1)
                          ctrlquantity=$(".c"+i);
                         
                        if(i===2)
                             ctrlselling=$(".c"+i);
                          
                      }
//                      alert("----"+ctrlquantity.length);
//                      
//                      alert("----"+ctrlitemname.length);
                        jsondata="[";
                        for(j=0;j<ctrlitemname.length;j++)
        {
            itemname=$(ctrlitemname[j]).html();
            quantity=$(ctrlquantity[j]).val();
//             alert(itemname);
//          alert(quantity);
           if(ctrlselling!=="")
           {
            selling=$(ctrlselling[j]).val();
           //  alert(selling);
        }
         
         
          jsondata=jsondata+"{\"in\":\""+itemname+"\",\"q\":\""+quantity+"\"";
        
               jsondata=jsondata+",\"selling\":\""+selling+"\"";
           
          jsondata=jsondata+"},";
         
        }
         jsondata=jsondata.slice(0,jsondata.length-1);
        jsondata=jsondata+"]";  
        alert(jsondata);
                 $.ajax({url: "<%=application.getContextPath()%>/SerItemOutwards",
            data:{
                "op":"ins",
                "personid":person,
                "persontype":persontype,
                "payment":payment,
                "rupees":rupees,
                "date":date,
                "json":jsondata
                
            },
            type: 'POST',
        success: function(result){
           location.href="<%=application.getContextPath()%>/UserPannelDesign/ItemOutwardReport.jsp";
    
  }}); 
                      });
       });
       
       function ItemOutward(type,person){
        $.post("<%=application.getContextPath()%>/SerItemOutwards?op=xyz",{"person":person},function(responseText,statusText,xhr){
                     // var header=["Item List","Quantity"];
                      obj=JSON.parse(responseText);
                     // alert(obj);
if(type==="Tailor")
          {
          var header=["type","quantity (in meters)"];
         // alert(header);
          }
      if(type==="Remote Person" || type==="Reference Person")
          {
          var header=["type","quantity","selling price"];
         }
                      var mydiv=createDiv('d1');
                     
                       var mytabel=createTable('t1');
                     //  var thead=createThead('th1');
                      //alert(mytabel);
                      var myrow=createRow('r1');
                     // myrow.append("</tr>");
                      //mytabel.append(myrow);
                      //mydiv.append(mytabel);
                      
      for(j=0;j<header.length;j++)
      {
      var head=createHeaderItemInward(header[j],"d");
     
       myrow.append(head.append(header[j]+"</th>"));
      }
      myrow.append("</tr>");
   
      mytabel.append(myrow);
    
    
     
     // var tbody=createTbody('tb1');
                      for(i=0;i<obj.length;i++)
                      {
                        var myrow1=createRow(obj[i]);
                      
                       var  data1=createHeaderItemInward(obj[i],"itemname");
                             myrow1.append(data1.append(obj[i]+"</th>"));
                         for(k=1;k<header.length;k++)
                        {
                           var data=createData(header[k]);
                          var text= createTextbox1ItemInward(obj[i],"c"+k);
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
                                                   <option value="-1">SELECT PERSON NAME </option>
                                                    <% JSONArray ja=(JSONArray)session.getAttribute("nid1");
                                                        for(int i=0;i< ja.length();i++)
                                                        {
                                                           JSONObject jo= ja.getJSONObject(i);
                                                      
                                                        
                                                %>
                                                    <option value="<%=jo.getString("ptype")%>" id="<%=jo.getString("pid") %>"><%=jo.getString("fm")%> ( <%=jo.getString("ptype")%> )</option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                                </div>
                                                <div class="row form-group">
                                             <div class="col col-md-3"><label for="hf-password" class=" form-control-label">Date</label></div>
                                            <div class="col-12 col-md-9"><input type="date"  id="date" name="text-input" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                     
                                        </div>

<!--                                     
                                        <div class="row form-group">
                                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Remark</label></div>
                                            <div class="col-12 col-md-9"><input type="text" id="remark" name="text-input" placeholder="Text" class="form-control"><small class="form-text text-muted">This is a help text</small></div>   
                                            </div>
                                                <div class="row form-group">
                                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">inward index</label></div>
                                            <div class="col-12 col-md-9"><input type="text" id="index" name="text-input" placeholder="Auto generate" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                        </div>-->
                                        <div class="row" id="row">
                                          </div>
                                                <div  id="pay"  class="row form-group">
                                                    <div class="col col-md-12">
                                                        <h5>Mode Of Payment</h5><br>
                                                     <input id="payment" type="radio" name="payment" value="Cash"> Cash
                                                     <input type="radio" name="payment" id="payment" value="Credit"> Credit<br> <br>
                                                    </div>
                                                     <div class="col col-md-3"><label for="hf-password" class=" form-control-label">amount paid</label></div>
                                                     <div class="col-12 col-md-9"><input type="number"  id="rupees" name="text-input" class="form-control"><small class="form-text text-muted">This is a help text</small></div>
                                     
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

