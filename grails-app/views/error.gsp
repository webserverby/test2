<!doctype html>
<html>
    <head>
        <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
        <meta name="layout" content="main">
        <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>

        <li>An error has occurred</li>
        <li>Exception: ${exception}</li>
        e  </li>
        <ul class="dropdown-menu">
            <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
            <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
            <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
            </g:else>
            </g:if>
    <ul class="errors">
        <li>An error has occurred</li>
        <li>Exception: ${ex
        <g:if env="development">
            <g:if test="${Throwable.isInstance(exception)}">

        <g:else>
    est="${request.getAttribute('javax.servlet.error.exception')}">
    <g:renderException exception="${request.getAttribute('javax.servlet.error.exception')}" />
    </
                <li>An error has occurred</li>
            </ul>
        </g:else>
    </body>
</html>
