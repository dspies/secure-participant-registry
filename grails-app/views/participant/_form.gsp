<%@ page import="org.chaos.core.Participant" %>



<div class="fieldcontain ${hasErrors(bean: participantInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="participant.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" maxlength="35" required="" value="${participantInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: participantInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="participant.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" maxlength="35" required="" value="${participantInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: participantInstance, field: 'birthDate', 'error')} ">
	<label for="birthDate">
		<g:message code="participant.birthDate.label" default="Birth Date" />
		
	</label>
	<g:datePicker name="birthDate" precision="day"  value="${participantInstance?.birthDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: participantInstance, field: 'patientId', 'error')} ">
	<label for="patientId">
		<g:message code="participant.patientId.label" default="Patient Id" />
		
	</label>
	<g:field name="patientId" type="number" value="${participantInstance.patientId}"/>
</div>

