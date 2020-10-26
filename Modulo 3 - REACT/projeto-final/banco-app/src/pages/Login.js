import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import axios from 'axios';

import Input from '../components/Input'
import Button from '../components/Button'


export default class Login extends Component {
    constructor() {
        super();
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = { 
            username: null, 
            password: null 
        };
    }
    handleSubmit = (e) => {
        e.preventDefault();
        const { username, password } = this.state
        axios.post('http://localhost:1337/login', {email: username, senha: password} )
            .then((res) => {
                console.log(res.data);
            }).catch((err) => {
                console.log(err);
            })
    }
    inputBlurUsername = (e) => {
        const email = e.target.value
        this.setState( {
            username: email,
        } )
    }
    inputBlurPassword = (e) => {
        const password = e.target.value
        this.setState( {
            password: password,
        } )
    }
    render() {
        return (
            <div className='App'>
                <section className='App-header'>
                        <form className='container box'>
                            <div className='row'>
                                <h1>VEM SER BANCO DIGITAL</h1>
                                <h3>LOGIN</h3>
                            </div>
                            <div className='row'>
                                <Input
                                    id='username'
                                    name='username'
                                    className='button-big input'
                                    placeholder='Insira seu email'
                                    type='email'
                                    onBlur={ this.inputBlurUsername.bind(this) }
                                />
                            </div>
                            <div className='row'>
                                <Input
                                    id='password'
                                    name='password'
                                    className='button-big input'
                                    placeholder='Insira sua senha'
                                    type='password'
                                    onBlur={ this.inputBlurPassword.bind(this) }
                                />
                            </div>
                            <div className='row'>
                                <Link to={'/home'}>
                                    <Button
                                        className='button button-big button-outline'
                                        mensagem='ENTRAR'
                                        onClick={ this.handleSubmit }
                                    />
                                </Link>
                            </div>
                        </form>
                </section>
            </div>
        );
  }
}