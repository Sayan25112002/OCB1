<%--
  Created by IntelliJ IDEA.
  User: SAYAN MAJUMDAR
  Date: 6/1/2026
  Time: 11:35 AM
--%>

<g:each in="${contactDetails}" var="details">
    <g:render template="form" model="[details:details]"/>
</g:each>
<g:render template="form"/>