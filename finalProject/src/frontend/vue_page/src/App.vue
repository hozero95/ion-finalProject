<template>
  <div id="app">
    <Header></Header>
    <!-- <Navbar_top v-if="$store.state.viewFlag[1] == 1"></Navbar_top> -->
    <Navbar_top></Navbar_top>
    <router-view/>
    <!-- <Footer v-if="$store.state.viewFlag[2] == 1"></Footer> -->
    <Footer></Footer>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'
import Navbar_top from './components/Navbar-top.vue'
export default {
  name: 'App',
  data() {
    return {
      
    }
  },
  components : {
    Header, Footer, Navbar_top
  }
  
}


</script>

<style>
#app {

}
</style>
