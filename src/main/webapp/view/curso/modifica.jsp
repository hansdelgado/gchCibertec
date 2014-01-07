<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<<<<<<< HEAD
<gch:base titulo="Modificar Curso">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="modificarCurso" method="post">
=======
<gch:base titulo="Registro de Curso">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="registrarCurso" method="post">
>>>>>>> origin/master
        <fieldset>

            <div>
                <label for="codigo">
                    C&oacute;digo:
                </label>
<<<<<<< HEAD
                <input type="text" id="codigo" name="codigo" value="${codigo}" maxlength="8"  autofocus >
=======
                <input type="text" id="codigo" name="codigo" maxlength="8"  autofocus >
>>>>>>> origin/master
            </div>

            <div>
                <label for="nombre">Nombres</label>
<<<<<<< HEAD
                <input type="text" id="nombre" name="nombre" value="${nombre}" maxlength="50" />
            </div>
            <div>
                <label for="descripcion">Descripcion:</label>
                <input type="text" id="descripcion" name="descripcion" value="${descripcion}" maxlength="50" />
            </div>
            <div>
                <label for="objetivo">Objetivos:</label>
                <input type="text" id="objetivo" name="objetivo" value="${objetivos}" maxlength="50" />
=======
                <input type="text" id="nombre" name="nombre" value="${curso.nombre}" maxlength="50" />
            </div>
            <div>
                <label for="descripcion">Descripcion:</label>
                <input type="text" id="descripcion" name="descripcion" value="${curso.descripcion}" maxlength="50" />
            </div>
            <div>
                <label for="objetivo">Objetivos:</label>
                <input type="text" id="objetivo" name="objetivo" value="${curso.objetivos}" maxlength="50" />
>>>>>>> origin/master
            </div>
        
    
            <div>
                <label for="requisito">Requisitos</label>
<<<<<<< HEAD
                <input type="text" id="requisito" name="requisito" value="${requisitos}"  maxlength="400" />
            </div>
            <div>
                <label for="referencia">Referencia</label>
                <input type="text" id="referencia" name="referencia" value="${referencia}" maxlength="400" />
=======
                <input type="text" id="requisito" name="requisito" value="${curso.requisitos}"  maxlength="400" />
            </div>
            <div>
                <label for="referencia">Referencia</label>
                <input type="text" id="referencia" name="referencia" value="${curso.referencia}" maxlength="400" />
>>>>>>> origin/master
            </div>
        
            
            <div>
                <label for="duracion">
                    Duracion:
                </label>
<<<<<<< HEAD
                <input type="2" name="duracion" id="duracion" value="${duracion}" />
=======
                <input type="2" name="duracion" id="duracion" value="${curso.duracion}" />
>>>>>>> origin/master
            </div>
            <div>
                <label for="estado">
                    Estado:
                </label>
<<<<<<< HEAD
                <input type="text" name="estado" id="estado" value="${estado}" />
=======
                <input type="text" name="estado" id="estado" value="${curso.estado}" />
>>>>>>> origin/master
            </div>

        </fieldset>
        <button>Actualizar</button>
    </form>
</gch:base>
