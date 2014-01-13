<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<gch:base titulo="Edicion Laboratorio">
    <div class="informacion">
        <span><s:property value="mensaje" /></span>
    </div>                
    <s:form action="actualizarLaboratorio" method="post"  >
        <s:push value="laboratorio">
       <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <s:iterator value="errores">
                    <li><s:property value="value"/></li>
                </s:iterator>
            </ul>
        </div> 
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <s:textfield name="codigo" maxlength="8" readonly="true" >
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos del Laboratorio</legend>
            <div>
                <label for="nombre">Nombres</label>
                <s:textfield name="nombre" maxlength="50" required="true" />
            </div>
            <div>
                <label for="descripcion">Descripcion</label>
                <s:textfield name="descripcion" maxlength="50" required="true"/>
            </div>
            <div>
                <label for="local">Local</label>
                <s:textfield name="local" required="true" maxlength="50" />
            </div>
            <div>
                <label for="pabellon">Pabellon</label>
                <s:textfield name="pabellon" required="true" maxlength="50"/>
            </div>
            <div>
                <label for="salon">Salon</label>
                <s:textfield name="salon" required="true" maxlength="50"  readonly="true"/>
            </div>
            <div>
                <label for="capacidad">Capacidad</label>
                <s:textfield name="capacidad" required="true" maxlength="50"/>
            </div>
             <div>
                <label for="estado">Estado</label>
                <s:select name="estado" value="estadoCode"
                          list="#{'1':"Implementado",'2':"Pendiente Implementacion",'3':'Con Problemas','4':'Deshabilitado','5':'No Disponible'}"
                          headerKey="-1" headerValue="Seleccione"/>
                </div>
        </fieldset>
                <s:submit value="Actualizar"/>
        </s:push>
    </s:form>
</gch:base>

