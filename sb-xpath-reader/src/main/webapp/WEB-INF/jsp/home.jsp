<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<script type="text/javascript" src="/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
  <form action="/loadurl" method="post" name="loadurlform">
    <div id="myDiv">MyDIV</div>
    <table style="width: 100%">
      <tr>
        <td>Enter URL: <input style="width: 80%" type="text" id="enteredurl" name="enteredurl" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Load URL"></td>
      </tr>
    </table>
  </form>
  <table border="1" style="width: 900px; height: 450px">
    <tr>
      <td><iframe id="myframe" src="${enteredurl}" style="width: 98%; height: 100%"></iframe></td>
    </tr>
  </table>
  <table>
    <tr>
      <td></td>
    </tr>
    <tr>
      <td>XPATH:
        <div id="xpathvalue"></div>
      </td>
    </tr>
    <tr>
      <td></td>
    </tr>
    <tr>
      <td>XPATH IFRAME:
        <div id="xpathvalueiframe"></div>
      </td>
    </tr>
  </table>
</body>
</html>

