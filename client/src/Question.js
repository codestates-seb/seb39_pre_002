import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";

export default function Question({ data, key, handleClick }) {
  return (
    <Body
      id="question-summary-73515715"
      data-post-id="73515715"
      data-post-type-id="1"
    >
      <div>
        <div title="Score of 0">
          <span>0</span>
          <span>votes</span>
        </div>
        <div title="0 answers">
          <span>0</span>
          <span>answers</span>
        </div>
        <div class="s-post-summary--stats-item " title="42 views">
          <span>42</span>
          <span>views</span>
        </div>
      </div>
      <div>
        <h3>
          <Link to={`/question/${data.id}`}>{data.title}</Link>
        </h3>
        <div>
          <div>
            <a>tags(map)</a>
          </div>

          <div>
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
                <a href="">{data.memberName}</a>
              </div>

              <ul>
                <li>
                  <span title="reputation score ">author reputation score</span>
                </li>
              </ul>
            </div>

            <time>
              <a href="">
                modified / answered / asked
                <span title="postedTime">xx sec ago</span>
              </a>
            </time>
          </div>
        </div>
      </div>
    </Body>
  );
}

export const Body = styled.div`
  font-size: 13px;
  line-height: 17px;
  text-decoration: none solid rgb(35, 38, 41);
  background-color: #fdf7e2;
  background-position: 0% 0%;
  color: #232629;
  height: 106.078px;
  width: 751px;
  border-bottom: 1px solid #e3e6e8;
  padding: 16px 16px 16px 16px;
  display: flex;
`;

{
  /* <button className="item-button" onClick={(e) => handleClick(e, data.id)}>
  이동?
</button> */
}
