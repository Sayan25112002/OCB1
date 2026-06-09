<%--
  Created by IntelliJ IDEA.
  User: SAYAN MAJUMDAR
  Date: 6/9/2026
  Time: 2:13 PM
--%>

<meta name="layout" content="main">

<div class="card">
    <div class="card-header">
        <g:message code="course" args="['Update']"/>
    </div>
    <div class="card-body">
        <g:form controller="course" action="update">
            <g:hiddenField name="id" value="${course.id}"/>
            <g:render template="form" model="[edit:'yes']"/>
                <div class="form-action-panel">
                    <g:submitButton class="btn btn-primary" name="update" value="${g.message(code: "update")}"/>
                    <g:link controller="course" action="index">
                        <g:message code="cancel"/>
                    </g:link>
                </div>
        </g:form>
    </div>
</div>

