<template>
  <!-- seasonal -->
  <section class="seasonal">
    <div class="seasonal__img">
      <img src="../images/seasonal01.jpeg" alt="">
    </div>
    <div class="seasonal__seafoods">
      <div class="seasonal__seafoods__wrap">
        <a href="" class="seafood" target="blank" data-type="">
          <img src="../images/img1.jpg" alt="해산물" class="seafood__img" />
          <div class="seafood__info">
            <div class="seafood__info__top">
              <div class="logo">5징어</div>
              <div class="cart-icon"><i class="fas fa-shopping-cart"></i></div>
            </div>
            <div class="seafood__info__title">
              <a href="" class="seafood__info__clickable">빨간줄 꼬리 새우</a>
            </div>
            <div class="seafood__info__price">50000원</div>
            <input type="hidden" value="">
          </div>
        </a>
      </div>
      <div class="seasonal__seafoods__wrap">
        <a href="" class="seafood" target="blank" data-type="">
          <img src="../images/img1.jpg" alt="해산물" class="seafood__img" />
          <div class="seafood__info">
            <div class="seafood__info__top">
              <div class="logo">5징어</div>
              <div class="cart-icon"><i class="fas fa-shopping-cart"></i></div>
            </div>
            <div class="seafood__info__title">
              <a href="" class="seafood__info__clickable">빨간줄 꼬리 새우</a>
            </div>
            <div class="seafood__info__price">50000원</div>
          </div>
        </a>
      </div>
      <div class="seasonal__seafoods__wrap">
        <a href="" class="seafood" target="blank" data-type="">
          <img src="../images/img1.jpg" alt="해산물" class="seafood__img" />
          <div class="seafood__info">
            <div class="seafood__info__top">
              <div class="logo">5징어</div>
              <div class="cart-icon"><i class="fas fa-shopping-cart"></i></div>
            </div>
            <div class="seafood__info__title">
              <a href="" class="seafood__info__clickable">빨간줄 꼬리 새우</a>
            </div>
            <div class="seafood__info__price">50000원</div>
          </div>
        </a>
      </div>
      <div class="seasonal__seafoods__wrap">
        <a href="" class="seafood" target="blank" data-type="">
          <img src="../images/img1.jpg" alt="해산물" class="seafood__img" />
          <div class="seafood__info">
            <div class="seafood__info__top">
              <div class="logo">5징어</div>
              <div class="cart-icon"><i class="fas fa-shopping-cart"></i></div>
            </div>
            <div class="seafood__info__title">
              <a href="" class="seafood__info__clickable">빨간줄 꼬리 새우</a>
            </div>
            <div class="seafood__info__price">50000원</div>
          </div>
        </a>
      </div>
    </div>
  </section>
</template>

<script>
  export default {

  }
</script>

<style scoped>
  /* seasonal */
  .seasonal {
    /* background-color: aqua; */
    width: 1300px;
    margin: 100px 0 0 300px;
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
    justify-content: space-evenly;
    margin-left: 20px;
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
    width: 60px;
    height: 25px;
    text-align: center;
  }

  .seafood__info__title {
    margin-bottom: 1%;
  }

  /* 노트북 사이즈 */
  @media screen and (max-width: 1500px) {
    .seasonal {
      margin-left: 60px;
    }
  }
</style>