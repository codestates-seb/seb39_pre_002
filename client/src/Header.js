import { Link } from "react-router-dom";
import styled from "styled-components";
import { useState } from "react";
function Header() {
  const [isLogin, setIsLogin] = useState(true); //로그인 상태 구별 true로 바꿀 경우 기존 헤더
  return (
    <>
      {isLogin === false ? (
        <Main>
          <div className="header-container">
            <a className="flex align nonLogin-img">
              <span className="marginUp">
                <Link to="/">
                  <svg width="150" height="30" viewBox="0 0 187 37">
                    <path
                      d="m42 23-2.2-.2c-1.7-.1-2.3-.8-2.3-2 0-1.4 1-2.2 3-2.2 1.3-.1 2.6.3 3.6 1.1l1.3-1.3c-1.4-1-3.1-1.5-4.8-1.4-2.9 0-4.9 1.5-4.9 3.9 0 2.2 1.4 3.4 4 3.6l2.2.2c1.6.1 2.2.8 2.2 2 0 1.6-1.4 2.4-3.6 2.4-1.6.1-3.1-.5-4.2-1.6L35 28.8c1.5 1.4 3.5 2 5.5 1.9 3.2 0 5.5-1.5 5.5-4.1 0-2.6-1.6-3.4-4-3.6Zm15.8-6.1c-2.2 0-3.5.4-4.7 1.9l1.3 1.3c.8-1.1 2.1-1.7 3.4-1.5 2.5 0 3.4 1 3.4 2.9v1.3h-4c-3 0-4.6 1.5-4.6 3.9 0 1 .3 2 1 2.7.8.9 1.9 1.2 3.8 1.2 1.4.1 2.9-.4 3.9-1.4v1.3h2v-9.1c-.1-2.9-1.9-4.5-5.5-4.5Zm3.4 8.9c.1.8-.1 1.7-.7 2.3a4 4 0 0 1-3 .9c-2.1 0-3.1-.7-3.1-2.3 0-1.6 1-2.4 3-2.4h3.8v1.5Zm9.7-7.1c1.2 0 2.4.5 3.1 1.5l1.3-1.3a5.4 5.4 0 0 0-4.4-2c-3.4 0-5.9 2.3-5.9 6.9 0 4.6 2.6 6.9 5.9 6.9 1.7.1 3.3-.7 4.4-2L74 27.4c-.7 1-1.9 1.5-3.1 1.5-1.2.1-2.4-.5-3.1-1.5-.7-1.1-1-2.3-.9-3.6-.1-1.3.2-2.5.9-3.6.7-1 1.9-1.6 3.1-1.5Zm16.8-1.6h-2.4L79.2 23V11.1h-2v19.4h2v-4.9l2.4-2.4 4.5 7.3h2.4l-5.6-8.6 4.8-4.8Zm9.2-.16c-1.6-.1-3.2.5-4.3 1.7-1.3 1.3-1.6 2.9-1.6 5.4 0 2.5.3 4.1 1.6 5.4 1.1 1.1 2.7 1.7 4.3 1.7 1.6.1 3.2-.5 4.3-1.7 1.3-1.3 1.6-2.9 1.6-5.4 0-2.5-.3-4.1-1.6-5.4a5.38 5.38 0 0 0-4.3-1.7Zm1.7 10.5c-.9.8-2.3.8-3.2 0-.7-.7-.8-2-.8-3.4s.1-2.7.8-3.4c.9-.8 2.3-.8 3.2 0 .7.7.8 1.9.8 3.4s-.1 2.7-.8 3.4Zm13.6-10.4-2.8 8.6-2.8-8.6h-3.7l5.2 14h2.7l5.1-14h-3.7Zm9.6-.1c-3.6 0-6.1 2.6-6.1 7.1 0 5.7 3.2 7.2 6.5 7.2 2 .1 4-.7 5.3-2.2l-2.1-2.1c-.8.9-2 1.4-3.2 1.3-1.6.1-3-1.1-3.1-2.7v-.4h8.7v-1.6c.1-3.8-2.1-6.6-6-6.6Zm-2.7 5.8c0-.5.1-1 .3-1.5.4-.9 1.3-1.4 2.3-1.4 1-.1 1.9.5 2.3 1.4.2.5.3 1 .3 1.5h-5.2Zm13.33-4.3v-1.3h-3.4v14h3.5v-8.4c-.1-1.3.8-2.4 2.1-2.6h.2c.7 0 1.4.3 1.8.8l2.6-2.6a4.1 4.1 0 0 0-3.3-1.3c-1.3-.1-2.6.4-3.5 1.4Zm7.6-2.8v15.4h3.5v-11h2.6v-2.7h-2.6v-1.5c-.1-.6.3-1.2.9-1.3h1.6v-3h-2a3.9 3.9 0 0 0-4 3.8v.3Zm20.27 1.3c-1.6-.1-3.2.5-4.3 1.7-1.3 1.3-1.6 2.9-1.6 5.4 0 2.5.3 4.1 1.6 5.4 1.1 1.1 2.7 1.7 4.3 1.7 1.6.1 3.2-.5 4.3-1.7 1.3-1.3 1.6-2.9 1.6-5.4 0-2.5-.3-4.1-1.6-5.4a5.38 5.38 0 0 0-4.3-1.7Zm1.7 10.5c-.9.8-2.3.8-3.2 0-.7-.7-.8-2-.8-3.4s.1-2.7.8-3.4c.9-.8 2.3-.8 3.2 0 .7.7.8 1.9.8 3.4s-.1 2.7-.8 3.4Zm20.7-10.4-2.3 8.6-2.9-8.6H175l-2.8 8.7-2.3-8.6h-3.7l4.3 14h2.9l2.9-8.8 2.9 8.8h3l4.3-14-3.8-.1Zm-31.22 9.8v-15.2h-3.5v15.4a3.8 3.8 0 0 0 3.6 4h2.5v-3h-1.3c-.6.1-1.1-.2-1.3-.8v-.4ZM52.7 17.4H49V13h-2v13.9c0 2 1.1 3.6 3.4 3.6h1.4v-1.7h-1c-1.3 0-1.8-.7-1.8-2v-7.7h1.9l1.8-1.7Z"
                      fill="var(--black-800)"
                    ></path>
                    <path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB"></path>
                    <path
                      d="m23.1 25.99.68-2.95-16.1-3.35L7 23l16.1 2.99ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm4.2-7.4L26 18.4l2.1-2.5L15.4 5.3l-2.1 2.5ZM21.5 0l-2.7 2 9.9 13.3 2.7-2L21.5 0ZM7 30h16v-3H7v3Z"
                      fill="#F48024"
                    ></path>
                  </svg>
                </Link>
              </span>
            </a>
            <a className="products gray nonLogin">About</a>
            <a className="products gray nonLogin">Products</a>
            <a className="products gray nonLogin">For Teams</a>
            <div className="marginUp nonLogin">
              <svg
                className="magnifyGlassF"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"></path>
              </svg>
              <input className="searchbar" type="text" placeholder="search…" />
            </div>
            <ol className="non-header-right">
              <li>
                <Link to="/login">Log in</Link>
              </li>
              <li>
                <Link to="/signup">Sign up</Link>
              </li>
            </ol>
            <ol className="padding"></ol>
          </div>
        </Main>
      ) : (
        <Main>
          <div className="header-container">
            <a className="flex align">
              <span className="marginUp">
                <Link to="/">
                  <svg width="150" height="30" viewBox="0 0 187 37">
                    <path
                      d="m42 23-2.2-.2c-1.7-.1-2.3-.8-2.3-2 0-1.4 1-2.2 3-2.2 1.3-.1 2.6.3 3.6 1.1l1.3-1.3c-1.4-1-3.1-1.5-4.8-1.4-2.9 0-4.9 1.5-4.9 3.9 0 2.2 1.4 3.4 4 3.6l2.2.2c1.6.1 2.2.8 2.2 2 0 1.6-1.4 2.4-3.6 2.4-1.6.1-3.1-.5-4.2-1.6L35 28.8c1.5 1.4 3.5 2 5.5 1.9 3.2 0 5.5-1.5 5.5-4.1 0-2.6-1.6-3.4-4-3.6Zm15.8-6.1c-2.2 0-3.5.4-4.7 1.9l1.3 1.3c.8-1.1 2.1-1.7 3.4-1.5 2.5 0 3.4 1 3.4 2.9v1.3h-4c-3 0-4.6 1.5-4.6 3.9 0 1 .3 2 1 2.7.8.9 1.9 1.2 3.8 1.2 1.4.1 2.9-.4 3.9-1.4v1.3h2v-9.1c-.1-2.9-1.9-4.5-5.5-4.5Zm3.4 8.9c.1.8-.1 1.7-.7 2.3a4 4 0 0 1-3 .9c-2.1 0-3.1-.7-3.1-2.3 0-1.6 1-2.4 3-2.4h3.8v1.5Zm9.7-7.1c1.2 0 2.4.5 3.1 1.5l1.3-1.3a5.4 5.4 0 0 0-4.4-2c-3.4 0-5.9 2.3-5.9 6.9 0 4.6 2.6 6.9 5.9 6.9 1.7.1 3.3-.7 4.4-2L74 27.4c-.7 1-1.9 1.5-3.1 1.5-1.2.1-2.4-.5-3.1-1.5-.7-1.1-1-2.3-.9-3.6-.1-1.3.2-2.5.9-3.6.7-1 1.9-1.6 3.1-1.5Zm16.8-1.6h-2.4L79.2 23V11.1h-2v19.4h2v-4.9l2.4-2.4 4.5 7.3h2.4l-5.6-8.6 4.8-4.8Zm9.2-.16c-1.6-.1-3.2.5-4.3 1.7-1.3 1.3-1.6 2.9-1.6 5.4 0 2.5.3 4.1 1.6 5.4 1.1 1.1 2.7 1.7 4.3 1.7 1.6.1 3.2-.5 4.3-1.7 1.3-1.3 1.6-2.9 1.6-5.4 0-2.5-.3-4.1-1.6-5.4a5.38 5.38 0 0 0-4.3-1.7Zm1.7 10.5c-.9.8-2.3.8-3.2 0-.7-.7-.8-2-.8-3.4s.1-2.7.8-3.4c.9-.8 2.3-.8 3.2 0 .7.7.8 1.9.8 3.4s-.1 2.7-.8 3.4Zm13.6-10.4-2.8 8.6-2.8-8.6h-3.7l5.2 14h2.7l5.1-14h-3.7Zm9.6-.1c-3.6 0-6.1 2.6-6.1 7.1 0 5.7 3.2 7.2 6.5 7.2 2 .1 4-.7 5.3-2.2l-2.1-2.1c-.8.9-2 1.4-3.2 1.3-1.6.1-3-1.1-3.1-2.7v-.4h8.7v-1.6c.1-3.8-2.1-6.6-6-6.6Zm-2.7 5.8c0-.5.1-1 .3-1.5.4-.9 1.3-1.4 2.3-1.4 1-.1 1.9.5 2.3 1.4.2.5.3 1 .3 1.5h-5.2Zm13.33-4.3v-1.3h-3.4v14h3.5v-8.4c-.1-1.3.8-2.4 2.1-2.6h.2c.7 0 1.4.3 1.8.8l2.6-2.6a4.1 4.1 0 0 0-3.3-1.3c-1.3-.1-2.6.4-3.5 1.4Zm7.6-2.8v15.4h3.5v-11h2.6v-2.7h-2.6v-1.5c-.1-.6.3-1.2.9-1.3h1.6v-3h-2a3.9 3.9 0 0 0-4 3.8v.3Zm20.27 1.3c-1.6-.1-3.2.5-4.3 1.7-1.3 1.3-1.6 2.9-1.6 5.4 0 2.5.3 4.1 1.6 5.4 1.1 1.1 2.7 1.7 4.3 1.7 1.6.1 3.2-.5 4.3-1.7 1.3-1.3 1.6-2.9 1.6-5.4 0-2.5-.3-4.1-1.6-5.4a5.38 5.38 0 0 0-4.3-1.7Zm1.7 10.5c-.9.8-2.3.8-3.2 0-.7-.7-.8-2-.8-3.4s.1-2.7.8-3.4c.9-.8 2.3-.8 3.2 0 .7.7.8 1.9.8 3.4s-.1 2.7-.8 3.4Zm20.7-10.4-2.3 8.6-2.9-8.6H175l-2.8 8.7-2.3-8.6h-3.7l4.3 14h2.9l2.9-8.8 2.9 8.8h3l4.3-14-3.8-.1Zm-31.22 9.8v-15.2h-3.5v15.4a3.8 3.8 0 0 0 3.6 4h2.5v-3h-1.3c-.6.1-1.1-.2-1.3-.8v-.4ZM52.7 17.4H49V13h-2v13.9c0 2 1.1 3.6 3.4 3.6h1.4v-1.7h-1c-1.3 0-1.8-.7-1.8-2v-7.7h1.9l1.8-1.7Z"
                      fill="var(--black-800)"
                    ></path>
                    <path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB"></path>
                    <path
                      d="m23.1 25.99.68-2.95-16.1-3.35L7 23l16.1 2.99ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm4.2-7.4L26 18.4l2.1-2.5L15.4 5.3l-2.1 2.5ZM21.5 0l-2.7 2 9.9 13.3 2.7-2L21.5 0ZM7 30h16v-3H7v3Z"
                      fill="#F48024"
                    ></path>
                  </svg>
                </Link>
              </span>
            </a>
            <a className="products gray">Products</a>
            <div className="marginUp">
              <svg
                className="magnifyGlassF"
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
      )}
    </>
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
  border-bottom: 3px solid #efefef;

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
    font-size: 13px;
    line-height: 17px;
    text-decoration: none solid rgb(35, 38, 41);
    text-align: left;
    white-space: nowrap;
    word-spacing: 0px;
    margin-top: -10px;
  }

  .magnifyGlassF {
    position: absolute;
    margin-top: 5px;
    margin-left: 5px;
  }
  .searchbar {
    width: 45vw;
    height: 10px;
    max-width: 788px;
    border: 1px solid #babfc4;
    padding: 8px 9px 8px 32px;
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
  .non-header-right {
    margin: 4px 4px 4px 4px;
    display: flex;
    list-style: none;
    align-items: flex-start;
    justify-content: flex-start;
    li {
      display: flex;
      justify-content: center;
      align-items: center;
      border-radius: 4px;
      height: 24px;
      width: 50px;
      padding: 4px 4px 4px 4px;
      margin: 1px;
      font-size: 13px;
    }
    li:first-child {
      border: 1px solid #7aa7c7;
      background-color: #e1ecf3;
      color: #2c5877;
      a {
        text-decoration: none;
      }
      a:visited {
        color: #2c5877;
      }
    }
    li:nth-child(2) {
      border: 1px solid #1095fa;
      background-color: #1095fa;
      color: #ffffff;
      a {
        text-decoration: none;
      }
      a:visited {
        color: #ffffff;
      }
    }
  }
  .nonLogin {
    margin-top: 0px;
  }
  .nonLogin-img {
    margin-top: 10px;
  }
`;

export default Header;
