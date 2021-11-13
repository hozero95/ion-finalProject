<template>

  <body class="body_review">
    <div class="container_my">
      <div class="header_my">
        <p class="user_name">#손님111</p>
        <img class="ssg_img" src="" alt="img" />
      </div>

      <div class="content_my">
        <div class="content_side">
          <div class="card">
            <div class="card-header hd1" @click="ONOFF1">
              주문관리
              <button v-if="item1bt==0" style="margin-left :85px">
                <i class="fas fa-chevron-up"></i>
              </button>
              <button v-if="item1bt==1" style="margin-left :85px">
                <i class="fas fa-chevron-down"></i>
              </button>
            </div>

            <ul class="list-group list-group-flush" v-if="sideitem1 ==1">
              <li class="list-group-item side_item">주문 관리</li>
              <li class="list-group-item side_item">배송 관리</li>
            </ul>
          </div>
          <div class="card">
            <div class="card-header hd1" @click="ONOFF2">
              활동관리
              <button v-if="item2bt==0" style="margin-left :85px">
                <i class="fas fa-chevron-up"></i>
              </button>
              <button v-if="item2bt==1" style="margin-left :85px">
                <i class="fas fa-chevron-down"></i>
              </button>
            </div>

            <ul class="list-group list-group-flush" v-if="sideitem2 ==1">
              <li class="list-group-item side_item">리뷰 관리</li>
              <li class="list-group-item side_item">QnA 관리</li>
            </ul>
          </div>
          <div class="card">
            <div class="card-header hd1" @click="ONOFF3">
              정보관리
              <button v-if="item3bt==0" style="margin-left :85px">
                <i class="fas fa-chevron-up"></i>
              </button>
              <button v-if="item3bt==1" style="margin-left :85px">
                <i class="fas fa-chevron-down"></i>
              </button>
            </div>

            <ul class="list-group list-group-flush" v-if="sideitem3 ==1">
              <li class="list-group-item side_item">회원정보 변경</li>
              <li class="list-group-item side_item">비밀번호 변경</li>
            </ul>
          </div>
        </div>

        <div class="content_body">
          <h2 class="body_header">리뷰 관리</h2>


          <div class="body_content">
            <h3 v-if="!writeReview_status && !showReview_status">미등록리뷰 n건</h3>

            <div class="content_tb">
              <table v-if="!writeReview_status && !showReview_status">
                <!-- <colgroup>
                  <col style="width: 14%" />
                  <col />
                  <col style="width: 20%" />
                  <col style="width: 17%" />
                </colgroup> -->
                <thead>
                  <tr class="th_box">
                    <th class="td_size1">주문번호</th>
                    <th class="td_size2">주문상품</th>
                    <th class="td_size3">수량</th>
                    <th class="td_size4">총 금액</th>
                    <th class="td_size5">결제일</th>
                    <th class="td_size6">리뷰쓰기</th>
                  </tr>
                </thead>

                <tbody>
                  <tr>
                    <td class="td_box" v-if="!unreview_status">
                      <p><span>구매내역이 없습니다.</span></p>
                    </td>
                  </tr>

                  <tr class="th_underbox" v-for="(unRegister, index) in unRegisters" v-bind:key="index">
                    <td class="td_size1">{{unRegister.orderUnum}}</td>
                    <td class="td_size2">{{unRegister.productName}}</td>
                    <td class="td_size3">{{unRegister.paymentCount}}</td>
                    <td class="td_size4">{{unRegister.paymentPrice}}</td>
                    <td class="td_size5">{{dateFormat(unRegister.paymentRegdate)}}</td>
                    <td class="td_size6" @click="writeReview(unRegister)">쓰기</td>
                  </tr>
                </tbody>
              </table>

              <div class="write_review" v-if="writeReview_status">

                <strong>주문번호 : </strong> {{write_review.orderUnum}}<br>
                <strong>주문상품 : </strong> {{write_review.productName}}<br>
                <div class="write_review_box">
                  <textarea name="ta_qna_modify" id="qna_modify" cols="95" rows="10" style="resize: none"
                    placeholder="리뷰를 작성해주세요." v-model="reviewWrite"></textarea>
                </div>
                <div class="add_review_button">
                  <button type="button" @click="addReview(write_review.paymentUnum)">
                    추가
                  </button>
                  <button type="button" @click="writeReviewStatus()">
                    취소
                  </button>
                </div>

              </div>



            </div>
            <br><br>
            <h3 v-if="!writeReview_status && !showReview_status">작성한리뷰 n건</h3>

            <div class="content_tb">
              <table  v-if="!writeReview_status && !showReview_status"> 
                <!-- <colgroup>
                  <col style="width: 14%" />
                  <col />
                  <col style="width: 20%" />
                  <col style="width: 17%" />
                </colgroup> -->
                <thead>
                  <tr class="th_box">
                    <th class="td_size1">주문번호</th>
                    <th class="td_size2">주문상품</th>
                    <th class="td_size3">수량</th>
                    <th class="td_size4">총 금액</th>
                    <th class="td_size5">리뷰작성일</th>
                    <th class="td_size6">리뷰보기</th>
                  </tr>
                </thead>

                <tbody>
                  <tr>
                    <td class="td_box" v-if="!review_status">
                      <p><span>작성한 리뷰가 없습니다.</span></p>
                    </td>
                  </tr>
                  <tr class="th_underbox" v-for="(register, index) in registers" v-bind:key="index">
                    <td class="td_size1">{{register.orderUnum}}</td>
                    <td class="td_size2">{{register.productName}}</td>
                    <td class="td_size3">{{register.paymentCount}}</td>
                    <td class="td_size4">{{register.paymentPrice}}</td>
                    <td class="td_size5">{{dateFormat(register.replyRegdate)}}</td>
                    <td class="td_size6" @click="showReview(register.replyUnum, register.orderUnum, register.productName)">보기</td>
                  </tr>
                </tbody>
              </table>

              <div class="show_review" v-if="showReview_status">
                <strong>주문번호 : </strong> {{show_review.orderUnum}}<br> 
                <strong>주문상품 : </strong> {{show_review.productName}} <br>
                <strong>리뷰작성일 : </strong> {{dateFormat(show_review[0].replyRegdate)}} <br>
                <div class="write_review_box">
                  <textarea name="ta_qna_modify" id="qna_modify" cols="95" rows="10" style="resize: none; border:none"
                    :value="show_review[0].replyContent" readonly></textarea>
                </div>
                <div class="add_review_button">
                  <button type="button" @click="showReviewStatus()">
                    돌아가기
                  </button>
                </div>

              </div>

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
        sideitem1: 1,
        sideitem2: 1,
        sideitem3: 1,
        item1bt: 1,
        item2bt: 1,
        item3bt: 1,
        reviewWrite: "",
        unRegisters: [],
        registers: [],
        write_review: {},
        show_review: {},
        unreview_status: false,
        review_status: false,
        writeReview_status: false,
        showReview_status: false
      }

    },
    created() {
      this.unRegister();
      this.register();
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
      dateFormat(date) {
        var regdate = new Date(date);
        var year = regdate.getFullYear();
        var month = regdate.getMonth() + 1;
        var day = regdate.getDate();

        return year + '-' + month + '-' + day;
      },
      unRegister() {
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken
        };

        axios({
            url: 'http://localhost:8000/api/mypage/show/reply/unregister',
            method: 'get',
            headers: headers,
            params: {
              userUnum: this.$store.state.userInfo.userUnum
            }
          })
          .then(res => {
            var unRegister = new Array();
            for (var i = 0; i < res.data.length; i++) {
              unRegister.push(res.data[i]);
            }
            this.unRegisters = unRegister;
            this.unreviewStatus();
            console.log(this.unRegisters);
            // console.log(this.unRegisters);
          })
      },
      register() {
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken
        };


        axios({
            url: 'http://localhost:8000/api/mypage/show/reply/register',
            method: 'get',
            headers: headers,
            params: {
              userUnum: this.$store.state.userInfo.userUnum,
            }
          })
          .then(res => {
            var register = new Array();
            for (var i = 0; i < res.data.length; i++) {
              register.push(res.data[i]);
            }
            this.registers = register;
            this.reviewStatus();
            // console.log(this.registers);
          })
      },
      unreviewStatus() {
        if (this.unRegisters.length > 0) {
          this.unreview_status = true;
        } else {
          this.unreview_status = false;
        }

      },
      reviewStatus() {
        if (this.registers.length > 0) {
          this.review_status = true;
        } else {
          this.review_status = false;
        }
      },
      writeReview(unRegister) {
        this.write_review = unRegister;
        this.writeReviewStatus()
      },
      writeReviewStatus() {
        this.writeReview_status = !this.writeReview_status;
      },
      addReview(paymentUnum) {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        var body = {
          paymentUnum: paymentUnum,
          replyContent: this.reviewWrite,
        };
        console.log(body);
        axios({
          url: "http://localhost:8000/api/mypage/regist/reply",
          method: "post",
          headers: headers,
          data: body,
        }).then(
          (res) => {
            alert("리뷰등록이 완료되었습니다.");
            this.reviewWrite="";
            this.writeReviewStatus();
            this.register();
            this.unRegister();
          },
          (error) => {
            alert("리뷰등록에 실패하였습니다.");

          }
        );
      },
      showReviewStatus() {
        this.showReview_status = !this.showReview_status;
      },
      showReview(replyUnum, orderUnum, productName) {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        axios({
          url: "http://localhost:8000/api/mypage/show/detail/reply",
          method: "get",
          headers: headers,
          params: {
            replyUnum: replyUnum
          }
        }).then(
          (res) => {
            this.show_review = res.data;
            this.show_review.orderUnum = orderUnum;
            this.show_review.productName = productName;
            this.showReviewStatus();
            console.log(this.show_review)
          },
          (error) => {
            console.log(error);
            alert('상세리뷰 불러오기 실패하였습니다.');
          }
        );
      }
    },
  };
</script>

<style scoped>
  .body_review {
    height: 1000px;

  }

  /* header setting */

  .container_my {
    /* background-color: aqua; */


    margin-top: 30px;
    margin-left: auto;
    margin-right: auto;
    border-right: 1px solid #d1dadd;
    border-left: 1px solid #d1dadd;
    width: 1020px;
    height: 1000px;
    /* fit content 사용시 풋터가 올라오는 에러 발생  height 고정값 주기*/
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
    display: inline-block
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

  .body_content {
    /* background-color: aquamarine; */
    margin-top: 30px;
    height: 207px;
    width: 777px;
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
    /* width: 777px; */
    /* height: 100px; */
    /* border-bottom: 1px solid #203a4d; */
    display: flex;
    justify-content: center;
    align-items: center;
  }

  /* ------------------------content_my body end-------------------------------- */

  .td_size1 {
    width: 100px;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .td_size2 {
    width: 300px;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .td_size3 {
    width: 40px;
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

  .td_size5 {
    width: 100px;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .td_size6 {
    width: 100px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>