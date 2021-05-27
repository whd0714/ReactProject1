import React, {useState} from 'react';
import {useDispatch} from "react-redux";
import {registerUser} from "../../../_actions/user_actions";
import { withRouter } from 'react-router-dom';

function RegisterPage(props) {

    const dispatch = useDispatch();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [name, setName] = useState("");

    const onNameHandler = (event) => {
        setName(event.currentTarget.value);
    }

    const onEmailHandler = (event) => {
        setEmail(event.currentTarget.value);
    }

    const onPasswordHandler = (event) => {
        setPassword(event.currentTarget.value);
    }

    const onSubmitHandler = (event) => {
        event.preventDefault();

        let body = {
            name:name,
            email:email,
            password:password
        }

        dispatch(registerUser(body))
            .then(response=>{
                if(response.payload == 'registerSuccess') {
                    props.history.push('/')
                } else {
                    alert('회원가입 실패')
                }
            });

    }

    return (
        <div style={{display:'flex', justifyContent:'center', alignItems:'center', width:'100%', height:'100vh'}} >
            <form style={{display:'flex', flexDirection:'column'}} onSubmit={onSubmitHandler}>
                <label>Name</label>
                <input type="text" value={name} onChange={onNameHandler}/>
                <label>Email</label>
                <input type="email" value={email} onChange={onEmailHandler}/>
                <label>Password</label>
                <input type="password" value={password} onChange={onPasswordHandler}/>
                <br />
                <button type={"submit"}>Register</button>
            </form>
        </div>
    );
}

export default withRouter(RegisterPage);