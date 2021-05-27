import React, {useState} from 'react';
import {useDispatch} from "react-redux";
import {loginUser} from "../../../_actions/user_actions";
import { withRouter } from 'react-router-dom';

function LoginPage(props) {

    const dispatch = useDispatch();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const onEmailHandler = (event) => {
        setEmail(event.currentTarget.value);
    }

    const onPasswordHandler = (event) => {
        setPassword(event.currentTarget.value);
    }

    const onSubmitHandler = (event) => {
        event.preventDefault();

        let body = {
            email:email,
            password:password
        }

        dispatch(loginUser(body))
            .then(response => {
                console.log(response.payload);
                if(response.payload == 'loginSuccess') {

                    props.history.push('/');
                } else {
                    alert('로그인 실패');
                }
            });

    }

    return (
        <div style={{display:'flex', alignItems:'center', justifyContent:'center', width:'100%', height:'100vh'}}>

            <form style={{display:'flex', flexDirection:'column'}} onSubmit={onSubmitHandler}>
                <label>Email</label>
                <input type="email" value={email} onChange={onEmailHandler}/>

                <label>Password</label>
                <input type="password" value={password} onChange={onPasswordHandler}/>

                <br />
                <button type={"submit"}>Login</button>
            </form>


        </div>
    );
}

export default withRouter(LoginPage);