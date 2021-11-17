<template>
  <div id="app">
    <!-- <infoModal v-if="$store.state.modalView ==1"></infoModal> -->
    
    <Header></Header>

    <!-- <NavbarTop v-if="this.viewflag[0] == 1"></NavbarTop> -->
    <NavbarTop></NavbarTop>

    <router-view></router-view>

    <!-- <Footer v-if="this.viewflag[1] == 1"></Footer> -->
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "./components/Header.vue";
import Footer from "./components/Footer.vue";
import NavbarTop from "./components/Navbar-top.vue";
import infoModal from "./components/modal.vue"
export default {
  name: "App",
  components: {
    Header,
    Footer,
    NavbarTop,
    infoModal,
  },
  data() {
    return {
      viewflag: [],
      
    };
  },
  created() {
    this.viewflag = this.$store.state.viewflag;
  },

  computed: {
    setViewFlag() {
      return this.$store.state.viewflag;
    },
  },
  watch: {
    setViewFlag() {
      this.viewflag = this.setViewFlag;
    },
  },
};
</script>

<style>
/* body {
    text-align: center;
  } */
a {
  text-decoration: none;
  color: black;
}
ul li {
  text-decoration: none;
  list-style: none;
  cursor: pointer;
}
</style>
