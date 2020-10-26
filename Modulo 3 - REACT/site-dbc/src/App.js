import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import './App.css';

import Home from './pages/Home';
import About from './pages/About';
import Service from './pages/Service';
import Contato from './pages/Contato';

export default class App extends Component{
  render() {

    return (
      <Router>
        <Route path="/" exact Component={ Home } />
        <Route path="/about" exact Component={ About } />
        <Route path="/service" exact Component={ Service } />
        <Route path="/contato" exact Component={ Contato } />
      </Router>
    );
  }
}