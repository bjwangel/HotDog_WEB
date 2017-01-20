<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board Main</title>
</head>
<body>



				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${showAll.map.list}"	var="vo" varStatus="status">			
						<tr>
							<td>${map.totalCount - (map.currentPage - 1)*map.listSize - status.index }</td> 
								<td class="left">
									<a href="${pageContext.request.contextPath }/board/view?no=${vo.no }&p=${map.currentPage }&kwd=${map.keyword }">${vo.title }</a>
								</td>
							<td>${vo.userName }</td>
							<td>${vo.hit }</td>
							<td>${vo.regDate }</td>
							<td>
								<c:choose>
									<c:when test="${not empty authUser && authUser.no == vo.userNo }">
										<a href="${pageContext.request.contextPath }/board/delete?no=${vo.no }&p=${map.currentPage }&kwd=${map.keyword }" class="del">삭제</a>
									</c:when>
									<c:otherwise>
										&nbsp;
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</table>

				<a href="${pageContext.request.contextPath }/board/write" id="new-book">글쓰기</a>


</body>
</html>