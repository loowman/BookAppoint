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
<form name="firstForm" action="<%= request.getContextPath()%>/books/search" method="post" accept-charset="UTF-8">
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
                <c:forEach items="${requestScope.list}" var="sk">
                    <tr>
                        <td>${sk.id}</td>
                        <td>${sk.name}</td>
                        <td>${sk.num}</td>
                        <td><a class="btn btn-info" href="<%= request.getContextPath()%>/books/${sk.id}/detail " target="_blank">详细</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table> 
        </div>

        
    </div>
</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>