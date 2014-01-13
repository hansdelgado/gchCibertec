<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Laboratorios">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <s:form action="buscarLaboratorio">
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <s:iterator value="errores">
                    <li><s:property value="value"/></li>
                </s:iterator>
            </ul>
        </div> 
        <fieldset>
                <legend>Datos de B&uacute;squeda</legend>
            
            <div>
                <s:label value="Nombre" for="nombre"/>
                <s:textfield type="search" name="nombre" maxlength="50"/>
            </div>
            <div>
                <s:label value="local" for="local"/>
                <s:textfield type="search" name="local" maxLength="50"/>
            </div>
            <div>
                <label for="tipoBusqueda">Tipo de busqueda</label>
                <s:select name="tipoBusqueda" list="#{'1':'Parcial','0':'Completa'}"/>
            </div>
        </fieldset>
                <s:submit value="Buscar"/>
    </s:form>
    <div>
        <nav>
            <ul>
                <li>
                    <s:a href="irRegistroLaboratorio">
                        Registrar nuevo laboratorio
                    </s:a>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <strong>Laboratorios registrados</strong>
        <ul id="resultadoConsulta">
            <li class="cabeceraConsulta">
                <span>Eliminar</span>
                <span>Editar</span>
                <span>Codigo</span>
                <span>Nombre</span>
                <span>Descripcion</span>
                <span>Local</span>
                <span>Pabellon</span>
                <span>Salon</span>
                <span>Capacidad</span>
                <span>Estado</span>
            </li>
            <s:iterator value="listaLaboratorios" status="statusItem">
                <li class="${statusItem.odd ? 'impar':'par'}">
                    <span>
                        <s:url action="eliminarLaboratorio" var="eliminacion">
                            <s:param name="codigo" value="codigo"/>
                        </s:url>
                        <s:a href="%{eliminacion}">X</s:a>
                    </span>
                    <span>
                    <s:url action="irEdicionLaboratorio" var="edicion">
                        <s:param name="codigo" value="codigo"/>
                    </s:url>
                    <s:a href="%{edicion}">E</s:a>
                    </span
                    <span><s:property value="codigo" /></span>
                    <span><s:property value="nombre"/></span>
                    <span><s:property value="descripcion"/></span>
                    <span><s:property value="local"/></span>
                    <span><s:property value="pabellon"/></span>
                    <span><s:property value="salon"/></span>
                    <span><s:property value="capacidad"/></span>
                    <span><s:property value="estado"/></span>
                </li>
            </s:iterator>
        </ul>
    </div>
</gch:base>