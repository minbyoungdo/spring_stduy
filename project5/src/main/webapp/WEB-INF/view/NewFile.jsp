<script type="text/javascript" src ="/resources/js/reply.js"></script>
<script>
console.log("===============");
console.log("JS Tset");

var bnoValue='<c:out value="${board.bno}"/>';

//for replyService add test
replyService.add(
		{reply:"JS Test", replyer:"tester",bno:bnoValue},
		function(result)
		{
			alter("RESULT:"+result);
		}
)
</script>