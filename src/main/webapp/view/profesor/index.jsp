<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Profesores">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <s:form action="buscarProfesor">
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <s:iterator value="errores">
                    <li><s:property value="value" /></li>
                </s:iterator>
            </ul>
        </div>
        <fieldset>
            <legend>Datos de B&uacute;squeda</legend>
            
            <div>
                <s:label value="Nombres" for="nombres" />
                <s:textfield type="search" name="nombres" maxlength="50" />
            </div>
            <div>
                <s:label value="Apellido Paterno" for="apellidoPaterno" />
                <s:textfield type="search" name="apellidoPaterno" maxlength="50" />
            </div>
            <div>
                <s:label value="Apellido Materno" for="apellidoMaterno" />
                <s:textfield type="search" name="apellidoMaterno" maxlength="50" />
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
                    <s:a action="irRegistroProfesor">
                        Registrar nuevo profesor
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
                <span>Nombres</span>
                <span>Genero</span>
            </li>
            <s:iterator value="listaProfesores" status="statusItem">
                <li class="${statusItem.odd ? 'impar' : 'par'}">
                    <span>
                        <s:url action="eliminarProfesor" var="eliminacion">
                            <s:param name="codigo" value="codigo" />
                        </s:url>
                        <s:a href="%{eliminacion}">X</s:a>
                    </span>
                    <span>
                        <s:url action="irEdicionProfesor" var="edicion">
                            <s:param name="codigo" value="codigo" />
                        </s:url>
                        <s:a href="%{edicion}">X</s:a>
                    </span>
                    <span><s:property value="codigo" /></span>
                    <span><s:property value="nombres + ' ' + apellidoPaterno" /></span>
                    <span><s:property value="sexo" /></span>
                </li>
            </s:iterator>
        </ul>
    </div>
</gch:base>