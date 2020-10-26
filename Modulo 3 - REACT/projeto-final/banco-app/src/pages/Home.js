import React, { Component } from 'react';

import Header from '../components/Header';

export default class Home extends Component {
    render() {
        return (
            <div className='App'>
                <Header />
                <section className='App-header'>
                    <div className='container box'>
                        <h1>SEJA BEM-VINDO</h1>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                            Montes nascetur ridiculus mus mauris vitae ultricies leo integer malesuada. 
                            Tellus molestie nunc non blandit massa enim nec. 
                            Tellus orci ac auctor augue mauris. Nisi lacus sed viverra tellus in hac habitasse platea dictumst. 
                            Sed augue lacus viverra vitae. Mattis rhoncus urna neque viverra justo nec.
                        </p>
                    </div>
                </section>
            </div>
        );
  }
}