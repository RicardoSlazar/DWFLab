const token=localStorage.getItem("token");


if(!token){

    window.location.href="index.html";

}


function logout(){

    localStorage.removeItem("token");

    window.location.href="index.html";

}

async function api(url,method="GET",body=null){

    try{

        const options={

            method,

            headers:{

                "Content-Type":"application/json",

                Authorization:"Bearer "+token

            }

        };

        if(body){

            options.body=
                JSON.stringify(body);

        }

        const response=
            await fetch(
                url,
                options
            );


        if(response.status===401){

            alert(
                "Sesión expirada"
            );

            logout();

            return;

        }


        if(response.status===403){

            alert(
                "No tienes permisos"
            );

            return;

        }


        if(response.status===204){

            return null;

        }


        const text=
            await response.text();

        return text
            ? JSON.parse(text)
            : null;

    }

    catch(error){

        console.log(error);

        alert(
            "Error de conexión con el servidor"
        );

    }

}

/* ALUMNOS */

async function crearAlumno(){

    const nombre=
        document.getElementById(
            "nombreAlumno"
        ).value.trim();

    const apellido=
        document.getElementById(
            "apellidoAlumno"
        ).value.trim();


    if(!nombre || !apellido){

        alert(
            "Complete todos los campos"
        );

        return;

    }


    await api(

        "http://localhost:8080/alumnos",

        "POST",

        {

            nombre,
            apellido

        }

    );


    alert(
        "Alumno creado correctamente"
    );


    document.getElementById(
        "nombreAlumno"
    ).value="";

    document.getElementById(
        "apellidoAlumno"
    ).value="";


    cargarAlumnos();

}


async function cargarAlumnos(){

    const data=await api(

        "http://localhost:8080/alumnos"

    );


    let html="";


    data.forEach(a=>{

        html+=`

<div class="lista-item">

<div>

<b>${a.id}</b> -
${a.nombre} ${a.apellido}

</div>

<div class="botones">

<button onclick="editarAlumno(${a.id})">

Editar

</button>

<button onclick="eliminarAlumno(${a.id})">

Eliminar

</button>

</div>

</div>

`;

    });


    document.getElementById(
        "alumnos"
    ).innerHTML=html;

}

async function eliminarAlumno(id){

    const confirmar = confirm(
        "¿Está seguro de eliminar este alumno?"
    );

    if(!confirmar){

        return;

    }

    try{

        await api(

            `http://localhost:8080/alumnos/${id}`,

            "DELETE"

        );

        alert(
            "Alumno eliminado correctamente"
        );

        cargarAlumnos();

    }
    catch(error){

        console.log(error);

        alert(
            "Error al eliminar"
        );

    }

}

async function editarAlumno(id){

    const nombre=
        prompt(
            "Nuevo nombre"
        );

    if(nombre===null){

        return;

    }


    const apellido=
        prompt(
            "Nuevo apellido"
        );

    if(apellido===null){

        return;

    }


    await api(

        `http://localhost:8080/alumnos/${id}`,

        "PUT",

        {

            id,
            nombre,
            apellido

        }

    );


    alert(
        "Alumno actualizado correctamente"
    );

    cargarAlumnos();

}

/* PROFESORES */

async function crearProfesor(){

    const nombre=
        document.getElementById(
            "nombreProfesor"
        ).value.trim();


    if(!nombre){

        alert(
            "Ingrese el nombre del profesor"
        );

        return;
    }


    await api(

        "http://localhost:8080/profesores",

        "POST",

        {

            nombre

        }

    );


    alert(
        "Profesor creado correctamente"
    );


    document.getElementById(
        "nombreProfesor"
    ).value="";


    cargarProfesores();

}

