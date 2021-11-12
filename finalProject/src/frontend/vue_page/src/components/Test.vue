<template>
  <div>
    <h1>{{msg}}</h1>
    <p>here is test page 입니다.</p>
    <p>here is test page 입니다.</p>
    <p>삭제하지마세요 ~ test 내역 확인중~</p>
    
    <p>{{ $store.state.viewflag[0]}}</p>
    <p>{{ $store.state.viewflag[1]}}</p>
    <p>{{ $store.state.viewflag[2]}}</p>
    <p>{{ $store.state.test[0]}}</p>
    <p>{{ $store.state.test[1]}}</p>
    <p>{{ $store.state.test[2]}}</p>
    
    <button v-on:click="fetchData">get data</button>
    <button v-on:click="getdata">get data2</button>
    <button v-on:click="getdata">get data2</button>
    


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

<style scoped>

</style>