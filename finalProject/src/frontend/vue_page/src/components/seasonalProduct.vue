<template>
  <!-- seasonal -->
  <section class="seasonal">
    <div class="seasonal__img">
      <img src="../images/seasonal01.jpeg" alt="">
    </div>
    <div class="seasonal__seafoods">
      <div class="seasonal__seafoods__wrap" v-for="(product, index) in products" v-bind:key="index"
        @click="showDetail(product.productUnum)">
        <a class="seafood" target="blank" data-type="">
          <img :src="product.productImage01Path" alt="해산물" class="seafood__img cursor_pointer shadow" />
          <div class="seafood__info">
            <div class="seafood__info__top">
              <div class="logo">해물오빠</div>
              <!-- <div class="cart-icon"><i class="fas fa-shopping-cart"></i></div> -->
            </div>
            <div class="seafood__info__title cursor_pointer">
              <a class="seafood__info__clickable">{{product.productName}}</a>
            </div>
            <div class="seafood__info__price cursor_pointer">{{wonSubstring(product.productPrice)}}원</div>
            <input type="hidden" :value="product.productUnum">
          </div>
        </a>
      </div>
    </div>
  </section>

  
</template>

<script>
  import axios from 'axios'

  export default {
    data() {
      return {
        products: []
      }
    },
    created() {
      var now = new Date();
      var season = parseInt(now.getMonth()) + 1;
      // console.log(now);
      // console.log(season);
      var seasonmonth;
      if (parseInt(season / 3) == 1) {
        seasonmonth = 0; //봄
      } else if (parseInt(season / 3) == 2) {
        seasonmonth = 1; //여름
      } else if (parseInt(season / 3) == 3) {
        seasonmonth = 2; //가을
      } else {
        seasonmonth = 3; //겨울
      }

      axios.get('http://localhost:8000/api/season/show/product', {
          params: {
            productSeason: seasonmonth
          }
        })
        .then(res => {
          var product = new Array();

          for (var i = 0; i < res.data.length; i++) {
            if (res.data[i].productSeason != null && res.data[i].productSeason != '') {
              product.push(res.data[i]);
            }
          }
          this.products = product;
          // console.log(this.products);
        })
    },
    methods: {
      showDetail(productUnum) {
        this.moveScrollTop();
        this.$store.commit('setProductUnum', productUnum);

        if (this.$route.path !== '/product') {
          this.$router.push('/product');
        }
      },
      moveScrollTop() {
        window.scrollTo({
          top: 0
        });
      },
      wonSubstring(won) {
        return won.toLocaleString();
      }
    },
  }
</script>

<style scoped>
  /* seasonal */
  .seasonal {
    /* background-color: aqua; */
    width: 1300px;
    margin: 100px auto;
  }

  .seasonal__img {
    text-align: center;
    margin-bottom: 5%;
    margin-left: 20px;
  }

  .seasonal__img img {
    width: 1232px;
    height: 340px;
  }

  .seasonal__seafoods {
    display: flex;
    flex-wrap: wrap;
    margin-left: 20px;
  }

  .seasonal__seafoods__wrap {
    margin-left: 2%;
    margin-bottom: 2%;
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
    background-color: #015a99;
    color: white;
    width: 80px;
    height: 25px;
    text-align: center;
  }

  .seafood__info__title {
    margin-bottom: 1%;
  }

  .seafood__info__clickable {
    font-size: 20px;
  }

  /* 노트북 사이즈 */
  @media screen and (max-width: 1500px) {
    .seasonal {
      margin-left: 60px;
    }
  }

  .cursor_pointer {
    cursor: pointer;
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
</style>
