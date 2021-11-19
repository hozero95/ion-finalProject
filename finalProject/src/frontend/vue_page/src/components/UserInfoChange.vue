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
              <span>아이디</span>
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
              <input type="text" name="user_name" class="input_box" placeholder="우편번호" v-model="zip" readonly
                required>&nbsp;
              <input type="button" id="findAddress" @click="showAddressApi" value="우편번호 찾기"><br>
              <input type="text" name="user_name" class="input_box" placeholder="주소" v-model="addr1" readonly
                required><br>
              <input type="text" name="user_name" class="input_box" placeholder="상세주소" v-model="addr2"
                @input="addr2Check()"><br><br>
              <span v-if="addressCheck" id="error_address" class="error_next_box">잘못된 주소 입니다.</span>
            </div>
          </div>

          <div class="filed1">
            <div class="filed1_lbox">
              <span>연락처 <img src="//sui.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"> </span>
            </div>

            <div class="filed1_rbox">
              <span>
                <input type="tel" name="user_name" class="input_box" maxlength="20" v-model="userTel"
                  placeholder="연락처 입력" @input="inputTelCheck" required>
              </span><br>
              <span v-if="telCheck" id="error_tel" class="error_next_box">잘못된 연락처 입니다.</span>
            </div>
          </div>

          <div class="area_cs_btn">
            <button @click="changeInfo()" id="submitBtn" class="cs_btn" style="">확인</button>
            <button class="cs_btn white" style="" @click="gotoBack()">취소</button>
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
        telCheck: false,

        zip: null,
        addr1: null,
        addr2: null
      }
    },
    created() {
      this.pageCheck();
      
      this.userEmail = this.$store.state.userInfo.userEmail;
      this.userAddress = this.$store.state.userInfo.userAddress;
      this.userTel = this.$store.state.userInfo.userTel;
      this.zip = this.userAddress.split('/')[0];
      this.addr1 = this.userAddress.split('/')[1];
      this.addr2 = this.userAddress.split('/')[2];
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
      changeInfo() {
        var check = true;

        if (this.userEmail == null || this.userEmail == '') {
          this.emailCheck = true;
          check = false;
        } else {
          this.emailCheck = false;
        }
        if (this.zip == null || this.zip == '' || this.addr1 == null || this.addr1 == '') {
          this.addressCheck = true;
          check = false;
        } else {
          this.addressCheck = false;
          this.userAddress = this.zip + '/' + this.addr1 + "/" + this.addr2;
        }
        if (this.userTel == null || this.userTel == '') {
          this.telCheck = true;
          check = false;
        } else {
          this.telCheck = false;
        }

        if (check) {
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
          // console.log(body);

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
              this.gotoBack();
            }, error => {
              alert('정보 변경에 실패했습니다.');
            });
        }
      },
      inputTelCheck() {
        this.telCheck = false;
        this.userTel = this.userTel.replace(/[^0-9]/g, "").replace(/(\..*)\./g, '$1');
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
      },
      inputAddrCheck() {
        if (this.zip == null || this.zip == '' || this.addr1 == null || this.addr1 == '') {
          this.addressCheck = true;
        } else {
          this.addressCheck = false;
        }
      },
      addr2Check() {
        var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;

        if (regExp.test(this.addr2)) {
          this.addr2 = this.addr2.substring(0, this.addr2.length - 1);
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

            this.addressCheck = false;
          }
        }).open();
      },
      gotoBack() {
        if (this.$route.path !== '/userinfolocker') {
          this.$router.push('/userinfolocker');
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

  .error_next_box {
    color: red;
  }



  /* ------------------------content_my body end-------------------------------- */

</style>
