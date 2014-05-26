<%--@elvariable id="error" type="com.ihealthlabs.client.bp.entity.Error"--%>
<%@ include file="common/header.jsp"%>
errorCode: ${error.errorCode}
error: ${error.error}<br>
errorDescription: ${error.errorDescription}
<%@ include file="common/footer.jsp"%>