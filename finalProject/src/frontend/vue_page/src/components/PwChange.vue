<template>
  <body>
    <div class="container_my">

        <div class="header_my">


            <p class="user_name">#손님</p>
            <img class="ssg_img" src="./headimg.jpg" alt="img">


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
                        <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                            <li><a class="dropdown-item" href="#">리뷰관리</a></li>
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

                <h2 class="stit"><span>비밀번호 변경</span></h2>
                <form id="submitForm" method="post">
                    <div class="password_change">
                        <div class="wrap">
                            <label for="pwd" class="label">이전 비밀번호 : </label>
                            <input type="password" id="pwd" name="pwd" title="비밀번호" value="" class="input_text small"
                                style="width: 270px" maxlength="20">
                        </div>

                        <div class="wrap">
                            <label for="pwd" class="label">변경될 비밀번호 : </label>
                            <input type="password" id="pwd" name="pwd" title="비밀번호" value="" class="input_text small"
                                style="width: 270px" maxlength="20">
                        </div>
                        <div class="wrap">
                            <label for="newPwd" class="label">비밀번호 확인 : </label>
                            <input type="password" id="newPwd" name="newPwd" title="비밀번호" value=""
                                class="input_text small" style="width: 270px" maxlength="20">
                        </div>

                    </div>

                    <div class="btn_area">
                        <button type="submit" id="submitBtn" class="cs_btn">확인</button>
                    </div>



                </form>

                <div class="information">
                    <h4>주의하세요</h4>
                    <ul>
                        <li>비밀번호는 <span style="color: red;">영문과 숫자를 조합하여 8~20자리로 입력</span>해 주세요.</li>
                        <li>아이디와 같은 비밀번호나 주민등록번호, 생일, 학번, 전화번호 등 개인정보와 관련된 숫자, 연속된 숫자, 동일 반복된 숫자 등 <br>다른 사람이 쉽게 알아낼 수
                            있는 비밀번호는 사용하지 않도록 주의하여 주시기 바랍니다.</li>
                    </ul>
                </div>

            </div>

        </div>


    </div>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
    </script>
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
    background-color: aquamarine;
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
    height: 1000px;
    /* border: solid 3px red; */
}

.content_side {
    /* background-color: aqua; */
    float: left;
    width: 200px;
    height: 600px;

}

.btn_size {
    width: 200px;
    height: 60px;
    

}

/* ------------------------side bar end-------------------------------- */
.content_body {
    margin-left: 30px;
    width: 770px;
    float: left;
}

/* ------------------------pw_change start-------------------------------- */
.stit{
    padding-top: 15px;
    border-bottom: 1px solid #203a4d;
    padding-bottom: 13px;
    padding-left: 10px;
    font-family: "Spoqa-Regular", -apple-system, BlinkMacSystemFont, "Apple SD Gothic Neo", Arial, sans-serif;
    font-size: 26px;
    color: #203a4d;
    font-weight: normal;
    line-height: 30px;
}

.password_change {
    border-top: 1px solid #e3e3e3;
    border-bottom: 1px solid #e3e3e3;
    background-color: #fbfbfb;
    text-align: center;
    height: 150px;
    display: flex;
    flex-direction: column;
    justify-content: center;
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

.information {
    position: relative;
    margin-top: 20px;
    font-family: "Spoqa-Regular", -apple-system, BlinkMacSystemFont, "Apple SD Gothic Neo", Arial, sans-serif;
    font-size: 11px;
    color: #777;
    border-top: 1px solid #d1dadd;
    letter-spacing: -1px;
    text-align: left;
}
</style>