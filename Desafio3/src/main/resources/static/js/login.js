async function login(){

    const username=
        document.getElementById(
            "username"
        ).value;

    const password=
        document.getElementById(
            "password"
        ).value;


    const data={
        username:username,
        password:password

    };


    try{
        const response=await fetch(
            "http://localhost:8080/api/auth/login",
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
            await response.json();

        if(response.ok){
            localStorage.setItem(
                "token",
                result.token
            );

            document.getElementById(
                "mensaje"
            ).innerHTML=
                "Login correcto";

            window.location.href=
                "dashboard.html";
        }

        else{
            document.getElementById(
                "mensaje"
            ).innerHTML=
                "Usuario o contraseña incorrectos";
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