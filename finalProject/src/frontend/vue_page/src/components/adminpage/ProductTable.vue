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
              <!-- <th scope="col5">이미지 2</th> -->
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input v-model="addCategoryUnum" type="text" /></td>
              <td><input v-model="addProductName" type="text" /></td>
              <td><input v-model="addProductPrice" type="text" /></td>
              <td><input v-model="addProductSeason" type="text" /></td>
              <td>
                <input v-model="addProductImage01" type="text" /><br /><input type="file" />
              </td>
              <!-- <td>
                <input v-model="addProductImage02" type="text" /><br /><input
                  type="file"
                />
              </td> -->
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
        <h4>상품 수정</h4>
        <table class="table table-bordered" style="border: 2px solid black">
          <thead>
            <tr>
              <th scope="col0">상품번호</th>
              <th scope="col1">카테고리</th>
              <th scope="col2">상품이름</th>
              <th scope="col3">상품가격</th>
              <th scope="col5">시즌</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <textarea :value="product.productUnum" readonly></textarea>
              </td>
              <td>
                <textarea v-model="product.categoryUnum"></textarea>
              </td>
              <td>
                <textarea v-model="product.productName"></textarea>
              </td>
              <td>
                <textarea v-model="product.productPrice"></textarea>
              </td>
              <td>
                <textarea v-model="product.productSeason"></textarea>
              </td>
            </tr>
          </tbody>
        </table>
        <div style="float: right">
          <button @click="ProductChange()">확인</button>
          <button @click="MdfModal = false" style="margin-left: 40px">
            취소
          </button>
        </div>
      </div>
    </div>
    <!-- modified modal end -->

    <!-- table area start -->

    <div>
      <br>
      <h1>상품 관리</h1>
      <div class="information">
        * list옆 <strong>' + '</strong>버튼을 누르시면 상품을 추가하실 수 있습니다.<br>
        * list(숫자)옆 <strong>수정아이콘</strong>을 누르시면 상품의 정보(카테고리, 상품이름, 상품가격, 시즌)를 수정하실 수 있습니다.<br>
        * <strong>상품삭제버튼</strong>을 누르시면 상품을 삭제하실 수 있습니다.<br><br>
      </div>
      <table class="table table-bordered" style="border: 2px solid black">
        <thead>
          <tr>
            <th scope="col5">
              list
              <div style="float: right">
                <span>
                  <span @click="AddItem()"><i class="fas fa-plus" style="cursor:pointer;"></i></span>
                </span>
              </div>
            </th>
            <th scope="col0">상품번호</th>
            <th scope="col1">카테고리</th>
            <th scope="col2">상품이름</th>
            <th scope="col3">상품가격</th>
            <th scope="col4">등록일자</th>
            <th scope="col5">시즌</th>
            <th scope="col6">상품삭제</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(p, index) in paginatedData" :key="index">
            <th scope="row">
              {{index+1}}
              <span style="float: right" @click="showMdfModal(p)">
                <i class="fas fa-tools" style="cursor:pointer;"></i>
              </span>
            </th>
            <td>{{p.productUnum }}</td>
            <td>{{ p.categoryUnum }}</td>
            <td>{{ p.productName }}</td>
            <td>{{ p.productPrice }}</td>
            <td>{{ dateFormat(p.productRegdate) }}</td>
            <td>{{ seasonWeather(p.productSeason) }}</td>
            <td style="cursor:pointer;" @click="ProductDeleteSure(p.productUnum)">삭제</td>
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
        product: {},

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

        productName: '',
        productPrice: 0,
        productSeason: 0
      };
    },

    methods: {
      dateFormat(date) {
        var regdate = new Date(date);
        var year = regdate.getFullYear();
        var month = regdate.getMonth() + 1;
        var day = regdate.getDate();

        return year + "-" + month + "-" + day;
      },
      AddItem() {
        this.AddModal = true;
      },
      showMdfModal(p) {
        this.product = p;
        this.MdfModal = true;
        // this.ItemNum = index;
        // this.ProductChange(productUnum, categoryUnum);
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
        };

        axios({
            url: "http://localhost:8000/api/admin/product/add",
            method: "post",
            headers: headers,
            data: body,
          })
          .then((res) => {
            this.AddModal = false;
            this.ProductAll();
            alert("상품 등록이 완료되었습니다.");
            this.AddModal = false;
          })
          .catch((err) => {
            alert("이미 있는 상품이거나, 등록할 수 없는 상품입니다.");
            this.AddModal = false;
          });
      },
      ProductDeleteSure(prouctUnum) {
        if (confirm('상품을 삭제하시겠습니까?')) {
          this.ProductDelete(prouctUnum);
        } else {
          alert('상품삭제를 취소하였습니다.')
        }
      },
      ProductDelete(productUnum) {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };
        axios({
            url: 'http://localhost:8000/api/admin/product/delete',
            method: 'delete',
            headers: headers,
            params: {
              productUnum: productUnum
            }
          })
          .then(res => {
            this.ProductAll();
            alert('상품삭제가 완료되었습니다.')
          }, error => {
            alert('상품삭제가 실패되었습니다.')
          })
      },
      ProductAll() {
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
            this.pageArray = product;
          });

      },
      ProductChange() {
        var headers = {
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };
        var body = {

          productUnum: this.product.productUnum,
          categoryUnum: this.product.categoryUnum,
          productName: this.product.productName,
          productPrice: this.product.productPrice,
          productSeason: this.product.productSeason

        }
        console.log(body);
        axios({
            url: 'http://localhost:8000/api/admin/product/infochange',
            method: 'patch',
            headers: headers,
            data: body
          })
          .then(res => {
            this.ProductAll();
            this.MdfModal = false;
            alert('상품변경이 완료되었습니다')
            this.ProductAll();
          }, error => {
            alert('상품변경에 실패하였습니다')
          })
      },
      seasonWeather(productSeason) {
        var weather = '';
        if (productSeason == 0) {
          weather = '봄';
        } else if (productSeason == 1) {
          weather = '여름';
        } else if (productSeason == 2) {
          weather = '가을';
        } else if (productSeason == 3) {
          weather = '겨울';
        }
        return weather;
      }
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
      this.ProductAll();
    },
  };
</script>

<style scoped>


  div {
    box-sizing: border-box;
  }

  .information {
    font-size: 10pt;
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
