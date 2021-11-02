<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view/>
    <button v-on:click="fetchData">get data</button>
    
  

    
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'App',
  
  methods: {
    fetchData: function() {
      axios.get('http://localhost:8000/api/main/show/nav')
        .then(function(response) {
          console.log(response);
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
