<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<gch:base titulo="Listado de Horarios">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <s:form action="buscarHorarios">
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <s:iterator value="errores">
                    <li><s:property value="value" /></li>
                </s:iterator>
            </ul>
        </div>
        <fieldset>
            <legend>Datos de búsqueda</legend>
            <div>
                <s:label value="Descripcion" for="descripcion"/>
                <s:textfield type="search" name="descripcion" maxlength="50" />                
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
    </s:form>
    <div>
        <nav>
            <ul>
                <li>
                    
                    <s:a href="irRegistroHorario">
                        Registrar nuevo horario
                    </s:a>
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
                    <a href="irHorarioEditar?codigo=${horario.codigo}">
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