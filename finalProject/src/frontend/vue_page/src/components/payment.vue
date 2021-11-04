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
                                <div class="name">강다혜</div>
                                <div class="phone">010-7188-7110</div>
                            </div>
                            <div class="addrwrap">
                                <div class="addr">[자택] 경기도 수원시 권선구 서부로 1534, 106동 702호(고색동, 대한아파트)</div>
                                <div class="addr-changebtn">배송지 변경 <i class="fas fa-chevron-right"></i></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="payment__info">
                    <div class="payment__info__shipping-request">
                        <div class="label">택배배송 요청사항</div>
                        <div class="info">
                            <select name="" id="">
                                <option selected>Choose...</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                    </div>
                </div>
                <!-- 핸드폰 -->
                <div class="payment__info">
                    <div class="payment__info__phone">
                        <div class="label">핸드폰</div>
                        <div class="info">
                            <div class="phonewrap">
                                <div class="phone">010-7188-7110</div>
                                <div class="phone-changebtn">인증번호 변경하기 <i class="fas fa-chevron-right"></i></div>
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
                                <div class="name-email">강다혜 / 010-7188-7110</div>
                                <div class="name-email-changebtn">주문자 정보변경 <i class="fas fa-chevron-right"></i></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="payment__middle">
                <div class="order-product">
                    <div class="line"></div> 
                    <div class="order-product__title">주문상품 : 1개</div>
                    <table class="order-product__table">
                        <td class="imgbox">
                            <img src="../images/img1.jpg" alt="">
                        </td>
                        <td class="order-product__content">
                            <div class="logo">5징어</div>
                            <div class="title">맛있는 참게 10개 한묶음</div>
                        </td>
                        <td class="order-product__pricewrap">
                            <div class="price">40,000
                                <div class="won">원</div>
                            </div>
                            <div class="inner-line"></div>
                            <div class="quantity-wrap">
                                <span class="quantity">수량</span>
                                <span class="num">1</span>
                                <span class="gae">개</span>
                            </div>
                        </td>
                    </table>
                </div>
            </div>
            
            <div class="payment__bottom">
                <div class="totalpay">
                    <div class="">결제예정금액 37000원</div>
                    <div>(상품가 + 배송비)</div>
                </div>
                <div class="terms">
                    <input type="checkbox">
                    <span>주문 상품정보 및 서비스 이용약관에 모두 동의하십니까?</span>
                </div>
                <div class="payment__bottom__btn" type="button">
                    <div class="pay">37000</div>
                    <div class="one">원 결제하기</div>
                </div>
            </div>

            <!-- <div class="line"></div> -->
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.payment{
    margin-left: 323px;
    margin-top: 20px;
    width: 930px;
    /* height: 300px; */
}
.line{
    border: 1px solid black;
    margin-bottom: 1%;
}
.payment__title{
    font-weight: 600;
    font-size: 18px;
}
.payment__info{
    margin-top: 1%;
    /* height: 30%; */
}
.payment__info__shipping-info{
    display: flex;
    border-bottom: 1px solid gainsboro;
    padding: 3% 0;
}
.label{
    /* border: 1px solid red; */
    width: 200px;
}
.info{
    /* border: 1px solid blue; */
    width: 730px;
}
.name-phone{
    display: flex;
}
.name-phone .phone{
    margin-left: 2%;
}
.addrwrap{
    display: flex;
}
.addrwrap .addr-changebtn{
    margin-left: 3%;
    color: #6d6d6d;
    font-size: 14px;
}
.payment__info__shipping-request{
    display: flex;
    border-bottom: 1px solid gainsboro;
    padding: 3% 0;
}
.phonewrap{
    display: flex;
}
.phone-changebtn{
    margin-left: 3%;
    color: #132c7d;
    font-size: 14px;
}
.phone-changebtn i{
}
.payment__info__phone{
    display: flex;
    margin-top: 3%;
}
.payment__info__name-email{
    display: flex;
}
.name-emailwrap{
    display: flex;
}
.name-email-changebtn{
    margin-left: 3%;
    color: #132c7d;
    font-size: 14px;
}
.order-product{
    margin-top: 10%;
}
.order-product__title{
    font-weight: 600;
    font-size: 18px;
}
.order-product__table{
    
}
.order-product__table .imgbox img{
    width: 130px;
    height: 130px;
}
.logo{
    background-color: #132c7d;
    color: white;
    width: 60px;
    height: 25px;
    text-align: center;
    margin-bottom: 5%;
}
.order-product__content{
    width: 70%;
    text-align: left;
    padding-left: 2%;
}
.order-product__pricewrap{
    /* border: 1px solid #c7c7c7; */
    width: 175px;
    height: 145px;
    padding-left: 5%;
}
.price{
    display: flex;
}
.inner-line{
    border: 1px solid gainsboro;
    width: 30%;
    margin: 5% 0;
}
.quantity-wrap{
    font-size: 14px;
    color: #6d6d6d;
}
.num{
    font-size: 16px;
    font-weight: 600;
    color: black
}
.payment__bottom{
    margin-top: 3%;
}
.totalpay{
    border: 3px solid gainsboro;
    text-align: center;
    padding: 1% 0;
}
.payment__bottom__btn{
    background-color: #132c7d;
    color: white;
    margin-top: 3%;
    padding: 2% 0;
    display: flex;
    justify-content: center;
}
.pay{
    font-weight: 900;
    font-size: 20px;
}
.one{
    font-size: 20px;
    font-weight: 400;
    margin-left: 1%;
}

@media screen and (max-width: 1500px) {
    .payment{
        margin-left: 256px;
    }
}
</style>