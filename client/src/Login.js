import styled from "styled-components";
import { useState } from "react";
import stackoverflow from "./img/stackoverflow.png"
import facebook from "./img/facebook.png"
import google from "./img/google.png"
import github from "./img/github.png"




const Div = styled.div`   

        
        display: flex;
        flex-direction : column;
        justify-content: center;
        align-items: center;
        background-color: #F1F2F3;
        width: 100vw;
        height: 100vh;

            .logo {
                margin-right: 5px;
                width: 15px;
            }

            
            button {                
                width: 274px;           
                color:white;
                background-color:hsl(206,100%,52%);
                border: 0;
                border-radius: 3px;
                padding: 8px;
                cursor: pointer;
                margin: 20px 20px 20px 20px;                
            }      

            form {
                background-color: white;
                width: 300px;
                box-shadow: 0.1rem 0.1rem 1rem #D1D2D3;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                text-align: left;                
            }          

            label { 
                margin-top: 20px;;
                width: 272px;                 
                text-align: left;
            }

            input {
                width: 250px;
                padding: 6px 10px;
                             
            }          
            
            .google_login {
                width: 300px;
                color: black;
                background-color: white;
                box-shadow: 0.1rem 0.1rem 1rem #D1D2D3;
            }           
            .github_login {
                margin-top: 0;
                width: 300px;
                color: white;
                background-color: hsl(210,8%,20%);
                box-shadow: 0.1rem 0.1rem 1rem #D1D2D3;            
            }
            .facebook_login {
                margin-top: 0;
                width: 300px;
                color: white;
                background-color: hsl(209,100%,32%);
                box-shadow: 0.1rem 0.1rem 1rem #D1D2D3;
            }
    `;   

const Img = styled.img`
    width: 50px;
`;


const Login = () => {
    return (
        <Div>
            <Img src={stackoverflow} alt="logo2" />
            <button className="google_login">
                <img className="logo" src={google} alt="googlelogo"></img>Log in with Google</button>
            <button className="github_login">
                <img className="logo" src={github} alt="githublogo"></img>Log in with GitHub</button>
            <button className="facebook_login">
                <img className="logo" src={facebook} alt="facebooklogo"></img>Log in with Facebook</button>

            <form>
                <label><strong>Email</strong></label>
                <input type="email"></input>
                <label><strong>Password</strong></label>
                <input type="password"></input>
                <button>Log in</button>

            </form>
           
        </Div>
    );
}
 
export default Login;