<template>
  <body>
    
    
    <div>
      <BarSet></BarSet>
    </div>
    <div>
      <DashBoard></DashBoard>
    </div>
    
    
    
    <div class="container">
      <Category style="background-color : lightpink"></Category>
      <ProductTable style="background-color : lightgray"></ProductTable>
    </div>
    
  </body>
</template>

<script>
import DashBoard from './adminpage/DashBoard';
import Category from './adminpage/Category.vue';
import ProductTable from './adminpage/ProductTable';
import BarSet from './adminpage/BarSet.vue'


export default {
  data() {
    return {
      
    };
  },
  components : {
   BarSet,DashBoard,Category,ProductTable,
  }
};
</script>

<style>
/* css item */
.ml {
  margin-left: 10px;
}

/* css item */

.nav-link {
  position: relative;
}

.badge {
  position: absolute;
  top: 0px;
  left: 15px;
}

.input-animation {
  width: 150px;
  transition: width 1s;
  border-top-right-radius: 0px;
  border-bottom-right-radius: 0px;
}
.input-animation:focus {
  width: 300px;
}

.content {
  margin-left: 50px;
}

.sidebar {
  transition: all 0.5s;
  width: 150px;
  height: 100vh;
  background: cadetblue;
  position: fixed;
  z-index: 5;
  color: white;
  font: bold;
  font-family: "nanumsquare";
  /*  시작화면 */
  transform: translateX(-110px);
}
.sidebar div {
  margin: 12px 0px 0px 15px;
}

.sidebar:hover {
  transform: translateX(0px);
}

.sidebar i {
  transition: all 1s;
  transform: translateX(100px);
}
.sidebar:hover i {
  transform: translateX(0px);
}
.input-button {
  border-bottom-left-radius: 0px;
  border-top-left-radius: 0px;
}
</style>