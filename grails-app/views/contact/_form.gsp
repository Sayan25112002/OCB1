<div class="form-group">
    <label><g:message code="contact.name"/></label>
    <g:textField name="name" class="form-control" value="${contact?.name}" placeholder="Please enter Contact Name"/>
    <UIHelper:renderErrorMessage fieldName="name" model="${contact}" errorMessage="Please Enter Contact Name"/>
</div>

<div class="form-group">
    <label><g:message code="image"/></label>
    <g:field name="contactImage" class="form-control" type="file" placeholder="Please Upload Contact Image"/>
    <g:if test="${contact?.image}">
        <img src="${resource(dir:"contact-image", file: "/${contact.id}-${contact.image}")}" class="img-thumbnail" style="margin-top: 10px; height: 100px; width: 100px;"/>
    </g:if>
</div>

<div class="form-group">
    <label><g:message code="contact.group.name"/></label>
    <UIHelper:contactGroup value="${contact?.contactGroups*.id}"/>
</div>
