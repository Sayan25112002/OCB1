<%--
  Created by IntelliJ IDEA.
  User: SAYAN MAJUMDAR
  Date: 5/26/2026
  Time: 6:16 PM
--%>

<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="member" args="['List of']"/>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="firstName" title="${g.message(code:"name")}"/>
                <g:sortableColumn property="firstName" title="${g.message(code:"email")}"/>
            </tr>
            </thead>
            <tbody>
            <g:each in="${memberList}" var="info">
                <tr>
                    <td>${info?.firstName+" "+info?.lastName}</td>
                    <td>${info?.email}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>