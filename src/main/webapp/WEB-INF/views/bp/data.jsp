<%@ include file="../common/header.jsp"%>
<h1>Blood Pressure data</h1>

<c:if test="${!empty user.allBPData}">

<table>
    <tr>
        <td>DateTime</td>
        <td>BPL</td>
        <td>HR</td>
        <td>HP</td>
        <td>LP</td>
        <td>Note</td>
    </tr>
    <%--@elvariable id="user" type="com.ihealthlabs.client.bp.beans.User"--%>
    <c:forEach var="item" items="${user.allBPData}">
        <tr>
            <td>${item.measurementDate}</td>
            <td>${item.bpl}</td>
            <td>${item.hr}</td>
            <td>${item.hp}</td>
            <td>${item.lp}</td>
            <td>${item.note}</td>
        </tr>
    </c:forEach>
</table>
</c:if>

<%@ include file="../common/footer.jsp"%>