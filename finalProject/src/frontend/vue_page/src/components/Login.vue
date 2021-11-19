<template>

  <body>
    <div class="loginSheet">
      <div class="popContainer">
        <div class="popContent">
          <div class="contentHeader">
            <h1><span>로그인</span></h1>
          </div>

          <form class="loginForm" action="" method="POST">
            <div class="input-box">
              <input id="inputId" type="text" name="username" placeholder="아이디">
              <label for="username">아이디</label>
            </div>

            <div class="input-box">
              <input id="inputPassword" type="password" name="password" placeholder="비밀번호">
              <label for="password">비밀번호</label>
            </div>

            <router-link to="joinuser">
              <div id="setid">회원가입 </div>
            </router-link>

            <router-link to="/">
              <input @click="login" class="btnSubmit" type="button" value="로그인">
            </router-link>
          </form>

          <div class="adImg">
            <img src="../assets/logo.jpeg" alt="ex" class="adSize">
          </div>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
  import axios from 'axios';

  export default {
    name: 'Login',
    data() {
      return {
        msg: 'Login page',
        idVal: '',
        passwordVal: ''
      }
    },
    methods: {
      login() {
        this.idVal = document.getElementById('inputId').value;
        this.passwordVal = document.getElementById('inputPassword').value;

        // jwt 토큰 생성
        axios.post('http://localhost:8000/api/signin', {
            "userId": this.idVal,
            "userPassword": this.passwordVal
          })
          .then(res => {
            this.$store.commit('setJwtToken', res.data.token);

            // 유저 정보 저장
            const headers = {
              "Content-Type": "application/json",
              "Authorization": "Bearer " + this.$store.state.jwtToken
            };

            axios.defaults.headers.post = null
            axios.get('http://localhost:8000/api/user', {
                headers
              })
              .then(res => {
                this.$store.commit('setUserInfo', res.data);
                alert(res.data.userId + '님 어서오세요.');
              }, error => {
                alert('회원 정보를 불러오는데 실패하였습니다.');
              });
          }, error => {
            alert('아이디 또는 비밀번호가 잘못되었습니다.');
          });

        // console.log(this.$store.state.jwtToken);
        // console.log(this.$store.state.userInfo);

        // this.$router.push('/');
      }
    }

  }
</script>

<style scoped>
  /* ---------------------- boxMapping  -------------------------------- */
  .loginSheet {
    /* background-color: aqua; */
    width: 1380px;
    height: 413px;
    margin-left: auto;
    margin-right: auto;

  }

  .popContainer {
    /* background-color: bisque; */
    width: 720px;
    height: 513px;
    margin-left: auto;
    margin-right: auto;
    position: relative;
  }

  .popContent {
    /* background-color: chartreuse; */
    width: 631px;
    height: 100%;
    margin-left: auto;
    margin-right: auto;
  }

  .contentHeader {
    /* background-color: brown; */
    width: 631px;
    height: 28px;
    padding: 56px 0 0 0;
    margin-bottom: 43px;
  }

  .loginForm {
    /* background-color: coral; */
    display: inline-block;
    height: 394px;
    width: 330px;
  }

  .adImg {
    /* background-color: cornflowerblue; */
    float: right;
    height: 253px;
    width: 253px;
  }


  /* ---------------------- boxMapping end  -------------------------------- */


  /* ---------------------- login form  -------------------------------- */
  form {
    padding: 10px;
  }

  .input-box {
    position: relative;
    margin: 10px 0;
  }

  .input-box>input {
    background: transparent;
    border: none;
    border-bottom: solid 1px #ccc;
    padding: 20px 0px 5px 0px;
    font-size: 14pt;
    width: 100%;
  }

  input::placeholder {
    color: transparent;
  }

  input:placeholder-shown+label {
    color: #aaa;
    font-size: 14pt;
    top: 15px;

  }

  input:focus+label,
  label {
    color: #8aa1a1;
    font-size: 10pt;
    pointer-events: none;
    position: absolute;
    left: 0px;
    top: 0px;
    transition: all 0.2s ease;
    -webkit-transition: all 0.2s ease;
    -moz-transition: all 0.2s ease;
    -o-transition: all 0.2s ease;
  }

  input:focus,
  input:not(:placeholder-shown) {
    border-bottom: solid 1px #8aa1a1;
    outline: none;
  }

  /* input[type=submit]{
    background-color: skyblue;
    border:none;
    color:white;
    width:100%;
    height:50px;
    font-size: 14pt;
    margin-top: 30px;
} */

  .btnSubmit {
    background-color: #132B7D;
    border: none;
    color: white;
    width: 100%;
    height: 50px;
    font-size: 14pt;
    margin-top: 30px;
  }

  #setid,
  #findid,
  #findpw {
    text-align: right;
    font-size: 10pt;
    padding: auto;
    color: rgb(164, 164, 164);
    float: right;

  }

  /* ---------------------- login form end -------------------------------- */


  /* ---------------------- advertise image sizing -------------------------------- */
  .adSize {
    width: 253px;
    height: 253px;
  }

  /* ---------------------- advertise image sizing end -------------------------------- */

  /* ----------------------------SNS Login Image-------------------------- */

  .snsLogin {

    width: 100%;
    height: 100px;
    margin-top: 20px;
    font-size: x-small;
    align-items: center;

  }

  .snsImg {
    display: flex;
    justify-content: space-around;
  }

  .snsImgSize {
    width: 50px;
    height: 50px;
  }


  /* ----------------------------SNS Login Image end-------------------------- */

  /* ----------------------------비회원 조회-------------------------- */
  .serch {
    display: block;
    padding: 14px;
    border-top: #666 solid 0.5px;
    color: #666;
    font-size: 13px;
    line-height: 17px;
    letter-spacing: -0.3px;
    text-align: center;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
  }


  /* ----------------------------비회원 조회 end-------------------------- */
</style>