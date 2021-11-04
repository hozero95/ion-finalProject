<template>
  <div>
    <!-- top -->
    <div class="container">
        <div class="row">
          <!-- top left -->
          <div class="col">
              <div class="title__img">
                <img src="../images/img1.jpg" alt="">
              </div>
          </div>
          <!-- top right -->
          <div class="col">
            <div class="seafood__info__title">
                <h4>[5징어] 맛있는 참게</h4>
                <h3>23,000원</h3>
            </div>
            <hr>
            <div class="shipping-info-label">
                <div class="label">배송비</div>
                <div class="info">
                    무료
                    <br>
                    제주 3000원, 도서산간 3000원 추가
                </div>
            </div>
            <!-- top right add box -->
            <div class="add-box">
                <p>[5징어] 맛있는 참게</p>
                <div class="add-box__bottom">
                    <div class="add-box__add">
                        <div class="add-box__add-btn minus">-</div>
                        <div class="add-box__add-btn number">1</div>
                        <div class="add-box__add-btn plus">+</div>
                    </div>
                    <div class="add-box__price">23000원</div>
                </div>
            </div>

            <!-- Price -->
            <div class="price-box">
                <span class="price-box__title">합계</span>
                <span class="price-box__price">23000원</span>
            </div>

            <!-- 장바구니 바로구매 버튼 -->
            <div class="button">
                <router-link to="cart"><button class="button cartbtn">장바구니</button></router-link> 
                <router-link to="payment"><div class="button buy">바로구매</div></router-link> 
            </div>
          </div>
        </div>
    </div>

    <div class="product">
        <!-- product top -->
        <div class="product__top">

        </div>

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
                <div class="shipping__information">

                </div>
                <!-- 교환 및 반품 안내 -->
                <div class="exchange-return__information">

                </div>
            </div>
            
        </div>
    </div>

    <!-- product nav -->
    <div class="product-nav">
        <ul class="product-nav__menu">
            <li class="product-nav__menu__iteam">상품상세정보</li>
            <li class="product-nav__menu__iteam">고객리뷰</li>
            <!-- <li class="product-nav__menu__iteam">상품Q&A</li> -->
            <li class="product-nav__menu__iteam">배송/반품/교환 안내</li>
        </ul>
    </div>

    <!-- 상품상세정보 -->
    <div class="product-info">
        <div class="product-info__num">
            <h3>상품상세정보</h3>
            <div class="product-info__line"></div>
            <p>상품번호 : 1000256725469</p>
        </div>
        <div class="product-info__info__detail">
            <div class="product-info__info__detail__line"></div>
            <div class="product-info__info__detail__img">
                <img src="../images/img1-1.png" alt="">
            </div>
            <div class="product-info__info__detail__img">
                <img src="../images/img1-2.png" alt="">
            </div>
        </div>
    </div>


    <!-- 고객리뷰 -->
    <div class="product-review">
        <div class="product-review__title">
            <h3>고객리뷰</h3>
            <div class="product-review__line"></div>

            <!-- 고객리뷰 -->
            <div class="product-review__table">
                <table class="table">
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>너무 잘 받았습니다. 선물했는데, 너무 좋아하셔서 제가 더 기분이 좋네요</td>
                        <td>pal******</td>
                        <td>2021-10-02</td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <td>너무 잘 받았습니다. 선물했는데, 너무 좋아하셔서 제가 더 기분이 좋네요</td>
                        <td>pal******</td>
                        <td>2021-10-02</td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <td>너무 잘 받았습니다. 선물했는데, 너무 좋아하셔서 제가 더 기분이 좋네요</td>
                        <td>pal******</td>
                        <td>2021-10-02</td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <td>너무 잘 받았습니다. 선물했는데, 너무 좋아하셔서 제가 더 기분이 좋네요</td>
                        <td>pal******</td>
                        <td>2021-10-02</td>
                    </tr>
                    </tbody>
                </table>
            </div>


            <!-- 댓글 페이징 -->
            <div class="comment__pagging">
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
            </div>
            
        </div>
    </div>

    <!-- 배송안내 -->
    <div class="shpping">
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
export default {

}
</script>

