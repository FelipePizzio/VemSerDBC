import React from 'react';

export default function Button(props) {
    return (
        <React.Fragment>
            <button type = {props.tipo} className={props.class} onClick={props.onClick}> {props.texto} </button>
        </React.Fragment>
    )
}