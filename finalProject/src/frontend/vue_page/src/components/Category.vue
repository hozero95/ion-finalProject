<template>

  <body class="category_body">
    <!-- 해산물 카테고리 -->
    <section class="category">
      <div class="category__top">
        <div class="category__top__title">
          <h1>{{ categoryName }}</h1>
        </div>
        <span class="category__top__aside-text">
          <em>{{ products.length }}</em>
          개의 상품이 있습니다.
        </span>
      </div>

      <div class="category__top__line"></div>

      <!-- 정렬  -->
      <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
          data-bs-toggle="dropdown" aria-expanded="false">
          {{sort}}
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
          <li>
            <a class="dropdown-item" href="#" v-on:click="showNew()">최신순</a>
          </li>
          <li>
            <a class="dropdown-item" href="#" v-on:click="showLowerPrice()">낮은가격순</a>
          </li>
          <li>
            <a class="dropdown-item" href="#" v-on:click="showHigherPrice()">높은가격순</a>
          </li>
          <li>
            <a class="dropdown-item" href="#" v-on:click="showManyReply()">리뷰많은순</a>
          </li>
        </ul>
      </div>

      <div class="category__seafoods">
        <div class="category__seafoods__wrap" v-for="(product, index) in list" v-bind:key="index"
          @click="showDetail(product.productUnum)">
          <a class="seafood">
            <img :src="product.productImage01Path" alt="해산물" class="seafood__img cursor_pointer" />
            <div class="seafood__info">
              <div class="seafood__info__logo">해물오빠</div>
              <div class="seafood__info__title cursor_pointer">
                <a class="seafood__info__clickable">{{product.productName}}</a>
              </div>
              <div class="seafood__info__price cursor_pointer">
                {{wonSubstring(product.productPrice)}}원
              </div>
            </div>
          </a>
          <input type="hidden" :value="product.productUnum" />
        </div>
      </div>
    </section>

    <section class="more">
      <button @click="range()" v-if="showMore">
        See More <i class="fas fa-chevron-down"></i>
      </button>
    </section>
  </body>
</template>

<script>
  import axios from "axios";

  export default {
    name: "Category",
    data() {
      return {
        categoryUnum: null,
        categoryName: null,
        products: [], //실제데이터
        list: [], //뿌려질데이터
        count: 0,
        sort: "",
        showMore: true,
      };
    },
    created() {
      this.categoryUnum = this.$store.state.categoryUnum;
      this.categoryName = this.$store.state.categoryName;
      this.showNew();
      this.range();
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
        this.showNew();
      },
      setCategoryName() {
        this.categoryName = this.setCategoryName;
      },
    },
    methods: {
      showNew() {
        this.count = 0;
        this.list = [];
        axios
          .get("http://localhost:8000/api/productlist/show/product/new", {
            params: {
              categoryUnum: this.categoryUnum,
            },
          })
          .then((res) => {
            var product = new Array();
            for (var i = 0; i < res.data.length; i++) {
              product.push(res.data[i]);
            }
            this.products = product;
            this.sort = "최신순";
            this.range();
          });
      },
      showLowerPrice() {
        this.count = 0;
        this.list = [];
        axios
          .get("http://localhost:8000/api/productlist/show/product/lowerprice", {
            params: {
              categoryUnum: this.categoryUnum,
            },
          })
          .then((res) => {
            var product = new Array();
            for (var i = 0; i < res.data.length; i++) {
              product.push(res.data[i]);
            }
            this.products = product;
            this.sort = "낮은가격순";
            this.range();
          });
      },
      showHigherPrice() {
        this.count = 0;
        this.list = [];
        axios
          .get("http://localhost:8000/api/productlist/show/product/higherprice", {
            params: {
              categoryUnum: this.categoryUnum,
            },
          })
          .then((res) => {
            var product = new Array();
            for (var i = 0; i < res.data.length; i++) {
              product.push(res.data[i]);
            }
            this.products = product;
            this.sort = "높은가격순";
            this.range();
          });
      },
      showManyReply() {
        this.count = 0;
        this.list = [];
        axios
          .get("http://localhost:8000/api/productlist/show/product/manyreply", {
            params: {
              categoryUnum: this.categoryUnum,
            },
          })
          .then((res) => {
            var product = new Array();
            for (var i = 0; i < res.data.length; i++) {
              product.push(res.data[i]);
            }
            this.products = product;
            this.sort = "리뷰많은순";
            this.range();
          });
      },
      range() {
        var index = this.count;
        this.count += 9;
        if (this.count > this.products.length) {
          this.count = this.products.length;
          this.showMore = false;
        } else {
          this.showMore = true;
        }

        if (this.count > index) {
          for (var i = index; i < this.count; i++) {
            this.list.push(this.products[i]);
          }
        }
      },
      showDetail(productUnum) {
        this.moveScrollTop();
        this.$store.commit("setProductUnum", productUnum);

        if (this.$route.path !== "/product") {
          this.$router.push("/product");
          location.replace("#app");
        }
      },
      moveScrollTop() {
        window.scrollTo({
          top: 0
        });
      },
      wonSubstring(won){
        return won.toLocaleString();        
      }
    },
  };

</script>

<style scoped>
  /* MD 추천 */
  .category_body {

    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .category {
    width: 1300px;
    margin: 0 auto;
  }

  .category__top {
    margin-top: 6%;
    margin-left:190px
  }

  .category__top {
    display: flex;
    justify-content: flex-end;
  }

  .category__top__title {
    margin : 0 auto;
  }

  .category__top__aside-text {
    margin-top: 10px;
    margin-right: 42px;
  }

  .category__top__aside-text em {
    color: red;
  }

  .category__top__line {
    margin-top: 30px;
    border: 1px solid black;
  }

  /* 정렬 */
  .dropdown {
    display: flex;
    justify-content: end;
    margin: 3% 3% 0 0;
  }

  .category__seafoods {
    width: 1100px;
    /* margin-top: 3%; */
    display: flex;
    flex-wrap: wrap;
    margin : 3% 0 0 130px;
    /* text-align: center; */
    /* justify-content: center; */
  }

  .category__seafoods__wrap {
    margin: 0 60px 0 0;
  }

  .seafood__img:hover {
    animation-name: bounce;
    animation-duration: 1.5s;
    animation-fill-mode: forwards;
    animation-iteration-count: 3;
  }

  @keyframes bounce {
    0% {
      transform: translateY(0px);
    }

    70% {
      transform: translateY(-20px);
    }

    100% {
      transform: translateY(0px);
    }

  }

  .category__seafoods img {
    width: 290px;
    height: 290px;
    border-radius: 5%;
    margin-bottom: 5%;
  }

  .seafood__info__logo {
    background-color: #015a99;
    color: white;
    width: 80px;
    height: 25px;
    text-align: center;
    margin-bottom: 5%;
  }

  .seafood__info__title {
    margin-bottom: 2%;
  }

  .seafood__info__clickable {
    font-size: 20px;
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
    width: 8%;
    height: 30%;
    padding: 15px 20px;
    font-size: 20px;
    background: #015a99;
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
      transform: rotate(0deg)
    }

    25% {
      transform: rotate(-8deg)
    }

    50% {
      transform: rotate(8deg)
    }

    75% {
      transform: rotate(-8deg)
    }

    100% {
      transform: rotate(0deg)
    }
  }

  @media screen and (max-width: 1500px) {
    .category {
      margin-left: 70px;
    }
  }

  .cursor_pointer {
    cursor: pointer;
  }

</style>
