$(document).ready(function() 
{
	statelist();
});

function statelist() {
	
//	alert("Hi this is states");
//	var firstName = $("#FN").val();
//	var lastName = $("#LN").val();
//	var rollno = $("#RN").val();
//	alert("Hi" + firstName+" "+lastName+" "+rollno);
//	
	$.ajax({
		  type: "GET",
		  url: "states.jsp",
		  data: {
		  
		  },
		  beforeSend: function() {
		        // setting a timeo
		    },
		  success: function(response) {
//			$("#dummyTable").hide();
	  		$('#state1').html(response);
			},
	       error: function(){
	       	alert('Error while request..');
	      }
		});
}