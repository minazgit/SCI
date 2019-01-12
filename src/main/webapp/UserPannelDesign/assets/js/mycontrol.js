/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function createTextbox1ItemInward(fid,cn)
{
    var ctrl=$("<input/>").attr({
        type:'text',
        id:fid,
        class:cn,
        name:'imagedesc',
        placeholder:'Description' 
    });
    return ctrl;
}
function createTextbox1(fid)
{
    var ctrl=$("<input/>").attr({
        type:'text',
        id:fid,
        name:'imagedesc',
        placeholder:'Description' 
    });
    return ctrl;
}
function createThead(fid)
{
    var ctrl=$("<thead>").attr({id:fid});
    return ctrl;
}
function createTbody(fid)
{
    var ctrl=$("<tbody>").attr({id:fid});
    return ctrl;
}
function createDiv(fid)
{
    var ctrl=$("<div/>").attr({id:fid,class:'card-body table-wrapper-scroll-y'});
    return ctrl;
}

function createTable(fid)
{
   var ctrl=$("<table>").attr({id:fid ,class:'table table-striped'});
    return ctrl;
}
function createRow(fid)
{
   var ctrl=$("<tr>").attr({id:fid});
    return ctrl;
}
function createHeaderItemInward(fid,cn)
{
    
   var ctrl=$("<th>").attr({id:fid,class:cn,scope:'row'});
    return ctrl;
}
function createHeader(fid)
{
    
   var ctrl=$("<th>").attr({id:fid,scope:'row'});
    return ctrl;
}
function createHeader1(fid,cn)
{
   var ctrl=$("<th>").attr({id:fid,class:cn,scope:'col'});
    return ctrl;
}
function createData(fid)
{
     var ctrl=$("<td>").attr({id:fid});
    return ctrl;
}
function createCheckBox(fid){
     var ctrl=$("<input/>").attr({
        type:'checkbox',
        id:fid
});
return ctrl;
}