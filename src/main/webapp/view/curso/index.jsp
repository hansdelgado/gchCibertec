<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Cursos">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
<form action="buscarCurso">
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
                <label for="codigo">
                    Codigo
                </label>
                <s:textfield type="search" name="codigo" maxlength="50" />
            </div>
             <div>
                <label for="nombre">
                    Nombre
                </label>
                <s:textfield type="search" name="nombre" maxlength="50" />
            </div>
             <div>
                <label for="descripcion">
                    Descripción
                </label>
                <s:textfield type="search" name="descripcion" maxlength="50" />
            </div>
            
            <div>
                <label for="tipoBusqueda">
                    Tipo Busqueda
                </label>
                <s:select name="tipoBusqueda"  list="#{'1': 'Parcial', '0':'Completa'}" />
            </div> 
        </fieldset>
        <s:submit value="Buscar" />    
    </form>
    <div>
        <nav>
            <ul>
                <li>
                    <s:a action="irRegistroCurso">
                        Registrar nuevo curso
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
                <span>Nombre</span>
                <span>Descripcion</span>
            </li>
            <s:iterator value="listaCursos" status="statusItem">
                <li class="${statusItem.odd ? 'impar' : 'par'}">
                    <span>
                        <s:url action="eliminarCurso" var="eliminacion">
                            <s:param name="codigo" value="codigo" />
                        </s:url>
                        <s:a href="%{eliminacion}">X</s:a>
                    </span>
                    <span>
                        <s:url action="irEdicionCurso" var="edicion">
                            <s:param name="codigo" value="codigo" />
                        </s:url>
                        <s:a href="%{edicion}">X</s:a>
                    </span>
                    <span><s:property value="codigo" /></span>
                    <span><s:property value="nombre" /></span>
                    <span><s:property value="descripcion" /></span>
                </li>
            </s:iterator>                
                
                
                
        </ul>
    </div>
</gch:base>