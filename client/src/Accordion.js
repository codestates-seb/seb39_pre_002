import styled from "styled-components";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {faAngleDown, faAngleUp} from "@fortawesome/free-solid-svg-icons";
import { useState } from "react";




const data = [
    {
        number: '1. ',
        title: 'Summarize the problem',
        content: 'include details about your goal'
    },
    {
        number: '2. ',
        title: ' Describe what you have tried',
        content: 'Show what you’ve tried and tell us what you found (on this site or elsewhere) and why it didn’t meet your needs. You can get better answers when you provide research.'
    },
    {
        number: '3. ',
        title: 'Show some code',
        content: 'When appropriate, share the minimum amount of code others need to reproduce your problem (also called a minimum, reproducible example)'
    }
]

const Accordion = () => {  
    const [selected, setSelected] = useState(null)
    
    const toggle = (i) => {
        if (selected === i) {
            return setSelected(null)
        }
        setSelected(i)
    }

    
    
    return (
        <Div>
            <PostIt>
                <div className="postItTitle">
                Step 1: Draft your question
                </div>
                <div className="postItContent">
                The community is here to help you with specific coding, algorithm, or language problems.
                Avoid asking opinion-based questions.
                </div>
            </PostIt>
            <Container>                
                <div className="accordion">
                    {data.map((item, i) => (
                        <div className="item">
                            <div className="title" onClick={() => toggle(i)}>                                                                  
                                
                                <div><span className="number"><strong>{item.number}</strong></span><strong>{`${item.title} `}</strong></div>                                
                                <span>{selected === i ? <FontAwesomeIcon icon={faAngleUp} /> : <FontAwesomeIcon icon={faAngleDown} />}</span>                                                         
                            </div>
                            <div className={selected === i ? 'content show' : 'content'}>{item.content}</div>
                        </div>
                    ))}
                </div>
            </Container>            
        </Div>
        
    );
}

const Div = styled.div`
 
    display: flex;
    flex-direction: column;
          
`;

const PostIt = styled.div`

    box-shadow: 0.1rem 0.1rem 1rem #D1D2D3;  
    width: 300px;
    min-width: 300px;
    margin: 128px 30px 0px 30px;
    display: flex;
    flex-direction: column;

    .postItTitle {

      border: 1px solid rgb(234, 234, 234);
      padding: 10px 10px 10px 20px;
      background-color: rgb(244, 244, 244);
      margin-bottom: 0px;
    }

    .postItContent {
      padding: 10px 20px 10px 20px;
      line-height: 180%;
      font-size: 0.8rem;
      border: 1px solid rgb(234, 234, 234);      
      background-color: white;
      margin-top: 0px;
      padding-right: 15px;
    }
  `;

const Container = styled.div`
     
    box-shadow: 0.1rem 0.1rem 1rem #D1D2D3;  
    
    width: 300px;
    min-width: 300px;
    margin: 0px 30px 30px 30px;

    .number {
        color: #0B96FE;
    }
    
    .item {
        display :flex;
        flex-direction: column;
    }

    .title {

        border: 1px solid rgb(234, 234, 234);
        padding: 10px 10px 10px 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: white;
        cursor: pointer;
    }

    .content {
        border: 1px solid rgb(234, 234, 234);
        background-color: white;
        max-height: 0;
        overflow: hidden;
        
    }

    .content.show {
        line-height: 180%;
        font-size: 0.8rem;
        padding: 10px 20px 10px 35px;
        height: auto;
        max-height: 9999px;
        
    }
`;




export default Accordion;