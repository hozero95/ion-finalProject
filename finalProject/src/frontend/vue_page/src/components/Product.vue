<template>
  <div>
    <!-- top -->
    <div class="container">
      <div class="row">

        <!-- top left -->
        <div class="col">
          <div class="title__img">
            <img class="title_img" :src="product.productImage01Path" alt="">
          </div>
        </div>
        <!-- top right -->
        <div class="col">

          <div class="seafood__info__title">
            <h4>[해물오빠] {{product.productName}}</h4>
            <h3>{{wonSubstring(productPrice)}}원</h3>
          </div>
          <hr>
          <div class="shipping-info-label">
            <div class="label">배송비</div>
            <div class="info">
              무료
              <br>
              제주 3,000원, 도서산간 3,000원 추가
            </div>
          </div>

          <!-- top right add box -->
          <div class="add-box">
            <p>[해물오빠] {{product.productName}}</p>
            <div class="add-box__bottom">
              <div class="add-box__add">
                <div class="add-box__add-btn minus cursor_pointer" @click="countMinus">-</div>
                <div class="add-box__add-btn number">{{productCount}}</div>
                <div class="add-box__add-btn plus cursor_pointer" @click="countPlus">+</div>
              </div>
              <div class="add-box__price">{{wonSubstring(productPrice)}}원</div>
            </div>
          </div>

          <!-- Price -->
          <div class="price-box">
            <span class="price-box__title">합계</span>
            <span class="price-box__price">{{wonSubstring(productPrice)}}원</span>
          </div>

          <!-- 장바구니 바로구매 버튼 -->
          <div class="button">
            <div class="button cartbtn cursor_pointer" @click="addCart">장바구니</div>
            <!-- <router-link to="payment"> -->
            <div class="button buy cursor_pointer" @click="goPayment()">바로구매</div>
            <!-- </router-link> -->
          </div>
        </div>

      </div>
    </div>

    <div class="product">
      <!-- product top -->
      <div class="product__top"></div>

      <!-- product wrap -->
      <div class="product__wrap">
        <!-- 상세정보 -->
        <div class="product__wrap__more-information"></div>
        <!-- 고객리뷰 -->
        <div class="product__wrap__customer-review"></div>
        <!-- 상품 Q&A-->
        <div class="product__wrap__product-qa"></div>
        <!-- 배송/반품/교환 안내 -->
        <div class="product__wrap__information">
          <!-- 배송안내 -->
          <div class="shipping__information"></div>
          <!-- 교환 및 반품 안내 -->
          <div class="exchange-return__information"></div>
        </div>
      </div>
    </div>

    <!-- product nav -->
    <div class="product-nav">
      <ul class="product-nav__menu">
        <li class="product-nav__menu__iteam"><a href="#targetInfo">상품상세정보</a></li>
        <li class="product-nav__menu__iteam"><a href="#targetReview">고객리뷰</a></li>
        <li class="product-nav__menu__iteam"><a href="#targetNotice">배송/반품/교환 안내</a></li>
      </ul>
    </div>

    <!-- 상품상세정보 -->
    <div id="targetInfo" class="product-info">
      <div class="product-info__num">
        <h3>상품상세정보</h3>
        <div class="product-info__line"></div>
        <p>상품번호 : {{product.productUnum}}</p>
      </div>
      <div class="product-info__info__detail">
        <div class="product-info__info__detail__line"></div>
        <div class="product-info__info__detail__img">
          <img :src="product.productImage02Path" alt="">
        </div>
        <!-- <div class="product-info__info__detail__img">
          <img src="../images/img1-2.png" alt="">
        </div> -->
      </div>
    </div>


    <!-- 고객리뷰 -->
    <div id="targetReview" class="product-review">
      <div class="product-review__title">
        <h3>고객리뷰</h3>
        <div class="product-review__line"></div>

        <!-- 고객리뷰 -->
        <div class="product-review__table">
          <table class="table">
            <tbody>
              <tr v-for="(reply, index) in replies" v-bind:key="index">
                <th scope="row">{{index + 1}}</th>
                <td>{{reply.replyContent}}</td>
                <td>{{hideId(reply.userId)}}</td>
                <td>{{toDate(reply.replyRegdate)}}</td>
              </tr>
            </tbody>
          </table>
        </div>


        <!-- 댓글 페이징 -->
        <!-- <div class="comment__pagging">
          <nav aria-label="...">
            <ul class="pagination pagination-sm">
              <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">1</a>
              </li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item"><a class="page-link" href="#">4</a></li>
              <li class="page-item"><a class="page-link" href="#">5</a></li>
              <li class="page-item"><a class="page-link" href="#">6</a></li>
              <li class="page-item"><a class="page-link" href="#">7</a></li>
              <li class="page-item"><a class="page-link" href="#">8</a></li>
              <li class="page-item"><a class="page-link" href="#">9</a></li>
              <li class="page-item"><a class="page-link" href="#">10</a></li>
              <li class="page-item"><a class="page-link" href="#">&gt;</a></li>
              <li class="page-item"><a class="page-link" href="#">&gt;&gt;</a></li>
            </ul>
          </nav>
        </div> -->

      </div>
    </div>

    <!-- 배송안내 -->
    <div id="targetNotice" class="shpping">
      <div class="shpping__title">
        <h3>배송안내</h3>
        <div class="shpping__line"></div>
        <div class="shpping__info">
          <img src="../images/shpping.png" alt="">
        </div>
      </div>
    </div>

    <!-- 교환 및 반품 안내 -->
    <div class="exchanges-returns">
      <div class="exchanges-returns__title">
        <h3>교환 및 반품 안내</h3>
        <div class="exchanges-returns__line"></div>
        <div class="exchanges-returns__info">
          <img src="../images/change.png" alt="">
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';

  export default {
    data() {
      return {
        productUnum: null,
        product: {},
        productCount: 1,
        productPrice: 0,
        replies: []
      }
    },
    created() {
      this.productUnum = this.$store.state.productUnum;
      this.productPrice = 0;
      this.getProduct();
      this.getReply();
    },
    computed: {
      setProductUnum() {
        return this.$store.state.productUnum;
      }
    },
    watch: {
      setProductUnum() {
        this.productUnum = this.setProductUnum;
        this.productCount = 1;
        this.productPrice = 0;
        this.getProduct();
        this.getReply();
      }
    },
    methods: {
      getProduct() {
        // console.log(this.productUnum);
        axios.get('http://localhost:8000/api/detail/show/product', {
            params: {
              productUnum: this.productUnum
            }
          })
          .then(res => {
            this.product = res.data[0];
            this.productPrice = this.product.productPrice;
          }, error => {
            alert("상품 정보를 불러오는데 실패하였습니다.");
            this.$router.push('/');
          });
      },
      getReply() {
        axios.get('http://localhost:8000/api/detail/show/reply', {
            params: {
              productUnum: this.productUnum
            }
          })
          .then(res => {
            this.replies = res.data;
          }, error => {
            alert("리뷰 정보를 불러오는데 실패하였습니다.");
            this.$router.push('/');
          });
      },
      countMinus() {
        if (this.productCount > 1) {
          this.productCount--;
          this.productPrice -= this.product.productPrice;
        } else {
          alert("수량은 1개 미만일 수 없습니다.");
        }
      },
      countPlus() {
        if (this.productCount < 10) {
          this.productCount++;
          this.productPrice += this.product.productPrice;
        } else {
          alert("수량은 최대 10개까지 선택이 가능합니다.");
        }
      },
      toDate(date) {
        return new Date(date).toLocaleDateString('en-US');
      },
      hideId(id) {
        var maskingId = '';
        var idLength = id.length;

        if (idLength < 3) {
          maskingId = id.replace(/(?<=.{1})./gi, "*");
        } else {
          maskingId = id.replace(/(?<=.{2})./gi, "*");
        }

        return maskingId;
      },
      addCart() {
        if (this.$store.state.jwtToken != null && this.$store.state.jwtToken != '') {
          var headers = {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + this.$store.state.jwtToken
          };

          var body = {
            userUnum: this.$store.state.userInfo.userUnum,
            productUnum: this.productUnum,
            cartCount: this.productCount,
            cartPrice: this.productPrice,
            cartAddress: this.$store.state.userInfo.userAddress
          }

          axios.defaults.headers.post = null;
          axios({
              url: 'http://localhost:8000/api/detail/regist/cart',
              method: 'post',
              headers: headers,
              data: body
            })
            .then((res) => {
              if (res.data) {
                alert("장바구니에 등록되었습니다.");
                if (confirm("장바구니로 이동하시겠습니까?")) {
                  this.$router.push('/cart');
                }
              } else {
                alert("이미 장바구니에 들어있는 상품이거나, 장바구니에 담을 수 없는 상품입니다.");
              }
            })
            .catch((err) => {
              alert("이미 장바구니에 들어있는 상품이거나, 장바구니에 담을 수 없는 상품입니다.");
            });
        } else {
          alert("로그인이 필요한 서비스입니다.");
          this.$router.push('/login');
        }
      },
      goPayment() {
        if (this.$store.state.jwtToken != null && this.$store.state.jwtToken != '') {
          this.$store.commit('setPayProductUnum', this.productUnum);
          this.$store.commit('setPayProductCount', this.productCount);
          this.$store.commit('setPayProductPrice', this.productPrice);

          if (this.$route.path !== '/payment') {
            this.$router.push('/payment');
          }
        } else {
          alert("로그인이 필요한 서비스입니다.");
          this.$router.push('/login');
        }
      },
      wonSubstring(won) {
        return won.toLocaleString();
      }
    }
  }
