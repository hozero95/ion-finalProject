<template>
  <body>
    <div>
      <!-- 좌측 파란색 사이드바 시작 -->
      <div class="sidebar">
        <div>
          <i class="fas fa-home me-2"></i>
          <span>Home</span>
        </div>
        <div>
          <i class="fas fa-clipboard-list me-2"></i>
          <span>카테고리</span>
        </div>
        <div>
          <i class="fas fa-birthday-cake me-2"></i>
          <span>이벤트</span>
        </div>
        <div>
          <i class="fas fa-truck me-2"></i>
          <span>배송관리</span>
        </div>
        <div>
          <i class="fas fa-coins me-2"></i>
          <span>주문관리</span>
        </div>
        <div>
          <i class="fas fa-gifts me-2"></i>
          <span>상품관리</span>
        </div>
        <div>
          <i class="fas fa-comments me-2"></i>
          <span>Q&A답변</span>
        </div>
        <div>
          <i class="fas fa-users-cog"></i>
          <span>회원관리</span>
        </div>
      </div>
      <!-- 좌측 파란색 사이드바 끝 -->

      <!-- 우측 내용 시작-->
      <div class="content">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container-fluid">
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
                    <span class="badge bg-danger">99</span>
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

        <div class="container" v-if="보이니 == true">
          <h4 class="my-4">Dashboard</h4>
          <div class="row">
            <div class="col-lg-3">
              <div
                class="card"
                style="border-left: 3px solid red"
                @click="보이니 = false"
              >
                <div class="card-body d-flex justify-content-between">
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
            <div class="col-lg-3">
              <div class="card" style="border-left: 3px solid cadetblue">
                <div class="card-body d-flex justify-content-between">
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
            <div class="col-lg-3">
              <div class="card" style="border-left: 3px solid blue">
                <div class="card-body d-flex justify-content-between">
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
            <div class="col-lg-3">
              <div class="card" style="border-left: 3px solid cadetblue">
                <div class="card-body d-flex justify-content-between">
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
            <div class="col-lg-3">
              <div class="card" style="border-left: 3px solid cadetblue">
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
            <div class="col-lg-3">
              <div class="card" style="border-left: 3px solid cadetblue">
                <div class="card-body d-flex justify-content-between">
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
            <div class="col-lg-3">
              <div class="card" style="border-left: 3px solid plum">
                <div class="card-body d-flex justify-content-between">
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
      </div>
      <!-- 우측 내용 끝-->
    </div>
    <div class="container">
      컴포넌트 들어갈 자리 컴포넌트 들어갈 자리 컴포넌트 들어갈 자리
    </div>
  </body>
</template>

<script>
export default {
  data() {
    return {
      보이니: true,
    };
  },
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