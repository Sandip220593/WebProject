$(document)
		.ready(
				function() {
					$('#tablediv').hide();
					$('#showButton').click(function() {
						var param = $('#uname').val();
						var actionURL = 'Action';
						var postData = "userName=" + param;
						var jsonRequest = $.ajax({
							type : "POST",
							url : actionURL,
							data : postData,
							dataType : "json",
							success : function(response) {
								console.log(response);
								populateUserDetails(response);
							}
						});
					});

					function customUserDetailTable(){
						var table = $('#userTable').DataTable({
					    	  /*searching: false, paging: false, info: false,	*/  
					    	 /* "createdRow": function( row, data, dataIndex ) {
					    		      $(row).addClass( 'border' );
					    		  },*/
					    		  "bAutoWidth": false,
					              "aaSorting": [],
					              "lengthMenu": [[2, 4, 8],[2,4,8]],
					              "paging":true,
					         		columnDefs: [{
					         		orderable: true,
					      	        targets: [0,1,2,3,4,5]
					      	        
					      			}] 
						});
					}
					
					function populateUserDetails(userDetails) {
						var td, tr;
						$('#userTable').DataTable().destroy();
						$('#userTable tbody').empty();
						for (var i = 0; i < userDetails.length; i++) {
							tr = document.createElement('tr');
							
							td = document.createElement('td');tr.appendChild(td);td.innerHTML=userDetails[i]['col_user_name'];
							td = document.createElement('td');tr.appendChild(td);td.innerHTML=userDetails[i]['col_user_age'];
							td = document.createElement('td');tr.appendChild(td);td.innerHTML=userDetails[i]['col_user_occupation'];
							td = document.createElement('td');tr.appendChild(td);td.innerHTML=userDetails[i]['col_user_address_street'];
							td = document.createElement('td');tr.appendChild(td);td.innerHTML=userDetails[i]['col_user_address_city'];
							td = document.createElement('td');tr.appendChild(td);td.innerHTML=userDetails[i]['col_user_address_pincode'];
							
							$("#userTable").find('tbody').append(tr);
						}
						
						$('#tablediv').show();
						$('#uname').hide();
						$('#showButton').attr('disabled',true);
						customUserDetailTable();
					}
				});