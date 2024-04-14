
import { useNavigate } from "react-router-dom";
import "./Login.css"
import { useState } from "react";
import axios from "axios";

export default function Login() {

    const [nome, setNome] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    async function login(Event: { preventDefault: () => any; }) {
        Event.preventDefault();
        try {
          await axios.post("http://localhost:8085/auth/login", {
            login: String(nome),
            password: String(password),
            }).then((res) => 
            {
                localStorage.setItem("id", res.data.id)
                localStorage.setItem("token", res.data.token)
             const id = res.data.id;
             const token = res.data.token;
             alert(id);
             alert(token)
             
             
          }, fail => {
           console.error(fail); // Error!
  });
        }
 
         catch (err: any) {
          console.error(err);
          alert(JSON.stringify(err));
        }
      
      }
    return (
        <div>

            <div className="login_principal">

                <div className="login_esquerda">
                    
                    <img src="" alt="peixe" />

                </div>

                <div className="login_direita">

                    <div className="login_form">

                        <form className="form" action="" method="post">

                            <h1>Login</h1>

                            <div className="text_field">
                                <label htmlFor="nome">NickName: </label>
                                <input type="text" name="usuario" id="usuario" placeholder="NickName"  value={nome} onChange={(Event) => {
                                    setNome(Event.target.value)
                                }}/>
                            </div>

                            <div className="text_field">
                                <label htmlFor="senha">Senha: </label>
                                <input type="password" name="senha" id="senha" placeholder="Senha" value={password} onChange={(Event)=>{
                                    setPassword(Event.target.value)
                                }} />
                            </div>

                            <button type="submit" onClick={login} className="btn_login">Login</button>

                            </form>

                    </div>

                </div>

            </div>

        </div>
    )
}