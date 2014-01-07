<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Edici&oacute;n de Profesor">
    <div class="informacion">
        <span><s:property value="mensaje" /></span>
    </div>
    <s:form action="actualizarProfesor" method="post">
        <s:push value="profesor">
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <s:iterator value="errores">
                    <li><s:property value="value" /></li>
                </s:iterator>
            </ul>
        </div>
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <s:textfield name="codigo" maxlength="8" readonly="true" />
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos Personales</legend>
            <div>
                <label for="nombres">Nombres</label>
                <s:textfield name="nombres" required="true" maxlength="50" />
            </div>
            <div>
                <label for="apellidoPaterno">Apellido Paterno</label>
                <s:textfield name="apellidoPaterno" required="true" maxlength="50" />
            </div>
            <div>
                <label for="apellidoMaterno">Apellido Materno</label>
                <s:textfield name="apellidoMaterno" maxlength="50" />
            </div>
        </fieldset>
        <fieldset>
            <legend>Direcci&oacute;n</legend>
            <div>
                <label for="direccion">Direcci&oacute;n Completa</label>
                <s:textarea name="direccion" maxlength="400" />
            </div>
            <div>
                <label for="referencia">Referencia</label>
                <s:textarea name="referencia" maxlength="400" />
            </div>
        </fieldset>
        <fieldset>
            <legend>Detalle</legend>
            <div>
                <label for="fechaNacimiento">
                    Fecha de Nacimiento
                </label>
                <s:textfield name="fechaNacimiento" required="true" />
            </div>
            <div class="multiopciones">
                <span>Sexo</span>
                <s:radio list="#{'m':'Masculino', 'f':'Femenimo'}" name="sexo"/>
            </div>
            <div>
                <label for="estado">
                    Estado del Profesor
                </label>
                <s:select name="estado" value="estadoCode" list="#{'1':'Activo','2':'Inactivo','3':'No Determinado','4':'Vacaciones'}" headerKey="-1" headerValue="Seleccione" />
            </div>
        </fieldset>
        <s:submit value="Actualizar" />
        </s:push>
    </s:form>
</gch:base>