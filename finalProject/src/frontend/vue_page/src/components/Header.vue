<template>
  <body>
    <!-- header -->
    <header class="header">
      <!-- header left -->
      <div>
        <div class="flip-outer">
          <div class="flip-inner">
            <router-link to="/">
              <img
                src="../assets/logo.jpeg"
                class="front"
              />
            </router-link>
            <div class="back"></div>
          </div>
        </div>
      </div>

      <!-- header right -->
      <ul class="header__menu" style="margin-left: 0px;">
        <!-- <button @click="checkFlag">viewflag 체크</button>
        <button @click="checkStore">store 체크</button> -->
        

        
        <router-link
          to="userpage"
          v-if="
            this.$store.state.jwtToken != null &&
            this.$store.state.jwtToken != ''
          "
        >
          <li class="header__menu__iteam"><i class="far fa-user fa-2x"></i></li>
        </router-link>
        <router-link 
          to="deliveryitem"
          v-if="
            this.$store.state.jwtToken != null &&
            this.$store.state.jwtToken != ''
          "
        >
          <li class="header__menu__iteam">
            <i class="fas fa-truck fa-2x"></i>
          </li>
        </router-link>
        <router-link 
          to="cart"
          v-if="
            this.$store.state.jwtToken != null &&
            this.$store.state.jwtToken != ''
          "
        >
          <li class="header__menu__iteam">
            <i class="fas fa-shopping-cart fa-2x"></i>
          </li>
        </router-link>
        <router-link
          to="login"
          v-if="
            this.$store.state.jwtToken == null ||
            this.$store.state.jwtToken == ''
          "
        >
          <li class="header__menu__iteam">로그인</li>
        </router-link>
        <router-link
          to="joinuser"
          v-if="
            this.$store.state.jwtToken == null ||
            this.$store.state.jwtToken == ''
          "
        >
          <li class="header__menu__iteam">회원가입</li>
        </router-link>
        <router-link
          to="login"
          v-if="
            this.$store.state.jwtToken != null &&
            this.$store.state.jwtToken != ''
          "
        >
          <li class="header__menu__iteam" @click="logout">로그아웃</li>
        </router-link>
        <router-link
          to="AdminPage"
          v-if="this.$store.state.userInfo.authorities.length >= 2"
        >
          <li class="header__menu__iteam" @click="hiding">관리자 페이지</li>
        </router-link>
                <li           v-if="
            this.$store.state.jwtToken != null &&
            this.$store.state.jwtToken != ''
          ">
          {{this.$store.state.userInfo.userId}}님 어서오세요!
        </li>
      </ul>
    </header>
  </body>
</template>

<script>
export default {
  methods: {
    logout() {
      this.$store.commit("logout");
      alert("로그아웃 되었습니다.");
    },
    hiding() {
      this.$store.commit("hideAll");
    },
    showing() {
      this.$store.commit("showAll");
    },
    checkStore() {
      console.log(this.$store.state.jwtToken);
      console.log(this.$store.state.userInfo);
    },
    checkFlag() {
      console.log(this.$store.state.viewflag);
    },
  },
};
</script>

<style scoped>
.flip-outer {
  width: 100px;
  height: 100px;
}

.flip-inner {
  width: 100%;
  height: 100%;
  position: relative;
}

.front {
  width: 100%;
  position: absolute;
}

.back {
  width: 100%;
  position: absolute;
  transform: rotateY(180deg);
}

.flip-inner {
  width: 100%;
  height: 100%;
  position: relative;
  transition: all 1s;
  transform-style: preserve-3d;
}

.flip-inner:hover {
  transform: rotateY(180deg);
}

/* Universal tags */
* {
  box-sizing: border-box;
}

body {
  font-family: "Open Sans", sans-serif;
  margin: 0;
}

ul {
  width: 3000px;
  height: 100px;
  /* background-color: aquamarine; */
  align-items: center;
  justify-content: end;
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

p {
  margin: 0;
}

.text1 {
  margin: 0;
  font-size: 12px;
  color: gray;
}

.text2 {
  margin: 0;
  font-size: 12px;
}

.text3 {
  margin: 0;
  font-size: 11px;
  color: gray;
}

/* header */
.header {
  height: 100px;
  display: flex;
  padding: 0 300px;
}
.input__header__search__input button {
  /* position: absolute; */
  /* left: 620px; */
  /* top: 57px; */
  margin-left: 5px;
  color: #5172de;
}

.header__menu {
  display: flex;
}

.header__menu__iteam {
  padding: 8px 12px;
  margin: 0 4px;
}

/* 노트북 사이즈 */
@media screen and (max-width: 1500px) {
  .header {
    padding: 0 80px;
  }

  .input__header__search__input button {
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