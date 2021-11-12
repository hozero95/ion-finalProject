<template>
  <body>
    <div class="container_my">
      <div class="header_my">
        <p class="user_name">#손님</p>
        <img class="ssg_img" src="" alt="img" />
      </div>

      <div class="content_my">
        <div class="content_side">
          <div
            class="btn-group-vertical"
            role="group"
            aria-label="Button group with nested dropdown"
          >
            <div class="btn-group" role="group">
              <button
                id="btnGroupDrop1"
                type="button"
                class="btn btn-primary dropdown-toggle btn_size"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                주문관리
              </button>
              <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <li><a class="dropdown-item" href="#">주문/배송관리</a></li>
                <li><a class="dropdown-item" href="#"></a></li>
              </ul>
            </div>

            <div class="btn-group btn_size" role="group">
              <button
                id="btnGroupDrop1 "
                type="button"
                class="btn btn-primary dropdown-toggle btn_size"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                활동관리
              </button>
              <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <li><a class="dropdown-item" href="#">리뷰관리</a></li>
                <li><a class="dropdown-item" href="#">Q&A관리</a></li>
              </ul>
            </div>

            <div class="btn-group" role="group">
              <button
                id="btnGroupDrop1"
                type="button"
                class="btn btn-primary dropdown-toggle btn_size"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                정보관리
              </button>
              <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <li><a class="dropdown-item" href="#">회원정보 변경</a></li>
                <li><a class="dropdown-item" href="#">비밀번호 변경</a></li>
              </ul>
            </div>
          </div>
        </div>

        <div class="content_body">
          <h2 class="body_header">Q&A</h2>

          <ul style="font-size: 12px; margin-top: 30px">
            <li>
              상품과 관련없는 내용, 비방, 광고, 불건전한 내용의 글은 사전 동의
              없이 삭제될 수 있습니다.
            </li>
            <li>고객님께서 상품상세에서 Q&A에 작성하신 내용입니다.</li>
          </ul>

          <div class="body_content">
            <button
              class="qnaadd"
              v-if="add_qna && showComment"
              @click="addQnaStatus()"
              type="button"
            >
              +
            </button>
            <div class="content_tb">
              <table>
                <!-- <colgroup>
                  <col style="width:276px">
                  <col style="width:324px">
                  <col style="width:99px">
                  <col>
                </colgroup> -->
                <thead v-if="add_qna && showComment">
                  <tr class="th_box">
                    <th class="td_size1">제목</th>
                    <th class="td_size2">내용</th>
                    <th class="td_size3"><span>작성일</span></th>
                    <th class="td_size4"><span>답변</span></th>
                  </tr>
                </thead>

                <div
                  style="height: 250px; overflow-y: scroll; positon: relative"
                >
                  <tbody v-if="add_qna && showComment">
                    <tr v-if="qnais">
                      <td class="td_box">
                        <p><span>작성된 Q&A가 없습니다.</span></p>
                      </td>
                    </tr>

                    <tr
                      class="th_underbox"
                      v-for="(qna, index) in qnas"
                      v-bind:key="index"
                    >
                      <td class="td_size1">
                        {{ titleSubstring(qna.qnaTitle) }}
                      </td>
                      <td class="td_size2" @click="showContComm(qna)">
                        {{ contentSubstring(qna.qnaContent) }}
                      </td>
                      <td class="td_size3">{{ dateFormat(qna.qnaRegdate) }}</td>
                      <td class="td_size4" v-if="qna.resComment != null">O</td>
                      <td class="td_size4" v-if="qna.resComment == null">X</td>
                    </tr>
                  </tbody>
                  <div
                    class="add_qna"
                    v-if="!add_qna && showComment"
                    style="position: absolute"
                  >
                    <textarea
                      name="ta_qna_modify"
                      placeholder="제목"
                      id="qna_modify"
                      cols="95"
                      rows="1"
                      style="resize: none"
                      v-model="title"
                    ></textarea
                    ><br />
                    <textarea
                      name="ta_qna_modify"
                      placeholder="내용"
                      id="qna_modify"
                      cols="95"
                      rows="11"
                      style="resize: none"
                      v-model="content"
                    ></textarea
                    ><br />
                    <div class="add_qna_button">
                      <button type="button" @click="addQnaConfirm()">
                        추가
                      </button>
                      <button type="button" @click="addQnaStatus()">
                        취소
                      </button>
                    </div>
                  </div>
                </div>

                <br />

                <div class="add_comment" v-if="!showComment && add_qna">
                  <div class="add_comment_box">
                    <div class="qnatitle">
                      <strong>제목 : </strong>{{ contComm.qnaTitle }}
                    </div>

                    <strong>내용 : </strong>
                    <div class="qnacontent">
                      <textarea
                        name="ta_qna_modify"
                        id="qna_modify"
                        cols="95"
                        rows="3"
                        style="resize: none; border: none"
                        :value="contComm.qnaContent"
                        readonly
                      ></textarea
                      ><br />
                    </div>

                    <div v-if="resContentis" class="contentres">
                      &nbsp; &nbsp; &nbsp;<strong>↳</strong>
                      <strong>답변 : </strong> {{ contComm.resContent }}
                    </div>

                    <div class="add_qna_button">
                      <button type="button" @click="allContCommStatus()">
                        돌아가기
                      </button>
                    </div>
                  </div>
                </div>
              </table>
            </div>
          </div>
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
      qnas: [],
      qnais: true,
      add_qna: true,
      showComment: true,
      resContentis: false,
      title: "",
      content: "",
      comment_title: "",
      comment_content: "",
      qna_comment: "",
      contComm: {},
    };
  },
  created() {
    this.showqna();
  },
  // computed: {
  //   setUserUnum() {
  //     return this.$store.state.userUnum;
  //   }
  // },
  // watch: {
  //   setUserUnum() {
  //     this.userUnum = this.setUserUnum;
  //   }
  // },
  methods: {
    showqna() {
      this.add_qna = true;
      this.showComment = true;

      var headers = {
        "Content-Type": "application/json",
        Authorization: "Bearer " + this.$store.state.jwtToken,
      };

      axios({
        url: "http://localhost:8000/api/mypage/show/qna",
        method: "get",
        headers: headers,
        params: {
          userUnum: this.$store.state.userInfo.userUnum,
        },
      }).then(
        (res) => {
          console.log(res);
          var qna = new Array();
          for (var i = 0; i < res.data.length; i++) {
            qna.push(res.data[i]);
          }
          this.qnas = qna;
          this.qnaMessage();
        },
        (error) => {
          console.log(error);
        }
      );
    },
    qnaMessage() {
      if (this.qnas.length > 0) {
        this.qnais = false;
      } else {
        this.qnais = true;
      }
    },
    dateFormat(date) {
      var regdate = new Date(date);
      var year = regdate.getFullYear();
      var month = regdate.getMonth() + 1;
      var day = regdate.getDate();

      return year + "-" + month + "-" + day;
    },
    toDate(date) {
      return new Date(date).toLocaleDateString("en-US");
    },
    addQnaStatus() {
      this.add_qna = !this.add_qna;
    },
    addQnaConfirm() {
      var headers = {
        "Content-Type": "application/json",
        Authorization: "Bearer " + this.$store.state.jwtToken,
      };

      var body = {
        userUnum: this.$store.state.userInfo.userUnum,
        qnaTitle: this.title,
        qnaContent: this.content,
      };

      axios({
        url: "http://localhost:8000/api/mypage/regist/qna",
        method: "post",
        headers: headers,
        data: body,
      }).then(
        (res) => {
          alert("질문등록이 완료되었습니다.");
          this.showqna();
          this.title = "";
          this.content = "";
          this.addQnaStatus();
        },
        (error) => {
          alert("질문등록에 실패하였습니다.");
          this.addQnaStatus();
        }
      );
    },
    contentSubstring(str) {
      if (str.length > 15) {
        str = str.substring(0, 15) + "...";
      }
      return str;
    },
    titleSubstring(str) {
      if (str.length > 5) {
        str = str.substring(0, 5) + "...";
      }
      return str;
    },
    allContCommStatus() {
      this.showComment = !this.showComment;
    },
    showContComm(qna) {
      this.contComm = qna;
      if (this.contComm.resContent != null) {
        this.resContentis = true;
      } else {
        this.resContentis = false;
      }
      this.allContCommStatus();
    },
  },
};
</script>

