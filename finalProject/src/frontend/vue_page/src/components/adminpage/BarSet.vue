<template>
<body>
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
    </div>        
</body>
</template>

<script>
export default {

}
</script>

<style>
.sticky{
  background-color: blueviolet;
  
}
</style>