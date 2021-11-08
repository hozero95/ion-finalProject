<template>
  <div>
    <!-- 해산물 카테고리 -->
    <section class="category">
      <div class="category__top">
        <div class="category__top__title">
          <h1>{{categoryName}}</h1>
        </div>
        <span class="category__top__aside-text">
          <em>{{products.length}}</em>
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
          <li><a class="dropdown-item" href="#" v-on:click="showNew()">최신순</a></li>
          <li><a class="dropdown-item" href="#" v-on:click="showLowerPrice()">낮은가격순</a></li>
          <li><a class="dropdown-item" href="#" v-on:click="showHigherPrice()">높은가격순</a></li>
          <li><a class="dropdown-item" href="#" v-on:click="showManyReply()">리뷰많은순</a></li>
        </ul>
      </div>


      <div class="category__seafoods">

        <div class="category__seafoods__wrap" v-for="(product, index) in products" v-bind:key="index">
          <a href="" class="seafood">
            <img src="../images/img1.jpg" alt="해산물" class="seafood__img" />
            <div class="seafood__info">
              <div class="seafood__info__logo">해물오빠</div>
              <div class="seafood__info__title">
                <a href="" class="seafood__info__clickable">{{product.productName}}</a>
              </div>
              <div class="seafood__info__price">{{product.productPrice}}원</div>
            </div>
          </a>
          <input type="hidden" :value="product.productUnum">
        </div>
      </div>

    </section>

    <section class="more">
      <button>해산물 더보기<i class="fas fa-chevron-down"></i></button>
    </section>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'Category',
    data() {
      return {
        categoryUnum: null,
        categoryName: null,
        products: [],
        sort: ''
      }
    },
    created() {
      this.categoryUnum = this.$store.state.categoryUnum;
      this.categoryName = this.$store.state.categoryName;
      this.showNew();
    },
    computed: {
      setCategoryUnum() {
        return this.$store.state.categoryUnum;
      },
      setCategoryName() {
        return this.$store.state.categoryName;
      }
    },
    watch: {
      setCategoryUnum() {
        this.categoryUnum = this.setCategoryUnum;
        this.showNew();
      },
      setCategoryName() {
        this.categoryName = this.setCategoryName;
      }
    },
    methods: {
      showNew() {
        axios.get('http://localhost:8000/api/productlist/show/product/new', {
            params: {
              categoryUnum: this.categoryUnum
            }
          })
          .then(res => {
            var product = new Array();
            for (var i = 0; i < res.data.length; i++) {
              product.push(res.data[i]);
            }
            this.products = product;
            this.sort = '최신순';
          });
      },
      showLowerPrice() {
        axios.get('http://localhost:8000/api/productlist/show/product/lowerprice', {
            params: {
              categoryUnum: this.categoryUnum
            }
          })
          .then(res => {
            var product = new Array();
            for (var i = 0; i < res.data.length; i++) {
              product.push(res.data[i]);
            }
            this.products = product;
            this.sort = '낮은가격순';
          });
      },
      showHigherPrice() {
        axios.get('http://localhost:8000/api/productlist/show/product/higherprice', {
            params: {
              categoryUnum: this.categoryUnum
            }
          })
          .then(res => {
            var product = new Array();
            for (var i = 0; i < res.data.length; i++) {
              product.push(res.data[i]);
            }
            this.products = product;
            this.sort = '높은가격순';
          });
      },
      showManyReply() {
        axios.get('http://localhost:8000/api/productlist/show/product/manyreply', {
            params: {
              categoryUnum: this.categoryUnum
            }
          })
          .then(res => {
            var product = new Array();
            for (var i = 0; i < res.data.length; i++) {
              product.push(res.data[i]);
            }
            this.products = product;
            this.sort = '리뷰많은순';
          });
      }
    }
  }
</script>

<style>
  /* MD 추천 */
  .category {
    /* background-color: aqua; */
    width: 1300px;
    margin: 30px 0 0 300px;
  }

  .category__top {
    margin-top: 6%;
  }

  .category__top {
    display: flex;
    justify-content: flex-end;
  }

  .category__top__title {
    margin-right: 30%;
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
    margin-top: 3%;
    display: flex;
    flex-wrap: wrap;
    /* justify-content:space-around; */
  }

  .category__seafoods__wrap {
    margin-left: 2%;
    margin-bottom: 2%;
  }

  .category__seafoods img {
    width: 290px;
    height: 290px;
    border-radius: 5%;
    margin-bottom: 5%;
  }

  .seafood__info__logo {
    background-color: #132c7d;
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
    text-align: center;
    margin-top: 100px;
  }

  .more button {
    border: 1px solid #132c7d;
    width: 10%;
    height: 30%;
  }

  @media screen and (max-width: 1500px) {
    .category {
      margin-left: 70px;
    }
  }
</style>