<%--
  Created by IntelliJ IDEA.
  User: SAYAN MAJUMDAR
  Date: 6/9/2026
  Time: 2:04 PM
--%>

<meta name="layout" content="main">

<div class="card">
    <div class="card-header">
        <g:message code="create" args="['Create']"/>
    </div>
    <div class="card-body">
        <g:form controller="course" action="save">
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="save" value="${g.message(code: "save")}"/>
                <g:link controller="course" action="index" class="btn btn-primary">
                    <g:message code="cancel"/>
                </g:link>
            </div>
        </g:form>
    </div>
</div>