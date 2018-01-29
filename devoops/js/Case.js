
 
 Request = {
      QueryString: function (item) {
        var svalue = location.search.match(new RegExp("[\?\&]" + item + "=([^\&]*)(\&?)", "i"));
        return svalue ? svalue[1] : svalue;
      }
    }
	
window.onload = function () {      
if(Request.QueryString("station")=="1")
{
		for(var i=1; i<13;i++)
		{
			var a=document.getElementById("tss"+i);
			a.disabled="disabled";
		}
	}
  
  }
   
   
 function  returns()
 {
		var url="#ajax/tables_tables.html"; 
	
  document.location.href=url;
	  location.reload();
	  
 }