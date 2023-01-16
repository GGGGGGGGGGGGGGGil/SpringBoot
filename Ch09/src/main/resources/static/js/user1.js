/**
 * 
 */

$(document).ready(function(){
	
	// user1 목록 요청1
	$('.user1_list1').click(function(){
		
		$.ajax({
			'url': '/Ch09/user1',
			'method': 'GET',
			'datatype': 'json',
			'success' : function(data){
				console.log(data);
			}
		});
	});
	
	// user1 목록 요청2
	$('.user1_list2').click(function(){
		
		$.ajax({
			'url': '/Ch09/user1/r101',
			'method': 'GET',
			'datatype': 'json',
			'success' : function(data){
				console.log(data);
			}
		});
	});	
	
	// user1 등록 요청
	$('.user1_register').click(function(){
		// user1 목록 요청
		$('.user1_register').click(function(){
			
			let jsonData = {
					"uid":"r101",	
					"name":"홍길동",	
					"hp":"010-1111-2222",	
					"age":"50"	
			};
			
			$.ajax({
				url: '/Ch09/user1',
				method: 'POST',
				data: jsonData,
				datatype: 'json',
				success : function(data){
					console.log(data);
				}
			});
		});	
	});				
	// user1 수정 요청
	$('.user1_modify').click(function(){
		
		let jsonData = {
				"uid":"r101",	
				"name":"홍길동",	
				"hp":"010-9999-4444",	
				"age":"27"	
		};
		
		$.ajax({
			url: '/Ch09/user1',
			method: 'PUT',
			data: jsonData,
			datatype: 'json',
			success : function(data){
				console.log(data);
			}
		});
	});
		
	// user1 삭제 요청
	$('.user1_delete').click(function(){
		
		$.ajax({
			url: '/Ch09/user1/r101',
			method: 'DELETE',
			datatype: 'json',
			success : function(data){
				console.log(data);
			}
		});
	});				
});