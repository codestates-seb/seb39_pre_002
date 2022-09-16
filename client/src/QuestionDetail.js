import styled from "styled-components";
import { Link, useParams } from "react-router-dom";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import useFetch from "./useFetch.js";
import Sidebar from "./Sidebar.js";
// import { CKEditor } from "@ckeditor/ckeditor5-react";
// import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
// import Editor from "./Editor";
// import Answer from "./Answer";

const QuestionDetail = () => {
  const navigate = useNavigate();
  const { id } = useParams();

  // const { data, error } = useFetch("http://localhost:3001/data/" + id);
  const { data, error } = useFetch(
    `http://15.164.53.160:8080/v1/questions/${id}`
  );

  const handleDelete = () => {
    fetch("http://15.164.53.160:8080/v1/questions/" + id, {
      // fetch("http://localhost:3001/data/" + data.id, {
      method: "DELETE",
    }).then(() => {
      navigate("/");
    });
  };

  const question_views = 0;

  let now = new Date();
  let year = now.getFullYear();
  let month = now.getMonth();
  let date = now.getDate();

  const [comment, setComment] = useState("");
  const onChange = (event) => setComment(event.target.value);

  const [commentArray, setCommentArray] = useState([]);
  const onSubmit = (event) => {
    event.preventDefault();
    if (comment === "") {
      return;
    }
    setCommentArray((commentValueList) => [comment, ...commentValueList]);
    setComment("");
  };
  return (
    <>
      {error && <div>{error}</div>}
      {data && (
        <Body>
          <Sidebar />
          <Div>
            <h2>{data.data.questionTitle}</h2>
            {/* <h2>{data.questionTitle}</h2> */}
            <p>
              <span>
                Asked <strong>{`${year}/${month}/${date}`}</strong>
              </span>
              <span>
                Modified <strong>{`${year}/${month}/${date}`}</strong>
              </span>
              <span>
                viewed <strong>{question_views}</strong>
              </span>
            </p>
            <hr></hr>
            <section>{data.data.questionContent}</section>
            {/* <section>{data.questionContent}</section> */}
            {/* <Link to={`/questions/${data.id}/modify`} state={{ data: data }}> */}
            <Link
              to={`/questions/${id}/modify`}
              // state={{ data: data }}
            >
              <EditDeleteButton>Edit</EditDeleteButton>
            </Link>
            <EditDeleteButton onClick={handleDelete}>Delete</EditDeleteButton>

            <div className="answerContainer">
              {commentArray.map((value, index) => (
                <div key={index} className="answer">
                  {value} <span className="answerName">- junho01234</span>
                </div>
              ))}
            </div>

            <form onSubmit={onSubmit}>
              <label>Your Answer</label>
              <textarea
                required
                placeholder="답변을 입력해주세요"
                value={comment}
                onChange={onChange}
              ></textarea>
              {/* <Editor /> */}
              <PostButton>Post Your Answer</PostButton>
            </form>
          </Div>

          <PostIt>
            <article className="postItTitle">The Overflow Blog</article>
            <article className="postItContent">
              <ul>
                <li>
                  Stack Overflow is launching a Student Ambassador program.
                  Here’s how to apply.
                </li>
                <li>
                  What companies lose when they track worker productivity (Ep.
                  478)
                </li>
              </ul>
            </article>
            <article className="postItTitle">Featured on Meta</article>
            <article className="postItContent">
              <ul>
                <li>Please welcome Valued Associate #1301 - Emerson</li>
                <li>
                  Announcing the Stack Overflow Student Ambassador Program
                </li>
                <li>Should we burninate the [option] tag?</li>
              </ul>
            </article>
          </PostIt>
        </Body>
      )}
    </>
  );
};

const Body = styled.div`
  display: flex;
  justify-content: center;
`;
const Div = styled.div`
  .body {
  }
  display: block;

  margin: 50px 50px 50px 100px;
  text-align: left;
  min-width: 350px;
  max-width: 800px;

  label {
    font-size: 20px;
    display: block;
    margin: 50px 20px 10px 0px;
  }

  textarea {
    width: 90%;
    height: 200px;
    padding: 6px 10px;
    display: block;
  }

  span {
    font-size: 12px;
    margin-right: 15px;
  }

  section {
    line-height: 150%;
  }

  .answer {
    margin: 20px 20px 20px 0px;
  }

  .answerName {
    color: hsl(206, 100%, 52%);
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
`;

const EditDeleteButton = styled.button`
  border: none;
  background-color: white;
  color: grey;
  margin-top: 30px;
  cursor: pointer;
`;

const PostIt = styled.div`
  box-shadow: 0.1rem 0.1rem 1rem #d1d2d3;
  height: 380px;
  width: 300px;
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
    background-color: #fdf7e2;
    margin-top: 0px;
    padding-right: 15px;
  }
`;

export default QuestionDetail;
