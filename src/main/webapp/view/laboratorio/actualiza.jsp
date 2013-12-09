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

                <input type="text" name="codigo" maxlength="8" value="${laboratorio.codigo}" readonly="true" >
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos del Laboratorio</legend>
            <div>
                <label for="nombre">Nombres</label>
                <input type="text" name="nombre" required maxlength="50" required autofocus  value="${laboratorio.nombre}" />
            </div>
            <div>
                <label for="descripcion">Descripcion</label>
                <input type="text" name="descripcion" required maxlength="50" value="${laboratorio.descripcion}"/>
            </div>
            <div>
                <label for="local">Local</label>
                <input type="text" name="local" required maxlength="50" value="${laboratorio.local}" />
            </div>
            <div>
                <label for="pabellon">Pabellon</label>
                <input type="text" id="pabellon" name="pabellon" required maxlength="50" value="${laboratorio.pabellon}"/>
            </div>
            <div>
                <label for="salon">Salon</label>
                <input type="text" id="salon" name="salon" required maxlength="50" value="${laboratorio.salon}"/>
            </div>
            <div>
                <label for="capacidad">Capacidad</label>
                <input type="text" id="capacidad" name="capacidad" required maxlength="50" value="${laboratorio.capacidad}"/>
            </div>
             <div>
                <label for="estado">Estado</label>
                <select name="estado">
                    <option value="1" <c:if test="${laboratorio.estado == Implementado}">selected</c:if> >Implementado</option>
                    <option value="2" <c:if test="${laboratorio.estado == PendientedeImplementacion}">selected</c:if> >Pendiente de Implementacion</option>
                    <option value="3" <c:if test="${laboratorio.estado == ConProblemas}">selected</c:if> >Con Problemas</option>
                    <option value="4" <c:if test="${laboratorio.estado == Deshabilitado}">selected</c:if> >Deshabilitado</option>
                    <option value="5" <c:if test="${laboratorio.estado == NoDisponible}">selected</c:if> >No Disponible</option>
                </select>
                </div>
            
        </fieldset>

                    <input type="Submit" name="operacion" value="Actualizar" /> <input type="Submit" name="operacion" value="Borrar" />
    </form>
</gch:base>

