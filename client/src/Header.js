import styled from "styled-components";
function header() {
  return (
    <Main>
      <div className="header-container">
        <a>
          (이미지)stack<b>overflow</b>
        </a>
        <a className="products">Products</a>
        <input className="searchbar" type="text" placeholder="search…" />
        <ul>
          <li className="profile-link">§</li>
          <li>§</li>
          <li>§</li>
          <li>§</li>
          <li>§</li>
        </ul>
      </div>
    </Main>
  );
}
export const Main = styled.div`
  background-color: gray;
  font-size: unset;
  display: flex;
  justify-content: center;
  /* transform: translate(-25%, -25%) scale(0.5); */
  display: inline-block;

  .header-container {
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
    width: 40vw;
    height: 3vh;
    max-width: 788px;
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
`;

export default header;
