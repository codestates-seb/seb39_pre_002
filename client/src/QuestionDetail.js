import styled from "styled-components";
import { Link, useParams } from "react-router-dom";
import useFetch from "./useFetch";
import Sidebar from "./Sidebar";
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';


const QuestionDetail = () => {
  const { id } = useParams();
  const { data, error } = useFetch("http://localhost:3001/data/" + id);

  const question_views = 0;

  let now = new Date();
  let year = now.getFullYear();
  let month = now.getMonth();
  let date = now.getDate();

  return (
    <>
      {error && <div>{error}</div>}
      {data && (
        <Body>
          <Sidebar />
          <Div>
            <h2>{data.title}</h2>
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
            <section>{data.content}</section>
            <Link to="/modify">
              <EditDeleteButton>Edit</EditDeleteButton>
            </Link>
            <EditDeleteButton>Delete</EditDeleteButton>
            <label>Your Answer</label>
            <CKEditor                                                                   
                    editor={ ClassicEditor }
                    data="<p>Hello from CKEditor 5!</p>"
                    onReady={ editor => {
                        // You can store the "editor" and use when it is needed.
                        console.log( 'Editor is ready to use!', editor );
                    } }
                    onChange={ ( event, editor ) => {
                        const data = editor.getData();
                        console.log( { event, editor, data } );
                    } }
                    onBlur={ ( event, editor ) => {
                        console.log( 'Blur.', editor );
                    } }
                    onFocus={ ( event, editor ) => {
                        console.log( 'Focus.', editor );
                    } }
                />
            <PostButton>Post Your Answer</PostButton>
          </Div>
          <PostIt>
            <article className="postItTitle">The Overflow Blog</article>
            <article className="postItContent">
              <ul>
                <li>Stack Overflow is launching a Student Ambassador program. Here’s how to apply.</li>
                <li>What companies lose when they track worker productivity (Ep. 478)</li>                
              </ul>
            </article>
            <article className="postItTitle">Featured on Meta</article>
            <article className="postItContent">
              <ul>
                <li>Please welcome Valued Associate #1301 - Emerson</li>
                <li>Announcing the Stack Overflow Student Ambassador Program</li>
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

  .ck.ck-editor__editable:not(.ck-editor__nested-editable) {
       min-height: 250px;
       max-height: 250px;
       margin-bottom: 20px;
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

    box-shadow: 0.1rem 0.1rem 1rem #D1D2D3;
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
      background-color: #FDF7E2;
      margin-top: 0px;
      padding-right: 15px;
    }
  `;

export default QuestionDetail;
