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
                
                <s:label value="Codigo" for="codigo" />
                <s:textfield type="search" name="codigo" maxlength="8" />
            </div>
            <div>
                <s:label value="Descripcion" for="descripcion" />
                <s:textfield type="search" name="descripcion" maxlength="50" />
            </div>
            <div>
                <s:label value="Estado" for="estado" />
                <s:textfield type="search" name="estado" maxlength="50" />
            </div>
            <div>
                <label for="tipoBusqueda">
                    Tipo de busqueda
                </label>
                <s:select name="tipoBusqueda"  list="#{'1': 'Parcial', '0':'Completa'}" />
            </div>
        </fieldset>
        <s:submit value="Buscar" />
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
            <span>Eliminar</span>
            <span>Editar</span>
            <span>Codigo</span> 
            <span>Descripcion</span>
            <span>Estado</span>
            </li>
            <s:iterator value="listaHorarios" status="statusItem">
                <li class="${statusItem.odd ? 'impar' : 'par'}">
                    <span>
                        <s:url action="eliminarHorario" var="eliminacion">
                            <s:param name="codigo" value="codigo" />
                        </s:url>
                        <s:a href="%{eliminacion}">X</s:a>
                    </span>
                    <span>
                        <s:url action="irEdicionHorario" var="edicion">                            
                            <s:param name="codigo" value="codigo" />
                        </s:url>
                        <s:a href="%{edicion}">O</s:a>
                    </span>
                    <span><s:property value="codigo" /></span>
                    <span><s:property value="descripcion" /></span>
                    <span><s:property value="estado" /></span>
                </li>
            </s:iterator>
        </ul>
    </div>
</gch:base>