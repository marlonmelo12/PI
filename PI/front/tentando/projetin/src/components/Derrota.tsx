import axios from 'axios';
import react from 'react'
import { useState } from 'react'
import { IUser } from '../interface/IUser';

const [user, setUser] = useState();

function FindUser() {
    axios.get("http://localhost:8085/")
}

export default function Derrota() {
    return (
        <div className='main'>
            <div className='mirror'>

                <h1>VOCE PERDEU QUE PENA</h1>
            </div>
        </div>
    )
}