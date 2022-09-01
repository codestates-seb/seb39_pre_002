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
                <a className="tabs">
                  <div>Newest</div>
                </a>
                <a className="tabs">
                  <div>Active</div>
                </a>
                <a className="tabs">
                  <div>Bountied 317</div>
                </a>
                <a className="tabs">
                  <div>Unanswered</div>
                </a>
                <button className="tabs">more ▼</button>
              </div>
              <div className="filter-box">
                <button className="filter">
                  <svg
                    width="18"
                    height="18"
                    viewBox="0 0 18 18"
                    fill="#39739d"
                  >
                    <path d="M2 4h14v2H2V4Zm2 4h10v2H4V8Zm8 4H6v2h6v-2Z"></path>
                  </svg>
                  <span>filter</span>
                </button>
              </div>
            </div>
          </div>
        </div>
        {data !== null ? (
          <div className="body-main">
            {data.map((data) => (
              <Question
                data={data}
                key={data.questionId}
                handleClick={handleClick}
              />
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
    .tabs {
      font-size: 12px;
      color: #525960;
      border: 1px solid #9fa6ad;
      margin: 0 -1px -1px 0;
      padding: 10px 10px 10px 10px;
    }
    .filter-box {
      display: flex;
      align-items: center;
    }
    .filter {
      background-color: #e1ecf4;
      color: #2c5877;
      border: 1px solid #7aa7c7;
      border-radius: 3px;
      height: 39px;
      width: 69px;
      margin-left: 10px;
      padding: 10px 10px 10px 10px;
      span {
        vertical-align: 3px;
      }
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
