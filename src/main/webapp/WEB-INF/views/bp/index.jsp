<%@ include file="../common/header.jsp"%>
<h1>Blood Pressure index</h1>

<c:if test="${!empty user.code}">
    You <c:if test="${!empty user.allBPData}">can <a href="/bp/data">view data</a></c:if>
    <c:if test="${empty user.allBPData}">should <a href="/bp/load">load data</a></c:if>
</c:if>

<%@ include file="../common/footer.jsp"%>