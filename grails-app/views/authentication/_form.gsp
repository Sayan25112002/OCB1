<div class="form-group">
    <label>*<g:message code="first.name"/></label>
    <g:textField name="firstName" class="form-control" value="${member?.firstName}" placeholder="Please enter First Name" required="required"/>
    <UIHelper:renderErrorMessage fieldName="firstName" model="${member}" errorMessage="Please Enter First Name"/>
</div>

<div class="form-group">
    <label><g:message code="middle.name"/></label>
    <g:textField name="firstName" class="form-control" value="${member?.middleName}" placeholder="Please enter Middle Name"/>
</div>

<div class="form-group">
    <label>*<g:message code="last.name"/></label>
    <g:textField name="lastName" class="form-control" value="${member?.lastName?:''}" placeholder="Please enter Last Name" required="required"/>
    <UIHelper:renderErrorMessage fieldName="firstName" model="${member}" errorMessage="Please Enter Last Name"/>
</div>

<div class="form-group">
    <label>*<g:message code="email.address"/></label>
    <g:textField name="email" class="form-control" value="${member?.email}" placeholder="Please enter Email Address" required="required"/>
    <UIHelper:renderErrorMessage fieldName="email" model="${member}" errorMessage="Please Enter Email Address/Email Address Already Exists"/>
</div>

<g:if test="${!edit}">
    <div class="form-group">
        <label>*<g:message code="password"/></label>
        <g:passwordField name="password" class="form-control" value="${member?.password}" placeholder="Please Enter Password(Password must have atleast 1 upper case letter, atleast 1 lower case letter, atleast 1 digit, atleast 1 special character and atleast total 8 characters)" required="required"/>
        <UIHelper:renderErrorMessage fieldName="password" model="${member}" errorMessage="Please Enter Password/Password is not Valid(Password must have atleast 1 upper case letter, atleast 1 lower case letter, atleast 1 digit, atleast 1 special character and atleast total 8 characters)"/>
    </div>
</g:if>