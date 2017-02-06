<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Podaj id:<input type="text" id="personId"/>
	<button id="showAccounts">Show Accounts</button>
	<div id="content"></div>
	
	<script type="text/javascript" src="scripts/jquery.js"></script>
	<script type="text/javascript">
		
		var textbox = $('#personId');
		var button = $('#showAccounts');
		var content = $('#content');
		
		button.click(function(){
			
			var id = textbox.val();
			
			$.ajax({
				  url: "rest/people/"+id+"/accounts",
				  method:'GET',
				  success: function( result ) {
						var accounts ='';
					  for(var i= 0; i<result.length;i++){
						  accounts = accounts.concat("<p>");
						  accounts = accounts.concat(result[i].currency);
						  accounts = accounts.concat(" ");
						  accounts = accounts.concat(result[i].asset);
						  accounts = accounts.concat("</p>");
							
						}
					  content.html(accounts);
				  }
				});
			
		});
		
	</script>
</body>
</html>