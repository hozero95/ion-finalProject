<template>

  <body class="body_my">
    <!-- header -->
    <div id="header">
      <img src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/img_xl.jpeg" id="logo">
    </div>

    <!-- wrapper -->
    <div id="wrapper">

      <!-- content-->
      <div id="content">

        <!-- ID -->
        <div>
          <h3 class="join_title"><label for="id">아이디</label></h3>
          <span class="box int_id">
            <input type="text" id="id" v-model="id" class="int" maxlength="30" minlength="3" placeholder="아이디 입력"
              @input="inputIdCheck()" required>
            <button v-if="!idSave" id="btnCheck" @click="idExistCheck">중복확인</button>
          </span>
          <span v-if="idLengthCheck" id="error_id" class="error_next_box">아이디는 3글자 이상이어야 합니다.</span>
          <br>
          <span v-if="idCheck" id="error_id" class="error_next_box">잘못된 아이디 입니다.</span>
        </div>

        <!-- PW1 -->
        <div>
          <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
          <span class="box int_pass">
            <input type="password" id="pswd1" v-model="pswd1" class="int" maxlength="20" minlength="3"
              placeholder="비밀번호 입력" @input="inputPswd1Check()" required>
            <!-- <span id="alertTxt">사용불가</span> -->
            <!-- <img src="" id="pswd1_img1" class="pswdImg"> -->
          </span>
          <span v-if="pswd1LengthCheck" id="error_password" class="error_next_box">비밀번호는 3자리 이상이어야 입니다.</span>
          <br>
          <span v-if="pswd1Check" id="error_password" class="error_next_box">잘못된 비밀번호 입니다.</span>
        </div>

        <!-- PW2 -->
        <div>
          <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
          <span class="box int_pass_check">
            <input type="password" id="pswd2" v-model="pswd2" class="int" maxlength="20" minlength="3"
              placeholder="비밀번호 재입력" @input="inputPswdCheck" required>
            <!-- <img src="" id="pswd2_img1" class="pswdImg"> -->
          </span>
          <span v-if="pswd2Check" id="error_password2" class="error_next_box">비밀번호가 일치하지 않습니다.</span>
          <br>
        </div>

        <!-- EMAIL -->
        <div>
          <h3 class="join_title"><label for="email">이메일<span class="optional"></span></label></h3>
          <span class="box int_email">
            <input type="email" id="email" v-model="email" class="int" maxlength="50" placeholder="이메일 입력"
              @input="inputEmailCheck" required>
          </span>
          <span v-if="emailCheck" id="error_email" class="error_next_box">잘못된 이메일 입니다.</span>
          <br>
        </div>

        <!-- ADDRESS -->
        <div>
          <h3 class="join_title"><label for="address">주소</label></h3>
          <span class="box int_id">
            <!-- <input type="text" id="address" v-model="address" class="int" maxlength="100" placeholder="주소 입력" required> -->
            <input type="text" id="sample6_postcode" class="int" placeholder="우편번호" v-model="zip" required readonly>
            <input type="button" id="findAddress" @click="showAddressApi" value="우편번호 찾기">
          </span>
          <span class="box int_address">
            <input type="text" id="sample6_address" class="int" placeholder="주소" v-model="addr1" required readonly>
          </span>
          <span class="box int_address">
            <input type="text" id="sample6_detailAddress" class="int" placeholder="상세주소" v-model="addr2">
          </span>
          <span v-if="addressCheck" id="error_address" class="error_next_box">잘못된 주소 입니다.</span>
          <br>
        </div>

        <!-- PHONE -->
        <div>
          <h3 class="join_title"><label for="phoneNo">연락처</label></h3>
          <span class="box int_mobile">
            <input type="tel" id="mobile" v-model="tel" class="int" maxlength="20" placeholder="연락처 입력"
              @input="inputTelCheck" required>
          </span>
          <span v-if="telCheck" id="error_tel" class="error_next_box">잘못된 연락처 입니다.</span>
          <br>
        </div>

        <!-- JOIN BTN-->
        <div class="btn_area">
          <button type="button" id="btnJoin" @click="checkForm">
            <span>가입하기</span>
          </button>
          <br>
        </div>

      </div>
      <!-- content-->
    </div>
    <!-- wrapper -->
  </body>
