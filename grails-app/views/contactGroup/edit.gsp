<%--
  Created by IntelliJ IDEA.
  User: SAYAN MAJUMDAR
  Date: 5/30/2026
  Time: 10:15 AM
--%>

<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="contact.group" args="['Update']"/>
    </div>
    <div class="card-body">
        <g:form controller="contactGroup" action="update">
            <g:hiddenField name="id" value="${contactGroup.id}"/>
            <g:render template="form" model="[edit:'yes']"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="update" value="${g.message(code:"update")}"/>
                <g:link controller="contactGroup" action="index" class="btn btn-primary">
                    <g:message code="cancel"/>
                </g:link>
            </div>
        </g:form>
    </div>
</div>