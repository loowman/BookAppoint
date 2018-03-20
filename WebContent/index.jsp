<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/views/common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>图书列表</title>
   <%@include file="/WEB-INF/views/common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>图书列表</h2>
        </div>
<form name="firstForm" action="books/search" method="post" accept-charset="UTF-8">
        	<div class="panel-heading ">
        	    <table class="table table-bookName">
        	       <thead>
        	       		<tr> 
        					<th width="90" align="left">图书名称：</th>
        					<th width="150" align="left">
        						<input type="text" name="name" class="allInput" value="${name}" placeholder="输入检索书名" />
        					</th>
        					<th> 
        						<input type="submit" id="tabSub" value="检索" /> 
        					</th> 
        				</tr> 
        	       </thead> 
        	    </table> 
         	</div>
        </form>
       
        
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>图书ID</th>
                    <th>图书名称</th>
                    <th>馆藏数量</th> 
                    <th>详细</th>
                </tr>
                </thead>
                <tbody>
                <%-- <c:forEach items="${requestScope.list}" var="sk">
                    <tr>
                        <td>${sk.bookId}</td>
                        <td>${sk.name}</td>
                        <td>${sk.number}</td>
                        <td><a class="btn btn-info" href="<%= request.getContextPath()%>/books/${sk.bookId}/detail " target="_blank">详细</a></td>
                    </tr>
                </c:forEach> --%>
                </tbody>
            </table> 
        </div>
                <div class="panel-body text-center">
            	<h2 class="text-danger">  
            		<!--用来展示预约控件-->
            		<span class="glyphicon" id="appoint-box"></span> <!--在js里面调用这个id还可以动态显示一些其他东西，例如动态时间等（需要插件）-->
            		 
            		<span class="glyphicon"><a class="btn btn-primary btn-lg" href="/books/appoint?studentId=${cookie['studentId'].value}" target="_blank">查看我的已预约书籍</a></span>
            	</h2>           <!--如何获取该页面弹出层输入的学生ID， 传给上面的url-->
        	</div>
        
    </div>
</div>
<div id="varifyModal" class="modal fade"> 
    <div class="modal-dialog"> 
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-studentId"> </span>请输入学号和密码:
                </h3>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="studentId" id="studentIdKey"
                               placeholder="填写学号^o^" class="form-control">
                    </div>
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="password" name="password" id="passwordKey"
                               placeholder="输入密码^o^" class="form-control">
                    </div>
                </div>
            </div>

            <div class="modal-footer">
               		<!--  验证信息 -->
                <span id="studentMessage" class="glyphicon"> </span>
                <button type="button" id="studentBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-student"></span>
                    Submit
                </button>
            </div>
        </div>
    </div> 
</div>  



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script  src="scripts/index.js"></script>


</body>
</html>