<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="/external/bootstrap_v_4_5_0/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="row">
			<table class="table table-bordered my-auto">
				<thead>
					<th scope="col">Id:</th>
					<th scope="col">Ime:</th>
					<th scope="col">Prezime:</th>
					<th scope="col">Username:</th>
					<th scope="col">Pol:</th>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td scope="row">${user.getId()}</td>
							<td>${user.getFirstName()}</td>
							<td>${user.getLastName()}</td>
							<td>${user.getUsername()}</td>
							<td>${user.getGender()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="col-12 flex-row" style="display: flex;flex-direction: row;">
				<div class="col-8">&nbsp;</div>
				<div class="col-4">
					
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:choose>
								<c:when test="${page>1}">
							    	<li class="page-item"><a class="page-link" href="/users/paginate/${page-1}">Previous</a></li>	
								</c:when>
								<c:when test="${page<=1}">
							    	<li class="page-item disabled"><a class="page-link" href="/users/paginate/${page}">Previous</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="/users/paginate/${page}">Previous</a></li>
								</c:otherwise>
							</c:choose>

							<c:if test="${(page-2)>0}">
								<li class="page-item"><a class="page-link" href="/users/paginate/${page-2}">${page-2}</a></li>
							</c:if>
							<c:if test="${(page-1)>0}">
							    <li class="page-item"><a class="page-link" href="/users/paginate/${page-1}">${page-1}</a></li>
							</c:if>

							<li class="page-item active"><a class="page-link" href="/users/paginate/${page}">${page}</a></li>

							<c:if test="${(page+1)<maxPageNum}">
								<li class="page-item"><a class="page-link" href="/users/paginate/${page+1}">${page+1}</a></li>
							</c:if>
							<c:if test="${(page+2)>maxPageNum}">
								<li class="page-item"><a class="page-link" href="/users/paginate/${page+2}">${page+2}</a></li>
							</c:if>

							<c:choose>
								<c:when test="${page<maxPageNum}">
									<li class="page-item"><a class="page-link" href="/users/paginate/${page+1}">Next</a></li>
								</c:when>
								<c:when test="${page==maxPageNum}">
									<li class="page-item"><a class="page-link" href="/users/paginate/${maxPageNum}">Next</a></li>
								</c:when>
							</c:choose>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="/external/jquery.min.js"></script>
	<script type="text/javascript" src="/external/bootstrap_v_4_5_0/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/index.js"></script>
</body>
</html>