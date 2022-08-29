import { useEffect, useState } from "react";
import styled from "styled-components";
import Body from "./Body";
import Header from "./Header";
import Sidebar from "./Sidebar";
import Signup from "./Signup";

function App() {
  const [data, setData] = useState(null);
  useEffect(() => {
    fetch("http://localhost:3001/data")
      .then((res) => {
        return res.json();
      })
      .then((data) => {
        setData(data);
      });
  }, []);

  return (
    <AppMain>
      <div id="header">
        <Header />
      </div>
      <div id="side--Body">
        <Sidebar />
        <Body data={data} />
      </div>
      {/* <Signup /> */}
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
