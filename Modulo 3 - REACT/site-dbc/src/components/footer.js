import React, { Component } from 'react';
import Texto from './texto';
import Menu from './menu';

export default class Footer extends Component {
    render() {
        return (
            <footer className="main-footer">
                <div className="container">
                    <nav>
                        <Menu />
                    </nav>
                    <Texto texto={"© Copyright DBC Company - 2020"}/>
                </div>
            </footer>
        )
    }
}