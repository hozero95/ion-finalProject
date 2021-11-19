<template>

  <body class="body_deliveryitem">
    <div class="container_my">
      <div class="header_my"></div>

      <div class="content_my">
        <div class="content_side">
          <div class="card">
            <div class="card-header" @click="ONOFF1">
              <span class="hd1">주문관리</span>
              <div style="display: inline-block; margin-left: 85px">
                <i v-if="item1bt == 0" style="float: right; cursor: pointer; " class="fas fa-chevron-up"></i>
                <i v-if="item1bt == 1" style="float: right; cursor: pointer; " class="fas fa-chevron-down"></i>
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
            <div class="card-header" @click="ONOFF2">
              <span class="hd1">활동관리</span>
              <div style="display: inline-block; margin-left: 85px">
                <i v-if="item2bt == 0" style="float: right; cursor: pointer; " class="fas fa-chevron-up"></i>
                <i v-if="item2bt == 1" style="float: right; cursor: pointer; " class="fas fa-chevron-down"></i>
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
              <span class="hd1">정보관리</span>
              <div style="display: inline-block; margin-left: 85px">
                <i v-if="item3bt == 0" style="float: right; cursor: pointer; " class="fas fa-chevron-up"></i>
                <i v-if="item3bt == 1" style="float: right; cursor: pointer; " class="fas fa-chevron-down"></i>
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
      </div>

      <div class="content_body">
        <h2 class="body_header">주문배송 조회</h2>

        <div class="body_header2">
          <span>조회기간 : {{getRecent3MonthStr()}} (최근3개월)</span>
          <!-- <span>조회설정</span> -->
        </div>

        <div class="body_content" v-if="orderList == null || orderList.length == 0">
          <img src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/del.jpg" alt="img">
          <p style="font-size: 20px;">주문내역이 없습니다.</p>
          <button class="btn cs" name="btn_ssgMain" @click="toMain()">쇼핑시작하기</button>
        </div>

        <div class="forClass" v-for="(order, index) in orderList" v-bind:key="index">
          <dl>
            <dt>
              <span class="codr_odrdeliv_odrdate notranslate" style="">{{dateFormat(order[0].orderRegdate)}}</span>
              <span>
                <em>주문번호 : </em>
                {{order[0].orderUnum}}
                / 결제수단 : {{order[0].orderType}}
              </span>
            </dt>
          </dl>

          <div class="del_box">
            <div class="del_box1">
              <em>{{isDelivery(order[0])}}</em>
            </div>
          </div>

          <div class="item_list" style="">
            <table>
              <colgroup>
                <col style="width:100px">
                <col style="width:500px">
                <col style="width:185px">
              </colgroup>

              <tbody>
                <tr name="divItemUnit" v-for="(product, index2) in order" v-bind:key="index2">
                  <td>
                    <div>
                      <span class="cursor_pointer" @click="showDetail(product.productUnum)">
                        <img :src="product.productImage01Path" alt="상품" style="width: 90px; height: 70px;">
                      </span>
                    </div>
                  </td>
                  <td>
                    <span class="cursor_pointer" @click="showDetail(product.productUnum)">{{product.productName}}</span>
                  </td>
                  <td>
                    <div>
                      <span class="blind">판매가격</span> <em class="ssg_price notranslate"
                        style="">{{wonSubstring(product.paymentPrice)}}</em> <span class="ssg_tx">원</span>
                    </div>
                    <strong>수량</strong> <em>{{product.paymentCount}}</em><span>개</span>
                  </td>
                </tr>
              </tbody>
            </table>
            <ul class="cs_button_area cus_ul" style="text-align: center;">
              <button class="cs_button_item" @click="orderCancelSure(order[0])">주문취소</button>
              <button class="cs_button_item" @click="orderChangeSure(order[0])">교환신청</button>
              <button class="cs_button_item" @click="orderReturnSure(order[0])">반품신청</button>
            </ul>
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
        orderList: null,
        sideitem1: 1,
        sideitem2: 1,
        sideitem3: 1,
        item1bt: 1,
        item2bt: 1,
        item3bt: 1,
      };
    },
    created() {
      this.pageCheck();
      this.getOrderList3Month();
    },
    methods: {
      pageCheck() {
        if (this.$store.state.jwtToken == null || this.$store.state.jwtToken == '') {
          alert("로그인이 필요합니다..");

          // this.moveScrollTop();
          if (this.$route.path !== "/login") {
            this.$router.push("/login");
            location.replace("#app");
          }
        }
      },
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
      toMain() {
        this.$router.push("/");
      },
      getRecent3MonthStr() {
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() - 2;
        var day = date.getDate() + 1;
        var str = "";

        if (month < 10) {
          str = year + "-0" + month + "-" + day + " ~ ";
        } else {
          str = year + "-0" + month + "-" + day + " ~ ";
        }

        month = month + 3;
        day = day - 1;

        if (month < 10) {
          str = str + year + "-0" + month + "-" + day;
        } else {
          str = str + year + "-" + month + "-" + day;
        }

        return str;
      },
      dateFormat(date) {
        var data = new Date(date);
        var year = data.getFullYear();
        var month = data.getMonth() + 1;
        var day = data.getDate();

        return year + "." + month + "." + day;
      },
      getOrderList3Month() {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        axios.defaults.headers.post = null;
        axios({
          url: "http://localhost:8000/api/mypage/show/orderdelivery/threemonth",
          method: "get",
          headers: headers,
          params: {
            userUnum: this.$store.state.userInfo.userUnum,
          },
        }).then(
          (res) => {
            var orderList = new Array();
            var list = new Array();
            var count = 0;
            var temp = res.data[count].orderUnum;

            for (var i = 0; i < res.data.length; i++) {
              if (temp != res.data[i].orderUnum) {
                orderList.push(list);
                list = new Array();
                temp = res.data[i].orderUnum;
                count++;
              }
              list.push(res.data[i]);
            }
            orderList.push(list);
            this.orderList = orderList;
          },
          (error) => {
            alert("주문배송 조회에 실패했습니다.");
          }
        );
      },
      isDelivery(order) {
        var status = "";

        if (order.orderStatus == 1) {
          return "취소된 주문입니다.";
        }
        if (order.deliveryUnum != null || order.deliveryUnum > 0) {
          if (order.deliveryStatus == null || order.deliveryStatus == 0) {
            status = "결제완료";
          } else if (order.deliveryStatus == 1) {
            status = "상품준비중";
          } else if (order.deliveryStatus == 2) {
            status = "배송중";
          } else if (order.deliveryStatus == 3) {
            status = "배송완료";
          } else if (order.deliveryStatus == 4) {
            status = "교환신청완료";
          } else if (order.deliveryStatus == 5) {
            status = "반품신청완료";
          }
          return "오징어택배 / " + order.deliveryUnum + " / " + status;
        }

        return "해당 주문의 결제 내역을 확인중입니다.";
      },
      orderCancelSure(order) {
        if (confirm('주문취소 하시겠습니까?')) {
          this.orderCancel(order);
        } else {
          alert('주문취소를 취소하셨습니다.');
        }
      },
      orderCancel(order) {
        this.getOrderList3Month();
        this.sleep(100);
        if (order.deliveryStatus < 2 || order.deliveryStatus == null) {

          var headers = {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + this.$store.state.jwtToken
          };

          axios.defaults.headers.post = null;
          axios({
              url: 'http://localhost:8000/api/mypage/remove/order',
              method: 'delete',
              headers: headers,
              params: {
                orderUnum: order.orderUnum
              }
            })
            .then(res => {
              alert(order.orderUnum + "번 주문이 취소되었습니다.");
              this.getOrderList3Month();
            }, error => {
              alert("주문 취소를 실패했습니다.");
            });

        } else {
          alert("배송 시작 전에만 주문취소가 가능합니다.");
        }
      },
      orderChangeSure(order) {
        if (confirm('교환신청 하시겠습니까?')) {
          this.orderChange(order);
        } else {
          alert('교환신청를 취소하셨습니다.');
        }
      },
      orderChange(order) {
        this.getOrderList3Month();
        this.sleep(100);
        if (order.deliveryStatus == 3 && order.deliveryStatus != null) {
          var headers = {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + this.$store.state.jwtToken
          };

          var body = {
            deliveryStatus: 4,
            orderUnum: order.orderUnum
          };

          axios.defaults.headers.post = null;
          axios({
              url: 'http://localhost:8000/api/mypage/replace/orderchange',
              method: 'patch',
              headers: headers,
              data: body
            })
            .then(res => {
              alert(order.orderUnum + "번 주문이 교환 신청되었습니다.");
              this.getOrderList3Month();
            }, error => {
              alert("주문 교환 신청에 실패했습니다.");
            });
        } else {
          alert("배송 완료 상태이어야 교환이 가능합니다.");
        }
      },
      orderReturnSure(order) {
        if (confirm('반품신청을 하시겠습니까?')) {
          this.orderReturn(order);
        } else {
          alert('반품신청을 취소하였습니다.');
        }
      },
      orderReturn(order) {
        this.getOrderList3Month();
        this.sleep(100);
        if (order.deliveryStatus == 3 && order.deliveryStatus != null) {
          var headers = {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + this.$store.state.jwtToken
          };

          var body = {
            deliveryStatus: 5,
            orderUnum: order.orderUnum
          };

          axios.defaults.headers.post = null;
          axios({
              url: 'http://localhost:8000/api/mypage/replace/orderreturn',
              method: 'patch',
              headers: headers,
              data: body
            })
            .then(res => {
              alert(order.orderUnum + "번 주문이 반품 신청되었습니다.");
              this.getOrderList3Month();
            }, error => {
              alert("주문 반품 신청에 실패했습니다.");
            });
        } else {
          alert("배송 완료 상태이어야 반품이 가능합니다.");
        }
      },
      showDetail(productUnum) {
        this.$store.commit('setProductUnum', productUnum);

        if (this.$route.path !== '/product') {
          this.$router.push('/product');
          location.replace('#app');
        }
      },
      sleep(delay) {
        var start = new Date().getTime();
        while (new Date().getTime() < start + delay);
      },
      wonSubstring(won) {
        return won.toLocaleString();
      }
    }
  };

