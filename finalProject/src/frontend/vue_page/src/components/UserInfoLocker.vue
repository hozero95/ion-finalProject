<template>
  <body>
    <div class="container_my">
      <div class="header_my"></div>

      <div class="content_my">
        <div class="content_side">
          <div class="card">
            <div class="card-header hd1" @click="ONOFF1">
              주문관리
              <div style="display: inline-block; margin-left: 85px">
                <i
                  v-if="item1bt == 0"
                  style="float: right"
                  class="fas fa-chevron-up"
                ></i>
                <i
                  v-if="item1bt == 1"
                  style="float: right"
                  class="fas fa-chevron-down"
                ></i>
              </div>
            </div>

            <ul class="list-group list-group-flush" v-if="sideitem1 == 1">
              <router-link to="deliveryitem" class="router_link side_item">
                <li class="list-group-item side_item" style="border: none">
                  주문/배송 관리
                </li>
              </router-link>
            </ul>
          </div>
          <div class="card">
            <div class="card-header hd1" @click="ONOFF2">
              활동관리
              <div style="display: inline-block; margin-left: 85px">
                <i
                  v-if="item2bt == 0"
                  style="float: right"
                  class="fas fa-chevron-up"
                ></i>
                <i
                  v-if="item2bt == 1"
                  style="float: right"
                  class="fas fa-chevron-down"
                ></i>
              </div>
            </div>

            <ul class="list-group list-group-flush" v-if="sideitem2 == 1">
              <router-link to="review" class="router_link side_item">
                <li class="list-group-item side_item" style="border: none">
                  리뷰 관리
                </li>
              </router-link>
              <router-link to="qna" class="router_link side_item">
                <li class="list-group-item side_item" style="border: none">
                  Q&A 관리
                </li>
              </router-link>
            </ul>
          </div>
          <div class="card">
            <div class="card-header hd1" @click="ONOFF3">
              정보관리
              <div style="display: inline-block; margin-left: 85px">
                <i
                  v-if="item3bt == 0"
                  style="float: right"
                  class="fas fa-chevron-up"
                ></i>
                <i
                  v-if="item3bt == 1"
                  style="float: right"
                  class="fas fa-chevron-down"
                ></i>
              </div>
            </div>

            <ul class="list-group list-group-flush" v-if="sideitem3 == 1">
              <router-link to="userinfolocker" class="router_link side_item">
                <li class="list-group-item side_item" style="border: none">
                  회원정보 변경
                </li>
              </router-link>
              <router-link to="pwchange" class="router_link side_item">
                <li class="list-group-item side_item" style="border: none">
                  회원 탈퇴
                </li>
              </router-link>
            </ul>
          </div>
        </div>

        <div class="content_body">
          <h2 class="body_header"><span>회원정보 변경</span></h2>

          <div class="section notice_txt">
            <p>
              고객님의 개인정보를 소중하게 보호하려고 노력하고 있으며,<br />
              회원님의 동의 없이는 입력하신 회원정보를 제공하지 않습니다.
            </p>
          </div>
          <div class="information">
            <p class="notifications">
              고객님의 개인정보 보호를 위해 비밀번호를 다시 한번 입력해 주시기
              바랍니다.
            </p>
          </div>

          <form id="submitForm" method="POST">
            <div class="password_change">
              <div class="wrap">
                <label for="password" class="label">비밀번호 : </label>
                <input
                  type="password"
                  id="password"
                  name="password"
                  title="비밀번호"
                  value=""
                  class="input_text small"
                  style="width: 270px"
                  v-model="passwordVal"
                />
                <span class="error_txt small warning"></span>
              </div>
            </div>
            <div class="btn_area">
              <router-link to="">
                <button @click="passwordTrue()" id="submitBtn" class="cs_btn">
                  확인
                </button>
              </router-link>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      sideitem1: 1,
      sideitem2: 1,
      sideitem3: 1,
      item1bt: 1,
      item2bt: 1,
      item3bt: 1,
      passwordVal: "",
    };
  },
  methods: {
    ONOFF1() {
      if (this.sideitem1 == 0) {
        this.sideitem1 = 1;
        this.item1bt = 1;
      } else if (this.sideitem1 == 1) {
        this.sideitem1 = 0;
        this.item1bt = 0;
      }
    },
    ONOFF2() {
      if (this.sideitem2 == 0) {
        this.sideitem2 = 1;
        this.item2bt = 1;
      } else if (this.sideitem2 == 1) {
        this.sideitem2 = 0;
        this.item2bt = 0;
      }
    },
    ONOFF3() {
      if (this.sideitem3 == 0) {
        this.sideitem3 = 1;
        this.item3bt = 1;
      } else if (this.sideitem3 == 1) {
        this.sideitem3 = 0;
        this.item3bt = 0;
      }
    },
    passwordTrue() {
      axios
        .post("http://localhost:8000/api/signin", {
          userId: this.$store.state.userInfo.userId,
          userPassword: this.passwordVal,
        })
        .then(
          (res) => {
            // console.log(res);
            if (this.$route.path !== "/userinfochange") {
              this.$router.push("/userinfochange");
            }
          },
          (error) => {
            alert("비밀번호가 잘못되었습니다.");
            if (this.$route.path !== "/userinfolocker") {
              this.$router.push("/userinfolocker");
            }
          }
        );
    },
  },
};
</script>

