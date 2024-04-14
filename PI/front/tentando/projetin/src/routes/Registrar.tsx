import { useState } from "react";
import { UsuarioData } from "../interface/UsuarioData";
import "./Registrar.css"
import axios from "axios";



export default function Registrar() {

    const [usuario, setUsuario] = useState("");
    const [nick, setnick] = useState("");
    const [password, setPassword] = useState("");

    async function save(event: { preventDefault: () => void; }) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:8085/auth/register", {
          name: String(nick),
          login: String(usuario),
          password: String(password),
          });
          alert("REGISTRADO");
        } catch (err : any) {
          alert(JSON.stringify(err))
        }
      }

   /* const { mutate } = EnviarLogin();

    const submit = () => {
        const usuarioData: UsuarioData = {
            
            nome: "",
            nickname:  "",
            senha: ""
        }
        mutate(usuarioData)
    }*/



    return (
        <div className="login_principal">

            <div className="login_esquerda">
                
                <img src="" alt="peixe" />

            </div>

            <div className="login_direita">

                <div className="login_form">

                    <form className="form" action="" method="post">

                        <h1>Registrar-se</h1>

                        <div className="text_field">
                            <label htmlFor="nome">Nome: </label>
                            <input value={usuario} type="text" name="usuario" id="usuario" placeholder="NickName" onChange={(Event)=>{
                                setUsuario(Event.target.value)
                            }}/>
                        </div>

                        
                        <div className="text_field">
                            <label htmlFor="nome">NickName: </label>
                            <input type="text" name="usuario" id="usuario" placeholder="NickName" value={nick} onChange={(Event) => {
                                setnick(Event.target.value)
                            }}/>
                        </div>

                        <div className="text_field">
                            <label htmlFor="nome">Senha: </label>
                            <input type="password" name="senha" id="senha" placeholder="Senha" value={password} onChange={(Event) => {
                                setPassword(Event.target.value);
                            }}/>
                        </div>

                        <button onClick={save} className="btn_login">Registrar-se</button>

                        </form>

                </div>

            </div>

        </div>
    )
}