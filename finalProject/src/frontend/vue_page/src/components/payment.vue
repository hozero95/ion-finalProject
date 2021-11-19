<template>
  <div class="payment">
    <h3>결제하기</h3>
    <div class="line"></div>

    <div class="payment__title">받는 분 정보</div>

    <div class="payment__wrap">
      <div class="payment__top">
        <div class="payment__info">
          <div class="payment__info__shipping-info">
            <div class="label">배송지 정보</div>
            <div class="info">
              <div class="name-phone">
                <div class="name">{{this.$store.state.userInfo.userId}}</div>
                <div class="phone">{{this.$store.state.userInfo.userTel}}</div>
              </div>
              <div class="addrwrap">
                <div class="addr">{{address}}</div>
                <!-- <div class="addr-changebtn">배송지 변경 <i class="fas fa-chevron-right"></i></div> -->
              </div>
            </div>
          </div>
        </div>
        <div class="payment__info">
          <div class="payment__info__shipping-request">
            <div class="label">택배배송 요청사항</div>
            <div class="info">
              <select v-model="orderMessage">
                <option selected>요청사항 선택</option>
                <option value="1">부재시 연락주세요.</option>
                <option value="2">부재시 경비실에 보관해주세요.</option>
                <option value="3">부재시 집 앞에 놔주세요.</option>
              </select>
            </div>
          </div>
        </div>
        <!-- 핸드폰 -->
        <div class="payment__info">
          <div class="payment__info__phone">
            <div class="label">연락처</div>
            <div class="info">
              <div class="phonewrap">
                <div class="phone">{{this.$store.state.userInfo.userTel}}</div>
                <!-- <div class="phone-changebtn">인증번호 변경하기 <i class="fas fa-chevron-right"></i></div> -->
              </div>
            </div>
          </div>
        </div>
        <!--  -->
        <div class="payment__info">
          <div class="payment__info__name-email">
            <div class="label">주문자명/이메일</div>
            <div class="info">
              <div class="name-emailwrap">
                <div class="name-email">{{this.$store.state.userInfo.userId}} / {{this.$store.state.userInfo.userEmail}}
                </div>
                <!-- <div class="name-email-changebtn">주문자 정보변경 <i class="fas fa-chevron-right"></i></div> -->
              </div>
            </div>
          </div>
        </div>

        <br>
        <div class="line"></div>
        <div class="payment__title">결제수단</div>
        <div class="payment__info">
          <div class="payment__info__shipping-info">
            <div class="label">결제수단 선택</div>
            <div class="info">
              <select v-model="paymentMethod">
                <option value="1">카드</option>
                <option value="2">무통장입금</option>

              </select>
              <span v-if="paymentMethod==2">
                &nbsp; 입금계좌 : (해물은행) 113-555-123098 / 예금주 : (주)해물오빠
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="payment__middle">
      <div class="order-product">
        <div class="line"></div>
        <div class="order-product__title">주문상품 : {{getProductAmount()}}개</div>
        <table class="order-product__table">

          <tr v-for="(product, index) in products" v-bind:key="index">
            <td class="imgbox">
              <img :src="product.productImage01Path" alt="">
            </td>
            <td class="order-product__content">
              <div class="logo">해물오빠</div>
              <div class="title">{{product.productName}}</div>
            </td>
            <td class="order-product__pricewrap">
              <div class="price">{{wonSubstring(product.cartPrice)}}
                <div class="won">원</div>
              </div>
              <div class="inner-line"></div>
              <div class="quantity-wrap">
                <span class="quantity">수량</span>
                <span class="num">{{product.cartCount}}</span>
                <span class="gae">개</span>
              </div>
            </td>
          </tr>
          <tr v-if="products == null">
            <td class="imgbox">
              <img src="../images/img1.jpg" alt="">
            </td>
            <td class="order-product__content">
              <div class="logo">해물오빠</div>
              <div class="title">{{payProductName}}</div>
            </td>
            <td class="order-product__pricewrap">
              <div class="price">{{wonSubstring(payProductPrice)}}
                <div class="won">원</div>
              </div>
              <div class="inner-line"></div>
              <div class="quantity-wrap">
                <span class="quantity">수량</span>
                <span class="num">{{payProductCount}}</span>
                <span class="gae">개</span>
              </div>
            </td>
          </tr>
        </table>
      </div>
    </div>

    <div class="payment__bottom">
      <div class="totalpay">
        <div class="">결제예정금액 {{wonSubstring(getTotalPrice())}}원</div>
        <div>(상품가 + 배송비)</div>
      </div>
      <div class="terms">
        <input v-model="payAgree" type="checkbox">
        <span 
        @click="payAgree = true" style="cursor: pointer;"
        >
        주문 상품정보 및 서비스 이용약관에 모두 동의하십니까?</span>
      </div>
      <div class="payment__bottom__btn" type="button" @click="doPay()">
        <div class="pay">{{wonSubstring(getTotalPrice())}}</div>
        <div class="one">원 결제하기</div>
      </div>
    </div>

  </div>

