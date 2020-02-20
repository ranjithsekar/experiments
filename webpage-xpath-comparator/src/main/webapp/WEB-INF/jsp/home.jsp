<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
      <td><xmp>${result1}</xmp></td>
    </tr>
    <tr>
      <td>No. of Elements in URL 2: ${url2EleSize}</td>
    </tr>
    <tr>
      <td><xmp>${result2}</xmp></td>
    </tr>
  </table>
</body>
</html>