<%--
  Created by IntelliJ IDEA.
  User: SAYAN MAJUMDAR
  Date: 6/9/2026
  Time: 3:21 PM
--%>

<meta name="layout" content="main">

<div class="card">
    <div class="card-header">
        <g:message code="course" args="['Details of']"/>
    </div>
    <div class="card-body">
        <g:if test="${course}">
            <table class="detail">
                <tr>
                    <th class="text-right"><g:message code="course.name"/></th>
                    <td class="text-left">${course.courseName}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="course.type"/></th>
                    <td class="text-left">${course.courseType}</td>
                </tr>
            </table>
        </g:if>
        <div class="form-action-panel">
            <g:link controller="course" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
        </div>
    </div>
</div>