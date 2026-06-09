<%--
  Created by IntelliJ IDEA.
  User: SAYAN MAJUMDAR
  Date: 6/9/2026
  Time: 2:53 PM
--%>

<meta name="layout" content="main">

<div class="card">
    <div class="card-header">
        <g:message code="course" args="['List of']"/>
        <span class="float-right">
            <div class="btn-group">
                <div class="btn-group">
                    <g:link controller="course" action="create" class="btn btn-success"><g:message code="create"/> </g:link>
                    <g:link controller="course" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
                </div>
            </div>
        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <g:sortableColumn property="courseName" title="${g.message(code:"course.name")}"/>
                    <g:sortableColumn property="courseType" title="${g.message(code:"course.type")}"/>
                    <th class="action-row"><g:message code="action"/> </th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${courses}" var="info">
                    <tr>
                        <td>${info?.courseName}</td>
                        <td>${info?.courseType}</td>
                        <td>
                            <div class="btn-group">
                                <g:link controller="course" action="details" class="btn btn-primary" id="${info.id}"><i class="fas fa-eye"></i></g:link>
                                <g:link controller="course" action="edit" class="btn btn-primary" id="${info.id}"><i class="fas fa-edit"></i></g:link>
                                <g:link controller="course" action="delete" class="btn btn-danger delete-confirmation" id="${info.id}"><i class="fas fa-trash"></i></g:link>
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