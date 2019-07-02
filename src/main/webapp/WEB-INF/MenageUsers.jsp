<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 30.06.19
  Time: 14:37
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
<body>
<jsp:include page="header.jsp"/>

<div class="table-responsive">
    <h2>Lista Uzytkownikow</h2>
    <div class="float-right">
        <a href="UserAdd">
            <button class="btn btn-sm btn-outline-secondary">
                Dodaj uzytkownika
            </button>
        </a>
    </div>
    <br>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>Nazwa Uzytkownika:</th>
            <th>Email:</th>
            <th>Id Grupy:</th>
            <th>Akcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="exerciseList" items="${userList}">
        <tr>
            <td>
                    ${exerciseList.userName}
            </td>
            <td>
                    ${exerciseList.email}
            </td>
            <td>
                    ${exerciseList.groupId}
            </td>
            <td>
                <form action="UserEdit" method="get">
                    <button class="btn btn-sm btn-outline-secondary" name="userId" value="${exerciseList.id}">
                        Edytuj
                    </button>
                </form>
                <form action="UserDelete" method="get">
                    <button class="btn btn-sm btn-outline-secondary" name="userId" value="${exerciseList.id}">
                        Usun
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