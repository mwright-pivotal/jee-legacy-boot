<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <h1><spring:message code="contact.create" /></h1>
    <a href="<spring:url value="/" />"><spring:message code="contact.list" /></a>
    <form:form method="POST" action="/contact_create.html" modelAttribute="contact">
        <form:errors path="" element="div" />
        <div>
            <form:label path="contactId"><spring:message code="contact.contactId" /></form:label>
            <form:input path="contactId" />
            <form:errors path="contactId" />
        </div>
        <div>
            <form:label path="firstName"><spring:message code="contact.firstName" /></form:label>
            <form:input path="firstName" />
            <form:errors path="firstName" />
        </div>
        <div>
            <form:label path="lastName"><spring:message code="contact.lastName" /></form:label>
            <form:input path="lastName" />
            <form:errors path="lastName" />
        </div>
        <div>
            <input type="submit" />
        </div>
    </form:form>
</body>
</html>