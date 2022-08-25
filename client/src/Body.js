import styled from "styled-components";
function Body() {
  return (
    <Main>
      <div className="body-top">
        <h1>All Questions</h1>
        <div>
          <a>Ask Question</a>
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
      <div className="body-main">
        뿌려줄 데이터
        <br />
        뿌려줄 데이터
        <br />
        뿌려줄 데이터
        <br />
        뿌려줄 데이터
        <br />
        뿌려줄 데이터
        <br />
        뿌려줄 데이터
        <br />
        뿌려줄 데이터
        <br />
        뿌려줄 데이터
        <br />
        뿌려줄 데이터
        <br />
        뿌려줄 데이터
        <br />
        뿌려줄 데이터
        <br />
      </div>
    </Main>
  );
}

export const Main = styled.div`
  /* background-color: rgba(255, 50, 50, 0.3); */
  width: 60vw;
  .body-top {
    display: flex;
  }
  .body-middle {
    display: flex;
    .body-middle-tab {
      display: flex;
    }
  }
`;

export default Body;
