<template>
  <body>
    <!-- header -->
    <header class="header">
		<!-- header left -->
		<div class="header__logo">
			<img src="" alt="">
			<!-- <a href="#">TEAM 5징어 </a> -->
        </div>
		<!-- 검색창 -->
		<div class="header__search">
			<div class="input__header__search__input">
				<input type="text">
				<button class="" type="button"><i class="fas fa-search"></i></button>
			</div>
		</div>
		<!-- header right -->
		<ul class="header__menu">
			
            <router-link to="login"><li class="header__menu__iteam">로그인</li></router-link>
			<li class="header__menu__iteam">회원가입</li>
			<li class="header__menu__iteam">고객센터</li>
			<li class="header__menu__iteam"><i class="far fa-user"></i></li>
			<li class="header__menu__iteam"><i class="fas fa-truck"></i></li>
			<li class="header__menu__iteam"><i class="fas fa-shopping-cart"></i></li>
		</ul>
    </header>
	




</body>
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

/* header */
.header{
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding: 0 300px;
}
.header__logo img{
    width: 100px;
    height: 100px;
    margin-top: 20px;
}
.header__search{
    width: 230px;
    height: 15px;
    margin-right: 35%;

}

.input__header__search__input button{
    position: absolute;
    left: 620px;
    top: 57px;
    color: #5172de;
}

.header__menu{
    display: flex;
    margin-top: 30px;
}

.header__menu__iteam{
    padding: 8px 12px;
    margin: 0 4px;

}

/* footer */

.footer {
    width: 100%;
    height: 335px;
    padding: 0 320px;
}
.footer__left {
    width: 70%;
    float: left;
}
.footer__left__row2{
    margin-top: 20px;
}
.footer__left__row2 img{
    width: 750px;
    height: 60px;
    margin-left: 0;

}
.footer__left__row3{
    margin-top: 20px;
}
.footer__right {
    width: 30%;
    float: right;
    padding-left: 180px;
}
.footer__right img {
    width: 200px;
    height: 80px;
}

/* 노트북 사이즈 */
@media screen and (max-width: 1500px) { 
    .header{
        padding: 0 80px;
    }
    .input__header__search__input button{
        left: 387px;
        top: 57px;
    }
    .footer {
        padding: 0 90px;
    }
    .footer__right {
        padding-left: 170px;
    }
}

</style>