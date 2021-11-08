<template>
  <div id="app">
    <Header></Header>

    <NavbarTop v-if="this.$store.state.viewflag[0] == 1"></NavbarTop>

    <router-view></router-view>

    <Footer v-if="this.$store.state.viewflag[1] == 1"></Footer>
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
        viewflag: []
      }
    },
    components: {
      Header,
      Footer,
      NavbarTop
    },
    computed: {
      
    },
    watch: {

    }
  }
</script>

<style>
</style>