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
      viewflag: [1, 1], // navbar, footer
      categoryUnum: -1,
      categoryName: '',
      productUnum: -1
    }
  },
  mutations: {
    setJwtToken(state, data) {
      state.jwtToken = data;
    },
    setUserInfo(state, data) {
      state.userInfo = data;
    },
    showAll(state) {
      state.viewflag = [1, 1];
    },
    hideFooter(state) {
      state.viewflag = [1, 0];
    },
    hideAll(state) {
      state.viewflag = [0, 0];
    },
    logout(state) {
      state.jwtToken = '';
      state.userInfo = {
        userUnum: -1,
        userId: '',
        userEmail: '',
        userAddress: '',
        userTel: '',
        userRegdate: '',
        authorities: []
      };
    },
    setCategoryUnum(state, categoryUnum) {
      state.categoryUnum = categoryUnum;
    },
    setCategoryName(state, categoryName) {
      state.categoryName = categoryName;
    },
    setProductUnum(state, productUnum) {
      state.productUnum = productUnum;
    }
  },

})

export default store
