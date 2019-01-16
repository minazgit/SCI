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
        $(document).ready(function() {    
           $("#example").hide();
                 $("#unit").change(function(event){
                     event.preventDefault();
                     
         var unit=$("#unit option:selected").text();
         if ( $.fn.dataTable.isDataTable( '#example' ) )

                        {

                            table = $('#example').DataTable();
                            
                            table.destroy();
                            
                        } 
    var   table=$('#example').DataTable( {
        "ajax": {"url":"<%=application.getContextPath()%>/SerUniformReturn",
        "data":{
            "unit":unit
                
                    },
          
         "type":"POST"},
        "columns": [
    { "data": "value" },
            { "data": "empcode" },
            { "data": "firstname" },
            { "data": "middlename" },
             { "data": "lastname" }
        ],
                'columnDefs': [{
         'targets': 0,
         'searchable': false,
         'orderable': false,
         'className': 'dt-body-center',
         'render': function (data, type, full, meta){
             return '<input type="checkbox" name="id[]" value="' + $('<div/>').text(data).html() + '">';
         }
      }],
      'order': [[1, 'asc']]          
   } );
   $('#example-select-all').on('click', function(){
      // Get all rows with search applied
      var rows = table.rows({ 'search': 'applied' }).nodes();
      // Check/uncheck checkboxes for all rows in the table
      $('input[type="checkbox"]', rows).prop('checked', this.checked);
   });
    $("#example").show();
          
      
       $("#submit").click(function(e){
           e.preventDefault();
      
       var data="";
        table.$('input[type="checkbox"]').each(function(){
           
       if(this.checked){
              data=data+this.value+" ";  
        }
    });
    data=data.trim();
    alert(data);
    location.href="<%=application.getContextPath()%>/SerUniformReturn?empno="+data+"&unit="+unit+"&op=unit";
       }); 
        });
     });
       
//       function UniformIssue(unit){
//        $.post("<>/NewServlet",{"unit":unit},function(responseText,statusText,xhr){
//                      var header=["Refrence No","Firstname","Middle Name","Last Name"," "];
//                      obj=JSON.parse(responseText);
//                      alert(obj);
//                      $.each(obj,function(index,value){
//                          alert(value.fname);
//                          alert(index);
////                         // $.each(value,function(innm,v)
////                          {
////                              alert(innm+"  "+v);
////                          });
//                      }
//                              
             //   );
//alert(responseText);
//                      var mydiv=createDiv('d1');
//                     
//                       var mytabel=createTable('t1');
//                       
//                      var myrow=createRow('r1');
//                      
//      for(j=0;j<header.length;j++)
//      {
//      var head=createHeader(header[j]);
//     
//       myrow.append(head.append(header[j]+"</th>"));
//       
//      }
//      myrow.append("</tr>");
//      
//      mytabel.append(myrow);
//    
//     
//      
//                      for(i=0;i<obj.length;i++)
//                      {
//                        var myrow1=createRow(obj[i]);
//                       $.each(obj,function(index,value){
//                          alert(value.fname);
//                          alert(index);
//                          if(index===i)
//                          {
// var  data1=createHeader(value);
//                             myrow1.append(data1.append(value.refrenceno+"</th>"));
//                      
//                      
//                             //alert(header.length);
//                         for(k=1;k<header.length;k++)
//                        {
//                           
//                           if(k===(header.length-1))
//                           {
//                               var check=createCheckBox(obj[i]);
//                               myrow1.append(check);
//                           }
//                           else
//                           {
//                              // alert(k);
//                               var data=createData(header[k]);
//                               if(k===1)
//                               {
//                                 data.append(value.fname+"</td>")  ;
//                               }
//                             //  var check=createCheckBox(obj[i]);
//                         // var text= createTextbox1(obj[i]+" "+header[k]);
//                           //$("#row1").append(text);
//                          // data.append(check);
//                           myrow1.append(data);
//                           }
//                        }
//                        myrow1.append("</tr>");
//                         mytabel.append(myrow1);
//                                
//                         }
//                      }
//                              
//                );
//                      }
//                       mydiv.append(mytabel);
//    //  $('#row').animate({height:'72px'}, 500);
//      $("#row").append(mydiv);
//     
//                      });
//      		
//         }
//               
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
                                    <strong>Uniform Return</strong> 
                                </div>
                                <div class="card-body card-block">
                                    <form action="<%=application.getContextPath()%>/Practice"  method="get" class="form-horizontal">


                                        <div class="row form-group">
                                            <div class="col col-md-3"><label for="select" class=" form-control-label">Unit</label></div>
                                            <div class="col-12 col-md-9">
                                              <%
                                                JSONArray ja=(JSONArray)session.getAttribute("unitname");
                                                
                                                %>
                                                <select name="select" id="unit" class="form-control">
                                                     <option value="0"> select item</option>
                                                    <%
                                                        for(int i=0;i<ja.length();i++)
                                                        {
                                                            String unitname=(String)ja.getString(i);
                                                    %> 
                                                   
                                                    
                                                    <option value="<%=unitname%>"><%=unitname%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                      <table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                 <th><input type="checkbox" name="select_all" value="1" id="example-select-all"></th>
                <th>Employee Number</th>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                
            </tr>
        </thead>
        </table>
                                      
                               
                                <div class="card-footer">
                                    <button type="submit" id="submit" class="btn btn-primary btn-sm">
                                        <i class="fa fa-dot-circle-o"></i> Submit
                                    </button>
                                 </div>
                                    </form>
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

