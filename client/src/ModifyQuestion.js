import styled from "styled-components";
import Sidebar from "./Sidebar";

import {useState} from "react";
import {useNavigate} from 'react-router-dom'

import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import Editor from "./Editor";
import { useParams } from "react-router-dom";




const ModifyQuestion = () => {
  
  const { id } = useParams();
  const navigate= useNavigate();

  const [questionTitle, setQuestionTitle] = useState('')
  
  function onClickEditButton() {
    navigate(`/questions/${id}`)
  }
  

  return (
    <Body>
      <Sidebar />
      <Div>
        <form className="form">
          <label>Title</label>
          <input
            type="text"
            required
            value={questionTitle}
            onChange={(e) => setQuestionTitle(e.target.value)}
            />
          <label>Body</label>
          <textarea
            required            
          ></textarea>
          {/* <Editor /> */}
          <div className="buttonContainer">
            <PostButton onClick={onClickEditButton}>Save edits</PostButton>
            <CancelButton>Cancel</CancelButton>
          </div>
          </form>        
      </Div>
      <PostIt>
        <article className="postItTitle">How to Edit</article>
        <article className="postItContent">
          <ul>
            <li>Correct minor typos or mistakes</li>
            <li>Clarify meaning without changing it</li>
            <li>Add related resources or links</li>
            <li>Always respect the author’s intent</li>
            <li>Don’t use edits to reply to the author</li>
          </ul>
        </article>
      </PostIt>
    </Body>
  );
};



const Body = styled.div`
  display: flex;
  justify-content: center;
`;
const Div = styled.div`
  display: flex;
  flex-direction: column;

  text-align: left;
  max-width: 800px;
  width: 100vw;
  height: 100vh;

  form {
    display: flex;
    flex-direction: column;
    margin-left: 30px;
  }

  label {
    font-size: 20px;
    display: block;
    margin: 50px 20px 10px 0px;
  }

  input, textarea {    
    border: 1px solid rgb(191,191,191);  
    padding: 6px 10px;    
  }

  textarea {
    height: 200px;
  }

  span {
    font-size: 12px;
    margin-right: 15px;
  }

  .buttonContainer {
    display: flex;
    flex-direction: row;
  }
  
`;

const PostButton = styled.button`
  color: white;
  background-color: hsl(206, 100%, 52%);
  border: 0;
  border-radius: 3px;
  padding: 8px;
  cursor: pointer;  
  margin-top: 50px;
  width: 100px;
  height: 40px;
`;

const CancelButton = styled.button`
  border: none;
  background-color: white;
  color: hsl(206, 100%, 52%);
  margin-top: 50px;
  margin-left: 10px;
  cursor: pointer;
  width: 100px;
  height: 40px;
`;

  const PostIt = styled.div`

    box-shadow: 0.1rem 0.1rem 1rem #D1D2D3;
    height: 190px;
    min-width: 300px;
    margin: 50px 30px 30px 30px;
    display: flex;
    flex-direction: column;

    .postItTitle {

      border: 1px solid rgb(226, 215, 179);
      padding: 10px 10px 10px 25px;
      background-color: rgb(255, 244, 211);
      margin-bottom: 0px;
    }

    .postItContent {

      line-height: 180%;
      font-size: 0.8rem;
      border: 1px solid rgb(226, 215, 179);
      height: 150px;
      background-color: #FDF7E2;
      margin-top: 0px;
    }
  `;

export default ModifyQuestion;
