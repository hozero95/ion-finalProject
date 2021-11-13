<template>
  <body>
    <!-- add modal -->
    <div class="black-bg" v-if="AddModal == true">
      <div class="white-bg">
        <h4>AddItem</h4>
        <table class="table table-bordered" style="border: 2px solid black">
          <thead>
            <tr>
              <th scope="col0">카테고리</th>
              <th scope="col1">상품이름</th>
              <th scope="col2">상품가격</th>
              <th scope="col3">시즌</th>
              <th scope="col4">이미지 1</th>
              <th scope="col5">이미지 2</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input v-model="addCategoryUnum" type="text" /></td>
              <td><input v-model="addProductName" type="text" /></td>
              <td><input v-model="addProductPrice" type="text" /></td>
              <td><input v-model="addProductSeason" type="text" /></td>
              <td>
                <input v-model="addProductImage01" type="text" /><br /><input
                  type="file"
                />
              </td>
              <td>
                <input v-model="addProductImage02" type="text" /><br /><input
                  type="file"
                />
              </td>
            </tr>
          </tbody>
        </table>
        <div style="float: right">
          <button @click="ProductAdd()">확인</button>
          <button @click="AddModal = false" style="margin-left: 40px">
            취소
          </button>
        </div>
      </div>
    </div>
    <!-- add modal end -->

    <!-- modified mo dal -->
    <div class="black-bg" v-if="MdfModal == true">
      <div class="white-bg">
        <h4>ModifiedItem</h4>
        <table class="table table-bordered" style="border: 2px solid black">
          
          <thead>
            <tr>
              <th scope="col0">상품번호</th>
              <th scope="col1">카테고리</th>
              <th scope="col2">상품이름</th>
              <th scope="col3">상품가격</th>
              <th scope="col4">등록일자</th>
              <th scope="col5">시즌</th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <td>
                <textarea v-model="pageArray[ItemNum].productUnum"></textarea>
              </td>
              <td>
                <textarea v-model="pageArray[ItemNum].categoryUnum"></textarea>
              </td>
              <td>
                <textarea v-model="pageArray[ItemNum].productName"></textarea>
              </td>
              <td>
                <textarea v-model="pageArray[ItemNum].productPrice"></textarea>
              </td>
              <td>
                <textarea
                  v-model="pageArray[ItemNum].productRegdate"
                ></textarea>
              </td>
              <td>
                <textarea v-model="pageArray[ItemNum].productSeason"></textarea>
              </td>
            </tr>
          </tbody>
          
        </table>
        <div style="float: right">
          <button>확인</button>
          <button @click="MdfModal = false" style="margin-left: 40px">
            취소
          </button>
        </div>
      </div>
    </div>
    <!-- modified modal end -->
    
    <!-- table area start -->
    
    <div>
      <h1>상품 관리</h1>

<table class="table table-bordered" style="border: 2px solid black">

      <thead>
        <tr>
          <th scope="col5">
            list
            <div style="float: right">
              <span>
                <button @click="AddItem()"><i class="fas fa-plus"></i></button>
              </span>
            </div>
          </th>
          <th scope="col0">상품번호</th>
          <th scope="col1">카테고리</th>
          <th scope="col2">상품이름</th>
          <th scope="col3">상품가격</th>
          <th scope="col4">등록일자</th>
          <th scope="col5">시즌</th>
        </tr>

      </thead>
      <tbody>
        <tr v-for="(product, index) in products" v-bind:key="index">
          <!-- <th scope="row">
            {{index+1}}
            <button style="float: right" @click="showMdfModal(index)">
              <i class="fas fa-tools"></i>
            </button>
          </th> -->
          <td>{{product.productUnum }}</td>
          <td>{{ product.categoryUnum }}</td>
          <td>{{ product.productName }}</td>
          <td>{{ product.productPrice }}</td>
          <td>{{ product.productRegdate }}</td>
          <td>{{ product.productSeason }}</td>
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
      products: [],
      
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

    ProductAdd() {
      var headers = {
        "Content-Type": "application/json",
        Authorization: "Bearer " + this.$store.state.jwtToken,
      };

      var body = {
        categoryUnum: this.addCategoryUnum,
        productName: this.addProductName,
        productPrice: this.addProductPrice,
        productSeason: this.addProductSeason,
        productImage01Path: this.addProductImage01,
        productImage02Path: this.addProductImage02,
      };

      axios.defaults.headers.post = null;
      axios({
        url: "http://localhost:8000/api/admin/product/add",
        method: "post",
        headers: headers,
        data: body,
      })
        .then((res) => {
          alert("상품 등록 " + res.data);
          this.AddModal = false;
        })
        .catch((err) => {
          alert("이미 있는 상품이거나, 등록할 수 없는 상품입니다.");
          this.AddModal = false;
        });
    },
  },
  computed: {
    pageCount() {
      let listLeng = this.pageArray.length,
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
      return this.pageArray.slice(start, end);
    },
  },

  created() {
    var headers = {
      Authorization: "Bearer " + this.$store.state.jwtToken,
    };
    axios
      .get("http://localhost:8000/api/admin/product/all", {
        headers,
      })
      .then((res) => {
        var product = new Array();

        for (var i = 0; i < res.data.length; i++) {
          product.push(res.data[i]);
        }
        this.products = product;
      });
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
