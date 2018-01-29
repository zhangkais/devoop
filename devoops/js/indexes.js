 window.onload = function () {
	 document.URL=location.href;
 }

function tong()
{
	for(var i=1;i<7;i++){
	 var a=document.getElementById('as'+i);
	
	 if(a.checked)
	 {
		  var d1=document.getElementById('a'+i);
		       for (j=0; j<d1.length; j++){
               if (d1[j].id == "sele1") // 根据option标签的ID来进行判断 测试的代码这里是两个等号
                 {
                   d1[j].selected = true;
                }
	          }   
			  var sele=document.getElementById('s2id_a'+i);
      objs = sele.firstChild.childNodes;
            objs[1].innerHTML = "通过";
	   }
	}
	//  if(b.checked)
//	 {
//	
	//	  var c1=document.getElementById('a3');
	//	  c1.value="通过";
	// }	 
}
function butong()
{
	
	for(var i=1;i<7;i++){
		
	 var a=document.getElementById('as'+i);
	 if(a.checked)
	 {
		 

		  var d1=document.getElementById('a'+i).options;  
		
          for (j=0; j<d1.length; j++){
               if (d1[j].id == "sele2") // 根据option标签的ID来进行判断 测试的代码这里是两个等号
                 {
                   d1[j].selected = true;
                }
	          } 
			  var sele=document.getElementById('s2id_a'+i);
			      objs = sele.firstChild.childNodes;
            objs[1].innerHTML = "不通过";
			//  alert(sele.firstChild.childNodes);
			 //   sele.firstChild.innerHTML="不通过";
			
			  
	  }
	//  if(b.checked)
	// {
	//	  var b1=document.getElementById('a2');
	//	  b1.value="不通过";
	//	  var c1=document.getElementById('a3');
	//	  c1.value="不通过";
	// }

    }
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

function panduan()
{    
   var url="#ajax/page_invoices.html";   
   var check=document.getElementById('as');
   if(!check.checked)
   {
    url+="?station=1&name=1";
   }
  document.location.href=url;
  location.reload();

}
