</script>

<style scoped>
  .body_deliveryitem {
    height: fit-content;
  }

  /* header setting */
  .container_my {
    /* background-color: aqua; */

    height: auto;
    overflow: hidden;
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
    float: left;

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


  }

  .body_header {
    height: fit-content;
    width: 780px;
    padding: 15px 0px 13px 10px;
    border-bottom: 1px solid #203a4d;
    line-height: 30px;
  }

  .body_header2 {
    background-color: #f5f5f5;

    height: 45px;
    width: 777px;
    padding: 22px 20px 18px;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .forClass {
    margin-top: 20px;
    margin-bottom: 20px;
  }

  .body_content {
    margin-top: 50px;
    /* height: 228px; */
    width: 777px;
    text-align: center;
  }

  .cs {
    height: 40px;
    width: 200px;
    background-color: #f5f5f5;
    border: 1px solid #e0e0e0;
  }

  dl {
    height: 60px;
    width: 777px;

    display: flex;
    /* justify-content: space-between; */
    align-items: center;
    margin-top: 30px;
    border-top: 2px solid #222222;
  }

  .btn_small {
    border: none;
    background: transparent;
    font-size: 13px;
  }

  .del_box {
    background-color: powderblue;
    width: 777px;
    height: 70px;
  }

  .del_box1 {
    /* background-color: lightslategrey; */
    width: 777px;
    height: 70px;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .del_box2 {
    width: 777px;
    height: 70px;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .del_box2_ch {
    background-color: #e0e0e0;
    height: 40px;
    width: 150px;
    border-radius: 20px;
    text-align: center;
    padding-top: 8px;
    border: 1px solid;
    display: inline;
    float: left;
  }

  .item_list {
    /* background-color: #d1dadd; */
    margin-top: 20px;
    /* height: 90px; */
    width: 777px;
    border-top: 1px solid #eeeeee;
    border-bottom: 1px solid #eeeeee;
  }

  td {
    /* background-color: burlywood; */
    border: 1px solid black;
    height: 90px;
  }

  .cs_button_area {
    margin-top: 30px;
    text-align: end;
    /* background-color: aqua; */
  }

  .cs_button_item {
    border: 1px solid #e0e0e0;
    border-radius: 1px;
    background: #f5f5f5;
    width: 150px;
    height: 40px;
  }

  .codr_contit {
    padding: 10px 0;
  }

  .ty_underline {
    border-bottom: 2px solid #222;
  }

  .codr_contit_tx {
    font-size: 24px;
    font-weight: normal;
    text-align: center;
    line-height: 1.3;
    letter-spacing: -1px;
  }

  .cus_ul {
    -webkit-padding-start: 0px;
    list-style-type: none;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
  }

  li a {
    display: block;
    /* padding: 28 px 15 px 26 px 32 px; */
    /* background: url(../img/order/bu_faq_q.png) no-repeat 0 25 px; */
    font-size: 14px;
    color: #222;
    line-height: 1.29;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .codr_btn_view {
    height: 50px;
    width: 777px;
    border: 1px solid black;
  }

  .cursor_pointer {
    cursor: pointer;
  }

  /* ------------------------content_my body end-------------------------------- */

</style>
