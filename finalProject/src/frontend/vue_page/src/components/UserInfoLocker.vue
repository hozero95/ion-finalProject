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

                <h2 class="body_header">회원정보 변경</h2>

                <div class="section notice_txt">
                    <p>
                        고객님의 개인정보를 소중하게 보호하려고 노력하고 있으며,<br>
                        회원님의 동의 없이는 입력하신 회원정보를 제공하지 않습니다.

                    </p>
                </div>
                <div class="information">
                    <p class="notifications">고객님의 개인정보 보호를 위해 비밀번호를 다시 한번 입력해 주시기 바랍니다.</p>
                </div>

                <form id="submitForm" method="post">

                    <div class="password_change">
                        <div class="wrap">
                            <label for="password" class="label">비밀번호 : </label>
                            <input type="password" id="password" name="password" title="비밀번호" value=""
                                class="input_text small" style="width: 270px">
                            <span class="error_txt small warning"></span>
                        </div>
                    </div>
                    <div class="btn_area">
                        <button type="submit" id="submitBtn" class="cs_btn">확인</button>
                    </div>
                </form>



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
    height: 900px;
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
    height: 700px;
    border : solid 3px red;
}

.content_side{
    /* background-color: aqua; */
    float: left;
    width: 200px;
    height: 600px;
    border-right: solid 1px #d1dadd;
}

.btn_size{
    width: 200px;
    height: 60px;
    border : solid 1px #d1dadd;
    
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
p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}

.notice_txt {
    
    border-bottom: 1px solid #69696a;
    text-align: center;
}

.information {
    position: relative;
    margin-top: 20px;
    font-family: "Spoqa-Regular", -apple-system, BlinkMacSystemFont, "Apple SD Gothic Neo", Arial, sans-serif;
    font-size: 11px;
    color: #777;
    letter-spacing: -1px;
    text-align: left;
}

.password_change{
    position: relative;
    height: 100px;
    margin-top: 30px;
    padding: 10px 0 30px 200px;
    border-top: 1px solid #e3e3e3;
    border-bottom: 1px solid #e3e3e3;
    background-color: #fbfbfb;
    display: flex;
    align-items: center;

}

.wrap {
    margin-top: 10px;
}

.btn_area{
    text-align: center;
    margin-top: 30px;
}


.cs_btn{
    background: #f14f4f;
    border: 1px solid #da3a3a;
    color: #fff;
    min-width: 130px;
    padding: 11px 16px;
    text-align: center;
}


/* ------------------------content_my body end-------------------------------- */





</style>