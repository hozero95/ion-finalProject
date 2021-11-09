<template>
  <body>
    
    
    <div>
      <BarSet
      @openHome ="HideAll(); ViewDashBoard = 1"
      @openCategory="HideAll(); ViewCategory = 1"
      @openEventMng="HideAll(); ViewEventMng = 1"
      @openDeliveryMng="HideAll(); ViewDeliveryMng = 1"
      @openOrderMng="HideAll(); ViewOrderMng = 1"
      @openItemList="HideAll(); ViewItemList = 1"
      @openQnAMng="HideAll(); ViewQnAMng = 1"
      @openCustomerMng="HideAll(); ViewCustomerMng = 1"
      >
      </BarSet>
    </div>
    <div>
      <DashBoard 
      v-if="ViewDashBoard == 1" 
      @openCategory="HideAll(); ViewCategory = 1"
      @openEventMng="HideAll(); ViewEventMng = 1"
      @openDeliveryMng="HideAll(); ViewDeliveryMng = 1"
      @openOrderMng="HideAll(); ViewOrderMng = 1"
      @openItemList="HideAll(); ViewItemList = 1"
      @openQnAMng="HideAll(); ViewQnAMng = 1"
      @openCustomerMng="HideAll(); ViewCustomerMng = 1"
      >
      </DashBoard>
    </div>
    
    <div class="container">
      <Category v-if="ViewCategory == 1" ></Category>
      <EventMng v-if="ViewEventMng == 1"></EventMng>
      <DeliveryMng v-if="ViewDeliveryMng == 1"></DeliveryMng>
      <OrderMng v-if="ViewOrderMng == 1"></OrderMng>
      <ProductTable v-if="ViewItemList == 1"></ProductTable>
      <QnAMng v-if="ViewQnAMng == 1"></QnAMng>
      <CustomerMng v-if="ViewCustomerMng ==1"></CustomerMng>
    </div>
    
  </body>
</template>

<script>
import BarSet from './adminpage/BarSet.vue'
import DashBoard from './adminpage/DashBoard';
import Category from './adminpage/Category.vue';
import EventMng from './adminpage/EventMng.vue';
import DeliveryMng from './adminpage/DeliveryMng.vue'
import OrderMng from './adminpage/OrderMng.vue'
import ProductTable from './adminpage/ProductTable.vue';
import QnAMng from './adminpage/QnAMng.vue';
import CustomerMng from './adminpage/CustomerMng.vue'


export default {
  data() {
    return {
      ViewDashBoard: 1,
      ViewCategory: 0,
      ViewEventMng: 0,
      ViewDeliveryMng: 0,
      ViewOrderMng : 0,
      ViewQnAMng :0,
      ViewItemList: 0,
      ViewCustomerMng :0,
    };
  },
  methods: {
    HideAll(){
      this.ViewDashBoard = 0;
      this.ViewCategory = 0;
      this.ViewEventMng = 0;
      this.ViewDeliveryMng = 0;
      this.ViewOrderMng = 0;
      this.ViewItemList = 0;
      this.ViewQnAMng = 0;
      this.ViewCustomerMng = 0;
    }
  },
  components : {
   BarSet,DashBoard,
   Category,EventMng,DeliveryMng,OrderMng,
   ProductTable,QnAMng,CustomerMng
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