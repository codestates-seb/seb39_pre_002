import Question from "./Question";
import styled from "styled-components";

function Body({ data }) {
  function handleClick(event, id) {}

  return (
    <Main>
      <div className="body-top">
        <h1>All Questions</h1>
        <div>
          <a className="askQuestion">Ask Question</a>
        </div>
      </div>
      <div className="body-middle">
        <div>22,935,667 questions</div>
        <div>
          <div>
            <div className="body-middle-tab">
              <a>
                <div>Newest</div>
              </a>
              <a>
                <div>Active</div>
              </a>
              <a>
                <div>Bountied 317</div>
              </a>
              <a>
                <div>Unanswered</div>
              </a>
              <button>more ▼</button>
            </div>
            <div>
              <button>filter</button>
            </div>
          </div>
        </div>
      </div>
      {data !== null ? (
        <div className="body-main">
          {data.map((data) => (
            <Question data={data} key={data.id} handleClick={handleClick} />
          ))}
        </div>
      ) : null}
    </Main>
  );
}

export const Main = styled.div`
  border-left: 1px, solid, gray;
  /* background-color: rgba(255, 50, 50, 0.3); */
  width: 60vw;
  border-left: 1px solid #d6d9dc;
  .body-top {
    display: flex;
  }
  .body-middle {
    display: flex;
    .body-middle-tab {
      display: flex;
    }
  }
  .askQuestion {
    font-size: 13px;
    line-height: 15px;
    text-decoration: none solid rgb(255, 255, 255);
    text-align: center;
    white-space: nowrap;
    word-spacing: 0px;

    background-color: #0074cc;
    background-position: 0% 0%;
    color: #ffffff;

    height: 37.8px;
    width: 100px;
    border: 1px solid #ffffff;
    padding: 10px 10px 10px 10px;

    cursor: pointer;
  }
`;

export default Body;
