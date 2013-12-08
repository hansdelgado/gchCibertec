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
                
    <form action="registrarLaboratorio" method="post">
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8" required autofocus >
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos del Laboratorio</legend>
            <div>
                <label for="nombre">Nombres</label>
                <input type="text" id="nombre" name="nombre" required maxlength="50" />
            </div>
            <div>
                <label for="descripcion">Descripcion</label>
                <input type="text" id="descripcion" name="descripcion" required maxlength="50" />
            </div>
            <div>
                <label for="local">Local</label>
                <input type="text" id="local" name="local" required maxlength="50" />
            </div>
            <div>
                <label for="pabellon">Pabellon</label>
                <input type="text" id="pabellon" name="pabellon" required maxlength="50" />
            </div>
            <div>
                <label for="salon">Salon</label>
                <input type="text" id="salon" name="salon" required maxlength="50" />
            </div>
            <div>
                <label for="capacidad">Capacidad</label>
                <input type="text" id="capacidad" name="capacidad" required maxlength="50" />
            </div>
             <div>
                <span>Estado</span>
                <select name="estado">
                    <option value="1">Implementado</option>
                    <option value="2">Pendiente de Implementacion</option>
                    <option value="3">Con Problemas</option>
                    <option value="4">Deshabilitado</option>
                    <option value="5">No Disponible</option>
                </select>                
            </div>

        </fieldset>

        <button>Registrar</button>
    </form>
</gch:base>

