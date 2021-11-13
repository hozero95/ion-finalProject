<template>
  <body>
    <!-- slider -->
    <section class="slider">
      <!-- slider 왼쪽 -->
      <div
        id="carouselExampleControls"
        class="carousel slide"
        data-bs-ride="carousel"
      >
        <div class="slider__img">
          <div class="carousel-inner">
            <div
              id="carouselExampleControls"
              class="carousel slide"
              data-bs-ride="carousel"
              style="width: 8000px"
            >
              <div class="slider__img">
                <div class="carousel-inner">
                  <div class="carousel-item active test">
                    <img
                      src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/img1.jpg"
                      class="d-block w-30"
                      alt="..."
                      style="float: left"
                    />
                    <div class="slider__right" style="float: left">
                      <div class="slider__right__text">
                        <p>{{ seasonEvent.eventTitle }}</p>
                        <p>{{ seasonEvent.eventContent }}</p>
                      </div>
                    </div>
                  </div>
                  <div
                    class="carousel-item test"
                    v-for="(event, index) in events"
                    v-bind:key="index"
                  >
                    <img
                      src="https://raw.githubusercontent.com/sky4564/img/master/FinalProjectImg/img1.jpg"
                      class="d-block w-30"
                      alt="..."
                      style="float: left"
                    />
                    <div class="slider__right" style="float: left">
                      <div class="slider__right__text">
                        <p>{{ event.eventTitle }}</p>
                        <p>{{ event.eventContent }}</p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- MD 추천 -->
    <!-- seasonal -->
    <section class="seasonal">
      <div class="seasonal__top">
        <div class="seasonal__top__title">
          <p>{{ sort }} 제철 지나기 전에!!</p>
          <h1>{{ sort }}시즌 해물 추천</h1>
          <p>#{{ sort }} #해산물 #맛있다 :D</p>
          <!-- 전체보기 버튼 -->
          <div class="seasonal__top__all">
            <router-link to="seasonalProduct">
              <a href="">전체보기 <i class="fas fa-arrow-right"></i></a>
            </router-link>
          </div>
        </div>
      </div>
      <div class="seasonal__seafoods">
        <div
          class="seasonal__seafoods__wrap"
          v-for="(product, index) in seasonProduct"
          v-bind:key="index"
          @click="showDetail(product.productUnum)"
        >
          <a class="seasonal__seafoods__wrap__box">
            <router-link to="product">
              <img src="../images/img1.jpg" alt="해산물" class="seafood__img" />
            </router-link>
            <div class="seafood__info">
              <div class="seafood__info__top">
                <div class="logo">해물오빠</div>
                <div class="cart-icon">
                  <i class="fas fa-shopping-cart fa-2x"></i>
                </div>
              </div>
              <div class="seafood__info__title">
                <a class="seafood__info__clickable">{{
                  product.productName
                }}</a>
              </div>
              <div class="seafood__info__price">
                {{ product.productPrice }}원
              </div>
            </div>
          </a>
        </div>
      </div>
    </section>

    <!-- best -->
    <section class="best">
      <div class="best__title">
        <h1>해물오빠 BEST</h1>
        <p>해물오빠 인기상품을 먹어보세요!</p>
      </div>
      <!-- best nav bar -->
      <div class="best__navbar-mid nav_sticky explain-container">
        <ul class="best__navbar-mid__menu">
          <li
            class="best__navbar-mid__menu__iteam"
            @click="showBestProduct(-1)"
          >
            전체
          </li>
          <li
            v-for="(bigCate, index) in bigCates"
            v-bind:key="index"
            class="best__navbar-mid__menu__iteam"
            @click="showBestProduct(index)"
          >
            {{ bigCate.categoryName }}
          </li>
        </ul>
        <div style="float: none; clear: both"></div>
      </div>
      <!-- best nav bar end-->

      <!-- 제품 사진들  -->
      <!-- md__seafoods__wrap -->
      <div class="best__seafoods">
        <div
          class="best__seafoods__wrap"
          v-for="(product, index) in list"
          v-bind:key="index"
          @click="showDetail(product.productUnum)"
        >
          <a class="seafood">
            <img src="../images/img1.jpg" alt="해산물" class="seafood__img" />
            <div class="seafood__info">
              <div class="seafood__info__top">
                <div class="logo">해물오빠</div>
                <div class="cart-icon">
                  <i class="fas fa-shopping-cart fa-2x"></i>
                </div>
              </div>
              <div class="seafood__info__title">
                <a class="seafood__info__clickable">{{
                  product.productName
                }}</a>
              </div>
              <div class="seafood__info__price">
                {{ product.productPrice }}원
              </div>
            </div>
          </a>
        </div>
      <div class="more">
        <button @click="range()" v-if="showMore">
          See More <i class="fas fa-chevron-down"></i>
        </button>
      </div>
      </div>
      
    </section>
  </body>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      products: [
        {
          productsimg: "../images/img1.jpg",
          alt: "상품이미지1",
        },
        {
          productsimg: "../images/img1.jpg",
          alt: "상품이미지1",
        },
      ],
      seasonProduct: [], //메인시즌상품
      bestProduct: [], //메인베스트상품
      sort: "",
      bigCates: [],
      categoryUnum: null,
      categoryName: null,
      list: [],
      count: 0,
      showMore: true,
      events: [],
      seasonEvent: {},
    };
  },
  created() {
    this.showEvent();
    var now = new Date();
    var season = parseInt(now.getMonth()) + 1;
    var seasonmonth;

    if (parseInt(season / 3) == 1) {
      seasonmonth = 0; //봄
      this.sort = "봄";
    } else if (parseInt(season / 3) == 2) {
      seasonmonth = 1; //여름
      this.sort = "여름";
    } else if (parseInt(season / 3) == 3) {
      seasonmonth = 2; //가을
      this.sort = "가을";
    } else {
      seasonmonth = 3; //겨울
      this.sort = "겨울";
    }

    axios
      .get("http://localhost:8000/api/season/show/product", {
        params: {
          productSeason: seasonmonth,
        },
      })
      .then((res) => {
        var product = new Array();

        var dataLength = res.data.length;

        if (dataLength > 5) {
          dataLength = 5;
        }

        for (var i = 0; i < dataLength; i++) {
          if (
            res.data[i].productSeason != null &&
            res.data[i].productSeason != ""
          ) {
            product.push(res.data[i]);
          }
        }
        this.seasonProduct = product;
      });
    this.showBestNav(), this.showBestProduct(-1);
  },
  computed: {
    setCategoryUnum() {
      return this.$store.state.categoryUnum;
    },
    setCategoryName() {
      return this.$store.state.categoryName;
    },
  },
  watch: {
    setCategoryUnum() {
      this.categoryUnum = this.setCategoryUnum;
    },
    setCategoryName() {
      this.categoryName = this.setCategoryName;
    },
  },
  methods: {
    showBestNav() {
      axios.get("http://localhost:8000/api/best/show/nav").then((res) => {
        var bigCate = new Array();

        for (var i = 0; i < res.data.length; i++) {
          if (
            res.data[i].categoryRef == null ||
            res.data[i].categoryRef == ""
          ) {
            bigCate.push(res.data[i]);
          }
        }
        this.bigCates = bigCate;
      });
    },
    showBestProduct(index) {
      this.count = 0;
      this.list = [];
      var categoryUnum = -1;
      if (index != -1) {
        categoryUnum = this.bigCates[index].categoryUnum;
      }

      axios
        .get("http://localhost:8000/api/best/show/product", {
          params: {
            categoryUnum: categoryUnum,
          },
        })
        .then((res) => {
          var product = new Array();
          for (var i = 0; i < res.data.length; i++) {
            product.push(res.data[i]);
          }
          this.bestProduct = product;
          this.range();
        });
    },
    showEvent() {
      axios.get("http://localhost:8000/api/event/show/event").then((res) => {
        var event = new Array();
        for (var i = 0; i < res.data.length; i++) {
          if (i == 0) {
            this.seasonEvent = res.data[i];
          } else {
            event.push(res.data[i]);
          }
        }
        this.events = event;
      });
    },
    range() {
      var index = this.count;
      this.count += 9;
      if (this.count > this.bestProduct.length) {
        this.count = this.bestProduct.length;
        this.showMore = false;
      } else {
        this.showMore = true;
      }
      if (this.count > index) {
        for (var i = index; i < this.count; i++) {
          this.list.push(this.bestProduct[i]);
        }
      }
    },
    showDetail(productUnum) {
      this.$store.commit("setProductUnum", productUnum);

      if (this.$route.path !== "/product") {
        this.$router.push("/product");
        location.replace("#app");
      }
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}

body {
}

/* Slider */
.slider {
  background-color: #5172de;
  width: 100%;
  height: 511px;
}

.test {
  /* position: absolute; */
  /* display: inline-block; */
  background-color: blueviolet;
  width: 1500px;
  margin: 80px 0 0 500px;
  text-align: center;
}

.test img {
  border-radius: 10%;
}

.slider__right {
  background-color: palevioletred;
  float: left;
  padding-right: 500px;
  /* height: 511px; */
}

.slider__right__text {
  width: 100%;
  height: 50%;
  font-size: 40px;
  color: white;
  margin: 60px 50px 0 40px;
}

.slider__right__arrow {
  background-color: aqua;
  width: 160px;
  height: 40px;
  margin-top: 100px;
  margin-left: 200px;
}

/* seasonal */
.seasonal {
  /* background-color: aqua; */
  margin: 300px 300px 0 300px;
}

.seasonal__top__title {
  text-align: center;
}

.seasonal__top__all {
  text-align: right;
  padding-right: 35px;
  margin-bottom: 10px;
}

.seasonal__seafoods {
  display: flex;
  justify-content: space-around;
}
.seasonal__seafoods__wrap {
  margin: 30px 30px;
}
.seasonal__seafoods__wrap__box {
  background-color: #5172de;
}
.seasonal__seafoods__wrap__box:hover {
  margin-bottom: 30px;
}
.seasonal__seafoods img {
  width: 290px;
  height: 290px;
  border-radius: 5%;
  margin-bottom: 5%;
}

.seafood__info__top {
  display: flex;
  justify-content: space-between;
  margin: 3% 3% 3% 0;
}

.seafood__info__top .logo {
  background-color: #132c7d;
  color: white;
  width: 80px;
  height: 25px;
  text-align: center;
}

.seafood__info__title {
  margin-bottom: 1%;
}

/* best */
.best {
  margin-top: 100px;
}

.best__title {
  text-align: center;
}

.best__navbar-mid {
  margin: 0;
  background-color: #132c7d;
  height: 60px;
}
.nav_sticky {
  position: sticky;
  top: 0px;
}

.best__navbar-mid__menu {
  margin-left: 320px;
  margin-top: 20px;
  width: 66%;
  height: 60px;
  color: white;
  display: flex;
  justify-content: space-between;
  font-size: 20px;
}

.best__navbar-mid__menu__iteam {
  justify-content: center;
  margin-left: 30px;
  margin-top: 15px;
}

.best__seafoods {
  /* background-color: aquamarine; */

  margin: 10px 200px 0 200px;
  display: flex;
  flex-wrap: wrap;
  /* justify-content:space-around; */
}

.best__seafoods__wrap {
  margin: 3%;
}

.best__seafoods__wrap .seafood__img {
  width: 386px;
  height: 386px;
  margin-top: 30px;
  margin-bottom: 5%;
  border-radius: 5%;
}
.seafood__img:hover {
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
    transform: translateY(-20px);
  }
}

