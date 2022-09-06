import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useEffect, useState } from "react";
import Body from "./Body";
import Header from "./Header";
import Signup from "./Signup";
import CreateQuestion from "./CreateQuestion";
import QuestionDetail from "./QuestionDetail";
import ModifyQuestion from "./ModifyQuestion";
import Login from "./Login";

function App() {
  const [data, setData] = useState(null);
  useEffect(() => {
    // fetch("http://localhost:3001/data")
    fetch("http://15.164.53.160:8080/v1/questions")
      .then((res) => {
        return res.json();
      })
      .then((data) => {
        setData(data[Object.keys(data)[0]]);
        // setData(data);
      });
  }, []);

  return (
    <BrowserRouter>
      <Header />
      <div>
        <Routes>
          <Route path="/" element={<Body data={data} />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/login" element={<Login />} />
          <Route path="/create" element={<CreateQuestion />} />
          <Route path="/questions/:id/modify" element={<ModifyQuestion />} />
          <Route path="/questions/:id" element={<QuestionDetail />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
