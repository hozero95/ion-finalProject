<template>

  <body>
    <div class="content_my">
      <div class="header_my"></div>

      <!-- <div class="deliver_header">
        <span class="deliver_img"
          ><img
            src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/deimg.jpg"
            alt="ss"
        /></span>
        <li class="deliver_img step1">
          <span
            ><img
              src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/deimg2.jpg"
              alt="ss"
          /></span>
        </li>
        <li class="deliver_img step2">
          <span
            ><img
              src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/deimg3.jpg"
              alt="ss"
          /></span>
        </li>
        <li class="deliver_img step3">
          <span
            ><img
              src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/deimg4.jpg"
              alt="ss"
          /></span>
        </li>
        <li class="deliver_img step4">
          <span
            ><img
              src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/deimg5.jpg"
              alt="ss"
          /></span>
        </li>

        <router-link to=""></router-link>
      </div> -->

      <div>
        <div class="content_box right_line">
          <div class="content_box_item">
            <router-link to="userinfolocker" class="router_link">
              <div class="i_box">
                <i class="far fa-address-card fa-5x"></i>
              </div>
              <div class="text_box">
                <h4>회원정보 변경</h4>
                <!-- <p>ddddddddddddddd</p> -->
              </div>
            </router-link>
          </div>
        </div>

        <div class="content_box right_line">
          <div class="content_box_item">
            <router-link to="pwchange" class="router_link">
              <div class="i_box">
                <i class="fas fa-user-lock fa-5x"></i>
              </div>
              <div class="text_box">
                <h4>회원 탈퇴</h4>
                <!-- <p>ddddddddddddddd</p> -->
              </div>
            </router-link>
          </div>
        </div>

        <div class="content_box">
          <div class="content_box_item">
            <router-link to="deliveryitem" class="router_link">
              <div class="i_box">
                <i class="fas fa-truck fa-5x"></i>
              </div>
              <div class="text_box">
                <h4>주문/배송조회</h4>
                <!-- <p>ddddddddddddddd</p> -->
              </div>
            </router-link>
          </div>
          <!-- 주문상품이있다면 to = deliveryitem 으로가야함 데이터바인딩해서 vue 문법으로 다뤄야함 -->
        </div>
      </div>

      <div class="content_box2 right_line">
        <div class="content_box_item">
          <router-link to="review" class="router_link">
            <div class="i_box bigbox">
              <i class="fas fa-comments fa-7x"></i>
            </div>
            <div class="text_box">
              <h4>리뷰관리</h4>
              <!-- <p>ddddddddddddddd</p> -->
            </div>
          </router-link>
        </div>
      </div>

      <div class="content_box2">
        <div class="content_box_item">
          <router-link to="QnA" class="router_link">
            <div class="i_box bigbox">
              <i class="fas fa-question fa-7x"></i>
            </div>
            <div class="text_box">
              <h4>QnA관리</h4>
              <!-- <p>ddddddddddddddd</p> -->
            </div>
          </router-link>
        </div>
      </div>

      <div class="img_box">
        <router-link to="event">
          <img src="https://raw.githubusercontent.com/sky4564/img/master/마이페이지/event1.jpeg" alt="event"
            class="event_img right_line" />
        </router-link>
        <router-link to="event">
          <img src="https://raw.githubusercontent.com/sky4564/img/master/마이페이지/event2.jpeg" alt="event"
            class="event_img" />
        </router-link>
      </div>
    </div>
  </body>
</template>

<script>
  export default {
    created() {
      this.pageCheck();
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
    }
  };

</script>

<style scoped>
  /* box sizing */
  .content_my {
    /* background-color: aqua; */

    margin-top: 30px;
    margin-left: auto;
    margin-right: auto;
    border-right: 1px solid #d1dadd;
    border-left: 1px solid #d1dadd;
    width: 1018px;
    height: fit-content;
  }

  .header_my {
    background-color: #80adcc;
    border-bottom: 3px solid #203a4d;
    width: 1015px;
    height: 94px;
  }

  .deliver_header {
    width: 1020px;
    height: 170px;
    border-bottom: 1px solid #ccd6da;
    display: flex;
    justify-content: center;
  }

  .deliver_img {
    float: left;
    padding: 30px;
    list-style-type: "\27A1";
    list-style-position: outside;
  }

  .right_line {
    border-right: 1px solid #ccd6da;
  }

  .router_link {
    text-decoration: none;
  }

  .content_box {
    height: 285px;
    width: 370px;
    display: table-cell;
    padding: 30px;

    border-bottom: 1px solid #ccd6da;
  }

  .content_box_item {
    width: fit-content;
    height: fit-content;
    margin-left: auto;
    margin-right: auto;
    justify-content: center;
  }

  .i_box {
    background-color: #80adcc;
    width: 160px;
    height: 160px;
    border-radius: 80px;
    padding-top: 25px;
    box-sizing: border-box;
    color: black;
    display: flex;
    align-items: center;
    justify-content: center;
    
  }

  .i_box:hover {
    animation-name: bounce;
    animation-duration: 0.7s;
    animation-fill-mode: forwards;
  }

  @keyframes bounce {
    0% {
      transform: translateY(0px);
    }

    30% {
      transform: translateY(10px);
    }

    100% {
      transform: translateY(-10px);
    }
  }

  .bigbox {
    width: 230px;
    height: 230px;
    border-radius: 130px;
  }

  .text_box {
    /* background-color: aqua; */
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 20px;
    padding-left: auto;
    padding-right: auto;
  }

  .content_box_item i {
    margin-left: auto;
    margin-right: auto;
    width: fit-content;
    height: fit-content;
    margin-bottom: 30px;
  }

  .content_box2 {
    height: 317px;
    width: 508px;
    display: table-cell;
    padding-top: 30px;
    border-bottom: 1px solid #ccd6da;
  }

  .img_box {


    height: 100px;
    width: 1018px;
  }

  .event_img {
    height: 97px;
    width: 507px;
    border-bottom: 1px solid #ccd6da;
    float: left;
    cursor: pointer;
  }

  /* box sizing */

</style>
