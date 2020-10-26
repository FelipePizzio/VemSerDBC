import React, { Component } from 'react';
import { withRouter } from "react-router-dom";

import Authentication from '../Util/Authentication'

import Card from "../Components/Card"
import Logo from "../Images/logo-ecos.png"
import Button from '../Components/Button';
import InputLogin from '../Components/InputLogin';

class Login extends Component {
  constructor(props) {
    super(props)
    this.state = {
      username: null,
      password: null,
      hasLoginFailed: false,
      showSuccessMessage: false
    }
    this.loginClicked = this.loginClicked.bind(this)
  }

  handleChangeUsername = (e) => {
    const username = e.target.value
    this.setState({
      username: username
    })
  }

  handleChangePassword = (e) => {
    const password = e.target.value
    this.setState({
      password: password    
    })
  }

  loginClicked() {

    Authentication
      .executeJwtAuthenticationService(this.state.username, this.state.password)
      .then((response) => {
        Authentication.registerSuccessfulLoginForJwt(this.state.username, response.data.token)
        this.props.history.push(`/vagas`)
      }).catch(() => {
        this.setState({ showSuccessMessage: false })
        this.setState({ hasLoginFailed: true })
      })

  }

  render() {
    return (
      <div className='App'>
        <section className='App-header'>
          <div className='login-background'>
            <Card className='container card-login card-login-md card-login-lg'>
              <div className='row'>
                <div className='col col-10 col-md-8 col-lg-8 col-offset-2'>
                  <img className='logo-ecos' src={Logo} alt="logo-ecos-dbc.png" />
                  {this.state.error && <p>{this.state.error}</p>}
                </div>
              </div>
              <div className='row'>
                  <InputLogin className='input-login col col-12 col-md-6 col-lg-6 col-offset-3' type="text" placeholder="username" name='username' onChange={this.handleChangeUsername.bind(this)} />
                  <InputLogin className='input-login col col-12 col-md-6 col-lg-6 col-offset-3' type="password" placeholder="password" name='password' onChange={this.handleChangePassword.bind(this)} />
              
              </div>
              <div className='row'>
                <div className='col col-10 col-md-6 col-lg-6 col-offset-3'>
                  <Button class='button button-big button-outline' onClick={this.loginClicked} texto='ENTRAR' />
                  {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                  {this.state.showSuccessMessage && <div>Login Sucessful</div>}
                </div>
              </div>
            </Card>
          </div>
        </section>
      </div>
    );
  }
}

export default withRouter(Login);