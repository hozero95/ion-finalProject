<template>
    <body>
    <div class="content"> 
        <div class="header"> 
        </div>

        <div class="deliver_header">
            
            
            <span class="deliver_img"><img src="/deimg.jpg" alt="ss"></span>
            <li class="deliver_img step1"><span ><img src="/deimg2.jpg" alt="ss"></span></li>
            <li class="deliver_img step2"><span><img src="/deimg3.jpg" alt="ss"></span></li>
            <li class="deliver_img step3"><span><img src="/deimg4.jpg" alt="ss"></span></li>
            <li class="deliver_img step4"><span><img src="/deimg5.jpg" alt="ss"></span></li>


            



        </div>
        
        <div>
        <div class="content_box right_line">
            <h3>① 회원정보변경</h3>
        </div>
        
        <div class="content_box right_line">
            <h3>② 비밀번호변경</h3>
        </div>
        
        <div class="content_box " >
            <h3>③ 주문/배송관리</h3>
        </div>
        </div>
        
        <div class="content_box2 right_line">
            <h3>④ 리뷰관리</h3>
        </div>
        
        <div class="content_box2 ">
            <h3>⑤ Q&A관리</h3>
        </div>

        <img src="https://raw.githubusercontent.com/sky4564/img/master/마이페이지/event1.jpeg" alt="event" class="event_img right_line">
        <img src="https://raw.githubusercontent.com/sky4564/img/master/마이페이지/event2.jpeg" alt="event" class="event_img">

        

            
        
    </div>
    
</body>
</template>

<script>
export default {

}
</script>

<style>
    /* box sizing */
.content {
    /* background-color: aqua; */
    
    margin-top: 30px;
    margin-left: auto;
    margin-right: auto;
    border-right: 1px solid #d1dadd;
    border-left: 1px solid #d1dadd;
    width: 1018px;
    height: fit-content;
}

.header {
    background-color: #F3FAFE;
    border-bottom: 3px solid #203a4d;
    width: 1020px;
    height: 94px;
}
.deliver_header{
    width: 1020px;
    height : 170px;
    border-bottom: 1px solid #ccd6da;
    display: flex;
    justify-content: center;
}
.deliver_img{
    
    float : left;
    padding: 30px;
    list-style-type: "\27A1";
    list-style-position: outside;
    list
}   



.right_line{
    border-right: 1px solid #ccd6da;
}

.content_box{
    height: 285px;
    width: 370px;
    display: table-cell;
    padding-top: 32px;
    padding-left: 30px;
    border-bottom: 1px solid #ccd6da;
}

.content_box2{
    height: 317px;
    width: 508px;
    display: table-cell;
    border-bottom: 1px solid #ccd6da;
    
}

.event_img{
    height: 100px;
    width: 508.2px;
    float: left;
    cursor: pointer;
}

/* box sizing */
</style>