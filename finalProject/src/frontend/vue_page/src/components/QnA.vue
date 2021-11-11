<template>

  <body>
    <div class="container_my">

      <div class="header_my">


        <p class="user_name">#손님</p>
        <img class="ssg_img" src="" alt="img">


      </div>

      <div class="content_my">




        <div class="content_side">
          <div class="btn-group-vertical" role="group" aria-label="Button group with nested dropdown">

            <div class="btn-group " role="group">
              <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle btn_size"
                data-bs-toggle="dropdown" aria-expanded="false">
                주문관리
              </button>
              <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <li><a class="dropdown-item" href="#">주문/배송관리</a></li>
                <li><a class="dropdown-item" href="#"></a></li>
              </ul>
            </div>

            <div class="btn-group btn_size" role="group">
              <button id="btnGroupDrop1 " type="button" class="btn btn-primary dropdown-toggle btn_size"
                data-bs-toggle="dropdown" aria-expanded="false">
                활동관리
              </button>
              <ul class="dropdown-menu " aria-labelledby="btnGroupDrop1">
                <li><a class="dropdown-item " href="#">리뷰관리</a></li>
                <li><a class="dropdown-item" href="#">Q&A관리</a></li>
              </ul>

            </div>

            <div class="btn-group" role="group">

              <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle btn_size"
                data-bs-toggle="dropdown" aria-expanded="false">
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

          <ul style="font-size: 12px; margin-top: 30px;">
            <li>상품과 관련없는 내용, 비방, 광고, 불건전한 내용의 글은 사전 동의 없이 삭제될 수 있습니다.</li>
            <li>고객님께서 상품상세에서 Q&A에 작성하신 내용입니다.</li>
          </ul>

          <div class="body_content">
            <button id="qnaadd" type="button">+</button>
            <div class="content_tb">
              <table>
                <!-- <colgroup>
                  <col style="width:276px">
                  <col style="width:324px">
                  <col style="width:99px">
                  <col>
                </colgroup> -->
                <thead>
                  <tr class="th_box">
                    <th class="td_size1">제목</th>
                    <th class="td_size2">내용</th>
                    <th class="td_size3"><span>작성일</span></th>
                    <th class="td_size4"><span>답변상황</span></th>
                  </tr>
                </thead>

                <tbody>
                  <tr v-if="qnais">
                    <td class="td_box">
                      <p><span>작성하신 상품 Q&A가 없습니다.</span></p>
                    </td>

                  </tr>
                  <tr class="th_underbox" v-for="(qna, index) in qnas" v-bind:key="index">
                    <td class="td_size1">{{qna.qnaTitle}}</td>
                    <td class="td_size2">{{qna.qnaContent}}</td>
                    <td class="td_size3">{{toDate(qna.qnaRegdate)}}</td>
                    <td class="td_size4">{{qna.qnaConment}}</td>
                  </tr>
                </tbody>

              </table>
            </div>
          </div>


        </div>

      </div>


    </div>
  </body>
</template>

<script>
  import axios from 'axios'

  export default {

    data() {
      return {
        userUnum: null,
        qnas: [],
        qnais: true
      }
    },
    created() {
      this.userUnum = this.$store.state.userUnum;
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
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken
        };

        axios({
            url: 'http://localhost:8000/api/mypage/show/qna',
            headers: headers,
            params: {
              userUnum: this.$store.state.userInfo.userUnum
            }
          })
          .then(res => {
            var qna = new Array();
            for (var i = 0; i < res.data.length; i++) {
              qna.push(res.data[i]);
            }
            this.qnas = qna;
            this.qnamessage();
          })
      },
      qnamessage() {
        if (this.qnas.length > 0) {
          this.qnais = false;
        } else {
          this.qnais = true;
        }
      },
      dateFormat(date) {
        var regdate = date;
        var year = regdate.getFullYear();
        var month = ('0' + (regdate.getMonth() + 1)).slice(-2);
        var day = ('0' + today.getDate()).slice(-2);

        return year + '-' + month + '-' + day;
      },
      toDate(date) {
        return new Date(date).toLocaleDateString('en-US');
      }
    },

  }
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
    background-color: #F3FAFE;
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

  #qnaadd {
    font-size: 30px;
    margin-left: 700px;
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