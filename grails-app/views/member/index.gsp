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
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${memberList}" var="info">
                <tr>
                    <td>${info?.firstName+" "+info?.lastName}</td>
                    <td>${info?.email}</td>
                    <td>
                        <div class="btn-group">
                            <g:link controller="member" action="details" class="btn btn-primary" id="${info.id}"><i class="fas fa-eye"></i> </g:link>
                            <g:link controller="member" action="edit" class="btn btn-primary" id="${info.id}"><i class="fas fa-edit"></i> </g:link>
                            <g:link controller="member" action="delete" class="btn btn-primary delete-confirmation" id="${info.id}"><i class="fas fa-trash"></i></g:link>

                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <div class="paginate">
            <g:paginate total="${total?:0}"/>
        </div>
    </div>
</div>