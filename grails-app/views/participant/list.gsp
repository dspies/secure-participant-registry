
<%@ page import="org.chaos.core.Participant" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'participant.label', default: 'Participant')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-participant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-participant" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="firstName" title="${message(code: 'participant.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'participant.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="birthDate" title="${message(code: 'participant.birthDate.label', default: 'Birth Date')}" />
					
						<g:sortableColumn property="patientId" title="${message(code: 'participant.patientId.label', default: 'Patient Id')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'participant.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'participant.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${participantInstanceList}" status="i" var="participantInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${participantInstance.id}">${fieldValue(bean: participantInstance, field: "firstName")}</g:link></td>
					
						<td>${fieldValue(bean: participantInstance, field: "lastName")}</td>
					
						<td><g:formatDate date="${participantInstance.birthDate}" /></td>
					
						<td>${fieldValue(bean: participantInstance, field: "patientId")}</td>
					
						<td><g:formatDate date="${participantInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${participantInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${participantInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
