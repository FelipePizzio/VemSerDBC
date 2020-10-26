import React, {Component} from "react";

export default class InputLogin extends Component{

    render() {
        const {className, type, value, placeholder, onChange } = this.props
        return (
            <div className='row'>
                <div className='col col-10 col-md-8 col-lg-8'>
                    <input className={className} type={type} value={value} placeholder={placeholder} onChange={onChange}/>
                </div>
            </div>
        )
    }
}