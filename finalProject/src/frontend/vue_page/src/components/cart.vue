<template>
      <div class="cart">
        <h3>장바구니</h3>
        <div class="left">
            <div class="left__top">
                <ul class="left__top__chk">
                    <li>
                        <span class="checkbox">
                            <input type="checkbox">
                            <label for="chk_all">전체선택</label>
                        </span>
                    </li>
                    <li>
                        <button type="button" class="btn_all">선택삭제</button>
                    </li>
                </ul>
                <div class="line"></div>
            </div>

            <!-- toggle sss -->
            <div class="accordion accordion-flush" id="accordionFlushExample">
                <div class="accordion-item">
                  <h2 class="accordion-header" id="panelsStayOpen-headingOne">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
                        <h4>
                            <input type="checkbox">
                            <label for="">택배배송 상품 : 1개</label>
                        </h4>
                    </button>
                  </h2>
                  <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingOne">
                    <div class="accordion-body">
                        <!--  -->
                        <div class="left__content">
                            <table class="left__content__table">
                                <td class="imgbox">
                                    <input type="checkbox">
                                    <img src="../images/img1.jpg" alt="">
                                </td>
                                <td class="content">
                                    <div class="logo">5징어</div>
                                    <div class="title">맛있는 참게 10개 한묶음</div>
                                </td>
                                <td class="pricewrap">
                                    <div class="price">40,000
                                        <div class="won">원</div>
                                    </div>
                                    <!-- <div class="addbtn"></div> -->
                                    <div class="add-box__add">
                                        <div class="add-box__add-btn minus">-</div>
                                        <div class="add-box__add-btn number">1</div>
                                        <div class="add-box__add-btn plus">+</div>
                                    </div>
                                </td>
                                <td class="btnarea">
                                    <div class="btnarea__btn">
                                        <div class="cartbtn">계속담아두기</div>
                                        <div class="buybtn">바로구매</div>
                                    </div>
                                    <div class="btnarea__icon"><i class="far fa-trash-alt"></i></div>
                                </td>
                            </table>
                            <div class="totalpay">
                                40,000원 + 배송비 0원 = 40,000원
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
                <label for="">기본배송지 : 자택</label>
                <div class="addr">
                    [16649] 경기 수원시 권선구 고산로6번길 45, 104동 804동 (고색동, 대원아파트)
                </div>
                <button class="addr-re">배송지 변경</button>
            </div>
            <div class="right__middle">
                <i class="fas fa-shopping-bag"></i>
                <label for="">전체상품 : 1개</label>

                <div class="right__middle__pays">
                    <ul class="right__middle__pay">
                        <li>주문금액</li>
                        <li>40,000 원</li>
                    </ul>
                    <ul class="right__middle__pay">
                        <li>배송비</li>
                        <li>0 원</li>
                    </ul>
                </div>
                <div class="payline"></div>
                <ul class="right__middle__pay total">
                    <li>결제예정금액</li>
                    <li>40,000 원</li>
                </ul>

            </div>
            <div class="right__btn">주문하기</div>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.cart{
    margin-left: 323px;
    margin-top: 20px;
}
.cart h3{
    margin-bottom: 1%;
}
.left{
    float: left;
    width: 930px;
    height: 300px;
}
.left__top__chk{
    padding: 0;
    display: flex;
    justify-content: space-between;
    color: #6d6d6d;
}
.left__top__chk button{
    color: #6d6d6d;
}
.line{
    border: 1px solid black;
    margin-bottom: 3%;
}

/* toggle */
.accordion-body{
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


.left__title{
    display: flex;
    justify-content: space-between;
}
.left__title label{
    margin-top: 10px;
}
.toggle-btn__on__icon{
    font-size: 24px;
}
.left__content__table .imgbox{
    position: relative;
    border: 1px solid #c7c7c7;
    border-left: none;
    width: 150px;
    height: 145px;
}
.left__content__table .imgbox input{
    position: absolute;
}
.left__content__table .imgbox img{
    width: 130px;
    height: 130px;
}
.left__content__table .content{
    border: 1px solid #c7c7c7;
    width: 355px;
    height: 145px;
    padding-left: 3%;
}
.left__content__table .content .logo{
    background-color: #132c7d;
    color: white;
    width: 60px;
    height: 25px;
    text-align: center;
    margin-bottom: 5%;
}
.left__content__table .pricewrap{
    border: 1px solid #c7c7c7;
    width: 175px;
    height: 145px;
    padding-left: 5%;
}
.left__content__table .pricewrap .price{
    display: flex;
    font-weight: bold;
    font-size: 24px;
    margin-top: 10%;
}
.left__content__table .pricewrap .won{
    font-weight: normal;
    font-size: 12px;
    margin-top: 12px;
    margin-left: 2px;
}

/* + - btn */
.add-box__add{
    display: flex;
    margin-top: 10px;
}
.add-box__add-btn{
    border: 1px solid #c7c7c7;
    width: 30px;
    height: 30px;
    text-align: center;
}

/*  */
.left__content__table .btnarea{
    border: 1px solid #c7c7c7;
    border-right: none;
    width: 145px;
    height: 145px;
}
.btnarea__btn{
    width: 120px;
    height: 10px;
    text-align: center;
    margin-left: 10%;
}
.cartbtn{
    border: 1px solid #c7c7c7;
    margin-bottom: 5%;
}
.buybtn{
    background-color: #132c7d;
    color: white;
}
.btnarea__icon{
    text-align: center;
    font-size: 18px;
    margin-top: 35%;
}

.totalpay{
    background-color: #e7e7e7;
    width: 825px;
    height: 50px;
    text-align: center;
    /* margin-right: 88px; */
    padding-top: 15px;
}
.totalpay p{
    margin-top: 5%;
}

.right{
    display: inline-block;
    width: 300px;
    height: 520px;
    border: 2px solid #f7f7f7;
    margin-left: 31px;
    padding: 1%;
    
}
.right__top{
    background-color: #f7f7f7;
    margin-bottom: 1%;
}
.right__top .addr{
    font-size: 14px;
    margin-bottom: 3%;
}
.right__top .addr-re{
    border: 1px solid #6d6d6d;
    width: 264px;
    height: 35px;
    background-color: white;
}
.right__middle{
    margin-top: 5%;
}
.right__middle__pays{
    margin-top: 50%;
}
.right__middle__pay{
    display: flex;
    justify-content: space-between;
}
.payline{
    border: 1px solid #c7c7c7;
    margin-bottom: 3%;
}
.total{
    color: #132c7d;
}
.right__btn{
    width: 264px;
    height: 60px;
    background-color: #132c7d;
    color: white;
    font-size: 24px;
    text-align: center;
    padding-top: 12px;
}

/* 노트북 사이즈 */
@media screen and (max-width: 1500px) { 
    .cart{
        margin-left: 100px;
    }
    .left{
        float: left;
        width: 880px;
    }
    .right{
        margin-left: 4%;
    }
}
</style>