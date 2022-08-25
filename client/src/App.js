import styled from "styled-components";
import Body from "./Body";
import Header from "./Header";
import Sidebar from "./Sidebar";

function App() {
  return (
    <AppMain>
      <div id="header">
        <Header />
      </div>
      <div id="side--Body">
        <Sidebar />
        <Body />
      </div>
    </AppMain>
  );
}

export const AppMain = styled.div`
  #side--Body {
    display: flex;
    width: 100vw;
    height: 194vh;
  }
`;

export default App;
