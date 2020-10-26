import React from 'react';

export default ( props ) => 
    <React.Fragment>
        { props.nome } { props.sobrenome }
    </React.Fragment>

/* [
    props.nome,
    props.sobrenome
]
<div>
    { props.nome } { props.sobreno }
</div> */