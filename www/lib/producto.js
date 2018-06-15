/**
* Creamos el objeto alumno y todos sus métodos.
*/
$.producto={};
// Configuración del HOST y URL del servicio
$.producto.HOST = 'http://localhost:8080';
$.producto.URL = '/rest/producto';


/**
    Esta función hace la llamada REST al servidor y crea la tabla con todos los alumnos.
*/
$.producto.ProductoReadREST = function() {
    // con esta función jQuery hacemos la petición GET que hace el findAll()
    $.ajax({
        url: this.HOST+this.URL,
        type: 'GET',
        dataType: 'json',
        crossDomain: true,
        contentType: 'application/json',
        accept: 'application/json',
        success: function (json) {
            $('#r_alumno').empty();
            $('#r_alumno').append('<h3>Listado de Productos</h3>');
            var table = $('<table />').addClass('table table-stripped');

            table.append($('<thead />').append($('<tr />').append('<th>id</th>', '<th>categoria</th>' )));
            var tbody = $('<tbody />');
           // for (var clave in json) {
           for (var i=0; i<json.length;i++){
                var fila= $('<tr></tr>');
                fila.append( '<td>' + json[i].idProducto + '</td>');
                fila.append( '<td>' + json[i].categoria.nombre + '</td>');
                tbody.append( fila );
                // Testing
                //console.log(json[clave].idProductoº);
                //console.log(json[clave].categoria.nombre);
                console.log(json[i].idProducto)
                console.log(json[i].categoria.nombre)
            }
            table.append(tbody);

            $('#r_alumno').append( $('<div />').append(table) );
            $('tr:odd').css('background','#CCCCCC');
        },
        error: function (xhr, status) {
             $.producto.error('Imposible leer producto','Compruebe su conexión e inténtelo de nuevo más tarde');
        }
    });
};

/**
    Esta función carga los datos del formulario y los envía vía POST al servicio REST
*/
$.producto.AlumnoCreateREST = function(){
    // Leemos los datos del formulario pidiendo a jQuery que nos de el valor de cada input.
    var datos = {
        'nombre' : $("#c_al_nombre").val(),
        'apellido': $("#c_al_apellidos").val()
    };
    
    // comprobamos que en el formulario haya datos...
    if ( datos.nombre.length>2 && datos.apellido.length>2 ) {
        $.ajax({
            url: $.producto.HOST+$.producto.URL,
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            data: JSON.stringify(datos),
            success: function(result,status,jqXHR ) {
               // probamos que se ha actualizado cargando de nuevo la lista -no es necesario-
                $.producto.ProductoReadREST();
            },
            error: function(jqXHR, textStatus, errorThrown){
                $.producto.error('Error: Alumno Create','No ha sido posible crear el alumno. Compruebe su conexión.');
            }
        });
        
        // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
        $.afui.clearHistory();
        // cargamos el panel con id r_alumno.
        $.afui.loadContent("#r_alumno",false,false,"up");
    }
    
};

/**
    Crea un desplegable, un select, con todos los alumnos del servicio para seleccionar el alumno a eliminar
*/
$.producto.AlumnoDeleteREST = function(id){
    // si pasamos el ID directamente llamamos al servicio DELETE
    // si no, pintamos el formulario de selección para borrar.
    if ( id !== undefined ) {
        id = $('#d_al_sel').val();
        $.ajax({
            url: $.producto.HOST+$.producto.URL+'/'+id,
            type: 'DELETE',
            dataType: 'json',
            contentType: "application/json",
            // data: JSON.stringify(datos),
            success: function(result,status,jqXHR ) {
               // probamos que se ha actualizado cargando de nuevo la lista -no es necesario-
                $.producto.ProductoReadREST();
                // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
                $.afui.clearHistory();
                // cargamos el panel con id r_alumno.
                $.afui.loadContent("#r_alumno",false,false,"up");
            },
            error: function(jqXHR, textStatus, errorThrown){
                $.producto.error('Error: Alumno Delete','No ha sido posible borrar el alumno. Compruebe su conexión.');
            }
        });    
    } else{
        $.ajax({
            url: this.HOST+this.URL,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (json) {
                $('#d_alumno').empty();
                var formulario = $('<div />');
                formulario.addClass('container');
                var div_select = $('<div />');
                div_select.addClass('form-group');
                var select = $('<select id="d_al_sel" />');
                select.addClass('form-group');
                for (var clave in json){
                    select.append('<option value="'+json[clave].id+'">'+json[clave].nombre+' ' + json[clave].apellido+'</option>');
                }
                formulario.append(select);
                formulario.append('<div class="form-group"></div>').append('<div class="btn btn-danger" onclick="$.alumno.AlumnoDeleteREST(1)"> eliminar! </div>');
                $('#d_alumno').append(formulario);
            },
            error: function(jqXHR, textStatus, errorThrown){
                $.producto.error('Error: Alumno Delete','No ha sido posible conectar al servidor. Compruebe su conexión.');
            }
        });
    }
    
};

