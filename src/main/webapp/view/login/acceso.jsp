<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<h1>
    <s:text name="gch.app.iniciar.sesion"/>
</h1>

<div class="informacion" style="margin-bottom: 7px">
    <s:property value="mensaje" />
    <s:fielderror/>
</div>
<div>
    <s:form namespace="/login" action="ingresar" method="post">
        <fieldset>
            <div>
                <s:label key="gch.login.usuario" />
                <s:textfield name="usuario" />
            </div>
            <div>
                <s:label key="gch.login.clave" />
                <s:textfield name="clave" />
            </div>
        </fieldset>
        <div class="comandos">
            <input type="submit" value="IniciarSesi&oacute;n"  />
        </div>
    </s:form>  
</div>


