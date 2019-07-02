<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 30.06.19
  Time: 13:03
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
    <h2>Lista Grup</h2>
    <div class="float-right">
        <a href="GroupAdd">
            <button class="btn btn-sm btn-outline-secondary">
                Dodaj grupe
            </button>
        </a>
    </div>
    <br>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>Nazwa Grupy:</th>
            <th>Akcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="groupList" items="${groupList}">
        <tr>
            <td>
                    ${groupList.name}
            </td>
            <td>
                <form action="GroupEdit" method="get">
                    <button class="btn btn-sm btn-outline-secondary" name="GroupId" value="${groupList.id}">
                        Edytuj
                    </button>
                    <input type="hidden" value="${groupList.id}" name="GroupId"/>
                </form>
                <form action="GroupDelete" method="get">
                    <button class="btn btn-sm btn-outline-secondary" name="GroupId" value="${groupList.id}">
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