/**
    Función para la gestión de actualizaciones. Hay tres partes: 
    1) Listado 
    2) Formulario para modificación
    3) Envío de datos al servicio REST (PUT)
*/

$.producto.AlumnoUpdateREST = function(id, envio){
    if ( id === undefined ) {
        $.ajax({
            url: this.HOST+this.URL,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function (json) {
                $('#u_alumno').empty();
                $('#u_alumno').append('<h3>Pulse sobre un alumno</h3>');
                var table = $('<table />').addClass('table table-stripped');

                table.append($('<thead />').append($('<tr />').append('<th>id</th>', '<th>nombre</th>', '<th>apellidos</th>')));
                var tbody = $('<tbody />');
                for (var clave in json) {
                    // le damos a cada fila un ID para luego poder recuperar los datos para el formulario en el siguiente paso
                    tbody.append($('<tr id="fila_'+json[clave].id+'" onclick="$.alumno.AlumnoUpdateREST('+json[clave].id+')"/>').append('<td>' + json[clave].id + '</td>',
                    '<td>' + json[clave].nombre + '</td>', '<td>' + json[clave].apellido + '</td>'));
                }
                table.append(tbody);

                $('#u_alumno').append( $('<div />').append(table) );
                $('tr:odd').css('background','#CCCCCC');
            },
            error: function (xhr, status) {
                $.producto.error('Error: Alumno Update','Ha sido imposible conectar al servidor.');
            }
        });
    } else if (envio === undefined ){
        var seleccion = "#fila_"+id+" td";
        var al_id = ($(seleccion))[0];
        var al_nombre = ($(seleccion))[1];
        var al_apellidos = ($(seleccion))[2];
        
        $("#u_al_id").val(al_id.childNodes[0].data);
        $("#u_al_nombre").val(al_nombre.childNodes[0].data);
        $("#u_al_apellidos").val(al_apellidos.childNodes[0].data);
        // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
        $.afui.clearHistory();
        // cargamos el panel con id r_alumno.
        $.afui.loadContent("#uf_alumno",false,false,"up");
    } else {
        //HACEMOS LA LLAMADA REST
            var datos = {
                'id' : $("#u_al_id").val(),
                'nombre' : $("#u_al_nombre").val(),
                'apellido': $("#u_al_apellidos").val()
            };

            // comprobamos que en el formulario haya datos...
            if ( datos.nombre.length>2 && datos.apellido.length>2 ) {
                $.ajax({
                    url: $.producto.HOST+$.producto.URL+'/'+$("#u_al_id").val(),
                    type: 'PUT',
                    dataType: 'json',
                    contentType: "application/json",
                    data: JSON.stringify(datos),
                    success: function(result,status,jqXHR ) {
                       // probamos que se ha actualizado cargando de nuevo la lista -no es necesario-
                        $.producto.ProductoReadREST();
                    },
                    error: function(jqXHR, textStatus, errorThrown){
                        $.producto.error('Error: Alumno Create','No ha sido posible crear el alumno. Compruebe su conexión.');
                    }
                });

                // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
                $.afui.clearHistory();
                // cargamos el panel con id r_alumno.
                $.afui.loadContent("#r_alumno",false,false,"up");
            }
    }
};


/**
    Función para la gestión de errores y mensajes al usuario
*/
$.producto.error = function(title, msg){
    $('#err_alumno').empty();
    $('#err_alumno').append('<h3>'+title+'</h3>');
    $('#err_alumno').append('<p>'+msg+'</p>');
    // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
    $.afui.clearHistory();
    // cargamos el panel con id r_alumno.
    $.afui.loadContent("#err_alumno",false,false,"up");
};

