import styled from "styled-components";
function Signup() {
  return (
    <Main>
      <div className="content">
        <div className="conten-body">
          <div className="content-left">
            <h1>Join the Stack Overflow community</h1>
            <div className="flex">
              <div>§</div>
              <div>Get unstuck — ask a question</div>
            </div>
            <div className="flex">
              <div>§</div>
              <div>Unlock new privileges like voting and commenting</div>
            </div>
            <div className="flex">
              <div>§</div>
              <div>Save your favorite tags, filters, and jobs</div>
            </div>
            <div className="flex">
              <div>§</div>
              <div>Earn reputation and badges</div>
            </div>
            <div>
              Collaborate and share knowledge with a private group for FREE.
              <br />
              <a>Get Stack Overflow for Teams free for up to 50 users</a>.
            </div>
          </div>
          <div className="content-right">
            <div className="buttons">
              <button className="button-top">§ Sign up with Google </button>
              <button className="button-top">§ Sign up with GitHub </button>
              <button className="button-top">§ Sign up with Facebook </button>
            </div>
            <div>
              <form>
                <div>
                  <label>Display name</label>
                  <div>
                    <input
                      type="text"
                      id="display-name"
                      name="display-name"
                      size="30"
                    />
                  </div>
                </div>
                <div>
                  <label>Email</label>
                  <div>
                    <input
                      type="email"
                      id="email"
                      name="email"
                      size="30"
                      maxlength="100"
                    />
                  </div>
                </div>
                <div>
                  <div>
                    <label>Password</label>
                  </div>
                  <div>
                    <input
                      type="password"
                      id="password"
                      name="password"
                      size="30"
                      autocomplete="off"
                    />
                  </div>
                  <p>
                    Passwords must contain at least eight characters, including
                    at least 1 letter and 1 number.
                  </p>
                </div>
                <div>봇 체크</div>
                <div>
                  <div className="flex">
                    <div>
                      <input type="checkbox" />
                    </div>
                    <div>
                      <label>
                        Opt-in to receive occasional product updates, user
                        research invitations, company announcements, and
                        digests.
                      </label>
                    </div>
                    <div>§</div>
                  </div>
                </div>
                <div>
                  <button className="button-sign">Sign up</button>
                </div>
              </form>
              <div>
                By clicking “Sign up”, you agree to our <a>terms of service</a>,{" "}
                <a>privacy policy</a> and <a>cookie policy</a>
              </div>
            </div>
            <div>
              Already have an account? <a>Log in</a>
              <div>
                Are you an employer? <a>Sign up on Talent §</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </Main>
  );
}
export const Main = styled.div`
  width: 100vw;
  background-color: #f1f2f3;
  .content {
    padding: 24px;
  }
  .conten-body {
    display: flex;
    justify-content: center;
  }
  .content-left {
    width: 421px;
  }
  .content-right {
    width: 316px;
  }

  .flex {
    display: flex;
  }
  a {
    color: #0074cc;
  }
  .buttons {
    display: flex;
    flex-direction: column;
  }
  .button-top {
    margin: 4px, 0px;
    padding: 10.4px;
    width: 316px;
    height: 38px;
  }
  .button-sign {
    width: 268px;
    height: 38px;
    padding: 10.4px;
    margin: 2px;
  }
`;

export default Signup;
