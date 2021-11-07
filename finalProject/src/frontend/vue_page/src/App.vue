<template>
  <div id="app">
    <Header></Header>
    <!-- <NavbarTop v-if="$store.state.viewFlag[1] == 1"></NavbarTop> -->
    <NavbarTop></NavbarTop>
    <router-view/>
    <!-- <Footer v-if="$store.state.viewFlag[2] == 1"></Footer> -->
    <Footer></Footer>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'
import NavbarTop from './components/Navbar-top.vue'
export default {
  name: 'App',
  data() {
    return {
      
    }
  },
  components : {
    Header,
    Footer,
    NavbarTop
  }
  
}


</script>

<style>
#app {

}
</style>
