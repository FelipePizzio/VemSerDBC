import React from "react";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";

import Authentication from './Util/Authentication';

import Login from './Pages/Login';
import Vagas from './Pages/VagasPage';
import Candidatos from "./Pages/CandidatosPage";
import DetalhesCandidato from "./Pages/DetalheCandidatoPage";
import CadastroCandidato from "./Pages/CadastroCandidatoPage";
import EditarCandidato from "./Pages/EditarCandidatoPage";

function Routes() {

  const PrivateRoute = ({ component: Component, ...rest }) => (
    <Route
      {...rest}
      render={props =>
        Authentication.isUserLoggedIn() ? (
          <Component {...props} />
        ) : (
            <Redirect to={{ pathname: "/", state: { from: props.location } }} />
          )
      }
    />
  );

  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact component={Authentication.isUserLoggedIn() ? Vagas : Login} />
        <PrivateRoute path="/vagas" exact component={Vagas} />
        <PrivateRoute path="/candidatos" exact component={Candidatos} />
        <PrivateRoute path="/candidatos/detalhes" exact component={DetalhesCandidato} />
        <PrivateRoute path="/candidatos/cadastro" exact component={CadastroCandidato} />
        <PrivateRoute path="/candidatos/editar" exact component={ EditarCandidato } />
      </Switch>
    </BrowserRouter>
  );
}
export default Routes;