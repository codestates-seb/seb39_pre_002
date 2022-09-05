import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";

export default function Question({ data, key, handleClick }) {
  return (
    <Body key={key}>
      <div class="left-box">
        <div className="left-text" title="Score of 0">
          <span>0</span>
          <span>votes</span>
        </div>
        <div className="left-text" title="0 answers">
          <span>0</span>
          <span>answers</span>
        </div>
        <div className="left-text" title="42 views">
          <span>42</span>
          <span>views</span>
        </div>
      </div>
      <div>
        <h3>
          <Link to={`/questions/${data.id}`}>{data.questionTitle}</Link>
        </h3>
        <div className="body-bottom">
          {/* <div>
            {data.hashtag.map((data) => (
              <a className="tags">{data}</a>
            ))}
          </div> */}
        </div>

        <div className="body-bottom-right">
          <a href="">
            <div>
              <img
                src="https://lh3.googleusercontent.com/a-/AOh14GhiOudBctF5JQSI9zwXa_r6A_uO3QDM1S3tDxxWoA=k-s32"
                alt="user avatar"
                width="16"
                height="16"
                class="s-avatar--image"
              />
            </div>
          </a>

          <div>
            <div>
              <a href="" className="name">
                {data.memberName}
              </a>
            </div>

            <ul>
              <li>
                {/* <span title="reputation score ">author reputation score</span> */}
              </li>
            </ul>
          </div>

          <time>
            {/* <a className="time" href="">
              {data.questionStatus}
              <span title="postedTime">xx sec ago</span>
            </a> */}
          </time>
        </div>
      </div>
    </Body>
  );
}

export const Body = styled.div`
  font-size: 13px;
  line-height: 17px;
  text-decoration: none solid rgb(35, 38, 41);
  /* background-color: #fdf7e2; */
  background-position: 0% 0%;
  color: #232629;
  width: 750px;
  border-bottom: 1px solid #e3e6e8;
  border-top: 1px solid #e3e6e8;
  padding: 16px 16px 16px 16px;
  display: flex;

  .left-box {
    margin: 0 10px 0 20px;
  }
  .left-text {
    display: flex;
    justify-content: flex-end;
    span {
      margin: 1px 1px 1px 2px;
    }
  }

  .tags {
    background-color: #d0e3f1;
    color: #2c5877;
    height: 23px;
    /* width: 68px; */
    border: 1px solid #ffffff;
    margin: 0 4px 4px 0;
    padding: 5px 6px 5px 5px;
  }
  .body-bottom {
    width: 655px;
    display: flex;
  }
  .body-bottom-right {
    /* padding-left: 40px; */
    justify-content: flex-end;
    display: flex;

    .name {
      color: #0074cc;
      margin-right: 2px;
    }
    .time {
      color: #525960;
      span {
        margin-left: 4px;
      }
    }
  }
  ul {
    padding-left: 0px;
  }
  li {
    list-style: none;
  }
  a {
    color: #0a95ff;
    text-decoration: none;
  }
  a:visited {
    color: #0a95ff;
  }

  h3 {
    margin: 0 20px 10px 0;
    font-weight: 450;
  }
`;

{
  /* <button className="item-button" onClick={(e) => handleClick(e, data.id)}>
  이동?
</button> */
}
