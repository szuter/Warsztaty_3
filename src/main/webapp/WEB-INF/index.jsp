<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 25.05.19
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body class="d-flex flex-column h-100">
<jsp:include page="header.jsp"/>


<div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>Tytuł zadania:</th>
            <th>Uzytkownik:</th>
            <th>Utwozono:</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="solutionList" items="${listOfSolutions}">
        <tr>
            <td><c:forEach var="exerciseList" items="${listOfExercises}">
                <c:if test="${solutionList.exercise_id == exerciseList.id}">
                    <c:out value="${exerciseList.title}"></c:out>
                </c:if>
            </c:forEach></td>
            <td><c:forEach var="exerciseList" items="${listOfUsers}">
                <c:if test="${solutionList.user_id == exerciseList.id}">
                    <c:out value="${exerciseList.userName}"></c:out>
                </c:if>
            </c:forEach></td>
            <td> ${solutionList.created}</td>
            <td>
                <form action="ExerciseInfo" method="get">
                    <button class="btn btn-sm btn-outline-secondary" name="SolutionId" value="${solutionList.id}">
                        Info
                    </button>
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
