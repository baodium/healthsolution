<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
	<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script src="js/jquery.autocomplete.js"></script>  
	<style>
		input {
			font-size: 120%;
		}
	</style>
</head>
<body>
	
	<h3>Country</h3>
	<input type="text" id="country" name="country"/>
	
	<script>
		$("#country").autocomplete("getdata.jsp");
	</script>
</body>
</html>