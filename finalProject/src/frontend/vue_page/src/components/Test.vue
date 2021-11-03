<template>
  <div>
    <h1>{{msg}}</h1>
    <p>here is test page 입니다.</p>
    <p>here is test page 입니다.</p>
    <p>아무거나 적어야지123</p>
    <button v-on:click="fetchData">get data</button>
  </div>
  
  
</template>

<script>
export default {
    name: 'Test',
    data(){
        return{
            msg: 'test page'
        }
    },
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

</style>