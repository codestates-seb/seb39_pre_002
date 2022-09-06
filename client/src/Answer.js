


const Answer = ({data, key}) => {
    return ( 
        <div>
            <div key={key}>{data.answerContent}</div>
        </div>
     );
}
 
export default Answer;