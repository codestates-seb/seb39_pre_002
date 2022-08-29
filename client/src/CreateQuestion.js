import styled from "styled-components";
import { useState } from "react";



const Div = styled.div`   

        
        display: flex;
        flex-direction: column;

        background-color: #F1F2F3;
        width: 100vw;
        height: 100vh;
       
        text-align: left;

            h2 {
                margin-bottom: 50px;
                margin-left: 100px;
            }

            section {

                background-color: white;
                max-width: 800px;
                margin-left: 100px;               
                
                box-shadow: 0.1rem 0.1rem 1rem #D1D2D3;
                padding: 10px 10px 10px 10px;
            }          

            label {
                display:block;
                margin: 20px 20px 10px 10px;
            }

            input, textarea {
                width: 90%;
                padding: 6px 10px;
                margin: 10px 10px;
                margin-bottom: 30px;
                display:block;
            }

            textarea {
                height: 200px;
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
        margin-left: 100px;
        width: 150px;
    `;

    const CreateQuestion = () => {

    const question_title = "title"
    const question_content = "content"

    const[title, setTitle] = useState('');
    const[body, setBody] = useState('');

    

    return(
        <Div>
            <h2>Ask a public question</h2>
            <section>
            <form>
                <label><strong>Title</strong></label>
                <input
                    type="text"
                    required
                    value={question_title}
                    onChange={(e) => setTitle(e.target.value)}
                />
                <label><strong>Body</strong></label>
                <textarea
                    required
                    value={question_content}
                    onChange={(e)=> setBody(e.target.value)}
                ></textarea>
                
            </form>
            </section>
            <PostButton>Post Your Question</PostButton>
        </Div>
    )

}
 
export default CreateQuestion;