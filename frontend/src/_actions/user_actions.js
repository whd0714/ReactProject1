import axios from "axios";
import {
    LOGIN_USER,
    REGISTER_USER,
    AUTH_USER
} from "./types";

export function loginUser(data) {
    const request = axios.post('/api/login',
        JSON.stringify(data),
        {headers:{"Content-Type":"application/json; charset=UTF-8"}})
        .then(response=>response.data);

    return  {
        type: LOGIN_USER,
        payload: request
    }
}

export function registerUser(data) {
    const request = axios.post('/api/register',
        JSON.stringify(data),
        {headers:{"Content-Type":"application/json; charset=UTF-8"}})
        .then(response => response.data)

    return {
        type:REGISTER_USER,
        payload:request
    }
}

export function auth() {
    const request = axios.get('/api/member/auth')
        .then(response => response.data)

    return {
        type:AUTH_USER,
        payload:request
    }
}
