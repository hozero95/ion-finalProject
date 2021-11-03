<template>
  <body>
    <div class="container_my">

        <div class="header_my">


            <p class="user_name">#손님</p>
            <img class="ssg_img" src="" alt="img">


        </div>

        <div class="content_my">




            <div class="content_side">
                <div class="btn-group-vertical" role="group" aria-label="Button group with nested dropdown">

                    <div class="btn-group " role="group">
                        <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle btn_size"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            주문관리
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                            <li><a class="dropdown-item" href="#">주문/배송관리</a></li>
                            <li><a class="dropdown-item" href="#"></a></li>
                        </ul>
                    </div>

                    <div class="btn-group btn_size" role="group">
                        <button id="btnGroupDrop1 " type="button" class="btn btn-primary dropdown-toggle btn_size"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            활동관리
                        </button>
                        <ul class="dropdown-menu " aria-labelledby="btnGroupDrop1">
                            <li><a class="dropdown-item " href="#">리뷰관리</a></li>
                            <li><a class="dropdown-item" href="#">Q&A관리</a></li>
                        </ul>

                    </div>

                    <div class="btn-group" role="group">
                        <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle btn_size"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            정보관리
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                            <li><a class="dropdown-item" href="#">회원정보 변경</a></li>
                            <li><a class="dropdown-item" href="#">비밀번호 변경</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="content_body">

                <h2 class="body_header">주문배송 조회</h2>
                <div class="body_header2">
                    <span>조회기간 2021.07.28~2021.10.28(최근3개월)</span>
                    <span>조회설정</span>
                </div>
                <dl class="dl_head">
                    <dt>
                        <span class="codr_odrdeliv_odrdate notranslate" style="">2021.10.20</span>
                        <span>
                            <em style="">주문번호 : </em>
                            20211020-0074DF</span>
                        <button class="btn_small">상세보기<span></span></button>
                    </dt>
                    <dd>
                        <button type="button" class="btn_small"><span>내 주문내역에서 삭제 X</span></button>

                        <button type="button" class="btn_small"><span>| &nbsp&nbsp전자영수증</span> </span></button>

                        <button type="button" class="btn_small"><span>| &nbsp&nbsp장바구니 담기</span></button>
                    </dd>
                </dl>
                <div class="del_box">
                    <div class="del_box1">
                        <em><span>롯데택배</span>&nbsp;/&nbsp;403566618722&nbsp;&nbsp;</em>
                        배송완료
                    </div>

                    <div class="del_box2">
                        <div class="del_box2_ch">결제완료</div>
                        <div class="del_box2_ch">상품준비중</div>
                        <div class="del_box2_ch">배송준비중</div>
                        <div class="del_box2_ch">배송중</div>
                        <div class="del_box2_ch">배송완료</div>
                    </div>

                </div>

                <dl class="deli_info" role="presentation">
                    <dt style="width: 200px;">주문자 정보</dt>
                    <dd>
                        <span style="">
                            <span class="blind">주문자 성함</span><em style="">김병민</em>
                            <span class="blind">주문자 전화번호</span> 010-5553-0475</span>
                    </dd>
                </dl>

                <dl class="deli_info" role="presentation">
                    <dt style="width: 200px;">받으시는 분</dt>
                    <dd>
                        <span style="">
                            <span class="blind">받으시는분 성함</span><em style="">김병민</em>
                            <span class="blind">받으시는분 전화번호</span> 010-5553-0475</span>
                    </dd>
                </dl>


                <dl class="deli_info" role="presentation">
                    <dt style="width: 200px;">받으시는 주소</dt>
                    <dd>
                        <span style="">
                            <span class="blind">주소 성질</span><em style="">자택 : </em>
                            <span class="blind">주소 상세</span>서울시 관악구  ㅇ ㅇ ㅇ</span>
                    </dd>
                </dl>

                <div class="item_list" style="">
                    <table>
                        <colgroup>
                            <col style="width:100px">
                            <col style="width:500px">
                            <col style="width:185px">
                        </colgroup>
                        <tbody>
                            <tr name="divItemUnit">
                                <td>
                                    <div>
                                        <a href="" target="_blank">
                                            <span>
                                                <img src="/del.jpg" alt="상품" style="width: 90px; height: 70px;">
                                            </span>
                                        </a>
                                    </div>
                                </td>

                                <td>
                                    <div>
                                    </div>
                                    <p>
                                        <a href="http://www.ssg.com/item/itemView.ssg?itemId=1000038461881&amp;siteNo=6004&amp;salestrNo=6005"
                                            target="_blank">
                                            <span>STL-1944 방문손잡이 문손잡이 문고리 방문고리</span>
                                        </a>
                                    </p>
                                    <div>
                                    </div>
                                </td>

                                <td>
                                    <div>
                                        <span class="blind">판매가격</span> <em class="ssg_price notranslate"
                                            style="">9,800</em> <span class="ssg_tx">원</span>
                                    </div>
                                    <strong>수량</strong> <em>1</em><span>개</span>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <ul class="cs_button_area">
                    <button class="cs_button_item">반품신청</button>
                    <button class="cs_button_item">교환신청</button>
                    <button class="cs_button_item">리뷰작성</button>
                </ul>

                <div class="codr_contit ty_underline" style="">
                    <h3 class="codr_contit_tx" style="">주문에 불편함이 있으신가요?</h3>
                </div>

                <ul class="codr_lst">
                    <li>
                        <a class="codr_btn_view">
                            상품을 이미 받았는데 배송중입니다.
                        </a>
                    </li>
                    <li>
                        <a class="codr_btn_view">
                            쓱배송 예약시간을 바꾸고 싶어요.
                        </a>
                    </li>
                    <li>
                        <a class="codr_btn_view">
                            옵션을 잘못 선택했어요.
                        </a>
                    </li>
                    <li>
                        <a class="codr_btn_view">
                            배송받을 주소를 바꾸고 싶어요.
                        </a>
                    </li>
                    <li>
                        <a class="codr_btn_view">
                            무통장입금 주문을 카드결제하고 싶어요.
                        </a>
                    </li>
                    <li>
                        <a class="codr_btn_view">
                            교환/반품 접수를 취소할 수 있나요?
                        </a>
                    </li>
                </ul>
                <ul class="cs_button_area" style="text-align: center;">
                    <button class="cs_button_item">주문취소</button>
                    <button class="cs_button_item">교환신청</button>
                    <button class="cs_button_item">반품신청</button>
                    <button class="cs_button_item">E-mail 상담</button>
                </ul>
                
                    <div class="pay">
                        <div class="codr_contit ty_underline area_pay_info">
                            <h3 class="codr_contit_tx" style="">결제 정보</h3>
                        </div>
                        
                        <div>
                            <div class="pay_info" >
                                <div>총 주문금액</div>
                                <div>1111원</div>
                            </div>
                            <div class="pay_info">
                                <div>총 할인금액</div>
                                <div>0원</div>
                            </div>
                            <div class="pay_info">
                                <div>배송비</div>
                                <div>2500원</div>
                            </div>
                            <div class="pay_info topline">
                                <div>총 결제금액</div>
                                <div>3611원</div>
                            </div>
                        </div>
                    </div>    
                </div>      
            </div>
        </div>
    </div>        
