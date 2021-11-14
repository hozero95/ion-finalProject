<template>

  <body>
    <div class="container_my">

      <div class="header_my">
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

          <h2 class="body_header">회원정보 변경</h2>

          <div class="information">
            <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"> 표시는 필수입력 항목 이오니 반드시 입력해 주세요.
          </div>


          <div class="filed1">
            <div class="filed1_lbox">
              <span>아이디 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></span>
            </div>
            <div class="filed1_rbox"><span>{{$store.state.userInfo.userId}}</span></div>
          </div>

          <div class="filed1">
            <div class="filed1_lbox">
              <span>이메일 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></span>
            </div>
            <div class="filed1_rbox">
              <span>
                <input type="text" name="user_name" class="input_box" v-model="userEmail" @input="inputEmailCheck"
                  required>
              </span><br>

              <span v-if="emailCheck" id="error_email" class="error_next_box">잘못된 이메일 입니다.</span>

            </div>
          </div>

          <div class="filed1">
            <div class="filed1_lbox">
              <span>자택주소 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></span>
            </div>
            <div class="filed1_rbox">
              <input type="text" name="user_name" class="input_box" v-model="userAddress">
            </div>


          </div>
          <div class="filed1">
            <div class="filed1_lbox">
              <span>연락처 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"> </span>
            </div>
            <div class="filed1_rbox">
              <span>
                <input type="tel" name="user_name" class="input_box" maxlength="20" v-model="userTel"
                  @input="inputTelCheck" required>
              </span><br>
              <span v-if="telCheck" id="error_tel" class="error_next_box">잘못된 연락처 입니다.</span>
            </div>
          </div>

          <div class="area_cs_btn">
            <router-link to="/userinfolocker">
              <a href="#" @click="changeInfo()" id="submitBtn" class="cs_btn" style="">확인</a>
            </router-link>

            <router-link to="/userinfolocker">
              <a href="#" class="cs_btn white" style="">취소</a>
            </router-link>
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
        userEmail: '',
        userAddress: '',
        userTel: '',
        emailCheck: false,
        addressCheck: false,
        telCheck: false
      }
    },
    created() {
      this.userEmail = this.$store.state.userInfo.userEmail;
      this.userAddress = this.$store.state.userInfo.userAddress;
      this.userTel = this.$store.state.userInfo.userTel;
    },
    methods: {
      changeInfo() {
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken
        };

        var body = {
          userUnum: this.$store.state.userInfo.userUnum,
          userEmail: this.userEmail,
          userAddress: this.userAddress,
          userTel: this.userTel
        };
        console.log(body);

        axios({
            url: 'http://localhost:8000/api/mypage/replace/userinfo',
            method: 'patch',
            headers: headers,
            data: body
          })
          .then(res => {
            // console.log(res);
            alert('정보변경이 완료되었습니다.');
            var modifyUserInfo = {
              userUnum: this.$store.state.userInfo.userUnum,
              userId: this.$store.state.userInfo.userId,
              userEmail: this.userEmail,
              userAddress: this.userAddress,
              userTel: this.userTel,
              userRegdate: this.$store.state.userInfo.userRegdate,
              authorities: this.$store.state.userInfo.authorities
            };
            this.$store.commit('setUserInfo', modifyUserInfo);
          }, error => {
            alert('정보 변경에 실패했습니다.');
          });

      },
      inputTelCheck() {
        var number = this.userTel.replace(/[^0-9]/g, "");
        var phone = "";

        if (number.length < 4) {
          return number;
        } else if (number.length < 7) {
          phone += number.substr(0, 3);
          phone += "-";
          phone += number.substr(3);
        } else if (number.length < 11) {
          phone += number.substr(0, 3);
          phone += "-";
          phone += number.substr(3, 3);
          phone += "-";
          phone += number.substr(6);
        } else {
          phone += number.substr(0, 3);
          phone += "-";
          phone += number.substr(3, 4);
          phone += "-";
          phone += number.substr(7);
        }
        this.userTel = phone;
      },
      inputEmailCheck() {
        var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        var email = this.userEmail;

        if (!reg.test(email)) {
          this.emailCheck = true;
        } else {
          this.emailCheck = false;
        }
      }
    }
  }
</script>

<style scoped>
  /* header setting */
  .container_my {
    /* background-color: aqua; */

    margin-top: 30px;
    margin-left: auto;
    margin-right: auto;
    border-right: 1px solid #d1dadd;
    border-left: 1px solid #d1dadd;
    width: 1020px;
    height: 700px;
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

  }

  .content_side {
    /* background-color: aqua; */
    float: left;
    width: 200px;
    height: 600px;

  }

  .btn {
    color: black;
    background-color: #F3FAFE;
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

    line-height: 30px;
  }


  .information {
    position: relative;
    margin-top: 20px;
    padding-bottom: 10px;
    font-family: "Spoqa-Regular", -apple-system, BlinkMacSystemFont, "Apple SD Gothic Neo", Arial, sans-serif;
    font-size: 11px;
    color: #777;
    letter-spacing: -1px;
    text-align: left;
    border-bottom: 1px solid #203a4d;


  }

  .filed1 {
    height: fit-content;
    width: 770px;
    border-top: 1px solid #E5E5E5;
    border-bottom: 1px solid #E5E5E5;
    padding: 12px 10px 12px 10px;
    display: flex;

  }

  .filed1_lbox {
    width: 100px;

  }

  .filed1_rbox {
    margin-left: 100px;

  }

  .input_box {
    float: left;
  }

  .button_hyp {
    height: 30px;
    width: 90px;
    border-radius: 1.5px;
    border: 1px solid black;
    background-color: lightgrey;
    margin-left: 5px;
    display: inline-block;
    text-align: center;
    float: left;

  }

  .area_cs_btn {
    margin-top: 20px;

    display: flex;
    justify-content: center
  }

  .cs_btn {
    width: 100px;
    height: 50px;
    background: #f14f4f;
    color: #fff;
    border: 1px solid #CCCCCC;
    text-align: center;
    padding: 12px 16px 10px 16px;

  }

  .white {
    margin-left: 30px;
    background-color: #F9F9F9;
    color: black;

  }



  /* ------------------------content_my body end-------------------------------- */
</style>