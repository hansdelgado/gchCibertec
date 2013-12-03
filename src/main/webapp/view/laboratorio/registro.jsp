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
                <label for="estado">Activo</label>
                <input type="radio" name="estado" id="activo"  default value="1" />
                <label for="estado">Inactivo</label>
                <input type="radio" name="estado" id="inactivo" value="0" />
            </div>

        </fieldset>

        <button>Registrar</button>
<!--        <button>Modificar</button>
        <button>Eliminar</button>-->

    </form>
</gch:base>