</body>
</template>

<script>
export default {

}
</script>

<style>
/* header setting */
.container_my {
    /* background-color: aqua; */

    margin-top: 30px;
    margin-left: auto;
    margin-right: auto;
    border-right: 1px solid #d1dadd;
    border-left: 1px solid #d1dadd;
    width: 1020px;
    height: 2000px;
}

.header_my {
    background-color: #F3FAFE;
    border-bottom: 3px solid #203a4d;
    width: 1018px;
    height: 94px;
    margin: 20px 0px 20px 0px;
}

.header_tag {
    /* background-color: aquamarine; */
    height: 37px;
    width: 139px;
    float: left;
    margin: 8px 0px 8px 0px;
    padding: 32px 15px 9px 18px;
}

.user_name {
    height: 17.5px;
    width: 53.5px;
    font-size: 12px;

}

.ssg_img {
    height: 37px;
    width: 139px;
}


/* content area */
/* content_side setting  + content_body setting*/

.content_my {
    width: 1018px;
    height: 1600px;
    border: solid 3px red;
}

.content_side {
    /* background-color: aqua; */
    float: left;
    width: 200px;
    height: 1600px;
    border-right: solid 1px #d1dadd;
}

.btn {
    background-color: #F3FAFE;
    color: #203a4d;
}