</template>

<script>
  import axios from 'axios';

  export default {
    data() {
      return {
        id: null,
        pswd1: null,
        pswd2: null,
        email: null,
        address: null,
        tel: null,

        idSave: false,
        idCheck: false,
        idLengthCheck: false,
        pswd1Check: false,
        pswd2Check: false,
        pswd1LengthCheck: false,
        emailCheck: false,
        addressCheck: false,
        telCheck: false,

        zip: null,
        addr1: null,
        addr2: null
      }
    },
    methods: {
      idExistCheck() {
        var url = 'http://localhost:8000/api/userid/' + this.id;
        console.log(url);
        axios.get(url)
          .then(res => {
            if (res.data) {
              alert("이미 등록된 아이디 입니다.");
              this.idSave = false;
              this.idCheck = true;
            } else {
              alert("사용 가능한 아이디 입니다.");
              this.idSave = true;
              this.idCheck = false;
            }
          });
      },
      checkForm() {
        var check = true;

        if (this.id == null || this.id == '') {
          this.idCheck = true;
          check = false;
        } else {
          this.idCheck = false;
        }
        if (this.pswd1 == null || this.pswd1 == '') {
          this.pswd1Check = true;
          check = false;
        } else {
          this.pswd1Check = false;
        }
        if (this.pswd2 != this.pswd1 || this.pswd2 == null || this.pswd2 == '') {
          this.pswd2Check = true;
          check = false;
        } else {
          this.pswd2Check = false;
        }
        if (this.email == null || this.email == '') {
          this.emailCheck = true;
          check = false;
        } else {
          this.emailCheck = false;
        }
        if (this.zip == null || this.zip == '' || this.addr1 == null || this.addr == '') {
          this.addressCheck = true;
          check = false;
        } else {
          this.addressCheck = false;
          this.address = "(" + this.zip + ")" + this.addr1 + " " + this.addr2;
        }
        if (this.tel == null || this.tel == '') {
          this.telCheck = true;
          check = false;
        } else {
          this.telCheck = false;
        }

        if (check) {
          if (this.idSave) {
            axios.post('http://localhost:8000/api/signup', {
                "userId": this.id,
                "userPassword": this.pswd1,
                "userEmail": this.email,
                "userAddress": this.address,
                "userTel": this.tel
              })
              .then(res => {
                alert("회원가입 완료");
                this.$router.push('/login');
              });
          } else {
            alert("중복확인이 필요합니다.");
          }
        }
      },
      inputIdCheck() {
        this.id = this.id.replace(/[^0-9|a-z|A-Z]/g, '').replace(/(\..*)\./g, '$1');

        if(this.id.length < 3) {
          this.idLengthCheck = true;
        } else {
          this.idLengthCheck = false;
        }
      },
      inputPswd1Check() {
        if(this.pswd1.length < 3) {
          this.pswd1LengthCheck = true;
        } else {
          this.pswd1LengthCheck = false;
        }
      },
      inputPswdCheck() {
        if (this.pswd2 != this.pswd1 || this.pswd1 == null || this.pswd1 == '' || this.pswd2 == null || this.pswd2 == '') {
          this.pswd2Check = true;
        } else {
          this.pswd2Check = false;
        }
      },
      inputTelCheck() {
        this.tel = this.tel.replace(/[^0-9]/g, "").replace(/(\..*)\./g, '$1');
        var number = this.tel.replace(/[^0-9]/g, "");
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
        this.tel = phone;
      },
      inputEmailCheck() {
        var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        var email = this.email;

        if (!reg.test(email)) {
          this.emailCheck = true;
        } else {
          this.emailCheck = false;
        }
      },
      showAddressApi() {
        new window.daum.Postcode({
          oncomplete: (data) => {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            let fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            let extraRoadAddr = ''; // 도로명 조합형 주소 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
              extraRoadAddr += data.bname;
            }

            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== '' && data.apartment === 'Y') {
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }

            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (extraRoadAddr !== '') {
              extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if (fullRoadAddr !== '') {
              fullRoadAddr += extraRoadAddr;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            this.zip = data.zonecode;
            //5자리 새우편번호 사용 
            this.addr1 = fullRoadAddr;
          }
        }).open();
      }
    }
  }

