<meta name="layout" content="public"/>
<div id="global-wrapper">
    <div id="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-6 mx-auto">
                    <h1 class="text-center login-title">Online Contact Book Login Form</h1>
                    <div class="account-wall">
                        <g:img dir="images" file="OnlineContactBook.png" class="profile-img"/>
                        <g:form controller="authentication" action="doLogin" class="form-signin">
                            <g:textField name="email" class="form-control" placeholder="Email Address" required="required"/>
                            <g:passwordField name="password" class="form-control" placeholder="Password" required="required"/>
                            <g:submitButton name="login" class="btn btn-lg btn-primary btn-block" value="Login"/>
                            <g:link controller="authentication" action="registration" class="btn btn-lg btn-primary btn-block">Member Registration</g:link>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>