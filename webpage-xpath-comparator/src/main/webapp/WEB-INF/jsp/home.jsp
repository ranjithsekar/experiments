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
        <td>Elements to Compare: <select name="element" id="element"><option>input</option>
            <option>label</option></select></td>
      </tr>
      <tr>
        <td>Enter URL 1: <input style="width: 80%" type="text" id="url1" name="url1" /></td>
      </tr>
      <tr>
        <td>Enter URL 2: <input style="width: 80%" type="text" id="url2" name="url2" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Compare"></td>
      </tr>
    </table>
  </form>
  <table>

    <tr>
      <td>No. of Elements in URL 1: ${url1EleSize}</td>
    </tr>
    <tr>
      <td>No. of Elements in URL 2: ${url2EleSize}</td>
    </tr>
    <tr>
      <td>&nbsp;</xmp></td>
    </tr>
    <tr>
      <td>&nbsp;</xmp></td>
    </tr>
    <tr>
      <td>PAGE 1</xmp></td>
    </tr>
    <tr>
      <td>
        <table border="1">
          <thead>
            <tr>
              <th>Element</th>
              <th>XPATH</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${result1}" var="result">
              <tr>
                <td><c:out value="${result.element}" /></td>
                <td><c:out value="${result.xpath}" /></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </td>
    </tr>
    <tr>
      <td>&nbsp;</xmp></td>
    </tr>
    <tr>
      <td>&nbsp;</xmp></td>
    </tr>
    <tr>
      <td>PAGE 2</xmp></td>
    </tr>
    <tr>
      <td>
        <table border="1">
          <thead>
            <tr>
              <th>Element</th>
              <th>XPATH</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${result2}" var="result">
              <tr>
                <td><c:out value="${result.element}" /></td>
                <td><c:out value="${result.xpath}" /></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </td>
    </tr>
  </table>
</body>
</html>