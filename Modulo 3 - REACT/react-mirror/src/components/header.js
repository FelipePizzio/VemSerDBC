import React, { Component } from 'react';
import Menu from './menu';

export default class Header extends Component {
    render() {
        return (
            <section className="main-header">
                <nav className="container clearfix">
                    <label className="mobile-menu" htmlFor="mobile-menu">
                        <span></span>
                        <span></span>
                        <span></span>
                    </label>
                    <input id="mobile-menu" type="checkbox" />
                    <Menu />
                </nav>
            </section>
        )
    }
}