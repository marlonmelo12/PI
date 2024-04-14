import {Link} from "react-router-dom"

import "./NavBar.css"

export default function NavBar() {
    return (
        <nav className="nav-bar">

                <Link to="/">
                    <img src="img" alt="peixe" />
                </Link>

                <ul className="list">
                    <li className="item"><Link to="Login">Login</Link></li>
                    <li className="item"><Link to="registrar">Registrar</Link></li>
                </ul>

        </nav>
    )
}