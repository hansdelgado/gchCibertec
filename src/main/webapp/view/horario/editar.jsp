<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<gch:base titulo="Registro de Horarios">
    <div class="informacion">
        <span><s:property value="mensaje" /></span>
    </div>    
     <s:form action="actualizarHorario" method="post">
        <s:push value="horario">  
            <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <s:iterator value="errores">
                    <li><s:property value="value" /></li>
                </s:iterator>
            </ul>
        </div>
        
        <fieldset>
            <legend>Datos</legend>
            <div>               
                <label for="codigo">Codigo</label>
                <s:textfield name="codigo" readonly="true" maxlength="8" />
            </div>
            <div>
                <label for="descripcion">Descripcion</label>
                <s:textfield name="descripcion" required="true" maxlength="50" />
            </div>
            <div>
                <label for="momentoInicio">Hora de Inicio</label>
                <s:textfield name="momentoInicio" maxlength="4" />
            </div>
            <div>
                <label for="momentoFin">Hora de Fin</label>
                <s:textfield name="momentoFin" maxlength="4" />
            </div>
           
            <div>
                <label for="estado">Estado</label>
                <s:textfield name="estado" maxlength="8" />
            </div>
            
        </fieldset>
        <s:submit value="Actualizar" />
        </s:push>
        
    </s:form>
</gch:base>