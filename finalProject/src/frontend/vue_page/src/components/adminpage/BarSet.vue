<template>
<body>
      <!-- 좌측 파란색 사이드바 시작 -->
    <div class="sidebar">
        <div @click="$emit('openHome')">
          <i class="fas fa-home me-2"></i>
          <span style="cursor:pointer">Home</span>
        </div>
        <div @click="$emit('openCategory')">
          <i class="fas fa-clipboard-list me-2"></i>
          <span style="cursor:pointer">카테고리</span>
        </div>
        <div @click="$emit('openEventMng')">
          <i class="fas fa-birthday-cake me-2"></i>
          <span style="cursor:pointer">이벤트</span>
        </div>
        <div @click="$emit('openDeliveryMng')">
          <i class="fas fa-truck me-2"></i>
          <span style="cursor:pointer">배송관리</span>
        </div>
        <div @click="$emit('openOrderMng')">
          <i class="fas fa-coins me-2"></i>
          <span style="cursor:pointer">주문관리</span>
        </div>
        <div @click="$emit('openItemList')">
          <i class="fas fa-gifts me-2"></i>
          <span style="cursor:pointer">상품관리</span>
        </div>
        <div @click="$emit('openQnAMng')">
          <i class="fas fa-comments me-2"></i>
          <span style="cursor:pointer">Q&A답변</span>
        </div>
        <div @click="$emit('openCustomerMng')">
          <i class="fas fa-users-cog"></i>
          <span style="cursor:pointer">회원관리</span>
        </div>
    </div>
      <!-- 좌측 파란색 사이드바 끝 -->

      <!-- 우측 내용 시작-->
    
    <!-- <div class="content">
        <nav class="navbar navbar-expand-lg navbar-light bg-light" >
          <div class="container-fluid sticky">
            <button
              class="navbar-toggler ms-auto"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbar"
            >
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbar">
              <form class="d-flex">
                <input
                  class="form-control input-animation"
                  placeholder="Search"
                />
                <button
                  class="btn btn-outline-secondary input-button"
                  type="submit"
                >
                  Search
                </button>
              </form>
              <ul class="navbar-nav ms-auto mb-1 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link ml" href="#">
                    <span class="badge bg-danger">113</span>
                    <i class="fas fa-home me-2"></i>
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link ml" href="#">
                    <span class="badge bg-danger">99</span>
                    <i class="fas fa-clipboard-list me-2"></i>
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link ml" href="#">
                    <span class="badge bg-danger">99</span>
                    <i class="fas fa-bell"></i>
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link ml" href="#"> Master</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
    </div>         -->
</body>
</template>

<script>
export default {

}
</script>

<style>
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
  height: 300px;
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