import Question from "./Question";
import styled from "styled-components";
import { Link } from "react-router-dom";
import Sidebar from "./Sidebar";

function Body({ data }) {
  function handleClick(event, id) {}

  return (
    <Main>
      <Sidebar />
      <div className="body">
        <div className="body-top">
          <h1>All Questions</h1>
          <div>
            <Link to="/create">
              <button className="askQuestion">Ask Question</button>
            </Link>
          </div>
        </div>
        <div className="body-middle">
          <div className="questionNubers">22,935,667 questions</div>
          <div>
            <div className="tab-filter">
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
      </div>
    </Main>
  );
}

export const Main = styled.div`
  display: flex;
  justify-content: center;
  width: 100%;
  overflow: hidden;

  .body {
    border-left: 1px, solid, gray;
    /* background-color: rgba(255, 50, 50, 0.3); */
    width: 60vw;
    border-left: 1px solid #d6d9dc;
  }

  h1 {
    font-size: 27px;
    font-weight: 400;
    margin-left: 20px;
  }

  .body-top {
    width: 727px;
    height: 60px;
    display: flex;
    justify-content: space-between;

    button {
      margin-top: 20px;
      background-color: #1095fa;
      border-radius: 5px;
    }
  }
  .body-middle {
    display: flex;
    height: 50px;
    .questionNubers {
      width: 260px;
      display: flex;
      align-items: center;
      margin-left: 20px;
    }
    .tab-filter {
      display: flex;
    }
    .body-middle-tab {
      display: flex;
      margin: 5px;
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
