<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
  <form action="/loadurl" method="post" name="loadurlform">
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
      <td><iframe src="${enteredurl}" style="width: 98%; height: 100%"></iframe></td>
    </tr>
  </table>
  <table>
    <tr>
      <td>XPATH</td>
    </tr>
    <tr>
      <td><label>xpath here </label></td>
    </tr>
  </table>
</body>
</html>