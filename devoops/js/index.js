 window.onload = function () {
	 document.URL=location.href;
 }

function tong()
{
	
	 var a=document.getElementById('as');
	// var b=document.getElementById('b');
	 
	 if(a.checked)
	 {
	   alert("sdsdasd");
		//  var d1=document.getElementById('a4');
		//  d1.value="通过";
	 }
	//  if(b.checked)
//	 {
//		  var b1=document.getElementById('a2');
	//	  b1.value="通过";
	//	  var c1=document.getElementById('a3');
	//	  c1.value="通过";
	// }	 
}
function butong()
{
	 var a=document.getElementById('as');
	// var b=document.getElementById('b');

	 
	 if(a.checked)
	 {
		  alert("sdsdasd");
		 // var b1=document.getElementById('a1');
		 // b1.value="不通过";
		//   var d1=document.getElementById('a4');
		//  d1.value="不通过";
	 }
	//  if(b.checked)
	// {
	//	  var b1=document.getElementById('a2');
	//	  b1.value="不通过";
	//	  var c1=document.getElementById('a3');
	//	  c1.value="不通过";
	// }

}

function displays(s)
{	
var ss=document.getElementById('downs');
	if(s=='true')
	{
	ss.style.display='block';
	
	}
		if(s=='none')
	{
		ss.style.display='none';
	}
}
function clears()
{
	var ss=document.getElementById('downs');
	ss.style.display='none';
	for(var i=1;i<=12;i++)
	{
		var ss=document.getElementById(i);
		ss.value="";
	}
}

function down()
{
	var ss=document.getElementById('d1');
		ss.style.display='none';
	var ss1=document.getElementById('d2');
		ss1.style.display='none';
	var ss2=document.getElementById('d3');
	ss2.style.display='block';
	var ss3=document.getElementById('d4');
	ss3.style.display='block';
}
function up()
{
var ss=document.getElementById('d1');
		ss.style.display='block';
	var ss1=document.getElementById('d2');
		ss1.style.display='block';
	var ss2=document.getElementById('d3');
	ss2.style.display='none';
	var ss3=document.getElementById('d4');
	ss3.style.display='none';	
}

function panduan(s)
{     var url="Case.html";
	if(s=="1"||s=="4"){
	   var a=document.getElementById('a');
	    var a1=document.getElementById('a'+s);
		if(a.checked  )
		{  if(a1.value=="不通过")
			{
				
			}
	      }else{
			   url+="?station=1&name=1"
		   }
		
		
      window.location.href=url;
	}
	if(s=="2"||s=="3"){
	   var a=document.getElementById('b');
	    var a1=document.getElementById('a'+s);
		if(a.checked)
		{  if(a1.value=="不通过")
			{
				
			}
	      }else{
			   url+="?station=1&name=2"
		   }
		
		
      window.location.href=url;
	}
	
	
	
}


























