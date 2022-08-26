import styled from "styled-components";
import Body from "./Body";
import Header from "./Header";
import Sidebar from "./Sidebar";
import Signup from "./Signup";

function App() {
  return (
    <AppMain>
      <div id="header">
        <Header />
      </div>
      {/* <div id="side--Body">
        <Sidebar />
        <Body />
      </div> */}
      <Signup></Signup>
    </AppMain>
  );
}

export const AppMain = styled.div`
  #side--Body {
    display: flex;
    justify-content: center;
    width: 100%;
    overflow: hidden;
  }
`;

export default App;