async function cargarProfesores(){

    const data=

        await api(

            "http://localhost:8080/profesores"

        );

    let html="";

    data.forEach(p=>{

        html+=`

<div class="lista-item">

<div>

<b>${p.id}</b> -
${p.nombre}

</div>

<div class="botones">

<button onclick="eliminarProfesor(${p.id})">

Eliminar

</button>

</div>

</div>

`;

    });

    document.getElementById(
        "profesores"
    ).innerHTML=html;

}

async function eliminarProfesor(id){

    const confirmar=

        confirm(

            "¿Seguro que deseas eliminar este profesor?"

        );


    if(!confirmar){

        return;

    }


    await api(

        `http://localhost:8080/profesores/${id}`,

        "DELETE"

    );


    alert(
        "Profesor eliminado correctamente"
    );


    cargarProfesores();

}

/* MATERIAS */

async function crearMateria(){

    const nombre=
        document.getElementById(
            "nombreMateria"
        ).value.trim();

    const idProfesor=

        parseInt(

            document.getElementById(
                "idProfesorMateria"
            ).value

        );


    if(!nombre){

        alert(
            "Ingrese el nombre de la materia"
        );

        return;

    }


    if(isNaN(idProfesor)){

        alert(
            "Ingrese un ID de profesor válido"
        );

        return;

    }


    await api(

        "http://localhost:8080/materias",

        "POST",

        {

            nombre,

            idProfesor

        }

    );


    alert(
        "Materia creada correctamente"
    );


    document.getElementById(
        "nombreMateria"
    ).value="";

    document.getElementById(
        "idProfesorMateria"
    ).value="";


    cargarMaterias();

}

async function cargarMaterias(){

    const data=

        await api(

            "http://localhost:8080/materias"

        );

    let html="";

    data.forEach(m=>{

        html+=`

<div class="lista-item">

<div>

<b>${m.id}</b> -
${m.nombre}

</div>

<div class="botones">

<button onclick="eliminarMateria(${m.id})">

Eliminar

</button>

</div>

</div>

`;

    });

    document.getElementById(
        "materias"
    ).innerHTML=html;

}



async function eliminarMateria(id){

    const confirmar=

        confirm(

            "¿Seguro que deseas eliminar esta materia?"

        );


    if(!confirmar){

        return;

    }


    await api(

        `http://localhost:8080/materias/${id}`,

        "DELETE"

    );


    alert(
        "Materia eliminada correctamente"
    );


    cargarMaterias();

}



/* NOTAS */



async function crearNota(){

    const idAlumno=
        parseInt(
            document.getElementById(
                "idAlumnoNota"
            ).value
        );

    const idMateria=
        parseInt(
            document.getElementById(
                "idMateriaNota"
            ).value
        );

    const nota=
        parseFloat(
            document.getElementById(
                "notaAlumno"
            ).value
        );


    if(isNaN(idAlumno)
        || isNaN(idMateria)
        || isNaN(nota)){

        alert(
            "Complete todos los campos"
        );

        return;
    }


    if(nota<0 || nota>10){

        alert(
            "La nota debe estar entre 0 y 10"
        );

        return;

    }


    await api(

        "http://localhost:8080/alumno-materia",

        "POST",

        {

            alumno:{
                id:idAlumno
            },

            materia:{
                id:idMateria
            },

            nota:nota

        }

    );


    alert(
        "Nota registrada correctamente"
    );


    cargarNotas();

}


async function cargarNotas(){

    const data=
        await api(
            "http://localhost:8080/alumno-materia"
        );

    let html="";

    data.forEach(n=>{

        html+=`

        <div class="lista-item">

            <div>

            <b>ID:</b> ${n.id}

            <br>

            <b>Alumno:</b>
            ${n.alumno?.nombre ?? "N/A"}

            <br>

            <b>Materia:</b>
            ${n.materia?.nombre ?? "N/A"}

            <br>

            <b>Nota:</b>
            ${n.nota}

            </div>

        </div>

        `;

    });

    document.getElementById(
        "notas"
    ).innerHTML=html;

}