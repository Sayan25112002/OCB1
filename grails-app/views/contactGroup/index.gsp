<%--
  Created by IntelliJ IDEA.
  User: SAYAN MAJUMDAR
  Date: 5/30/2026
  Time: 10:20 AM
--%>

<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="contact.group" args="['List of']"/>
        <span class="float-right">
            <div class="btn-group">
                <div class="btn-group">
                    <g:link controller="contactGroup" action="create" class="btn btn-success"><g:message code="create"/> </g:link>
                    <g:link controller="contactGroup" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
                </div>
            </div>
        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="name" title="${g.message(code:"name")}"/>
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${contactGroups}" var="group">
                <tr>
                    <td>${group?.name}</td>
                    <td>
                        <div class="btn-group">
                            <g:link controller="contactGroup" action="details" class="btn btn-primary" id="${group.id}"><i class="fa-solid fa-eye"></i> </g:link>
                            <g:link controller="contactGroup" action="edit" class="btn btn-primary" id="${group.id}"><i class="fas fa-edit"></i> </g:link>
                            <g:link controller="contactGroup" action="delete" class="btn btn-primary delete-confirmation" id="${group.id}"><i class="fas fa-trash"></i></g:link>

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