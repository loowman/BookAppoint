$(function(){
    $("#tabSub").on('click',function(event){
    	event.preventDefault();
    	 var url=$('form').attr('action');
    	
    	 var name=$('.allInput').val();
    	  var args={'name':name};
    	  $.post(url,args,function(data){
    		     for(let i=0;i<data.length;i++){
    		    	
    		         let str='<tr><td>'+data[i].id+'</td>'+'<td>'+data[i].name+'</td>'+'<td>'+data[i].num+'</td>'+'<td><a class="btn btn-info" href=\"/BookAppointment/books/'+data[i].id+'/detail\" target="_blank">详细</a></td></tr>'; 
    		              $('tbody').append(str);    
    		     } 
    		  
    		  
    	  });
           
    	
    	
    	
    	
    	return false;
    
    
    })
    


})

