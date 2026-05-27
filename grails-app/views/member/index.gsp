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
        <span class="float-right">
            <div class="btn-group">
                <g:form controller="member" action="index" method="GET">
                    <div class="input-group" id="search-area">
                        <g:select name="colName" class="form-control" from="[firstName:'First Name', lastName:'Last Name', email:'Email']" value="${params?.colName}" optionKey="key" optionValue="value"/>
                        <g:textField name="colValue" class="form-control" value="${params?.colValue}"/>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit">Search</button>
                        </span>
                    </div>
                </g:form>
            </div>
            <div class="btn-group">
                <g:link controller="member" action="create" class="btn btn-success"><g:message code="create"/> </g:link>
                <g:link controller="member" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
            </div>
        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="firstName" title="${g.message(code:"name")}"/>
                <g:sortableColumn property="email" title="${g.message(code:"email")}"/>
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
                            <g:link controller="member" action="details" class="btn btn-primary" id="${info.id}"><i class="fa-solid fa-eye"></i> </g:link>
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