<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task4</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="icon" href="img/icotab.png">
</head>
<body>
    <header>
        <div class="head">
            <div class="ico"><a href="index.jsp"><img src="img/icohead.png"></a></div>  
        </div>
    </header>
    
    <nav id="menuVertical">
        <ul>
            <li><div class="submenu"><div class="img_n"><img src="img/parser.png"></div></div>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/data?parser=sax&lang=en">SAX</a></li>
                    <li><a href="${pageContext.request.contextPath}/data?parser=dom&lang=en">DOM</a></li>
                    <li><a href="${pageContext.request.contextPath}/data?parser=stax&lang=en">STAX</a></li>
                </ul>
            </li>

            <li><div class="submenu"><div class="img_n"><img src="img/localization.png"></div></div>
                <ul>
                    <li id="en"><a href="${pageContext.request.contextPath}/data?parser=sax&lang=en">EN</a></li>
                    <li id="ru"><a href="${pageContext.request.contextPath}/data?parser=sax&lang=ru">RU</a></li>
                    <li id="by"><a href="${pageContext.request.contextPath}/data?parser=sax&lang=by">BY</a></li>
                </ul>
            </li>

            <li><a href="index.jsp"><div class="img_n"><img src="img/home.png"></div></a></li>
        </ul>
    </nav>
    <div class="menu"><div class="footer">Copyright © 2019<br>
    powered by Anthony</div></div>
    
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>idnumber</th>
          <th>Operator name</th>
          <th>payroll</th>
          <th>data</th>
          <th>internet price</th>
          <th>free mgb</th>
          <th>inside / outside / landline / sms</th>
          <th>tariffing</th>
          <th>free minute</th>
          <th>favorite numbe</th>
          <th>connection fee</th>
        </tr>
      </thead>
    </table>

</body>
</html>