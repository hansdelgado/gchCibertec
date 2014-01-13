<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Registro de Curso">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="registrarCurso" method="post">
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <c:forEach var="error" items="${requestScope.errores}">
                    <li>${error.value}</li>
                </c:forEach>
            </ul>
        </div>

        <fieldset>

            <div>
                <label for="codigo">
                    C&oacute;digo:
                </label>
                <input type="text" id="codigo" name="codigo" required maxlength="8"  autofocus >
            </div>

            <div>
                <label for="nombre">Nombres</label>
                <input type="text" id="nombre" name="nombre" required maxlength="50" />
            </div>
            <div>
                <label for="descripcion">Descripcion:</label>
                <input type="text" id="descripcion" name="descripcion" required maxlength="50" />
            </div>
            <div>
                <label for="objetivos">Objetivos:</label>
                <input type="text" id="objetivos" name="objetivos" maxlength="50" />
            </div>
        
    
            <div>
                <label for="requisitos">Requisitos</label>
                <input type="text" id="requisitos" name="requisitos"  maxlength="400" />
            </div>
            
            <div>
                <label for="duracion">
                    Duracion:
                </label>
                <input type="text" id="duracion" name="duracion" required maxlength="50"  />
            </div>
        </fieldset>
        <button>Registrar</button>
    </form>
</gch:base>
