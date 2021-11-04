import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
  state(){
    return {
      testid1 : 'hello store1',
      testid2 : 'hello store2',
      age: 0 ,
    }
  },
  mutations :{
    한살더하기(state, data){
      state.age += data;
    }
  },

})

export default store
