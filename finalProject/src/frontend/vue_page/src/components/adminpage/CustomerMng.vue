<template>

  <body>

    <!-- table area start -->

    <div>
      <h1>회원 관리</h1>

      <table class="table table-bordered" style="border: 2px solid black">
        <thead>
          <tr>
            <th scope="col0">회원번호</th>
            <th scope="col1">ID</th>
            <th scope="col2">Email</th>
            <th scope="col3">Address</th>
            <th scope="col4">Tel</th>
            <th scope="col5">Regdate</th>
            <th scope="col6">삭제</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(userAll, index) in paginatedData" :key="index">
            <td>{{userAll.userUnum }}</td>
            <td>{{ userAll.userId }}</td>
            <td>{{ userAll.userEmail }}</td>
            <td>{{ userAll.userAddress }}</td>
            <td>{{ userAll.userTel }}</td>
            <td>{{ userAll.userRegdate }}</td>
            <td @click="deleteAsk(userAll.userUnum)">삭제</td>
          </tr>
        </tbody>
      </table>
      <!-- table area end -->

      <!-- pagination area start -->
      <div class="btn-cover">
        <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
          이전
        </button>
        <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
        <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
          다음
        </button>
      </div>
    </div>
    <!-- pagination area end -->
  </body>
</template>

<script>
  import axios from "axios";


  export default {
    name: "simple-pagination",
    data() {
      return {
        pageArray: [],
        userAlls: [],

        AddModal: false,
        MdfModal: false,
        ItemNum: 0,
        pageNum: 0,
        pageSize: 10,

        // add modal
        addCategoryUnum: null,
        addProductName: null,
        addProductPrice: null,
        addProductSeason: null,
        addProductImage01: null,
        addProductImage02: null,
      };
    },

    methods: {

      AddItem() {
        this.AddModal = true;
      },
      showMdfModal(index) {
        this.MdfModal = true;
        this.ItemNum = index;
      },

      nextPage() {
        this.pageNum += 1;
      },
      prevPage() {
        this.pageNum -= 1;
      },
      showUserAll() {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };
        axios({
            url: 'http://localhost:8000/api/admin/user/all',
            method: "get",
            headers: headers,
          })
          .then(res => {
            var userAll = new Array();
            for (var i = 0; i < res.data.length; i++) {
              userAll.push(res.data[i]);
            }
            this.userAlls = userAll;
          })
      },
      deleteAsk(userUnum) {
        if (confirm('삭제하시겠습니까?')) {
          this.deleteUser(userUnum);
        } else {
          alert('취소되었습니다');
        }
      },
      deleteUser(userUnum) {
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken
        };

        axios({
            url: 'http://localhost:8000/api/admin/user/delete',
            method: 'delete',
            headers: headers,
            params: {
              userUnum: userUnum
            }
          })
          .then(res => {
            alert('회원삭제가 완료되었습니다.');
            this.showUserAll();
          }, error => {
            console.log(error);
            alert('회원삭제에 실패하였습니다.');
          })
      }

    },
    computed: {
      pageCount() {
        let listLeng = this.userAlls.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
        if (listLeng % listSize > 0) page += 1;

        /*
        아니면 page = Math.floor((listLeng - 1) / listSize) + 1;
        이런식으로 if 문 없이 고칠 수도 있다!
        */
        return page;
      },
      paginatedData() {
        const start = this.pageNum * this.pageSize,
          end = start + this.pageSize;
        return this.userAlls.slice(start, end);
      },
    },
    created() {
      this.showUserAll();
    },


  };
</script>

<style scoped>
  body {
    margin: 30px;
  }

  div {
    box-sizing: border-box;
  }

  .black-bg {
    width: 100%;
    height: 100%;
    /* background: rgba(0,0,0,0.5); */

    position: fixed;
  }

  .white-bg {
    width: fit-content;
    background: white;
    border-radius: 8px;
    padding: 20px;
  }

  /* -----------------------pagination start -------------------------- */
  table {
    width: 100%;
    border-collapse: collapse;
  }

  table th {
    font-size: 1.2rem;
  }

  table tr {
    height: 2rem;
    text-align: center;
    border-bottom: 1px solid #505050;
  }

  table tr:first-of-type {
    border-top: 2px solid #404040;
  }

  table tr td {
    padding: 1rem 0;
    font-size: 1.1rem;
  }

  .btn-cover {
    margin-top: 1.5rem;
    text-align: center;
  }

  .btn-cover .page-btn {
    width: 5rem;
    height: 2rem;
    letter-spacing: 0.5px;
  }

  .btn-cover .page-count {
    padding: 0 1rem;
  }
</style>