/* more btn */
.more {
  width: 3000px;
  height: 200px;
  text-align: center;
  margin-top: 100px;
}

.more button {
  border: 1px solid #132c7d;
  width: 10%;
  height: 30%;
  padding: 15px 20px;
  font-size: 20px;
  background: skyblue;
  color: white;
  border: none;
  border-radius: 5px;
  display: block;
  margin: 30px auto;
}
.more:hover {
  animation-name: shake;
  animation-duration: 1s;
}

@keyframes shake {
  0% {
    transform: rotate(0deg);
  }
  25% {
    transform: rotate(-8deg);
  }
  50% {
    transform: rotate(8deg);
  }
  75% {
    transform: rotate(-8deg);
  }
  100% {
    transform: rotate(0deg);
  }
}

/* 노트북 사이즈 */
@media screen and (max-width: 1500px) {
  .navbar-top__menu {
    /* background-color: black; */
    margin-left: 220px;
  }

  .slider__img {
    padding-left: 250px;
  }

  .slider__right {
    float: right;
    padding-right: 300px;
  }

  .seasonal {
    margin: 200px 0 0 80px;
  }

  .best__navbar-mid__menu {
    margin-left: 220px;
  }

  .best__seafoods {
    /* background-color:aquamarine; */
    margin-left: 75px;
  }

  /* .carousel-inner {
      position: flex;
      test test
    } */
}
/* .explain-container > ul {
  float: left;
  width: 25%;
}

@media screen and (max-width: 992px) {
  .explain-container > ul {
    float: left;
    width: 50%;
  }
}

@media screen and (max-width: 768px) {
  .explain-container > ul {
    float: none;
    width: 100%;
  }
} */


/* 추가 css */

ul {
    list-style: none;
  }

</style>