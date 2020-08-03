<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4> List of Customer within 100km</h4>
<table cellspacing="2" cellpadding="2">
<tr><th>User ID</th><th>User Name</th></tr>

  <c:forEach items="${customerList}" var="item">
    <tr>
      <td><c:out value="${item.user_id}" /></td>
      <td><c:out value="${item.name}" /></td>
    </tr>
  </c:forEach>
</table>