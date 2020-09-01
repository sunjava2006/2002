<%@ page language="java" contentType="text/html; charset=UTF-8" 
    import="java.util.List,com.thzhima.jw.beans.Class,java.net.URLEncoder"
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

        function modify(btn){
            var tr = $(btn).parents('tr').children('td').each(function(i){
                console.log(i);
               
                if(i==0){
                    var id = $(this).text();
                    $('#mid').val(id);
                }
                else if(i==1){
                    var classNO = $(this).text();
                    $('#mclassNO').val(classNO);
                }
                else if(i==2){
                    var className = $(this).text();
                    $('#mclassName').val(className);
                }
                
            });

            $('#modifyPop').modal('show');
           
        }

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
            
            <div class="panel panel-info">
                  
                  <div class="panel-heading">
                    查询
                  </div>
                  <form action="/queryClass" method="GET">
                  <div class="panel-body">
                    <div class="input-group">
                      
                        <div class="input-group-addon">班级编号</div>
                        <input type="text" class="form-control" id="queryNO" name="classNO" placeholder="%：表示多个任意字符，_：一个任意字符">
                        <div class="input-group-addon">班级名</div>
                        <input type="text" class="form-control" id="queryName" name="className" placeholder="%：表示多个任意字符，_：一个任意字符">
                        
                       
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-info">查询</button>
                            </span>
                      
                        
                    </div>
                   </form>
<%
      Object o = request.getAttribute("list");
	  if(o != null){
		  List<Class> li = (List<Class>)o;
%>		
		 <table class="table table-bordered table-hover text-warning">
         <thead>
             <tr>
                 <th>id</th>
                 <th>班级编号</th>
                 <th>班级名</th>
                 <th style="width:130px;"></th>
             </tr>
         </thead>
         <tbody>
<%for(Class c : li){ %>         
             <tr style="line-height:51px">
                 <td><%=c.getId() %></td>
                 <td><%=c.getClassNO() %></td>
                 <td><%=c.getClassName() %></td>
                 <td>
                    <button type="button" class="btn btn-info" onclick="modify(this)">修改</button>
                    <a href="/delClass?id=<%=c.getId() %>" class="btn btn-warning">删除</a>
                 </td>
             </tr>
             
<% }%>             
         </tbody>
     </table>
		
		
<%		
		
	}

%>
                   
                  </div>
                  <div class="panel-footer">
                        
<%
      Integer totalRecord = (Integer)request.getAttribute("totalRecord");
      if(totalRecord!=null){
    	  out.print("总记录数："+totalRecord+",");
      }
      Integer totalPage = (Integer)request.getAttribute("totalPage");
      if(totalPage!=null){
    	  out.print("共"+totalPage+"页,");
      }
      Integer currentPage = (Integer)request.getAttribute("currentPage");
      if(currentPage!=null){
    	  out.print("当前为第"+currentPage+"页.");
      }
      
      String classNO = request.getParameter("classNO");
      String className = request.getParameter("className");
      if(classNO!=null && !"".equals(classNO)){
    	  classNO = classNO.replaceAll("%", "%25");
      }
      if(className!=null && !"".equals(className)){
    	  className = className.replaceAll("%","%25");
    	  
      }
     
%>
<%
     if(totalRecord!=null && currentPage>1){
     String href =  "/queryClass?classNO="+classNO+"&className="+className+"&currPage="+(currentPage-1); 
     //href = URLEncoder.encode(href);
%>
<a href=<%=href %> class="btn btn-info">上一页</a>
<%    	 
     }
     if(totalRecord!=null && currentPage<totalPage){
    	 String href =  "/queryClass?classNO="+classNO+"&className="+className+"&currPage="+(currentPage+1); 
         //href = URLEncoder.encode(href);
         
%>  
<a href=<%=href %> class="btn btn-info">下一页</a>
<%  	 
     }
%>
      
                        
                        
                    </div>
            </div>
            
        </div>

    </div>

 <form action="/modifyClass" method="POST">
        <input type="hidden" name="id" id="mid">
        <div class="modal fade"  id="modifyPop" role="dialog" tabindex="-1"><!-- 按ESC消除对话框，要设置tabindex属性 -->
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal" aria-hidden="true">&times;</a>
                        <h4> 班级信息修改</h4>
                    </div>
                    <div class="modal-body">
    
                        <div class="input-group">
                                    <div class="input-group-addon">班级编号</div>
                                    <input type="text" class="form-control" id="mclassNO" name="classNO">
                                    <div class="input-group-addon">班级名</div>
                                    <input type="text" class="form-control" id="mclassName" name="className">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button"  class="btn btn-danger" data-dismiss="modal" value="保存" onclick="document.forms[2].submit()">保存</button>
                    </div>
                </div>
            </div>
        </div>
    
    </form>



</body>

</html>