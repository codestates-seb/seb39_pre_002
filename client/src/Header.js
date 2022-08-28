import styled from "styled-components";
function header() {
  return (
    <Main>
      {/* <hr size="5" color="orange" align="top" /> */}
      <div className="header-container">
        <a className="flex align">
          <span className="marginUp">
            (이미지)stack<b>overflow</b>
          </span>
        </a>
        <a className="products gray">Products</a>
        <div className="marginUp">
          <svg
            aria-hidden="true"
            class="s-input-icon s-input-icon__search svg-icon iconSearch"
            width="18"
            height="18"
            viewBox="0 0 18 18"
          >
            <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"></path>
          </svg>
          <input className="searchbar" type="text" placeholder="search…" />
        </div>
        <ul>
          <li className="profile-link flex align">
            <img
              src="https://www.gravatar.com/avatar/44011235b79b08f889287bf4f307bd86?s=48&amp;d=identicon&amp;r=PG"
              alt="user avatar"
              width="24"
              height="24"
              class="bar-sm s-avatar--image js-avatar-me"
            />
            <div>1</div>
          </li>
          <li>
            <svg
              aria-hidden="true"
              class="svg-icon iconInbox"
              width="20"
              height="18"
              viewBox="0 0 20 18"
              className="gray"
            >
              <path d="M4.63 1h10.56a2 2 0 0 1 1.94 1.35L20 10.79V15a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-4.21l2.78-8.44c.25-.8 1-1.36 1.85-1.35Zm8.28 12 2-2h2.95l-2.44-7.32a1 1 0 0 0-.95-.68H5.35a1 1 0 0 0-.95.68L1.96 11h2.95l2 2h6Z"></path>
            </svg>
          </li>
          <li>
            <svg
              aria-hidden="true"
              class="svg-icon iconAchievements"
              width="18"
              height="18"
              viewBox="0 0 18 18"
              className="gray"
            >
              <path d="M15 2V1H3v1H0v4c0 1.6 1.4 3 3 3v1c.4 1.5 3 2.6 5 3v2H5s-1 1.5-1 2h10c0-.4-1-2-1-2h-3v-2c2-.4 4.6-1.5 5-3V9c1.6-.2 3-1.4 3-3V2h-3ZM3 7c-.5 0-1-.5-1-1V4h1v3Zm8.4 2.5L9 8 6.6 9.4l1-2.7L5 5h3l1-2.7L10 5h2.8l-2.3 1.8 1 2.7h-.1ZM16 6c0 .5-.5 1-1 1V4h1v2Z"></path>
            </svg>
          </li>
          <li>
            <svg
              aria-hidden="true"
              class="svg-icon iconHelp"
              width="18"
              height="18"
              viewBox="0 0 18 18"
              className="gray"
            >
              <path d="M9 1C4.64 1 1 4.64 1 9c0 4.36 3.64 8 8 8 4.36 0 8-3.64 8-8 0-4.36-3.64-8-8-8Zm.81 12.13c-.02.71-.55 1.15-1.24 1.13-.66-.02-1.17-.49-1.15-1.2.02-.72.56-1.18 1.22-1.16.7.03 1.2.51 1.17 1.23ZM11.77 8c-.59.66-1.78 1.09-2.05 1.97a4 4 0 0 0-.09.75c0 .05-.03.16-.18.16H7.88c-.16 0-.18-.1-.18-.15.06-1.35.66-2.2 1.83-2.88.39-.29.7-.75.7-1.24.01-1.24-1.64-1.82-2.35-.72-.21.33-.18.73-.18 1.1H5.75c0-1.97 1.03-3.26 3.03-3.26 1.75 0 3.47.87 3.47 2.83 0 .57-.2 1.05-.48 1.44Z"></path>
            </svg>
          </li>
          <li>
            <svg
              aria-hidden="true"
              class="svg-icon iconStackExchange"
              width="18"
              height="18"
              viewBox="0 0 18 18"
              className="gray"
            >
              <path d="M15 1H3a2 2 0 0 0-2 2v2h16V3a2 2 0 0 0-2-2ZM1 13c0 1.1.9 2 2 2h8v3l3-3h1a2 2 0 0 0 2-2v-2H1v2Zm16-7H1v4h16V6Z"></path>
            </svg>
          </li>
        </ul>
      </div>
    </Main>
  );
}
export const Main = styled.div`
  background-color: #f8f9f9;
  font-size: unset;
  display: flex;
  justify-content: center;
  /* transform: translate(-25%, -25%) scale(0.5); */
  display: inline-block;
  height: 50px;

  .header-container {
    border-top: 3px solid #f48225;

    display: flex;
    align-items: center;
    justify-content: center;
    width: 100vw;
    overflow: hidden;
  }
  .products {
    margin-right: 15px;
    margin-left: 15px;
  }
  .searchbar {
    width: 45vw;
    height: 10px;
    max-width: 788px;
    padding: 7px 9px 7px 32px;
  }
  ul {
    list-style: none;
    display: flex;
    justify-content: flex-start;
  }
  li {
    margin-right: 20px;
  }
  .profile-link {
    margin-right: 40px;
  }
  .gray {
    fill: #525960;
    color: #525960;
  }
  .flex {
    display: flex;
  }
  .align {
    align-items: center;
  }
  .marginUp {
    margin-top: -10px;
  }
`;

export default header;