</script>

<style scoped>
  body {
    padding: 0px;
    margin: 0px;
  }

  .container {
    margin-top: 30px;
  }

  .shipping-info-label {
    display: flex;
    margin-top: 20px;
  }

  .shipping-info-label .label {
    width: 80px;
  }

  .shipping-info-label .info {
    margin-left: 30px;
  }

  /* top right add-Box */
  .add-box {
    width: 96%;
    background-color: #fafafa;
    margin-top: 50px;
    padding: 10px;
  }

  .add-box__bottom {
    display: flex;
  }

  .add-box__add {
    display: flex;
    margin-top: 50px;
  }

  .add-box__add-btn {
    border: 1px solid black;
    border-radius: 20%;
    width: 30px;
    height: 30px;
    text-align: center;

  }

  .add-box__price {
    font-size: 20px;
    margin-top: 55px;
    margin-left: 70%;
  }

  /* top right price */
  .price-box {
    text-align: right;
    margin-top: 12%;
    /* margin-right: 2%; */
  }

  .price-box__title {
    font-size: 20px;
  }

  .price-box__price {
    margin-left: 10px;
    font-size: 28px;
    font-weight: 600;
    color: #ff5c59;
  }

  .button {
    text-align: center;
    display: flex;
    width: 500px;
    height: 60px;
    color: white;
  }

  .button .cartbtn {
    background-color: #222;
    padding: 16px 0 0 85px;
  }

  .button .buy {
    background-color: #132c7d;
    padding: 16px 0 0 85px;
  }


  /* product-nav */
  .product-nav {
    margin-top: 10%;

  }

  .product-nav__menu {
    height: 70px;
    color: black;
    display: flex;
    font-size: 20px;
    justify-content: center;
  }

  .product-nav__menu__iteam {
    border: 1px solid gainsboro;
    width: 435px;
    text-align: center;
    padding-top: 20px;
  }

  /* .product-nav__menu__iteam :hover{
    background-color: #132c7d;
} */

  /* 상세정보 */
  .product-info {
    margin-top: 100px;
  }

  .product-info__line {
    border: 2px solid black;
    width: 81%;
    margin-bottom: 20px;
  }

  .product-info__num {
    padding-left: 310px;
  }

  .product-info__info__detail__img {
    text-align: center;
  }

  /* 고객리뷰 */
  .product-review {
    margin-top: 10%;

  }

  .product-review__title {
    margin-left: 320px;
  }

  .product-review__line {
    border: 2px solid black;
    width: 81%;
    margin-bottom: 20px;
  }

  .product-review__table {
    margin-right: 19%;
  }

  .product-review__box {
    margin-top: 3%;
    display: flex;
    border: 1px solid gainsboro;
    padding-left: 7%;
    width: 35%;
    margin-left: 33%;
    align-items: center;
  }

  .product-review__box__left .text {
    font-size: 20px;
  }

  .product-review__box__meddle .avr {
    font-size: 60px;
    margin-left: 50px;
  }

  .product-review__box__meddle .total {
    font-size: 30px;
    color: gainsboro;
  }

  .product-review__box__right {
    margin-left: 50px;
    font-size: 50px;
  }

  /* 댓글 */
  .comment {
    margin: 10px 320px 0 320px;
    /* align-items: center; */
    /* margin-top: 10%; */
  }

  .comment__line {
    border: 2px solid black;
    margin-bottom: 3%;

  }

  .comment__pagging {
    padding-left: 27%;
    margin-top: 5%;
  }


  /* 배송 안내 */
  .shpping {
    margin-left: 320px;
    margin-top: 10%;
  }

  .shpping__title {
    font-size: 18px;
  }

  .shpping__line {
    border: 2px solid black;
    width: 81%;
    margin-bottom: 20px;
  }

  .shpping__info img {
    width: 70%;
  }

  /* 교환 및 반품 */
  .exchanges-returns {
    margin-left: 320px;
    margin-top: 10%;
  }

  .exchanges-returns__title {
    font-size: 18px;
  }

  .exchanges-returns__line {
    border: 2px solid black;
    width: 81%;
    margin-bottom: 20px;
  }

  .product-qna-table {
    margin: 0;
    padding-right: 20%;
  }

  .exchanges-returns__info img {
    width: 70%;
  }

  /* 노트북 사이즈 */
  @media screen and (max-width: 1500px) {
    .product-nav__menu {
      margin-left: 5%;
    }

    .product-info__num {
      padding-left: 20%;
    }
  }

  .cursor_pointer {
    cursor: pointer;
  }

  .title_img {
    width: 510px;
    height: 510px;
  }
</style>