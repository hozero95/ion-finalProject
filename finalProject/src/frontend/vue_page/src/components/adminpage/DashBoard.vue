<template>
  <body>
    <div class="container">
      <h4 class="my-4">Dashboard</h4>
      <div class="row">
        
        <div style="cursor:pointer;" class="col-lg-4 mb-5">
          <div class="card" style="border-left: 3px solid red">
            <div class="card-body d-flex justify-content-between" @click="$emit('openCategory')">
              <div>
                <p class="card-text mb-2">Customer Service</p>
                <h4>카테고리 관리</h4>
              </div>
              <a class="nav-link ml" href="#">
                <i
                  
                  class="fas fa-clipboard-list"
                  style="font-size: 30px; margin-top: 20px; color"
                ></i>
              </a>
            </div>
          </div>
        </div>
        <div style="cursor:pointer;" class="col-lg-4">
          <div class="card" style="border-left: 3px solid cadetblue">
            <div class="card-body d-flex justify-content-between" @click="$emit('openEventMng')">
              <div>
                <p class="card-text mb-2">Event Management</p>
                <h4>이벤트 관리</h4>
              </div>
              <i
                class="fas fa-birthday-cake"
                style="font-size: 30px; margin-top: 20px; color: pink"
              ></i>
            </div>
          </div>
        </div>
        <div style="cursor:pointer;" class="col-lg-4">
          <div class="card" style="border-left: 3px solid blue">
            <div class="card-body d-flex justify-content-between" @click="$emit('openDeliveryMng')">
              <div>
                <p class="card-text mb-2">Delivery Management</p>
                <h4>배송관리</h4>
              </div>
              <i
                class="fas fa-truck"
                style="font-size: 30px; margin-top: 20px; color: gray"
              ></i>
            </div>
          </div>
        </div>
        <div style="cursor:pointer;" class="col-lg-4 mb-5">
          <div class="card" style="border-left: 3px solid cadetblue">
            <div class="card-body d-flex justify-content-between" @click="$emit('openOrderMng')">
              <div>
                <p class="card-text mb-2">Orders Management</p>
                <h4>주문관리</h4>
              </div>
              <i
                class="fas fa-coins"
                style="font-size: 30px; margin-top: 20px; color: gold"
              ></i>
            </div>
          </div>
        </div>
        <div style="cursor:pointer;" class="col-lg-4">
          <div class="card" style="border-left: 3px solid cadetblue" @click="$emit('openItemList')">
            <div class="card-body d-flex justify-content-between">
              <div>
                <p class="card-text mb-2">Merchandise Management</p>
                <h4>상품관리</h4>
              </div>
              <i
                class="fas fa-gifts"
                style="font-size: 30px; margin-top: 20px; color: cadetblue"
              ></i>
            </div>
          </div>
        </div>
        <div style="cursor:pointer;" class="col-lg-4">
          <div class="card" style="border-left: 3px solid cadetblue">
            <div class="card-body d-flex justify-content-between" @click="$emit('openQnAMng')">
              <div>
                <p class="card-text mb-2">Question & Answer</p>
                <h4>Q&A답변</h4>
              </div>
              <i
                class="fas fa-comments"
                style="font-size: 30px; margin-top: 20px; color: gold"
              ></i>
            </div>
          </div>
        </div>
        <div style="cursor:pointer;" class="col-lg-4">
          <div class="card" style="border-left: 3px solid plum">
            <div class="card-body d-flex justify-content-between" @click="$emit('openCustomerMng')">
              <div>
                <p class="card-text mb-2">Customer Management</p>
                <h4>회원관리</h4>
              </div>
              <i
                class="fas fa-users-cog"
                style="font-size: 30px; margin-top: 20px; color: green"
              ></i>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>

  <!-- 우측 내용 끝-->
</template>

<script>
export default {
    data() {
    return {
      viewflag : 1,
    }
  },
};
</script>

<style>
</style>