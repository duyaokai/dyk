
$(document).ready(function(){

			/* 获取session信息 */
			 $.ajax({
					type : "POST",
					url :"http://localhost/ShopMall/login/query.im",
					dataType: "json",
					success : function(data) {
						
					 	if(data.code==1002){
							if(data.data==null){
								$("#menu-hd1").html("<a href=\"login.html\" target=\"_top\" class=\"h\">亲，请登录</a> "+
										"<a href=\"register.html\" target=\"_top\">免费注册</a>");							
								return ;
							}
							if(data.data.username!=null){
								$(".menu-hd:first").html("Hi "+data.data.username+
										"<div class=\"menu-hd\"><a href=\"\" onclick = \"clean();\" target=\"_top\">退出</a></div>");
								
								return ;
							}else if(data.data.mobile!=null){
								$(".menu-hd:first").html("Hi "+data.data.mobile+
										"<div class=\"menu-hd\"><a href=\"home.html\" onclick = \"clean();\" target=\"_top\">退出</a></div>");								
								return ;
							}else if(!data.data.email!=null){
								$(".menu-hd:first").html("Hi "+data.data.email+
										"<div class=\"menu-hd\"><a href=\"home.html\" onclick = \"clean();\" target=\"_top\">退出</a></div>");								
								return ;
							}
						}else{
							alert(data.msg);
						} 
						}
					}); 	 
				});		 
			 
			 
			 
			 /*退出*/
			 function clean() {
				 $.ajax({
						type : "POST",
						url :"http://localhost/ShopMall/login/clean.im",
						dataType: "json",
						success : function(data) {
						}
						}); 
			}
			 
			 
			 