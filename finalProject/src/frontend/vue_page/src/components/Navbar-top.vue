<template>
    <!-- top navbar -->
    <div class="navbar-top">
        <ul class="navbar-top__menu">
                <li class="navbar-top__menu__iteam">
                    <a href="http://localhost:8080/#/category">생선</a> 
                    <div class="dropdown-content">
                        <router-link to="category"><a href="#">생물 생선</a></router-link>
                        <router-link to="category"><a href="#">냉동 생선</a></router-link>
                        <router-link to="category"><a href="#">반건조 생선</a></router-link>
                        <router-link to="category"><a href="#">굴비</a></router-link>
                    </div>
			    </li>
            <router-link to="category">
                <li class="navbar-top__menu__iteam">킹크랩, 꽃게, 랍스터
                    <div class="dropdown-content">
                        <a href="#">킹크랩</a>
                        <a href="#">꽃게</a>
                        <a href="#">랍스터</a>
                    </div>
                </li>
            </router-link>
            <router-link to="category">
                <li class="navbar-top__menu__iteam">새우류
                    <div class="dropdown-content">
                        <a href="#">냉동 새우</a>
                        <a href="#">횟감용 새우</a>
                        <a href="#">활새우</a>
                    </div>
                </li>
            </router-link>
            <li class="navbar-top__menu__iteam">쭈꾸미, 오징어, 문어
				<div class="dropdown-content">
					<a href="#">쭈꾸미, 낙지, 꼴뚜기</a>
					<a href="#">오징어 한치</a>
					<a href="#">문어</a>
				</div>
			</li>
            <li class="navbar-top__menu__iteam">/</li>
            <router-link to="seasonalProduct"><li class="navbar-top__menu__iteam">제철</li></router-link>
            <router-link to="bestProduct"><li class="navbar-top__menu__iteam">BEST</li></router-link>
            <router-link to="event"><li class="navbar-top__menu__iteam">이벤트</li></router-link>
        </ul>
    </div>
</template>

<script>
export default {

}
</script>

<style>
/* Universal tags */
* {
    box-sizing: border-box;
}

body {
    font-family: 'Open Sans', sans-serif;
    margin: 0;
}

a {
    text-decoration: none;
    color: var(--color-white);
}

ul {
    padding-left: 0;
}

li {
    list-style: none;
}

button {
    background-color: transparent;
    cursor: pointer;
    border: none;
    outline: none;
    padding: 0;
}
p{
    margin: 0;
}
.text1{
    margin: 0;
    font-size: 12px;
    color: gray;
}
.text2{
    margin: 0;
    font-size: 12px;
}
.text3{
    margin: 0;
    font-size: 11px;
    color: gray;
}

/* navber top */
.navbar-top{
    margin: 0;
    background-color: #132c7d;
    height: 60px;
}
.navbar-top__menu{
    margin-left: 16%;
    width: 66%;
    height: 60px;
    color: white;
    display: flex;
    justify-content: space-between;
    font-size: 20px;
}
.navbar-top__menu__iteam{
    justify-content: center;
    margin-left: 30px;
    margin-top: 15px;
    cursor:pointer;
}

/* navbar dropdown */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
    margin-top: 15px;
}
.dropdown-content a {
    color: black;
    padding: 12px 0px;
    text-decoration: none;
    display: block;
}
.navbar-top__menu__iteam:hover .dropdown-content{
    display: block;
}
</style>