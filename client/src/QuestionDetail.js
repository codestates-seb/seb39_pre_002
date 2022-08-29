import styled from "styled-components";
import { Link, useParams } from "react-router-dom";
import useFetch from "./useFetch";




    const Div = styled.div`   

        display: block;

        margin: 50px 50px 50px 100px;
        text-align: left;
        max-width: 800px;
        
    
        label {
            font-size: 20px;
            display:block;
            margin: 50px 20px 10px 0px;
        }

        textarea {
            width: 90%;
            height: 200px;
            padding: 6px 10px;
            display:block;
        }

        span {
            font-size: 12px;
            margin-right: 15px;
        }           

        section {
            line-height: 150%;
        }

        
    `;

    const PostButton = styled.button`
        color:white;
        background-color:hsl(206,100%,52%);
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



const QuestionDetail = () => {

    const {id} = useParams();
    const {data, error} = useFetch('http://localhost:3001/data/'+ id)



        const question_views = 0
  
        let now = new Date();
        let year = now.getFullYear();
        let month = now.getMonth();
        let date = now.getDate();   
  
  
      return (
          <>
            {error && <div>{error}</div>}
            {data && (               
                    <Div>            
                        <h2>{data.title}</h2>
                        <p>
                            <span>Asked <strong>{`${year}/${month}/${date}`}</strong></span>
                            <span>Modified <strong>{`${year}/${month}/${date}`}</strong></span>
                            <span>viewed <strong>{question_views}</strong></span>
                        </p>
                        <hr></hr>
                        <section>
                            {data.content}
                        </section>      
                        <Link to="/modify"><EditDeleteButton>Edit</EditDeleteButton></Link>
                        <EditDeleteButton>Delete</EditDeleteButton>
                        <label>Your Answer</label>
                            <textarea></textarea>
                        <PostButton>Post Your Answer</PostButton>
                    </Div>               
            )}
          </>
      )
  
  }
 
export default QuestionDetail;