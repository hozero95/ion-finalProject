<template>
  <div>
    <h1>{{msg}}</h1>
    <p>here is test page 입니다.</p>
    <p>here is test page 입니다.</p>
    <p>{{ $store.state.age }}</p>
    <button v-on:click="fetchData">get data</button>
    <button v-on:click="getdata">get data2</button>
    <button v-on:click="getdata">get data2</button>
    <button @click="$store.commit('한살더하기', 1)">버튼</button>


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
    },
    getdata: function(){
        

    }
  }


}
</script>

<style>

</style>