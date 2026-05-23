async function registrar(){

    const data={

        username:
        document.getElementById(
            "username"
        ).value,

        password:
        document.getElementById(
            "password"
        ).value,

        firstname:
        document.getElementById(
            "firstname"
        ).value,

        lastname:
        document.getElementById(
            "lastname"
        ).value,

        age:
        document.getElementById(
            "age"
        ).value

    };


    try{

        const response=await fetch(

            "http://localhost:8080/api/auth/register",

            {

                method:"POST",

                headers:{

                    "Content-Type":"application/json"

                },

                body:JSON.stringify(
                    data
                )

            }

        );


        const result=
            await response.text();


        if(response.ok){

            document.getElementById(
                "mensaje"
            ).innerHTML=
                "Usuario creado correctamente";

            setTimeout(()=>{

                window.location.href=
                    "index.html";

            },1500);

        }

        else{

            document.getElementById(
                "mensaje"
            ).innerHTML=
                result;

        }

    }

    catch(error){

        console.log(error);

        document.getElementById(
            "mensaje"
        ).innerHTML=
            "Error de conexión";

    }

}