$(document).ready(function(){

	/********************home页面类目******************/
var conent =
		"<div class=\"category-info\">"+
		"<h3 class=\"category-name b-category-name\"><i><img   src=\"../images/cake.png\"></i><a class=\"ml-22\" title=\"点心\">点心/蛋糕</a></h3>"+
		"<em>&gt;</em></div>"+
		"<div class=\"menu-item menu-in top\">"+
			"<div class=\"area-in\">"+
				"<div class=\"area-bg\">"+
					"<div class=\"menu-srot\">"+
						"<div class=\"sort-side\">"+
						"</div>"+
					"</div>"+
				"</div>"+
			"</div>"+
		"</div>"+
		"<b class=\"arrow\"></b>";
	
	var typeFirst = "<li class=\"appliance js_toggle relative first\">"+conent+"</li>";
	
	var typeLast = "<li class=\"appliance js_toggle relative last\">"+conent+"</li>";
	
	
	
	//渲染类目
	$.ajax({
		type : "POST",
		url : $.mallHost+"/goods_type/select.im",
		data :"",
		async : false,
		dataType: "json",
		success : function(obj) {
				if(obj.code==1){
					;
					var types = obj.data;
					//一级类目
					for (var i = 0; i < types.length; i++) {
						/*var host = "http://localhost/ShopMall/"+types[i].picture*/
					/*	alert(types[i].picture);*/
					/*	$("#picture22").attr("src",host);*/
						$(".category-content .category-list").append(typeFirst);
						
						if(i==0){
							
						}else if (i==types.length-1) {
							$(".category-content .category-list li:last").removeClass("first").addClass("last");
						}else {							
							$(".category-content .category-list:last").removeClass("first");
						}						
						$(".category-content .category-list .ml-22:last").html(types[i].type_name).attr("title",types[i].type_name);
						
						//二级类目
						var types2 = types[i].list;
						for (var j = 0; j < types2.length; j++) {
							
							$(".category-content .category-list .sort-side:last").append("<dl class=\"dl-sort\">"+
									"<dt><span title=\""+types2[j].type_name+"\">"+types2[j].type_name+"</span></dt>"+
								"</dl>");
							
							//三级类目
							var types3 = types2[j].list;
							for (var k = 0; k < types3.length; k++) {
								$(".category-content .category-list .dl-sort:last").append("<dd><a title=\""+types3[k].type_name+"\" href=\"#\"><span>"+types3[k].type_name+"</span></a></dd>");
							}
						}
					}
					
				} else {
					alert(data.msg);
				}
			}
		});
	
	/****************************获取服务端登录session信息*********************************/
	
	$.ajax({
		type : "POST",
		url :$.mallHost+"/login/query.im",
		dataType: "json",
		success : function(data) {
			
		 	if(data.code==1002){
				if(data.data==null){
					$("#menu-hd1").html("<a href=\"login.html\" target=\"_top\" class=\"h\">亲，请登录</a> "+
							"<a href=\"register.html\" target=\"_top\">免费注册</a>");
					 $("#m-baseinfo1").hide();
					return ;
				}
				if(data.data.username!=null){
					$(".menu-hd:first").html("Hi "+data.data.username+
							"<div class=\"menu-hd\"><a href=\"\" onclick = \"clean();\" target=\"_top\">退出</a></div>");
					$("#userinfo1").html(data.data.username);
					$("#member-logout2").hide();
					$("#member-login1").show();
					return ;
				}else if(data.data.mobile!=null){
					$(".menu-hd:first").html("Hi "+data.data.mobile+
							"<div class=\"menu-hd\"><a href=\"home.html\" onclick = \"clean();\" target=\"_top\">退出</a></div>");
					$("#userinfo1").html(data.data.mobile);
					$("#member-logout2").hide();
					$("#member-login1").show();
					return ;
				}else if(!data.data.email!=null){
					$(".menu-hd:first").html("Hi "+data.data.email+
							"<div class=\"menu-hd\"><a href=\"home.html\" onclick = \"clean();\" target=\"_top\">退出</a></div>");
					$("#userinfo1").html(data.data.email);
					$("#member-logout2").hide();
					$("#member-login1").show();
					return ;
				}
			}else{
				alert(data.msg);
			} 
			}
		}); 
	
	
	/**********************************************/
	//渲染商品列表
	$.ajax({
		type : "POST",
		url : $.mallHost+"/goods/select.im",
		data : "",
		dataType: "json",
		success : function(data) {
				if(data.code==1){
					if(data.data==null){
						
					} else {
						
						$.each(data.data, function (index, obj) {
							$("#good"+(index+1)+" .title").html(obj.good_name);
							$("#good"+(index+1)+" .sub-title").html(obj.promotion_price/100);
							$("#good"+(index+1)+" img").attr("src","http://localhost/ShopMall/"+obj.pic_url);
							$("#good"+(index+1)+" a").attr("href","http://localhost/ShopMall/home/introduction.html?goodId="+obj.id);
						});
						
					}
					
				} else {
					alert(data.msg);
				}
			}
		}
	);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});



//退出
function clean() {
	 $.ajax({
			type : "POST",
			url :$.mallHost+"/login/clean.im",
			dataType: "json",
			success : function(data) {
			}
			}); 
}










				