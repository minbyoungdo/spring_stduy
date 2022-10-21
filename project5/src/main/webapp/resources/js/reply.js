var replyService =(function(){
	function add(reply, callback, error)
	{
		console.log("add reply....");
		$.ajax({
			type:'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr)
			{
				if(callback){callback(result);}
			},
			error : function(xhr, status, er)
			{
				if(error){error(er);}
			}
		})
	}

	return {add: add};
})();

var replyService =(function(){
	function getList(param, callback, error){
	var bno =param.bno;
	var page= param.page || 1;
	
	$.getJSON("/replies/pages/"+bno+"/"+page+".json",
	function(data){
		if(callback){
			callback(data);
		}
	}).fail(function(xhr, status, err){
		if(error)
		{
			error();
		}
	});
}
return {getList:getList};
})();

var replyService =(function(){
function remove(rno, callback, error){
	$.ajax({
		type: 'delete',
		url : '/replies/'+rno,
		success : function(deleteResult, status, xhr){
			if(callback){
				callback(deleteResult);
			}
		},
		error : function(xhr, status, er){
			if(error){
				error(er);
			}
		}
	});
}

return {remove:remove};
})();

var replyService =(function(){
	function update(reply, callback, error){
		$.ajax({
			type : 'put',
			url : '/replies/' +reply.rno,
			data : JSON.stringify(reply),
			contentType :"application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, staus, er){
				if(error){
					error(er);
				}
			}
		});
	}
	return {update : update};
}
)();

var replyService =(function(){
function get(rno, callback, error){
	$.get("/replies/"+rno +".json", function(result){
	if(callback){
		callback(result);
		}
	}).fail(function(xhr, status, err){
		if(error){
			error();
		}
	});
	}
	return {get : get};
}
)();