import React, {Component} from 'react';
import {Link} from 'react-router-dom';
// import {logout} from '../utils/logHelper'
import logo from '../Images/logo-dbc.png'
import Menu from '../Components/Menu.js';

export default class Header extends Component {
    /* handleLogout = () =>{
        logout();
    } */

    render() {
        return (
            <header className="main-header">
                <nav className="container clearfix">
                    <Link className="logo-dbc" to="/">
                        <img src={logo} alt="DBC Logo"/>
                    </Link>
                    <label className="mobile-menu" for="mobile-menu">
                        <span></span>
                        <span></span>
                        <span></span>
                    </label>
                    <input id="mobile-menu" type="checkbox"/>

                    <Menu/>
                </nav>
            </header>
        )
    }
}
    