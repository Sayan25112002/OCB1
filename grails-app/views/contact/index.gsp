<%--
  Created by IntelliJ IDEA.
  User: SAYAN MAJUMDAR
  Date: 5/30/2026
  Time: 10:20 AM
--%>

<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="contact" args="['List of']"/>
        <span class="float-right">
            <div class="btn-group">
                <div class="btn-group">
                    <g:link controller="contact" action="create" class="btn btn-success"><g:message code="create"/> </g:link>
                    <g:link controller="contact" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
                </div>
            </div>
        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="image" title="${g.message(code:"image")}"/>
                <g:sortableColumn property="name" title="${g.message(code:"name")}"/>
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${contacts}" var="info">
                <tr>
                    <td>
                        <g:if test="${info.image}">
                            <img src="${resource(dir: "contact-image",file: "/${info.id}-${info.image}")}" class="img-thumbnail" style="height: 50px; width: 50px;"/>
                        </g:if>
                        <g:else>
                            <g:img dir="images" file="grails.svg" class="img-thumbnail" style="height: 50px; width: 50px;"/>
                        </g:else>
                    </td>
                    <td>${info?.name}</td>
                    <td>
                        <div class="btn-group">
                            <g:link controller="contact" action="details" class="btn btn-primary" id="${info.id}"><i class="fa-solid fa-eye"></i> </g:link>
                            <g:link controller="contact" action="edit" class="btn btn-primary" id="${info.id}"><i class="fas fa-edit"></i> </g:link>
                            <g:link controller="contact" action="delete" class="btn btn-primary delete-confirmation" id="${info.id}"><i class="fas fa-trash"></i></g:link>

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