<style scope>
/* header setting */
.container_my {
  /* background-color: aqua; */

  margin-top: 30px;
  margin-left: auto;
  margin-right: auto;
  border-right: 1px solid #d1dadd;
  border-left: 1px solid #d1dadd;
  width: 1020px;
  height: 900px;
}

.header_my {
  background-color: #f3fafe;
  border-bottom: 3px solid #203a4d;
  width: 1018px;
  height: 94px;
  margin: 20px 0px 20px 0px;
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
  height: 700px;
  border: solid 3px red;
}

.content_side {
  /* background-color: aqua; */
  float: left;
  width: 200px;
  height: 600px;
  border-right: solid 1px #d1dadd;
}

.btn_size {
  width: 200px;
  height: 60px;
  border: solid 1px #d1dadd;
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

.body_content {
  /* background-color: aquamarine; */
  margin-top: 30px;
  height: 207px;
  width: 777px;
}

.qnaadd {
  font-size: 30px;
  margin-left: 650px;
}

.add_qna_button {
  margin-left: 660px;
}

.content_tb {
  /* background-color: brown; */
}

.blind {
  display: none;
}

h2 {
  margin: 0px;
  padding: 0px;
  display: block;
  font-size: 26px;
}

h3 {
  font-size: 20px;
  margin-top: 20px;
}

thead {
  /* background: red; */
  height: 18px;
  width: 80px;
  padding: 15px;
  border-bottom: 1px solid #ededed;
  color: #222;
  font-size: 12px;
}

.th_box {
  background-color: lightgray;
  height: 40px;
  border-top: 3px solid #203a4d;
  border-bottom: 3px solid #203a4d;
  display: flex;
  /* justify-content: space-around; */
  align-items: center;
  text-align: center;
}

.th_underbox {
  /* background-color: lightgray; */
  height: 40px;
  /* border-top: 1px solid #203a4d; */
  border-bottom: 1px solid #203a4d;
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.td_box {
  /* height: 100px; */
  /* border-bottom: 1px solid #203a4d; */
  display: flex;
  justify-content: center;
  align-items: center;
}

.td_size1 {
  width: 150px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.td_size2 {
  width: 320px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.td_size3 {
  width: 150px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.td_size4 {
  width: 100px;
  display: flex;
  justify-content: center;
  align-items: center;
}

/* ------------------------content_my body end-------------------------------- */
</style>