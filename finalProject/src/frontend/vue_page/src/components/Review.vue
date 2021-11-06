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

                <h2 class="body_header">리뷰 관리</h2>
                <img src="" alt="img" style="width: 777px; height: 62px;">

                <div class="body_content">
                    <h3>미등록리뷰 n건</h3>

                    <div class="content_tb">
                        <table>
                            <colgroup>
                                <col style="width:14%">
                                <col>
                                <col style="width:20%">
                                <col style="width:17%">
                            </colgroup>
                            <thead>

                                <tr class="th_box">
                                    <th scope="col" style="">주문번호</th>
                                    <th scope="col" style="">주문상품</th>
                                    <th scope="col" style=""><span class="blind">리뷰 혜택</span></th>
                                    <th scope="col" style=""><span class="blind">리뷰 쓰기</span></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="td_box">
                                        <p style=""><span style="">해당 기간에 구매내역이 없습니다.</span></p>
                                    </td>
                                </tr>

                            </tbody>

                        </table>
                    </div>

                    <h3>작성한리뷰 n건</h3>

                    <div class="content_tb">
                        <table>
                            <colgroup>
                                <col style="width:15%">
                                <col style="width:14%">
                                <col style="width:14%">
                                <col>
                            </colgroup>
                            <thead>
                                <tr class="th_box">
                                    <th scope="col" style="">주문상품</th>
                                    <th scope="col"><span class="blind">주문번호</span></th>
                                    <th scope="col" style="">작성일</th>
                                    <th scope="col"><span class="blind">수정/삭제</span></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="td_box">
                                        <p style=""><span style="">작성한 리뷰가 없습니다.</span></p>
                                    </td>
                                </tr>

                            </tbody>

                        </table>
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
    height: fit-content;
}

.header_my {
    background-color: #F3FAFE;
    border-bottom: 3px solid #203a4d;
    width: 1018px;
    height: 94px;
    margin: 20px 0px 20px 0px;
}
.header_tag{
    /* background-color: aquamarine; */
    height: 37px;
    width: 139px;
    float: left;
    margin: 8px 0px 8px 0px;
    padding: 32px 15px 9px 18px;
}
.user_name{
    height: 17.5px;
    width: 53.5px;
    font-size: 12px;

}
.ssg_img{
    height: 37px;
    width: 139px;
}


/* content area */
/* content_side setting  + content_body setting*/

.content_my{
    width: 1018px;
    height: 1000px;
    /* border : solid 3px red; */
}

.content_side{
    /* background-color: aqua; */
    float: left;
    width: 200px;
    height: 600px;
    
}

.btn_size{
    width: 200px;
    height: 60px;
}


/* ------------------------side bar end-------------------------------- */


/* ------------------------content_my body start-------------------------------- */
.content_body{
    /* background-color: lightgray; */
    float: left;
    margin-left: 35px;
    width: 777px;
    height: 600px;
}

.body_header{
    height: fit-content;
    width: 780px;
    padding: 15px 0px 13px 10px;
    border-bottom: 1px solid #203a4d;
    line-height: 30px;
}
.body_content{
    /* background-color: aquamarine; */
    margin-top: 30px;
    height: 207px;
    width: 777px;
}

.content_tb{
    /* background-color: brown; */
}

.blind{
    display: none;
}

h2{
    margin : 0px;
    padding: 0px;
    display: block;
    font-size: 26px;
    
}

h3{
    font-size: 20px;
    margin-top: 20px;
}

thead{
    /* background: red; */
    height: 18px;
    width: 80px;
    padding: 15px;
    border-bottom: 1px solid #ededed;
    color: #222;
    font-size: 12px;
}

.th_box{
    background-color: lightgray;
    width: 777px;
    height: 40px;
    border-top: 1px solid #203a4d;
    border-bottom: 1px solid #203a4d;
    margin-top: 10px;
    display: flex;
    justify-content: space-around;
    align-items: center;
}

.td_box{
    width: 777px;
    height: 100px;
    border-bottom: 1px solid #203a4d;
    display: flex;
    justify-content: center;
    align-items: center;

}

/* ------------------------content_my body end-------------------------------- */



</style>