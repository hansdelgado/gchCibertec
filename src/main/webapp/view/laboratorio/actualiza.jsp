<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<gch:base titulo="Registro de Laboratorio">

    <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <c:forEach var="error" items="${requestScope.errores}">
                    <li>${error.value}</li>
                </c:forEach>
            </ul>
     </div>  
                
    <form action="actualizarLaboratorio" method="post"  >
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" name="codigo" maxlength="8" required autofocus  value="${laboratorio.codigo}" >
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos del Laboratorio</legend>
            <div>
                <label for="nombre">Nombres</label>
                <input type="text" name="nombre" required maxlength="50" value="${laboratorio.nombre}" />
            </div>
            <div>
                <label for="descripcion">Descripcion</label>
                <input type="text" name="descripcion" required maxlength="50" value="${laboratorio.descripcion}"/>
            </div>
            <div>
                <label for="local">Local</label>
                <input type="text" name="local" required maxlength="50" value="${laboratorio.local}" />
            </div>
            

        </fieldset>

                    <input type="Submit" name="operacion" value="Actualizar" />
                    <input type="Submit" name="operacion" value="Borrar" />

    </form>
</gch:base>

