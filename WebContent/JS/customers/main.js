
function addCustomer(){
	var fName=$('#addFName').val();
	var lName=$('#addLName').val();
	var email=$('#addEmail').val();
	var phone=$('#addPhone').val();
	var address=$('#addAddress').val();
	
	if (fName=="" || lName=="" || email=="" || phone=="" ||  address==""){
		alert("Please fill all requried information");
	}else{
		$.ajax({
			url: "addCustomer.html",
			type:'GET',
			data:{fName:fName, lName:lName, email:email, phone:phone, address:address},
			success:function(result){
						$('#results').html(result);
					}
		});
	}
}
