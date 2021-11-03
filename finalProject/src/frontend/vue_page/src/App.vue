<template>
  <div id="app">
    <Header v-if="flag == true" @hide ="flag = flase"></Header>
    <Navbar_top v-if="flag == true"></Navbar_top>
    <router-view/>
    <!-- <Footer v-if="flag == true"></Footer> -->
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
      flag : true
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