</template>

<script>
  import axios from 'axios';

  export default {
    data() {
      return {
        payProductUnum: null,
        payProductCount: null,
        payProductPrice: null,
        payProductName: null,
        productOne: null,
        products: [],
        orderMessage: '',
        paymentMethod: '',
        address: '',
        payAgree: false,
        count: 0
      }
    },
    created() {
      this.payProductUnum = this.$store.state.payProductUnum;
      this.payProductCount = this.$store.state.payProductCount;
      this.payProductPrice = this.$store.state.payProductPrice;

      if (this.payProductUnum == null || this.payProductUnum < 0) {
        this.productOne = null;
        this.getCart();
      } else {
        this.products = null;
        this.getProduct();
      }
    },
    computed: {
      setPayProductUnum() {
        return this.$store.state.payProductUnum;
      },
      setPayProductCount() {
        return this.$store.state.payProductCount;
      },
      setPayProductPrice() {
        return this.$store.state.payProductPrice;
      }
    },
    watch: {
      setPayProductUnum() {
        this.payProductUnum = this.setPayProductUnum;
      },
      setPayProductCount() {
        this.payProductCount = this.setPayProductCount;
      },
      setPayProductPrice() {
        this.payProductPrice = this.setPayProductPrice;
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
            this.getAddress();
          }, error => {
            alert("장바구니의 정보를 불러오는데 실패하였습니다.");
            this.$router.push('/');
          });
      },
      getProduct() {
        axios.get('http://localhost:8000/api/detail/show/product', {
            params: {
              productUnum: this.payProductUnum
            }
          })
          .then(res => {
            this.productOne = res.data[0];
            this.getAddress();
            this.getProductName();
          }, error => {
            alert("상품 정보를 불러오는데 실패하였습니다.");
            this.$router.push('/');
          });
      },
      getAddress() {
        if (this.products != null) {
          this.address = this.products[0].cartAddress;
        } else {
          this.address = this.$store.state.userInfo.userAddress;
        }
      },
      getTotalPrice() {
        var totalPrice = 0;
        if (this.products != null) {
          for (var i = 0; i < this.products.length; i++) {
            totalPrice += this.products[i].cartPrice;
          }
        } else {
          totalPrice = this.payProductPrice;
        }
        return totalPrice;
      },
      getProductAmount() {
        if (this.products != null) {
          return this.products.length;
        } else {
          return 1;
        }
      },
      getProductName() {
        if (this.products != null) {
          this.payProductName = '';
        } else {
          this.payProductName = this.productOne.productName;
        }
      },
      doPay() {
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken
        };

        if (this.payAgree) {
          if (this.orderMessage == 1) {
            this.orderMessage = "부재시 연락주세요.";
          } else if (this.orderMessage == 2) {
            this.orderMessage = "부재시 경비실에 보관해주세요.";
          } else if (this.orderMessage == 3) {
            this.orderMessage = "부재시 집 앞에 놔주세요.";
          } else {
            this.orderMessage = "요청사항 없음";
          }

          if (this.paymentMethod == 1) {
            this.paymentMethod = "카드";
          } else if (this.paymentMethod == 2) {
            this.paymentMethod = "무통장입금";
          }

          var body1 = {
            userUnum: this.$store.state.userInfo.userUnum,
            orderAddress: this.address,
            orderMessage: this.orderMessage,
            orderType: this.paymentMethod
          };

          axios({
              url: 'http://localhost:8000/api/pay/regist/order',
              method: 'post',
              headers: headers,
              data: body1
            })
            .then(res => {
              axios({
                  url: 'http://localhost:8000/api/pay/show/recentOrder',
                  method: 'get',
                  headers: headers,
                  params: {
                    userUnum: this.$store.state.userInfo.userUnum
                  }
                })
                .then(res => {
                  var orderUnum = res.data;
                  if (this.products != null) {
                    for (var i = 0; i < this.products.length; i++) {
                      var body2 = {
                        orderUnum: orderUnum,
                        productUnum: this.products[i].productUnum,
                        paymentCount: this.products[i].cartCount,
                        paymentPrice: this.products[i].cartPrice
                      };

                      axios({
                          url: 'http://localhost:8000/api/pay/regist/payment',
                          method: 'post',
                          headers: headers,
                          data: body2
                        })
                        .then(res => {
                          axios({
                              url: 'http://localhost:8000/api/pay/trash/cart',
                              method: 'delete',
                              headers: headers,
                              params: {
                                userUnum: this.$store.state.userInfo.userUnum
                              }
                            })
                            .then(res => {
                              if (this.count == 0) {
                                alert("결제가 완료되었습니다.");
                                this.count++;
                              }
                              if (this.$route.path !== '/deliveryitem') {
                                this.$router.push('/deliveryitem');
                                location.replace('#app');
                              }
                            }, error => {
                              alert("장바구니 내역이 갱신되지 못했습니다.");
                            });
                        }, error => {
                          alert(this.product[i].productUnum + " 상품의 결제가 정상적으로 이루어지지 않았습니다.");
                        });
                    }
                  } else {
                    var body2 = {
                      orderUnum: orderUnum,
                      productUnum: this.payProductUnum,
                      paymentCount: this.payProductCount,
                      paymentPrice: this.payProductPrice
                    };

                    axios({
                        url: 'http://localhost:8000/api/pay/regist/payment',
                        method: 'post',
                        headers: headers,
                        data: body2
                      })
                      .then(res => {
                        alert("결제가 완료되었습니다.");
                        if (this.$route.path !== '/deliveryitem') {
                          this.$router.push('/deliveryitem');
                          location.replace('#app');
                        }
                      }, error => {
                        alert(this.payProductUnum + " 상품의 결제가 정상적으로 이루어지지 않았습니다.");
                      });
                  }
                }, error => {
                  alert("결제 진행 중 문제가 발생했습니다.");
                });
            }, error => {
              alert("결제수단을 선택해주십시오.");
            });
        } else {
          alert("주문 상품정보 및 서비스 이용약관에 동의하십시오.");
        }
      },
      wonSubstring(won) {
        return won.toLocaleString();
      }
    }
  }
