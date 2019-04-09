<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
            <div>${result}</div>
        </div>
    </header>

    <nav id="menuVertical">
        <ul>
            <li><div class="submenu"><div class="img_n"><img src="img/parser.png"></div></div>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/data?parser=sax&lang=${language}">SAX</a></li>
                    <li><a href="${pageContext.request.contextPath}/data?parser=dom&lang=${language}">DOM</a></li>
                    <li><a href="${pageContext.request.contextPath}/data?parser=stax&lang=${language}">STAX</a></li>
                </ul>
            </li>

            <li><div class="submenu"><div class="img_n"><img src="img/localization.png"></div></div>
                <ul>
                    <li id="en"><a href="${pageContext.request.contextPath}/data?parser=${parser}&lang=en">EN</a></li>
                    <li id="ru"><a href="${pageContext.request.contextPath}/data?parser=${parser}&lang=ru">РУС</a></li>
                    <li id="by"><a href="${pageContext.request.contextPath}/data?parser=${parser}&lang=be">БЕЛ</a></li>
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
          <th>${name}</th>
          <th>${id}</th>
          <th>${operator}</th>
          <th>${payroll}</th>
          <th>${data}</th>
          <th>${internetPrice}</th>
          <th>${mgb}</th>
          <th>${callPrices}</th>
          <th>${tariffing}</th>
          <th>${minute}</th>
          <th>${favNumber}</th>
          <th>${connection}</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="elem" items="${res}" varStatus="status">
            <tr>
                <td><c:out value="${ elem.name }" /></td>
                <td><c:out value="${ elem.idnumber }" /></td>
                <td><c:out value="${ elem.operatorName }" /></td>
                <td><c:out value="${ elem.payroll }" /></td>
                <td>
                    <c:set var="lang" value="${language}"/>
                    <c:if test="${lang == 'en'}">
                    <fmt:formatDate pattern = "MM/dd/yyyy" value = "${ elem.dateType.start }" />-
                    <fmt:formatDate pattern = "MM/dd/yyyy" value = "${ elem.dateType.finish }" />
                    </c:if>
                    <c:if test="${lang != 'en'}">
                    <fmt:formatDate type = "date" value = "${ elem.dateType.start }" />-
                    <fmt:formatDate type = "date" value = "${ elem.dateType.finish }" />
                    </c:if>
                </td>
                <c:if test="${ elem.getClass().getSimpleName() != 'OnlyCalls' }">
                    <td><c:out value="${ elem.internetPrice }" /></td>
                    <td><c:out value="${ elem.freeMgb }" /></td>
                </c:if>
                <c:if test="${ elem.getClass().getSimpleName() == 'OnlyCalls' }">
                    <td>—</td>
                    <td>—</td>
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
                    <td>—</td>
                    <td>—</td>
                    <td>—</td>
                    <td>—</td>
                    <td>—</td>
                </c:if>
            </tr>
        </c:forEach>
      </tbody>
    </table>
    
</body>
</html>