<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Registro de Horarios">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="registrarHorario" method="post">
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <c:forEach var="error" items="${requestScope.errores}">
                    <li>${error.value}</li>
                </c:forEach>
            </ul>
        </div>
        <fieldset>
            <legend>Datos</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8" required autofocus >
            </div>
            <div>                           
                <label for="descripcion">Descripci&oacute;n</label>
                <input type="text" id="descripcion" name="descripcion" required maxlength="50" />
            </div>
            <div>
                <label for="momentoInicio">Momento de Inicio</label>
                <input type="text" id="momentoInicio" name="momentoInicio" required maxlength="5" />
            </div>
            <div> 
                <label for="momentoFin">Momento Fin</label>
                <input type="text" id="momentoFin" name="momentoFin" required maxlength="5" />
            </div>
            <div>       
                <label for="estado">estado</label>
                <input type="text" id="estado" name="estado" required maxlength="15" />
            </div>
        </fieldset>
        <button>Registrar</button>
    </form>
</gch:base>