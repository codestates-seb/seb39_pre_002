import styled from "styled-components";
function Sidebar() {
  return (
    <Main>
      <div>
        <ol>
          <li>
            <ol>
              <a>
                <div>Home</div>
              </a>
            </ol>
          </li>
          <li>
            <ol>
              <li>PUBLIC</li>
              <li>Questions</li>
              <li>Tags</li>
              <li>Users</li>
              <li>Companies</li>
              <li>COLLECTIVES</li>
              <li>Explore Collectives</li>
            </ol>
          </li>
          <li>
            <ol>
              <li>TEAMS</li>
              <li>Create free team</li>
            </ol>
          </li>
        </ol>
      </div>
    </Main>
  );
}
export const Main = styled.div`
  background-color: gray;
  ol {
    list-style: none;
    margin-top: 30px;
  }
`;
export default Sidebar;
