import axios from "axios";
import { useState, useEffect } from "react";

import { Navigate } from "react-router-dom";

export default function authenticationUser() {
    const [authentication, setAuthentication] = useState(false);


    useEffect(() => {
        const token = localStorage.getItem('token');

        if(token) {
            axios.post("f"). = `${JSON.parse(token)}`;
            setAuthentication(true);
        }
    }, []);
}