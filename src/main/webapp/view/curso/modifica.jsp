<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Modificar Curso">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="modificarCurso" method="post">
        <fieldset>

            <div>
                <label for="codigo">
                    C&oacute;digo:
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8"  autofocus >
            </div>

            <div>
                <label for="nombre">Nombres</label>
                <input type="text" id="nombre" name="nombre" value="${nombre}" maxlength="50" />
            </div>
            <div>
                <label for="descripcion">Descripcion:</label>
                <input type="text" id="descripcion" name="descripcion" value="${descripcion}" maxlength="50" />
            </div>
            <div>
                <label for="objetivo">Objetivos:</label>
                <input type="text" id="objetivo" name="objetivo" value="${objetivos}" maxlength="50" />
            </div>
        
    
            <div>
                <label for="requisito">Requisitos</label>
                <input type="text" id="requisito" name="requisito" value="${requisitos}"  maxlength="400" />
            </div>
            <div>
                <label for="referencia">Referencia</label>
                <input type="text" id="referencia" name="referencia" value="${referencia}" maxlength="400" />
            </div>
        
            
            <div>
                <label for="duracion">
                    Duracion:
                </label>
                <input type="2" name="duracion" id="duracion" value="${duracion}" />
            </div>
            <div>
                <label for="estado">
                    Estado:
                </label>
                <input type="text" name="estado" id="estado" value="${estado}" />
            </div>

        </fieldset>
        <button>Actualizar</button>
    </form>
</gch:base>
