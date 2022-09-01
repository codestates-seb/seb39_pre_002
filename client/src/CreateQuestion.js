import styled from "styled-components";
import { useState } from "react";
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import Accordion from "./Accordion";



    const CreateQuestion = () => {

    const question_title = "title"
    const question_content = "content"

    const[title, setTitle] = useState('');
    const[body, setBody] = useState('');

    

    return(
        <Container>
            <Div>
                <h2>Ask a public question</h2>            
                <section>
                <form className="form">
                    <label><strong>Title</strong></label>
                    <input
                        type="text"
                        required
                        value={question_title}
                        onChange={(e) => setTitle(e.target.value)}
                        />
                    <label><strong>Body</strong></label>
                    <CKEditor                                                                 
                        editor={ ClassicEditor }
                        data=""
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
                </form>
                </section>
                <PostButton>Post Your Question</PostButton>
            </Div>
            <Accordion />
        </Container>
        
    )

}

const Container = styled.div`
    display: flex;
    justify-content: center;    

    background-color: #F1F2F3;
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
                
                box-shadow: 0.1rem 0.1rem 1rem #D1D2D3;
                padding: 10px 20px 10px 20px;
            }          

            label {                
                margin: 20px 20px 10px 0px;
            }

            input {    
                border: 1px solid rgb(191,191,191);        
                padding: 6px 10px;              
                margin-bottom: 30px;                
            }

            .ck.ck-editor__editable:not(.ck-editor__nested-editable) {
                min-height: 250px;
                max-height: 250px;
                margin-bottom: 20px;
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
    
    

 
export default CreateQuestion;