<style>
body{
    padding: 0px;
    margin: 0px;
}
.container{
    margin-top: 30px;
}
.shipping-info-label{
    display: flex;
    margin-top: 20px;
}
.shipping-info-label .label{
    width: 80px;
}
.shipping-info-label .info{
    margin-left: 30px;
}

/* top right add-Box */
.add-box{
    width: 96%;
    background-color: #fafafa;
    margin-top: 50px;
    padding: 10px;
}
.add-box__bottom{
    display: flex;
}
.add-box__add{
    display: flex;
    margin-top: 50px;
}
.add-box__add-btn{
    border: 1px solid black;
    border-radius: 20%;
    width: 30px;
    height: 30px;
    text-align: center;
    
}
.add-box__price{
    font-size: 20px;
    margin-top: 55px;
    margin-left: 70%;
}

/* top right price */
.price-box{
    text-align: right;
    margin-top: 12%;
    /* margin-right: 2%; */
}
.price-box__title{
    font-size: 20px;
}
.price-box__price{
    margin-left: 10px;
    font-size: 28px;
    font-weight: 600;
    color: #ff5c59;
}
.button{
    display: flex;
    width: 100%;
    height: 60px;
    color: white;
}
.button .cartbtn{
    background-color: #222;
    padding: 20px 0 0 130px;
}
.button .buy{
    background-color: #132c7d;
    padding: 20px 0 0 130px;
}


/* product-nav */
.product-nav{
    margin-top: 10%;
    
}
.product-nav__menu{
    margin-left: 310px;
    height: 70px;
    color: black;
    display: flex;
    font-size: 20px;
    
}
.product-nav__menu__iteam{
    border: 1px solid gainsboro;
    width: 435px;
    text-align: center;
    padding-top: 20px;
}
/* .product-nav__menu__iteam :hover{
    background-color: #132c7d;
} */

/* 상세정보 */
.product-info{
    margin-top: 100px;
}
.product-info__line{
    border: 2px solid black;
    width: 81%;
    margin-bottom: 20px;
}
.product-info__num{
    padding-left: 310px;
}

.product-info__info__detail__img{
    text-align: center;
}

/* 고객리뷰 */
.product-review{
    margin-top: 10%;
    
}

.product-review__title{
    margin-left: 320px;
}
.product-review__line{
    border: 2px solid black;
    width: 81%;
    margin-bottom: 20px;
}
.product-review__table{
    margin-right: 19%;
}
.product-review__box{
    margin-top: 3%;
    display: flex;
    border: 1px solid gainsboro;
    padding-left: 7%;
    width: 35%;
    margin-left: 33%;
    align-items: center;
}
.product-review__box__left .text{
    font-size: 20px;
}

.product-review__box__meddle .avr{
    font-size: 60px;
    margin-left: 50px;
}
.product-review__box__meddle .total{
    font-size: 30px;
    color: gainsboro;
}
.product-review__box__right{
    margin-left: 50px;
    font-size: 50px;
}

/* 댓글 */
.comment{
    margin: 10px 320px 0 320px;
    /* align-items: center; */
    /* margin-top: 10%; */
}

.comment__line{
    border: 2px solid black;
    margin-bottom: 3%;

}
.comment__pagging{
   padding-left: 27%;
   margin-top: 5%;
}


/* 배송 안내 */
.shpping{
    margin-left: 320px;
    margin-top: 10%;
}
.shpping__title{
    font-size: 18px;
}
.shpping__line{
    border: 2px solid black;
    width: 81%;
    margin-bottom: 20px;
}
.shpping__info img{
    width: 70%;
}

/* 교환 및 반품 */
.exchanges-returns{
    margin-left: 320px;
    margin-top: 10%;
}
.exchanges-returns__title{
    font-size: 18px;
}
.exchanges-returns__line{
    border: 2px solid black;
    width: 81%;
    margin-bottom: 20px;
}
.product-qna-table{
    margin: 0;
    padding-right: 20%;
}
.exchanges-returns__info img{
    width: 70%;
}

/* 노트북 사이즈 */
@media screen and (max-width: 1500px) {
    .product-nav__menu{
        margin-left: 5%;
    }
    .product-info__num{
        padding-left: 20%;
    }
}
</style>