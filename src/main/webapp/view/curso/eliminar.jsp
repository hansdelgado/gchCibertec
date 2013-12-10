<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Registro de Curso">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="eliminarCurso" method="post">
        <fieldset>

            <div>
                <label for="codigo">
                    Ingrese C&oacute;digo a eliminar:
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8"  autofocus >
            </div>

            <div>
                <label for="nombre">Nombres</label>
                <input type="text" id="nombre" name="nombre"  maxlength="50" />
            </div>
            <div>
                <label for="descripcion">Descripcion:</label>
                <input type="text" id="descripcion" name="descripcion"  maxlength="50" />
            </div>
            <div>
                <label for="objetivo">Objetivos:</label>
                <input type="text" id="objetivo" name="objetivo" maxlength="50" />
            </div>
        
    
            <div>
                <label for="requisito">Requisitos</label>
                <input type="text" id="requisito" name="requisito"  maxlength="400" />
            </div>
            <div>
                <label for="referencia">Referencia</label>
                <input type="text" id="referencia" name="referencia" maxlength="400" />
            </div>
        
            
            <div>
                <label for="duracion">
                    Duracion:
                </label>
                <input type="2" name="duracion" id="duracion"  />
            </div>
            <div>
                <label for="estado">
                    Estado:
                </label>
                <input type="text" name="estado" id="estado"  />
            </div>

        </fieldset>
        <button>Eliminar</button>
    </form>
</gch:base>