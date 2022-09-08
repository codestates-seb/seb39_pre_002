import styled from "styled-components";
import { useState, useEffect } from "react";
import Accordion from "./Accordion";
import { useNavigate } from "react-router-dom";
import Editor from "./Editor";

const CreateQuestion = () => {
  const [questionTitle, setQuestionTitle] = useState("");
  const [questionContent, setQuestionContent] = useState("");

  const [isPending, setIsPending] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = { questionTitle, questionContent };

    setIsPending(true);

    fetch("http://15.164.53.160:8080/v1/questions", {
      // fetch('http://localhost:3001/data', {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    }).then(() => {
      console.log("new question added");
      setIsPending(false);
      navigate("/");
    });
  };

  useEffect(() => {}, [questionTitle]);

  return (
    <Container>
      <Div>
        <h2>Ask a public question</h2>
        <section>
          <form className="form" onSubmit={handleSubmit}>
            <label>
              <strong>Title</strong>
            </label>
            <input
              type="text"
              required
              value={questionTitle}
              onChange={(e) => setQuestionTitle(e.target.value)}
            />
            <label>
              <strong>Body</strong>
            </label>
            {/* <textarea
                        required
                        value={questionContent}
                        onChange={(e)=> setQuestionContent(e.target.value)}
                    ></textarea> */}
            <Editor
              questionContent={questionContent}
              setQuestionContent={setQuestionContent}
            />
            {!isPending && <PostButton>Post Your Question</PostButton>}
            {isPending && <PostButton disabled>Post Your Question</PostButton>}
          </form>
        </section>
      </Div>
      <Accordion />
    </Container>
  );
};

const Container = styled.div`
  display: flex;
  justify-content: center;

  background-color: #f1f2f3;
  width: 100vw;
  height: 100vh;
`;

const Div = styled.div`
  display: flex;
  flex-direction: column;
  text-align: left;

  form {
    display: flex;
    flex-direction: column;
  }

  h2 {
    margin: 50px 0px 50px 100px;
  }

  section {
    background-color: white;
    width: 800px;
    margin-left: 100px;

    box-shadow: 0.1rem 0.1rem 1rem #d1d2d3;
    padding: 10px 20px 10px 20px;
  }

  label {
    margin: 20px 20px 10px 0px;
  }

  input,
  textarea {
    border: 1px solid rgb(191, 191, 191);
    padding: 6px 10px;
    margin-bottom: 30px;
  }

  textarea {
    min-height: 250px;
    max-height: 250px;
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
  margin-bottom: 30px;
  width: 150px;
`;

export default CreateQuestion;
