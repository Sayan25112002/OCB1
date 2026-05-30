<%--
  Created by IntelliJ IDEA.
  User: SAYAN MAJUMDAR
  Date: 5/30/2026
  Time: 10:11 AM
--%>

<meta name="layout" content="main">

<div class="card">
    <div class="card-header">
        <g:message code="contact.group" args="{'Details of'}"/>
    </div>
    <div class="card-body">
        <g:if test="${contactGroup}">
            <table class="detail">
                <tr>
                    <th class="text-right"><g:message code="name"/></th>
                    <td class="text-left">${contactGroup.name}</td>
                </tr>
            </table>
        </g:if>
        <div class="form-action-panel">
            <g:link controller="contactGroup" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
        </div>
    </div>
</div>