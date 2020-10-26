import React from 'react';
import { Link } from 'react-router-dom';

export default function Menu() {
    return (
        <React.Fragment>
            <ul className="clearfix">
                <li>
                    <Link className="link" to="/vagas">Vagas</Link>
                </li>
                <li>
                    <Link className="link" to="/candidatos">Candidatos</Link>
                </li>
                <li>
                    {/* <Link onClick={this.handleLogout} to="/">Sair</Link> */}
                </li>
            </ul>
        </React.Fragment>
    );
}