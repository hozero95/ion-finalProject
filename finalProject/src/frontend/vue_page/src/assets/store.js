import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

const store = new Vuex.Store({
  plugins: [
    createPersistedState()
  ],
  state() {
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
      },
      test: [0, 1, 2],
      viewflag: [0, 1, 2],
      categoryUnum: -1,
      categoryName: ''
    }
  },
  mutations: {
    setJwtToken(state, data) {
      state.jwtToken = data.token;
    },
    setUserInfo(state, data) {
      state.userInfo = data;
    },
    show(state) {
      state.viewFlag = [1, 1, 1];
    },
    hideHeader(state) {
      state.viewFlag[0] = 0;
    },
    hideNav(state) {
      state.viewFlag[1] = 0;
    },
    hideFooter(state) {
      state.viewFlag[2] = 0;
    },
    logout(state) {
      state.jwtToken = null;
      userInfo = null;
    },
    setCategoryUnum(state, categoryUnum) {
      state.categoryUnum = categoryUnum;
    },
    setCategoryName(state, categoryName) {
      state.categoryName = categoryName;
    }
  },

})

export default store