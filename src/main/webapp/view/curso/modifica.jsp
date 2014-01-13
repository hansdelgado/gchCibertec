<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Registro de Curso">
    <div class="informacion">
        <span><s:property value="mensaje" /></span>
    </div>
    <form action="actualizarCurso" method="post">
        <s:push value="curso">
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <s:iterator value="errores">
                    <li><s:property value="value" /></li>
                </s:iterator>
            </ul>
        </div>
            
        <fieldset>

            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <s:textfield name="codigo" maxlength="8" readonly="true" />
            </div>

            <div>
                <label for="nombre">Nombres</label>
                <s:textfield name="nombre" required="true" maxlength="50" />
            </div>
            <div>
                <label for="descripcion">Descripcion:</label>
                <s:textfield name="descripcion" required="true" maxlength="50" />
            </div>
            <div>
                <label for="objetivos">Objetivos:</label>
                <s:textfield name="objetivos" maxlength="50" />
            </div>


            <div>
                <label for="requisitos">Requisitos</label>
                <s:textfield name="requisitos" maxlength="50" />
            </div>

            <div>
                <label for="duracion">
                    Duracion:
                </label>
                <s:textfield name="duracion" maxlength="20" />
            </div>
            <div>
                <label for="estado">
                    Estado del Curso
                </label>
                <s:select name="estado" value="estadoCode" list="#{'1':'Activo','2':'Inactivo'}" headerKey="-1" headerValue="Seleccione" />
            </div>

        </fieldset>
        <button>Actualizar</button>
        </s:push>    
    </form>
</gch:base>

