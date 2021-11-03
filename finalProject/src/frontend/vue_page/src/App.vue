<template>
  <div id="app">
    <Header></Header>
    <Navbar_top></Navbar_top>
    <router-view/>
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
