import { useState, useEffect } from "react"
import "./Game.css"
import Button from "../inputs/Button";
import axios from 'axios';
//import pexe from '../img/pexe.png'





export default function Game() {

     function getU() {

         axios.post("http://localhost:8085/user/searchUser", {
             Headers: {
                 'Authorization': `token ${localStorage.getItem("token")}`
        },
        id: localStorage.getItem("id"),
    }).then((res) => {
        setUsuario(res);
    })
}

    

    const [usuario, setUsuario] = useState({});
    const [questão, setQuestao] = useState([]);
    const [rodadas, setRodadas] = useState(0);
    const [acerta, setAcertas] = useState(0);
    const [parar, setParar] = useState(0);
    const [errar, setErrar] = useState(0);
    const [ganhou, setGanhou] = useState(0);
    const [jogo, jogoSet] = useState(0)
    const [fim, setFim] = useState(false);

    function estatisticas() {
        switch (rodadas) {

            case 0: 
            setAcertas(1000);
            break;

            case 1: 
            setAcertas(5000);
            setGanhou(1000);
            setParar(1000);
            setErrar(1000);
            break;

            case 2: 
            setAcertas(50000);
            setGanhou(1000);
            setParar(5000);
            setErrar(1000);
            break;

            case 3: 
            setAcertas(100000);
            setGanhou(1000);
            setParar(5000);
            setErrar(1000);
            break;

            case 4: 
            setAcertas(300000);
            setGanhou(1000);
            setParar(1000);
            setErrar(1000);
            break;

            case 5: 
            setAcertas(500000);
            setGanhou(1000);
            setParar(1000);
            setErrar(1000);
            break;

            case 6: 
            setAcertas(1000000);
            setGanhou(1000);
            setParar(1000);
            setErrar(1000);
            break;
            
        }
    }
    
    async function carregarUsers() {
        const {data} = await axios.get(`http://localhost/8085/Users/${id}`)
        setUsuario(data);
    }

    return (
        <div className="jogo">
            <div className="logo">
                
            </div>

            <div className="pergunta">
                <p>E uma pergunta</p>
            </div>

            <div className="respostas">
                <p>perrere</p>
            </div>
        </div>
    )
}