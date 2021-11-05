import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

const store = new Vuex.Store({
  plugins: [
    createPersistedState()
  ],
  state(){
    return {
      jwtToken: '',
      userInfo: {
        userUnum: -1,
        userId: '',
        userEmail: '',
        userAddress: '',
        userTel: '',
        userRegdate: '',
        authorities: {}
      }
    }
  },
  mutations :{
    setJwtToken(state, data) {
      state.jwtToken = data.token;
    },
    setUserInfo(state, data) {
      state.userInfo = data;
    }
  },

})

export default store
