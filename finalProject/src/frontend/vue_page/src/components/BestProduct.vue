<template>
  <div class="bestitem_body">
    <!-- best -->
    <section class="best">
      <div class="best__title">
        <h1>해물오빠 BEST</h1>
        <p>해물오빠 인기상품을 먹어보세요.</p>
      </div>

      <div class="container bestBtn">
        <div class="row row-cols-3 bestBtn__iteams">
          <button type="button" class="col bestBtn__iteam" @click="showProduct(-1)">
            전체
          </button>
          <button type="button" class="col bestBtn__iteam" v-for="(bigCate, index) in bigCates" v-bind:key="index"
            @click="showProduct(index)">
            {{ bigCate.categoryName }}
          </button>
        </div>
      </div>

      <!-- 제품 사진들  -->
      <!-- md__seafoods__wrap -->
      <div class="best__seafoods">
        <div class="best__seafoods__wrap" v-for="(product, index) in list" v-bind:key="index"
          @click="showDetail(product.productUnum)">
          <a class="seafood" target="blank" data-type="">
            <img :src="product.productImage01Path" alt="해산물" class="seafood__img cursor_pointer shadow" />
            <div class="seafood__info">
              <div class="seafood__info__top">
                <div class="logo">해물오빠</div>
                <div class="cart-icon">
                  <!-- <i class="fas fa-shopping-cart"></i> -->
                </div>
              </div>
              <div class="seafood__info__title cursor_pointer">
                <a class="seafood__info__clickable">{{
                  product.productName
                }}</a>
              </div>
              <div class="seafood__info__price cursor_pointer">
                {{ wonSubstring(product.productPrice) }}원
              </div>
            </div>
          </a>
        </div>
      </div>
    </section>

    <section class="more">
      <button @click="range()" v-if="showMore">
        See More <i class="fas fa-chevron-down"></i>
      </button>
    </section>
  </div>
</template>

<script>
  import axios from "axios";

  export default {
    data() {
      return {
        categoryUnum: null,
        categoryName: null,
        bigCates: [],
        products: [], //실제데이터
        list: [], //뿌려질 데이터
        count: 0,
        showMore: true,
      };
    },
    created() {
      axios.get("http://localhost:8000/api/best/show/nav").then((res) => {
        // console.log(res);
        var bigCate = new Array();

        for (var i = 0; i < res.data.length; i++) {
          if (res.data[i].categoryRef == null || res.data[i].categoryRef == "") {
            bigCate.push(res.data[i]);
          }
        }
        this.bigCates = bigCate;
        //   console.log(this.bigCates);
      });

      this.showProduct(-1);
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
      },
      setCategoryName() {
        this.categoryName = this.setCategoryName;
      },
    },
    methods: {
      showProduct(index) {
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
            this.products = product;
            this.range();
          });
      },
      range() {
        var index = this.count;
        this.count += 8;
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
        this.$store.commit("setProductUnum", productUnum);

        if (this.$route.path !== "/product") {
          this.$router.push("/product");
          location.replace("#app");
        }
      },
      wonSubstring(won) {
        return won.toLocaleString();
      }
    },
  };
</script>

<style scoped>
  .bestitem_body {
    /* background-color: aquamarine; */
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .bestBtn__iteams {
    margin-left: 45px;
    margin-right: 22px;
  }

  .bestBtn__iteam {
    border: 1px solid gainsboro;
    text-align: center;
    padding: 1%;
  }

  /* best */
  .best {
    margin-top: 3%;
  }

  .best__title {
    margin-left: 18%;
    margin-bottom: 2%;
  }

  .bestBtn {
    margin-bottom: 2%;
    /* margin-right: 333px; */
  }

  .best__seafoods {
    /* background-color:aquamarine; */
    width: 1700px;


    display: flex;
    flex-wrap: wrap;
    margin: 0 0 0 300px
      /* justify-content:space-around; */
  }

  .best__seafoods__wrap {
    margin-left: 0px;
  }

  .best__seafoods__wrap {
    margin: 30px;
  }

  .best__seafoods__wrap .seafood__img {
    width: 290px;
    height: 290px;
    margin-top: 10px;
    margin-bottom: 5%;
    border-radius: 5%;
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

  .seafood__info__top {
    display: flex;
    justify-content: space-between;
    margin: 3% 3% 3% 0;
  }

  .seafood__info__top .logo {
    background-color:#015a99;
    color: white;
    width: 80px;
    height: 25px;
    text-align: center;
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

  .cursor_pointer {
    cursor: pointer;
  }
</style>
