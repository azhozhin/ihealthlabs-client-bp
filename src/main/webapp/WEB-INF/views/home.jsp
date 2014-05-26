<%--@elvariable id="user" type="com.ihealthlabs.client.bp.beans.User"--%>
<%@ include file="common/header.jsp"%>

<h1>iHealthLabs client</h1>

<c:if test="${empty user.code}">
    You should <a href="/login">Login</a>.
</c:if>
<c:if test="${!empty user.code}">
    <a href="/bp/">Blood Pressure</a>
</c:if>

<%@ include file="common/footer.jsp"%>