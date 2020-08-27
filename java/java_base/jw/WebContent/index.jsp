<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe="false" errorPage="error.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>教务管理系统-管理员登录</title>
	<script src="js/bower_components/jquery/dist/jquery.js"></script>
	<script src="js/bower_components/bootstrap/dist/js/bootstrap.js"></script>

	<link rel="stylesheet" href="js/bower_components/bootstrap/dist/css/bootstrap.css">
</head>

<body>
<%--     <%! int a = 90; %> --%>
<%--     <% int b = 900; %> --%>
   
<%--    <jsp:include page="error.jsp"></jsp:include> --%>
	<div class="container  " style="margin-top:200px;">

		<div class="row col-xs-12 col-sm-12 col-md-6 col-lg-6 col-md-offset-3 col-lg-offset-3  " >

			<form action="/login" method="POST">

				<div class="panel panel-primary " >


					<div class="panel-heading">
						登录:
					</div>
					<div class="panel-body">

						<div class="input-group">
							<div class="input-group-addon">登录名</div>
							<input type="text" class="form-control" id="exampleInputAmount" placeholder="" name="loginName">
						</div>

						<div class="input-group" style="margin-top: 20px;">
							<div class="input-group-addon">密码</div>
							<input type="text" class="form-control" id="exampleInputAmount" placeholder="" name="pwd">
<!-- 							<span class="input-group-btn"> -->
<!-- 								<button type="submit" class="btn btn-primary">登录</button> -->
<!-- 							</span> -->
						</div>

					</div>
					<div class="panel-footer">
						<label id="msg">
						<% String msg = (String)request.getAttribute("msg");
						   if(null!=msg){
							   out.print(msg);
						   }
						%>
						 ${msg}</label>
						
                        
                        <button type="submit" class="btn btn-danger  pull-right">登录</button>
                        <br>
                       <br>
					</div>
				</div>



			</form>



		</div>

	</div>


</body>

</html>