.btn_size {
    width: 200px;
    height: 60px;
    border: solid 1px #d1dadd;
}


/* ------------------------side bar end-------------------------------- */


/* ------------------------content_my body start-------------------------------- */
.content_body {
    /* background-color: lightgray; */
    float: left;
    margin-left: 35px;
    width: 777px;
    height: 600px;
}

.body_header {
    height: fit-content;
    width: 780px;
    padding: 15px 0px 13px 10px;
    border-bottom: 1px solid #203a4d;
    line-height: 30px;
}

.body_header2 {
    background-color: #f5f5f5;

    height: 45px;
    width: 777px;
    padding: 22px 20px 18px;
    display: flex;
    justify-content: space-between;
    align-items: center;


}

.body_content {

    margin-top: 50px;
    height: 228px;
    width: 777px;
    text-align: center;

}

.cs {
    height: 40px;
    width: 200px;
    background-color: #f5f5f5;
    border: 1px solid #e0e0e0;

}

.dl_head{
    height: 60px;
    width: 777px;

    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 30px;
    border-top: 2px solid #222222;

}

.btn_small {
    border: none;
    background: transparent;
    font-size: 13px;
}

.del_box {
    background-color: powderblue;
    width: 777px;
    height: 150px;
}

.del_box1 {
    background-color: lightslategrey;
    width: 777px;
    height: 70px;
    display: flex;
    justify-content: center;
    align-items: center;
}

.del_box2 {
    width: 777px;
    height: 70px;
    display: flex;
    justify-content: center;
    align-items: center;

}

.del_box2_ch {
    background-color: #e0e0e0;
    height: 40px;
    width: 150px;
    border-radius: 20px;
    text-align: center;
    padding-top: 8px;
    border: 1px solid;
    display: inline;
    float: left;
}

.item_list {
    background-color: #d1dadd;
    margin-top: 20px;
    height: 90px;
    width: 777px;
    border-top: 1px solid #eeeeee;
    border-bottom: 1px solid #eeeeee;
}

td {
    background-color: burlywood;
    border: 3px solid red;
    height: 90px;
}

.cs_button_area {
    margin-top: 30px;
    text-align: end;
    background-color: aqua;

}

.cs_button_item {
    border: 1px solid #e0e0e0;
    border-radius: 1px;
    background: #f5f5f5;
    width: 150px;
    height: 40px;
}

.codr_contit {
    padding: 10px 0;
}

.ty_underline {
    border-bottom: 2px solid #222;
}

.codr_contit_tx {
    font-size: 24px;
    font-weight: normal;
    text-align: center;
    line-height: 1.3;
    letter-spacing: -1px;
}

ul {
    -webkit-padding-start: 0px;
    list-style-type: none;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    
}

li a {
    display: block;
    padding: 28 px 15 px 26 px 32 px;
    /* background: url(../img/order/bu_faq_q.png) no-repeat 0 25 px; */
    font-size: 14px;
    color: #222;
    line-height: 1.29;
    display: flex;
    justify-content: center;
    align-items: center;
}

.codr_btn_view{
    height: 50px;
    width: 777px;
    border: 1px solid black;
    
}

.blind{
    display: none;
}

.deli_info{
    margin-top: 20px;
    border-bottom: 1px solid #e0e0e0;
    height: auto;
    width: 777px;
    font-size: 13px;
    display: flex;
    align-items: center;

}
.area_pay_info{
    margin-left: auto;
    margin-right: auto;
    width: 400px;

}

.pay_info{
    width: 400px;
    font-size: 14px;
    margin-left: auto;
    margin-right: auto;
    padding: 5px;
    display: flex;
    justify-content: space-between;
}
.topline{
    font-size: 14px;
    font-weight: bold;
    border-top:  2px solid #e0e0e0;
}
.pay{
    /* background-color: antiquewhite; */
    margin-top: 70px;
    height: 400px;
    width: 777px;

}


/* ------------------------content_my body end-------------------------------- */
</style>