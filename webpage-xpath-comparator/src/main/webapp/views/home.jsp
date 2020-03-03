<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="rs.xpath.model.XPathResult"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
  <form action="/compare" method="post">
    <table style="width: 100%">
      <tr>
        <td>Enter URL: <input style="width: 80%" type="text" id="url1" name="url1" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Compare"></td>
      </tr>
    </table>
  </form>
  <table>
    <tr>
      <td>
        <table border="1">
          <thead>
            <tr>
              <th>INPUT XPATH</th>
              <th>OUTPUT XPATH</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${inputXpaths}" var="inputXpath">
              <tr>
                <td><c:out value="${inputXpath}" /></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </td>
    </tr>
  </table>
</body>
</html>