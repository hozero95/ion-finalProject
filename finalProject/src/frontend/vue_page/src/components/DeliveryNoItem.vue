<template>

  <body>
    <div class="container_my">
      <div class="header_my">
        <p class="user_name">#손님</p>
        <img class="ssg_img" src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/headimg.jpg"
          alt="img">
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
          <h2 class="body_header">주문배송 조회</h2>

          <div class="body_header2">
            <span>조회기간 {{getRecent3MonthStr()}}(최근3개월)</span>
            <span>조회설정</span>
          </div>

          <div class="body_content">
            <img src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/del.jpg" alt="img">
            <p style="font-size: 20px;">주문내역이 없습니다.</p>
            <button class="btn cs" name="btn_ssgMain" @click="toMain()">쇼핑시작하기</button>
          </div>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
  export default {
    methods: {
      toMain() {
        this.$router.push('/');
      },
      getRecent3MonthStr() {
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();

        var str = year + "-" + month + "-" + day;

        return str;
      }
    }
  }

</script>

<style>
  /* header setting */
  .container_my {
    /* background-color: aqua; */

    margin-top: 30px;
    margin-left: auto;
    margin-right: auto;
    border-right: 1px solid #d1dadd;
    border-left: 1px solid #d1dadd;
    width: 1020px;
    height: 2000px;
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
    height: 1000px;
    border: solid 3px red;
  }

  .content_side {
    /* background-color: aqua; */
    float: left;
    width: 200px;
    height: 600px;
    border-right: solid 1px #d1dadd;
  }

  .btn {
    background-color: #F3FAFE;
    color: #203a4d;
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

  .body_header2 {
    background-color: #f5f5f5;

    height: 45px;
    width: 777px;
    padding: 22px 20px 18px;
    display: flex;
    justify-content: space-between;
    align-items: center;


  }

  .body_content {

    margin-top: 50px;
    height: 228px;
    width: 777px;
    text-align: center;

  }

  .cs {
    height: 40px;
    width: 200px;
    background-color: #f5f5f5;
    border: 1px solid #e0e0e0;

  }





  /* ------------------------content_my body end-------------------------------- */

</style>
