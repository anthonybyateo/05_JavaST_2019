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
            <div class="ico"><a href="#"><img src="img/icohead.png"></a></div>  
        </div>
    </header>

    <nav id="menuVertical">
        <ul>
            <li><div class="submenu"><div class="img_n"><img src="img/parser.png"></div></div>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/data">SAX</a></li>
                    <li><a href="${pageContext.request.contextPath}/data">DOM</a></li>
                    <li><a href="${pageContext.request.contextPath}/data">STAX</a></li>
                </ul>
            </li>

            <li><div class="submenu"><div class="img_n"><img src="img/localization.png"></div></div>
                <ul>
                    <li id="en"><a href="${pageContext.request.contextPath}/data?lang=en">${en}</a></li>
                    <li id="ru"><a href="${pageContext.request.contextPath}/data?lang=ru">${ru}</a></li>
                    <li id="by"><a href="${pageContext.request.contextPath}/data?lang=by">${by}</a></li>
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
          <th>Name${name}</th>
          <th>idnumber${id}</th>
          <th>Operator name${operator}</th>
          <th>payroll${payroll}</th>
          <th>data${data}</th>
          <th>internet price${internetPrice}</th>
          <th>free mgb${mgb}</th>
          <th>inside / outside / landline / sms${callPrices}</th>
          <th>tariffing${tariffing}</th>
          <th>free minute${minute}</th>
          <th>favorite number${favNumber}</th>
          <th>connection fee${connection}</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="elem" items="${res}" varStatus="status">
            <tr>
                <td><c:out value="${ elem.name }" /></td>
                <td><c:out value="${ elem.idnumber }" /></td>
                <td><c:out value="${ elem.operatorName }" /></td>
                <td><c:out value="${ elem.payroll }" /></td>
                <td><c:out value="${ elem.dateType.start }" /> - <c:out value="${ elem.dateType.finish }" /></td>
                <c:if test="${ elem.getClass().getSimpleName() != 'OnlyCalls' }">
                    <td><c:out value="${ elem.internetPrice }" /></td>
                    <td><c:out value="${ elem.freeMgb }" /></td>
                </c:if>
                <c:if test="${ elem.getClass().getSimpleName() == 'OnlyCalls' }">
                    <td></td>
                    <td></td>
                </c:if>
                <c:if test="${ elem.getClass().getSimpleName() != 'Internet' }">
                    <td>
                        <c:out value="${ elem.callPrices.inside }" />/
                        <c:out value="${ elem.callPrices.outside }" />/
                        <c:out value="${ elem.callPrices.landline }" />/
                        <c:out value="${ elem.callPrices.sms }" />
                    </td>
                    <td><c:out value="${ elem.tarrifing }" /></td>
                    <td><c:out value="${ elem.freeMinute }" /></td>
                    <td><c:out value="${ elem.parameters.favoriteNumber }" /></td>
                    <td><c:out value="${ elem.parameters.connectionFee }" /></td>
                </c:if>
                <c:if test="${ elem.getClass().getSimpleName() == 'Internet' }">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </c:if>
            </tr>
        </c:forEach>
      </tbody>
    </table>

<!-- <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="js/language.js" type="text/javascript"></script> -->
</body>
</html>