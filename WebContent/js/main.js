$(function(){
	$.ajax({
        type: 'POST',
        async:false,
        url: 'allCardController0',
        success: function (data, status) {
        		},
        error:function(req,ques){
        	alert("系统出现错误！");
        	
        }
    })
    
})