</script>

<style scoped>
  .payment {
    margin-left: 323px;
    margin-top: 20px;
    width: 930px;
    /* height: 300px; */
  }

  .line {
    border: 1px solid black;
    margin-bottom: 1%;
  }

  .payment__title {
    font-weight: 600;
    font-size: 18px;
  }

  .payment__info {
    margin-top: 1%;
    /* height: 30%; */
  }

  .payment__info__shipping-info {
    display: flex;
    border-bottom: 1px solid gainsboro;
    padding: 3% 0;
  }

  .label {
    /* border: 1px solid red; */
    width: 200px;
  }

  .info {
    /* border: 1px solid blue; */
    width: 730px;
  }

  .name-phone {
    display: flex;
  }

  .name-phone .phone {
    margin-left: 2%;
  }

  .addrwrap {
    display: flex;
  }

  .addrwrap .addr-changebtn {
    margin-left: 3%;
    color: #6d6d6d;
    font-size: 14px;
  }

  .payment__info__shipping-request {
    display: flex;
    border-bottom: 1px solid gainsboro;
    padding: 3% 0;
  }

  .phonewrap {
    display: flex;
  }

  .phone-changebtn {
    margin-left: 3%;
    color: #132c7d;
    font-size: 14px;
  }

  .phone-changebtn i {}

  .payment__info__phone {
    display: flex;
    margin-top: 3%;
  }

  .payment__info__name-email {
    display: flex;
  }

  .name-emailwrap {
    display: flex;
  }

  .name-email-changebtn {
    margin-left: 3%;
    color: #132c7d;
    font-size: 14px;
  }

  .order-product {
    margin-top: 10%;
  }

  .order-product__title {
    font-weight: 600;
    font-size: 18px;
  }

  .order-product__table {}

  .order-product__table .imgbox img {
    width: 130px;
    height: 130px;
  }

  .logo {
    background-color: #132c7d;
    color: white;
    width: 70px;
    height: 25px;
    text-align: center;
    margin-bottom: 5%;
  }

  .order-product__content {
    width: 70%;
    text-align: left;
    padding-left: 2%;
  }

  .order-product__pricewrap {
    /* border: 1px solid #c7c7c7; */
    width: 175px;
    height: 145px;
    padding-left: 5%;
  }

  .price {
    display: flex;
  }

  .inner-line {
    border: 1px solid gainsboro;
    width: 30%;
    margin: 5% 0;
  }

  .quantity-wrap {
    font-size: 14px;
    color: #6d6d6d;
  }

  .num {
    font-size: 16px;
    font-weight: 600;
    color: black
  }

  .payment__bottom {
    margin-top: 3%;
  }

  .totalpay {
    border: 3px solid gainsboro;
    text-align: center;
    padding: 1% 0;
  }

  .payment__bottom__btn {
    background-color: #132c7d;
    color: white;
    margin-top: 3%;
    padding: 2% 0;
    display: flex;
    justify-content: center;
  }

  .pay {
    font-weight: 900;
    font-size: 20px;
  }

  .one {
    font-size: 20px;
    font-weight: 400;
    margin-left: 1%;
  }

  @media screen and (max-width: 1500px) {
    .payment {
      margin-left: 256px;
    }
  }
</style>
