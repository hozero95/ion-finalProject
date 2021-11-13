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
              <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <li><a class="dropdown-item" href="#">리뷰관리</a></li>
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

          <h2 class="stit"><span>회원 탈퇴</span></h2>
          <form id="submitForm" method="POST">

            <div class="password_change">
              <div class="wrap">
                <label for="password" class="label">비밀번호 : </label>
                <input type="password" id="password" name="password" title="비밀번호" value="" class="input_text small"
                  style="width: 270px" v-model="passwordVal">
                <span class="error_txt small warning"></span>
              </div>
            </div>
            <div class="btn_area">
              <router-link to="">
                <button @click="passwordTrue()" id="submitBtn" class="cs_btn">확인</button>
              </router-link>
            </div>
          </form>

          <div class="information">
            <h4>주의하세요</h4>
            <ul>
              <li><span style="color: red;">회원탈퇴시 저장된 정보는 모두 삭제됩니다.</span></li>
            </ul>
          </div>

        </div>

      </div>


    </div>

  </body>
</template>

<script scoped>
  import axios from 'axios'

  export default {
    data() {
      return {
        passwordVal: null
      }
    },
    methods: {
      passwordTrue() {
        axios.post('http://localhost:8000/api/signin', {
            "userId": this.$store.state.userInfo.userId,
            "userPassword": this.passwordVal
          })
          .then(res => {
            alert('비밀번호가 맞습니다');
            if (confirm('탈퇴하시겠습니까?')) {
              this.deleteUser();

            } else {
              alert('탈퇴가 취소되었습니다.');

            }

          }, error => {
            alert('비밀번호가 잘못되었습니다.');
          });
      },
      deleteUser() {
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken
        };

        axios({
            url: 'http://localhost:8000/api/mypage/remove/user',
            method: 'delete',
            headers: headers,
            params: {
              userUnum: this.$store.state.userInfo.userUnum,
            },
          })
          .then(res => {
            alert('탈퇴가 완료되었습니다.');
            this.logout();
          }, error => {
            console.log(error);
            alert('회원탈퇴에 실패하였습니다.')

          })

      },
      logout() {
        this.$store.commit("logout");
        this.$router.push('/login');
      },
    },

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
    background-color: aquamarine;
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
    /* border: solid 3px red; */
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

  /* ------------------------side bar end-------------------------------- */
  .content_body {
    margin-left: 30px;
    width: 770px;
    float: left;
  }

  /* ------------------------pw_change start-------------------------------- */
  .stit {
    padding-top: 15px;
    border-bottom: 1px solid #203a4d;
    padding-bottom: 13px;
    padding-left: 10px;
    font-family: "Spoqa-Regular", -apple-system, BlinkMacSystemFont, "Apple SD Gothic Neo", Arial, sans-serif;
    font-size: 26px;
    color: #203a4d;
    font-weight: normal;
    line-height: 30px;
  }

  .password_change {
    border-top: 1px solid #e3e3e3;
    border-bottom: 1px solid #e3e3e3;
    background-color: #fbfbfb;
    text-align: center;
    height: 150px;
    display: flex;
    flex-direction: column;
    justify-content: center;
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

  .information {
    position: relative;
    margin-top: 20px;
    font-family: "Spoqa-Regular", -apple-system, BlinkMacSystemFont, "Apple SD Gothic Neo", Arial, sans-serif;
    font-size: 11px;
    color: #777;
    border-top: 1px solid #d1dadd;
    letter-spacing: -1px;
    text-align: left;
  }
</style>