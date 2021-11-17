<template>
  <div class="cart">
    <h3>장바구니</h3>
    <div class="left">
      <div class="left__top">
        <ul class="left__top__chk">
          <li>
            <!-- <span class="checkbox">
              <input type="checkbox">
              <label for="chk_all">전체선택</label>
            </span> -->
          </li>
          <li>
            <!-- <button type="button" class="btn_all">선택삭제</button> -->
          </li>
        </ul>
        <div class="line"></div>
      </div>

      <!-- toggle sss -->
      <div class="accordion accordion-flush" id="accordionFlushExample">
        <div class="accordion-item">
          <h2 class="accordion-header" id="panelsStayOpen-headingOne">
            <button class="accordion-button" type="button" data-bs-toggle="collapse"
              data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true"
              aria-controls="panelsStayOpen-collapseOne">
              <h4>
                <label for="">택배배송 상품 : {{products.length}}개</label>
              </h4>
            </button>
          </h2>
          <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show"
            aria-labelledby="panelsStayOpen-headingOne">
            <div class="accordion-body">
              <!--  -->
              <div class="left__content">
                <table class="left__content__table">

                  <tr v-for="(product, index) in products" v-bind:key="index">
                    <td class="imgbox">
                      <!-- <input type="checkbox"> -->
                      <img :src="product.productImage01Path" alt="">
                    </td>
                    <td class="content">
                      <div class="logo">해물오빠</div>
                      <div class="title cursor_pointer" @click="showDetail(product.productUnum)">{{product.productName}}
                      </div>
                    </td>
                    <td class="pricewrap">
                      <div class="price">{{product.cartPrice}}
                        <div class="won">원</div>
                      </div>
                      <!-- <div class="addbtn"></div> -->
                      <div class="add-box__add">
                        <div class="add-box__add-btn minus cursor_pointer" @click="countMinus(index)">-</div>
                        <div class="add-box__add-btn number">{{product.cartCount}}</div>
                        <div class="add-box__add-btn plus cursor_pointer" @click="countPlus(index)">+</div>
                      </div>
                    </td>
                    <td class="btnarea">
                      <!-- <div class="btnarea__btn"> -->
                      <!-- <div class="cartbtn">계속담아두기</div> -->
                      <!-- <div class="buybtn cursor_pointer">바로구매</div> -->
                      <!-- </div> -->
                      <div class="btnarea__btn"><i class="far fa-trash-alt cursor_pointer" @click="delCart(index)"></i>
                      </div>
                    </td>
                  </tr>

                </table>
                <div class="totalpay">
                  {{getTotalPrice()}}원 + 배송비 0원 = {{getTotalPrice()}}원
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="right">
      <div class="right__top">
        <i class="fas fa-map-marker-alt"></i>
        <label for="">배송지 주소</label>
        <div class="addr">
          {{address}}
        </div>
        <button class="addr-re" v-if="!modify_address" @click="modifyAddressStatus()">배송지 변경</button>
        <div class="modify_address" v-if="modify_address">
          <span>
            <input type="text" id="sample6_postcode" class="int" placeholder="우편번호" v-model="zip" required readonly>
            <input type="button" id="findAddress" @click="showAddressApi" value="우편번호 찾기">
          </span>
          <span>
            <input type="text" id="sample6_address" class="int" placeholder="주소" v-model="addr1" required readonly>
          </span>
          <span>
            <input type="text" id="sample6_detailAddress" class="int" placeholder="상세주소" v-model="addr2">
          </span>
          <br>
          <button @click="modifyAddressConfirm()">확인</button>
          &nbsp;&nbsp;
          <button @click="modifyAddressCancle()">취소</button>
        </div>
      </div>
      <div class="right__middle">
        <i class="fas fa-shopping-bag"></i>
        <label for="">전체상품 : {{products.length}}개</label>

        <div class="right__middle__pays">
          <ul class="right__middle__pay">
            <li>주문금액</li>
            <li>{{getTotalPrice()}} 원</li>
          </ul>
          <ul class="right__middle__pay">
            <li>배송비</li>
            <li>0 원</li>
          </ul>
        </div>
        <div class="payline"></div>
        <ul class="right__middle__pay total">
          <li>결제예정금액</li>
          <li>{{getTotalPrice()}} 원</li>
        </ul>

      </div>
      <div class="right__btn cursor_pointer" @click="goPayDispaly()">주문하기</div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';

  export default {
    data() {
      return {
        products: [],
        address: '',
        modify_address: false,

        zip: null,
        addr1: null,
        addr2: null
      }
    },
    created() {
      this.getCart();
      if (this.products != null && this.products.length > 0) {
        this.address = this.products[i].cartAddress;
      } else {
        this.address = this.$store.state.userInfo.userAddress;
      }
    },
    methods: {
      getCart() {
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken
        };

        axios.defaults.headers.post = null;
        axios({
            url: 'http://localhost:8000/api/cart/show/cart',
            method: 'get',
            headers: headers,
            params: {
              userUnum: this.$store.state.userInfo.userUnum
            }
          })
          .then(res => {
            this.products = res.data;
          }, error => {
            alert("장바구니 정보를 불러오는데 실패하였습니다.");
            this.$router.push('/');
          });
      },
      setCartCount(index) {
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken
        };

        var body = {
          cartCount: this.products[index].cartCount,
          cartPrice: this.products[index].cartPrice,
          userUnum: this.$store.state.userInfo.userUnum,
          productUnum: this.products[index].productUnum
        };

        axios.defaults.headers.post = null;
        axios({
            url: 'http://localhost:8000/api/cart/replace/count',
            method: 'patch',
            headers: headers,
            data: body
          })
          .then(res => {}, error => {
            alert("수량 업데이트에 문제가 생겼습니다.");
            this.getCart();
          });
      },
      delCart(index) {
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken
        };

        var params = {
          userUnum: this.$store.state.userInfo.userUnum,
          productUnum: this.products[index].productUnum
        };

        axios.defaults.headers.post = null;
        axios({
            url: 'http://localhost:8000/api/cart/remove/cart',
            method: 'delete',
            headers: headers,
            params: params
          })
          .then(res => {
            alert("상품이 삭제되었습니다.");
            this.getCart();
          }, error => {
            alert("상품을 삭제하는 데 실패하였습니다.");
            this.getCart();
          });
      },
      getTotalPrice() {
        var totalPrice = 0;
        for (var i = 0; i < this.products.length; i++) {
          totalPrice += this.products[i].cartPrice;
        }
        return totalPrice;
      },
      countMinus(index) {
        if (this.products[index].cartCount > 1) {
          this.products[index].cartCount--;
          this.products[index].cartPrice -= this.products[index].productPrice;
          this.setCartCount(index);
        } else {
          alert("수량은 1개 미만일 수 없습니다.");
        }
      },
      countPlus(index) {
        if (this.products[index].cartCount < 10) {
          this.products[index].cartCount++;
          this.products[index].cartPrice += this.products[index].productPrice;
          this.setCartCount(index);
        } else {
          alert("수량은 최대 10개까지 선택이 가능합니다.");
        }
      },
      showDetail(productUnum) {
        this.$store.commit('setProductUnum', productUnum);

        if (this.$route.path !== '/product') {
          this.$router.push('/product');
        }
      },
      modifyAddressStatus() {
        this.modify_address = !this.modify_address;
      },
      modifyAddressCancle() {
        if (this.products != null && this.products.length > 0) {
          this.address = this.products[0].cartAddress;
        } else {
          this.address = this.$store.state.userInfo.userAddress;
        }
        this.modifyAddressStatus();
      },
      modifyAddressConfirm() {
        if (this.zip == null || this.zip == '' || this.addr1 == null || this.addr1 == '') {
          alert("우편번호 찾기를 눌러 주소를 넣어주세요.");
        } else {
          if (confirm("배송지를 변경하시겠습니까?")) {
            var headers = {
              "Content-Type": "application/json",
              "Authorization": "Bearer " + this.$store.state.jwtToken
            };

            this.address = "(" + this.zip + ")" + this.addr1 + " " + this.addr2;
            var body = {
              userUnum: this.$store.state.userInfo.userUnum,
              cartAddress: this.address
            };

            axios.defaults.headers.post = null;
            axios({
                url: 'http://localhost:8000/api/cart/replace/address',
                method: 'patch',
                headers: headers,
                data: body
              })
              .then(res => {
                alert("배송지가 변경되었습니다.");
              }, error => {
                alert("배송지 변경에 실패하였습니다.");
              });

            this.modifyAddressStatus();
          }
        }
      },
      goPayDispaly() {
        this.$store.commit('setPayProductUnum', -1);

        if (this.$route.path !== '/payment') {
          this.$router.push('/payment');
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
  .cart {
    margin-left: 323px;
    margin-top: 20px;
  }

  .cart h3 {
    margin-bottom: 1%;
  }

  .left {
    float: left;
    height: 520px;
    overflow: scroll;
    width: 930px;
  }

  .left__top__chk {
    padding: 0;
    display: flex;
    justify-content: space-between;
    color: #6d6d6d;
  }

  .left__top__chk button {
    color: #6d6d6d;
  }

  .line {
    border: 1px solid black;
    margin-bottom: 3%;
  }

  /* toggle */
  .accordion-body {
    padding: 0;
    padding-left: 17px;
  }

  .accordion-button:not(.collapsed) {
    color: black;
    background-color: white;
    box-shadow: none;
  }

  .accordion-button:focus {
    z-index: 3;
    border-color: white;
    outline: 0px;
    box-shadow: none;
  }


  .left__title {
    display: flex;
    justify-content: space-between;
  }

  .left__title label {
    margin-top: 10px;
  }

  .toggle-btn__on__icon {
    font-size: 24px;
  }

  .left__content__table .imgbox {
    position: relative;
    border: 1px solid #c7c7c7;
    border-left: none;
    width: 150px;
    height: 145px;
  }

  .left__content__table .imgbox input {
    position: absolute;
  }

  .left__content__table .imgbox img {
    width: 130px;
    height: 130px;
  }

  .left__content__table .content {
    border: 1px solid #c7c7c7;
    width: 355px;
    height: 145px;
    padding-left: 3%;
  }

  .left__content__table .content .logo {
    background-color: #132c7d;
    color: white;
    width: 70px;
    height: 25px;
    text-align: center;
    margin-bottom: 5%;
  }

  .left__content__table .pricewrap {
    border: 1px solid #c7c7c7;
    width: 175px;
    height: 145px;
    padding-left: 5%;
  }

  .left__content__table .pricewrap .price {
    display: flex;
    font-weight: bold;
    font-size: 24px;
    margin-top: 10%;
  }

  .left__content__table .pricewrap .won {
    font-weight: normal;
    font-size: 12px;
    margin-top: 12px;
    margin-left: 2px;
  }

  /* + - btn */
  .add-box__add {
    display: flex;
    margin-top: 10px;
  }

  .add-box__add-btn {
    border: 1px solid #c7c7c7;
    width: 30px;
    height: 30px;
    text-align: center;
  }

  /*  */
  .left__content__table .btnarea {
    border: 1px solid #c7c7c7;
    border-right: none;
    width: 145px;
    height: 145px;
  }

  .btnarea__btn {
    width: 120px;
    height: 10px;
    text-align: center;
    margin-left: 10%;
  }

  .cartbtn {
    border: 1px solid #c7c7c7;
    margin-bottom: 5%;
  }

  .buybtn {
    background-color: #132c7d;
    color: white;
  }

  .btnarea__icon {
    text-align: center;
    font-size: 18px;
    margin-top: 35%;
  }

  .totalpay {
    background-color: #e7e7e7;
    width: 825px;
    height: 50px;
    text-align: center;
    /* margin-right: 88px; */
    padding-top: 15px;
  }

  .totalpay p {
    margin-top: 5%;
  }

  .right {
    display: inline-block;
    width: 300px;
    height: 520px;
    border: 2px solid #f7f7f7;
    margin-left: 31px;
    padding: 1%;

  }

  .right__top {
    background-color: #f7f7f7;
    margin-bottom: 1%;
  }

  .right__top .addr {
    font-size: 14px;
    margin-bottom: 3%;
  }

  .right__top .addr-re {
    border: 1px solid #6d6d6d;
    width: 264px;
    height: 35px;
    background-color: white;
  }

  .right__middle {
    margin-top: 5%;
  }

  .right__middle__pays {
    margin-top: 50%;
  }

  .right__middle__pay {
    display: flex;
    justify-content: space-between;
  }

  .payline {
    border: 1px solid #c7c7c7;
    margin-bottom: 3%;
  }

  .total {
    color: #132c7d;
  }

  .right__btn {
    width: 264px;
    height: 60px;
    background-color: #132c7d;
    color: white;
    font-size: 24px;
    text-align: center;
    padding-top: 12px;
  }

  .cursor_pointer {
    cursor: pointer;
  }

  .modify_address {
    text-align: center;
  }

  /* 노트북 사이즈 */
  @media screen and (max-width: 1500px) {
    .cart {
      margin-left: 100px;
    }

    .left {
      float: left;
      width: 880px;
    }

    .right {
      margin-left: 4%;
    }
  }

</style>
