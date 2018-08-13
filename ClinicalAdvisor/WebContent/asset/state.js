$('document').ready(function(){
$.getJSON('FetchStatesJSON',{ajax:true},function(data){
//alert(data);
	$('#ccity').append($('<option>').val('-Select-').text('-Select-'));	  
	$('#cstate').append($('<option>').val('-Select-').text('-Select-'));	  
  $.each(data,function(i,item){
  $('#cstate').append($('<option>').val(item.STATEID).text(item.STATENAME));	  
  });	
});	


$('#cstate').change(function(){
	
$.getJSON("FetchCityByStateIDJSON",{ajax:true,stateid:$('#cstate').val()},function(data){
	 $('#ccity').empty();
	 $('#ccity').append($('<option>').val('-Select-').text('-Select-'));	  
	$.each(data,function(i,item){
		  $('#ccity').append($('<option>').val(item.CITYID).text(item.CITYNAME));	  
		  });
	
});	
	
});

$('#ccity').change(function(){
	
	$.getJSON("FetchClinicByCityIdJSON",{ajax:true,cityid:$('#ccity').val()},function(data){
		 $('#cliid').empty();
		 $('#cliid').append($('<option>').val('-Select-').text('-Select-'));
		$.each(data,function(i,item){
			  $('#cliid').append($('<option>').val(item.CLINICID).text(item.CLINICNAME));
			  });

	});

	});


});

	












 	
		
		
		
		
		
		
		
	 
	 
	 
	 
	 
	 
	 
	 	 
 
 
 
 
 
 