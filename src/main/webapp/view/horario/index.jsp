<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Horarios">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="buscarHorarios">
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <c:forEach var="error" items="${requestScope.errores}">
                    <li>${error.value}</li>
                </c:forEach>
            </ul>
        </div>
        <fieldset>
            <legend>Datos de búsqueda</legend>
            <div>
                <label for="codigo">
                    Codigo
                </label>
                <input type="text" name="codigo" id="codigo" />
            </div>
            <div>
                <label for="descripcion">
                    Descripción
                </label>
                <input type="text" name="descripcion" id="descripcion" />
            </div>
            <div>
                <label for="estado">
                    Estado
                </label>
                <input type="text" name="estado" id="estado" />
            </div>
        </fieldset>
        <fieldset>
            <div>
                <label for="tipoBusqueda">
                    Tipo Búsqueda
                </label>
                <select name="tipoBusqueda" id="tipoBusqueda">
                    <option value="0">Completa</option>
                    <option value="1">Parcial</option>
                </select>
            </div>
        </fieldset>

        <button><span>Buscar</span></button>
    </form>
    <div>
        <nav>
            <ul>
                <li>
                    <a href="irRegistroHorario">
                        Registrar nuevo horario
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <ul id="resultadoConsulta">
            <li class="cabeceraConsulta">
            <span>Codigo</span>
            <span>Descripcion</span>
            <span>estado</span> 
            <span>Editar</span>
            <span>Eliminar</span>
            </li>
            <c:forEach var="horario" items="${requestScope.horarios}" >
                <li>

                <span>${horario.codigo}</span>
                <span>${horario.descripcion}</span>
                <span>${horario.estado}</span>
                <span align="center">
                    <!--?codigo=${horario.codigo}">-->
                    <a href="editarHorarios?codigo=${horario.codigo}">
                    <img src="images/file_edit.png" alt="Editar partida" width="12" height="12" border="0">
                </a>
                </span>

                <span>
                    
                <a onclick="return confirm('Desea elimar Registro: ??')"
                   href="eliminarHorario?codigo=${horario.codigo}">
                    <img src="images/file_delete.png" alt="Eliminar partida" width="12" height="12" border="0">
                </a>
                </span>
                </li>
            </c:forEach>
        </ul>
    </div>
</gch:base>