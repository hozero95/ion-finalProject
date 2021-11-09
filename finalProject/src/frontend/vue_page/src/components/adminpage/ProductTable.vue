<template>

  <body>
    <div>{{ products[0] }}</div>

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
              <td><input v-model="addProductImage01" type="text"><br><input type="file" /></td>
              <td><input v-model="addProductImage02" type="text"><br><input type="file" /></td>
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
                <textarea v-model="products[ItemNum].productUnum"></textarea>
              </td>
              <td>
                <textarea v-model="products[ItemNum].categoryUnum"></textarea>
              </td>
              <td>
                <textarea v-model="products[ItemNum].productName"></textarea>
              </td>
              <td>
                <textarea v-model="products[ItemNum].productPrice"></textarea>
              </td>
              <td>
                <textarea v-model="products[ItemNum].productRegdate"></textarea>
              </td>
              <td>
                <textarea v-model="products[ItemNum].productSeason"></textarea>
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

    <table class="table table-bordered" style="border: 2px solid black">
      <thead>
        <tr>
          <th scope="col5">
            list
            <div style="float: right">
              <span>
                <button><i class="fas fa-plus" @click="AddItem()"></i></button>
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
        <tr v-for="(item, i) in products" :key="i">
          <th scope="row">
            {{ i
            }}<button style="float: right">
              <i class="fas fa-tools" @click="ModifiedModal(i)"></i>
            </button>
          </th>
          <td>{{ products[i].productUnum }}</td>
          <td>{{ products[i].categoryUnum }}</td>
          <td>{{ products[i].productName }}</td>
          <td>{{ products[i].productPrice }}</td>
          <td>{{ products[i].productRegdate }}</td>
          <td>{{ products[i].productSeason }}</td>
        </tr>
      </tbody>
    </table>
  </body>
</template>

<script>
  import axios from "axios";
  export default {
    data() {
      return {
        products: [],
        AddModal: true,
        MdfModal: false,
        ItemNum: 0,

        // add modal
        addCategoryUnum: null,
        addProductName: null,
        addProductPrice: null,
        addProductSeason: null,
        addProductImage01: null,
        addProductImage02: null
      };
    },
    methods: {
      AddItem() {
        this.AddModal = true;
      },
      ModifiedModal(index) {
        this.MdfModal = true;
        this.ItemNum = index;
      },

      ProductAdd() {
        var headers = {
              "Content-Type": "application/json",
              "Authorization": "Bearer " + this.$store.state.jwtToken
            };

        var body = {
          categoryUnum: this.addCategoryUnum,
          productName: this.addProductName,
          productPrice: this.addProductPrice,
          productSeason: this.addProductSeason,
          productImage01Path: this.addProductImage01,
          productImage02Path: this.addProductImage02
        };

        axios.defaults.headers.post = null
        axios({
            url: 'http://localhost:8000/api/admin/product/add',
            method: 'post',
            headers: headers,
            data: body
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

</style>
