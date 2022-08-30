import styled from "styled-components";
import { useState } from "react";
import Sidebar from "./Sidebar";

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

  label {
    font-size: 20px;
    display: block;
    margin: 50px 20px 10px 30px;
  }

  input,
  textarea {
    width: 90%;
    padding: 6px 10px;
    display: block;
    margin-left: 30px;
  }

  textarea {
    height: 200px;
  }

  span {
    font-size: 12px;
    margin-right: 15px;
  }

  section {
    line-height: 150%;
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
  margin-left: 30px;
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

const ModifyQuestion = () => {
  const [title, setTitle] = useState("");
  const [body, setBody] = useState("");

  const question_title =
    "Reactjs: Why doesn't state boolean lock on event listener?";
  const question_content = `React Noob - thought I'd ask here for a quick answer before I spend hours digging.

    In the example below I have an event listener inside useEffect that listens for scroll position on a container and fires a trigger after a point if it hasn't done so already.
  
    I want to know why the event still triggers even though the boolean registers true in the DOM. I've solved the problem by using a normal variable but I think it would benefit me to understand why this is happening. I've read lightly into mutating states and have experimented with changing the useState to an object like useState({status: false}) but this had similar results.
  
     Even a point in the direction of a reading topic would be enough. Cheers!`;

  return (
    <Body>
      <Sidebar />
      <Div>
        <label>Title</label>
        <input
          type="text"
          required
          value={question_title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <label>Body</label>
        <textarea
          required
          value={question_content}
          onChange={(e) => setBody(e.target.value)}
        ></textarea>

        <div className="buttonContainer">
          <PostButton>Save edits</PostButton>
          <CancelButton>Cancel</CancelButton>
        </div>
      </Div>
    </Body>
  );
};

export default ModifyQuestion;
