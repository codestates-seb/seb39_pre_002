import styled from "styled-components";
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { useState } from "react";

const Editor = ( {questionContent, setQuestionContent }) => {
    return ( 
        <Div>
            <CKEditor                                                                                     
                        editor={ ClassicEditor }
                        data=""
                        onReady={ editor => {
                            // You can store the "editor" and use when it is needed.
                            console.log( 'Editor is ready to use!', editor );
                        } }
                        onChange={ ( event, editor ) => {
                            // setQuestionContent(event.target.value)
                            const data = editor.getData();
                            setQuestionContent(
                                data                           
                            )
                            console.log( { event, editor, data } );
                        } }                                   
                        />
        </Div>
     );
}

const Div = styled.div `

    .ck.ck-editor__editable:not(.ck-editor__nested-editable) {
        min-height: 250px;
        max-height: 250px;
        margin-bottom: 20px;
}    

`;

 
export default Editor;