</script>

<style scoped>
  /* 레이아웃 틀 */
  html {
    height: 100%;
  }

  .body_my {
    margin: 0;
    height: 1300px;
    /* overflow:auto; */
    background: #f5f6f7;
    font-family: Dotum, '돋움', Helvetica, sans-serif;
  }

  #logo {
    width: 240px;
    height: 240px;
    background: #f5f6f7;

  }

  #header {
    padding-top: 62px;
    padding-bottom: 20px;
    text-align: center;
  }

  #wrapper {
    position: relative;
    height: 100%;
  }

  #content {
    position: absolute;
    left: 50%;
    transform: translate(-50%);
    width: 460px;
  }




  /* 입력폼 */

  input:focus {
    outline: none;
  }


  h3 {
    margin: 19px 0 8px;
    font-size: 14px;
    font-weight: 700;
  }


  .box {
    display: block;
    width: 100%;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 14px 10px 14px;
    box-sizing: border-box;
    background: #fff;
    position: relative;
  }

  .int {
    display: block;
    position: relative;
    width: 100%;
    height: 29px;
    border: none;
    background: #fff;
    font-size: 15px;
  }

  input {
    font-family: Dotum, '돋움', Helvetica, sans-serif;
  }

  .box.int_id {
    display: flex;
  }

  .box.int_pass {
    padding-right: 40px;
  }

  .box.int_pass_check {
    padding-right: 40px;
  }

  .step_url {
    /*@naver.com*/
    position: absolute;
    top: 16px;
    right: 13px;
    font-size: 15px;
    color: #8e8e8e;
  }

  .pswdImg {
    width: 18px;
    height: 20px;
    display: inline-block;
    position: absolute;
    top: 50%;
    right: 16px;
    margin-top: -10px;
    cursor: pointer;
  }

  #bir_wrap {
    display: table;
    width: 100%;
  }

  #bir_yy {
    display: table-cell;
    width: 147px;

  }

  #bir_mm {
    display: table-cell;
    width: 147px;
    vertical-align: middle;
  }

  #bir_dd {
    display: table-cell;
    width: 147px;
  }

  #bir_mm,
  #bir_dd {
    padding-left: 10px;
  }

  select {
    width: 100%;
    height: 29px;
    font-size: 15px;
    background: #fff url(https://static.nid.naver.com/images/join/pc/sel_arr_2x.gif) 100% 50% no-repeat;
    background-size: 20px 8px;
    -webkit-appearance: none;
    display: inline-block;
    text-align: start;
    border: none;
    cursor: default;
    font-family: Dotum, '돋움', Helvetica, sans-serif;
  }

  /* 에러메세지 */

  .error_next_box {
    margin-top: 9px;
    font-size: 12px;
    color: red;
  }

  #alertTxt {
    position: absolute;
    top: 19px;
    right: 38px;
    font-size: 12px;
    color: red;
    display: none;
  }

  /* 버튼 */

  .btn_area {
    margin: 30px 0 91px;
  }

  #btnJoin {
    width: 100%;
    padding: 21px 0 17px;
    border: 0;
    cursor: pointer;
    color: #fff;
    background-color: #185B9A;
    font-size: 20px;
    font-weight: 400;
    font-family: Dotum, '돋움', Helvetica, sans-serif;
  }

  #btnCheck {
    width: 80px;
    color: #fff;
    font-size: 12px;
    background-color: #185B9A;
    font-family: Dotum, '돋움', Helvetica, sans-serif;
  }

  #findAddress {
    width: 120px;
    color: #fff;
    font-size: 12px;
    background-color: #185B9A;
    font-family: Dotum, '돋움', Helvetica, sans-serif;
  }

</style>
