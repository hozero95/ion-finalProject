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
              <th scope="col5">list</th>
              <th scope="col0">상품</th>
              <th scope="col1">카테고리</th>
              <th scope="col2">상품이름</th>
              <th scope="col3">상품가격</th>
              <th scope="col4">등록일자</th>
              <th scope="col5">시즌상품</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row"></th>
              <td><input type="text" /></td>
              <td><input type="text" /></td>
              <td><input type="text" /></td>
              <td><input type="text" /></td>
              <td><input type="text" /></td>
              <td><input type="text" /></td>
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
              <th scope="col5">list</th>
              <th scope="col0">상품</th>
              <th scope="col1">카테고리</th>
              <th scope="col2">상품이름</th>
              <th scope="col3">상품가격</th>
              <th scope="col4">등록일자</th>
              <th scope="col5">시즌상품</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row"></th>
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
          <th scope="col0">상품</th>
          <th scope="col1">카테고리</th>
          <th scope="col2">상품이름</th>
          <th scope="col3">상품가격</th>
          <th scope="col4">등록일자</th>
          <th scope="col5">시즌상품</th>
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
        Authorization: "Bearer " + this.$store.state.jwtToken,
      };
      var body = {
        categoryUnum: 11,
        productName: "asd",
        productPrice: 11,
        productRegdate: [1,2,3],
        productSeason: 11,
        productImage01Path: "asd",
        productImage02Path: "asd",
      };

      axios
        .post("http://localhost:8000/api/admin/product/add", {
          headers,body,
        })
        .then((res) => {
          console.log("hi dude");
        })
        .catch((err) => {
          console.log(err);
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
        console.log(this.products);
      });
  },
};
</script>

<style>
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