<style scoped>
.container_my {
  height: auto;
  overflow: hidden;
/* fit content 사용시 풋터가 올라오는 에러 발생  height 고정값 주기*/
/* 최상위 부모의 영역 설정은 이걸로하면 잘 구성됨 */
  margin-top: 30px;
  margin-left: auto;
  margin-right: auto;
  border-right: 1px solid #d1dadd;
  border-left: 1px solid #d1dadd;
  width: 1020px;

  
}

.header_my {
  background-color: #f3fafe;
  border-bottom: 3px solid #203a4d;
  width: 1018px;
  height: 94px;
  
}

.header_tag {
  /* background-color: aquamarine; */
  height: 37px;
  width: 139px;
  float: left;
  margin: 8px 0px 8px 0px;
  padding: 32px 15px 9px 18px;
}

.user_name {
  height: 17.5px;
  width: 53.5px;
  font-size: 12px;
}

.ssg_img {
  height: 37px;
  width: 139px;
}

/* content area */
/* content_side setting  + content_body setting*/

.content_my {
  width: 1018px;
  height: fit-content;
  /* border : solid 3px red; */
}

.content_side {
  /* background-color: aqua; */
  float: left;
  width: 200px;
  height: 600px;
}

.btn_size {
  width: 200px;
  height: 60px;
}

/* ------------------------side bar start-------------------------------- */
.hd1 {
  cursor: pointer;
}

.side_item {
  background-color: #f3fafe;
}

.side_item:hover {
  background-color: cadetblue;
  display: inline-block;
}

.side_item:active {
  background-color: lightskyblue;
}

/* ------------------------side bar end-------------------------------- */
/* ------------------------content_my body start-------------------------------- */
.content_body {
  /* background-color: lightgray; */
  float: left;
  margin-left: 35px;
  width: 777px;
  height: 600px;
}

.body_header {
  height: fit-content;
  width: 780px;
  padding: 15px 0px 13px 10px;
  border-bottom: 1px solid #203a4d;
  line-height: 30px;
}

p {
  display: block;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}

.notice_txt {
  border-bottom: 1px solid #69696a;
  text-align: center;
}

.information {
  position: relative;
  margin-top: 20px;
  font-family: "Spoqa-Regular", -apple-system, BlinkMacSystemFont,
    "Apple SD Gothic Neo", Arial, sans-serif;
  font-size: 11px;
  color: #777;
  letter-spacing: -1px;
  text-align: left;
}

.password_change {
  position: relative;
  height: 100px;
  margin-top: 30px;
  padding: 10px 0 30px 200px;
  border-top: 1px solid #e3e3e3;
  border-bottom: 1px solid #e3e3e3;
  background-color: #fbfbfb;
  display: flex;
  align-items: center;
}

.wrap {
  margin-top: 10px;
}

.btn_area {
  text-align: center;
  margin-top: 30px;
}

.cs_btn {
  background: #f14f4f;
  border: 1px solid #da3a3a;
  color: #fff;
  min-width: 130px;
  padding: 11px 16px;
  text-align: center;
}

/* ------------------------content_my body end-------------------------------- */
</style>