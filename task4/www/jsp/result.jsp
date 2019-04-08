<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task4</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="icon" href="../img/icotab.png">
</head>
<body>
    <header>
        <div class="head">
            <div class="ico"><a href="#"><img src="../img/icohead.png"></a></div>
        </div>
    </header>

    <s:url var="indexEN" namespace="/" action="locale" >
        <s:param name="request_locale" >en</s:param>
    </s:url>

    <nav id="menuVertical">
        <ul>
            <li><a href="#"><div class="img_n"><img src="../img/parser.png"></div></a>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/data">SAX</a></li>
                    <li><a href="${pageContext.request.contextPath}/data">DOM</a></li>
                    <li><a href="${pageContext.request.contextPath}/data">STAX</a></li>
                </ul>
            </li>

            <li><a href="#"><div class="img_n"><img src="../img/localization.png"></div></a>
                <ul>
                    <li id="en"><a href="#">${en}</a></li>
                    <li id="ru"><a href="${pageContext.request.contextPath}/data">${ru}</a></li>
                    <li id="by"><a href="${pageContext.request.contextPath}/data">${by}</a></li>
                </ul>
            </li>

            <li><a href="#"><div class="img_n"><img src="../img/home.png"></div></a></li>
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
          <th>favorite number</th>
          <th>connection fee</th>
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

    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="js/language.js" type="text/javascript"></script>
</body>
</html>