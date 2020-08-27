<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Document</title>
    <script src="js/bower_components/jquery/dist/jquery.js"></script>
    <script src="js/bower_components/bootstrap/dist/js/bootstrap.js"></script>

    <link rel="stylesheet" href="js/bower_components/bootstrap/dist/css/bootstrap.css">
    <script>
        $(function(){
            $('#btn_add').click(function(e){
                var classNO = $('#classNO').val().trim();
                var className = $('#className').val().trim();
                if(className=='' || classNO==''){
                    $('#msg').text('班级编号、班级名都不能为空。');
                    return false;
                }
                return true;
               
            });
        });


    </script>
</head>

<body>

    <div class="container" style="margin-top: 0px;">

        <div class="row">
            <form action="/addClass" method="POST">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        新增班级
                    </div>
                    <div class="panel-body">

                        <div class="input-group">
                            <div class="input-group-addon">班级编号</div>
                            <input type="text" class="form-control" id="classNO" name="classNO">
                            <div class="input-group-addon">班级名</div>
                            <input type="text" class="form-control" id="className" name="className">
                        </div>

                    </div>
                    <div class="panel-footer">

                        <label id="msg">
<%
                           String msg = (String)request.getAttribute("msg"); 
                           if(null != msg){
                        	   out.print(msg);
                           }
%>
                        </label>
                        <button id="btn_add" type="submit" class="btn btn-info pull-right">添加</button>
                        <br>
                        <br>


                    </div>
                </div>
            </form>
        </div>

        <div class="row">
            
            <div class="panel panel-default">
                  
                  <div class="panel-heading">
                    查询
                  </div>
                  
                  <div class="panel-body">
                    <div class="input-group">
                        <div class="input-group-addon">班级编号</div>
                        <input type="text" class="form-control" id="queryNO" name="classNO">
                        <div class="input-group-addon">班级名</div>
                        <input type="text" class="form-control" id="queryName" name="className">
                        
                        <!-- <div class="input-group"> -->
                            <!-- <input type="text" class="form-control" id="exampleInputAmount" placeholder="Search"> -->
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-info">查询</button>
                            </span>
                        <!-- </div> -->
                        
                    </div>

                    <table class="table table-bordered table-hover text-warning">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>班级编号</th>
                                <th>班级名</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>150102</td>
                                <td>15计算机2班</td>
                            </tr>
                        </tbody>
                    </table>
                  </div>
                  <div class="panel-footer">
                        
                        
                        
                    </div>
            </div>
            
        </div>

    </div>

</body>

</html>