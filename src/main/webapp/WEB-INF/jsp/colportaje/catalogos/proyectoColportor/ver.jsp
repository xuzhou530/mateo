<%-- 
    Document   : ver
    Created on : Mar 07, 2013, 6:52:45 AM
    Author     : osoto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:message code="proyectoColportor.ver.label" /></title>
    </head>
    <body>
        <jsp:include page="../menu.jsp" >
            <jsp:param name="menu" value="proyectoColportor" />
        </jsp:include>

        <div id="ver-proyectoColportor" class="content scaffold-list" role="main">
            <h1><s:message code="proyectoColportor.ver.label" /></h1>

            <p class="well">
                <a class="btn btn-primary" href="<s:url value='/colportaje/catalogos/proyectoColportor'/>"><i class="icon-list icon-white"></i> <s:message code='proyectoColportor.lista.label' /></a>
                <a class="btn btn-primary" href="<s:url value='/colportaje/catalogos/proyectoColportor/nuevo'/>"><i class="icon-file icon-white"></i> <s:message code='proyectoColportor.nuevo.label' /></a>
            </p>
            <c:if test="${not empty message}">
                <div class="alert alert-block alert-success fade in" role="status">
                    <a class="close" data-dismiss="alert">×</a>
                    <s:message code="${message}" arguments="${messageAttrs}" />
                </div>
            </c:if>

            <c:url var="eliminaUrl" value="/colportaje/catalogos/proyectoColportor/elimina" />
            <form:form commandName="proyectoColportor" action="${eliminaUrl}" >
                <form:errors path="*" cssClass="alert alert-error" element="ul" />
                <div class="row-fluid" style="padding-bottom: 10px;">
                    <div class="span4">
                        <h4><s:message code="codigo.label" /></h4>
                        <h3>${proyectoColportor.codigo}</h3>
                    </div>
                    <div class="span4">
                        <h4><s:message code="nombre.label" /></h4>
                        <h3>${proyectoColportor.nombre}</h3>
                    </div>
                    <div class="span4">
                        <h4><s:message code="descripcion.label" /></h4>
                        <h3>${proyectoColportor.descripcion}</h3>
                    </div>
                    <div class="span4">
                        <h4><s:message code="fechaInicio.label" /></h4>
                        <h3>${proyectoColportor.fechaInicio}</h3>
                    </div>
                    <div class="span4">
                        <h4><s:message code="status.label" /></h4>
                        <h3>${proyectoColportor.status}</h3>
                    </div>
                </div>

                <p class="well">
                    <a href="<c:url value='/colportaje/catalogos/proyectoColportor/edita/${proyectoColportor.id}' />" class="btn btn-primary btn-large"><i class="icon-edit icon-white"></i> <s:message code="editar.button" /></a>
                    <form:hidden path="id" />
                    <button type="submit" name="eliminaBtn" class="btn btn-danger btn-large" id="eliminar"  onclick="return confirm('<s:message code="confirma.elimina.message" />');" ><i class="icon-trash icon-white"></i>&nbsp;<s:message code='eliminar.button'/></button>
                </p>
            </form:form>
        </div>
    </body>
</html>
