var $arr = [
			["10%","20%","30%"],
			["30","40","50"]
			];
//숙제 데이터
var basket = [
	{"seq:1":"1", "product":"냉장고", "price":"195000"},
	{"seq:2":"2", "product":"세탁기", "price":"287000"},
	{"seq:3":"10", "product":"에어프라이어", "price":"97000"}
];
		
$(function(){
	$("#btn3").click(function(){			
		$.ajax({
			url : "./ajaxok3.do",
			type: "",
			cache : false,
			dataType:"text",
			contentType:"application/json",
			data:JSON.stringify(arr),
			success:function($result){
				console.log($result);
			},
			error:function(){
				console.log("Error");
			}
		});
		
	});
	
	
	
})