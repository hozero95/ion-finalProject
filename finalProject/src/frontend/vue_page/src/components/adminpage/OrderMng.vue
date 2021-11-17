<template>

  <body>
    <!-- add modal -->
    <!-- <div class="black-bg" v-if="AddModal == true">
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
    </div> -->
    <!-- add modal end -->



    <!-- table area start -->

    <div>
      <br>
      <h1>주문 관리</h1>
      <div class="information">
        * 결제완료처리의 확인버튼을 누르시면 배송관리탭으로 상품이 넘어갑니다.<br>
          <p style="color:red; font-size:9pt;">&nbsp; &nbsp;(주문취소건에 대해서는 결제완료확인을 하실 수 없습니다.)</p>
          
      </div>
      <table class="table table-bordered" style="border: 2px solid black">
        <thead>
          <tr>

            <th scope="col0">회원번호</th>
            <th scope="col1">주문번호</th>
            <th scope="col2">주문날짜</th>
            <th scope="col3">메세지</th>
            <th scope="col4">결제수단</th>
            <th scope="col5">주문상태</th>
            <th scope="col6">결제완료처리</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(orderAll, index) in paginatedData" :key="index">
            <!-- <th scope="row">
            {{index}}
            <button style="float: right" @click="showMdfModal(index)">
              <i class="fas fa-tools"></i>
            </button>
          </th> -->
            <td>{{orderAll.userUnum}}</td>
            <td>{{orderAll.orderUnum}}</td>
            <td>{{dateFormat(orderAll.orderRegdate)}}</td>
            <td>{{messageSubstring(orderAll.orderMessage)}}</td>
            <td>{{orderAll.orderType}}</td>
            <td>{{orderStatus(orderAll.orderStatus)}}</td>
            <!--(0: 정상, 1: 주문취소, 2: 환불)-->
            <td v-if="orderAll.orderStatus==1 || orderAll.orderStatus==2"> </td>
            <td style="cursor:pointer" v-if="orderAll.orderStatus==0" @click="deliveryStart(orderAll.orderUnum, orderAll.orderAddress)">확인</td>

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
        orderAlls: [],


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
      showOrderAll() {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        axios({
            url: 'http://localhost:8000/api/admin/order/all',
            method: 'get',
            headers: headers
          })
          .then(res => {
            var orderAll = new Array();
            for (var i = 0; i < res.data.length; i++) {
              orderAll.push(res.data[i]);
            }
            this.orderAlls = orderAll;
          })
      },
      deliveryStart(orderUnum, orderAddress) {
        if (confirm('결제완료처리 하시겠습니까?')) {
          var headers = {
            "Content-Type": "application/json",
            Authorization: "Bearer " + this.$store.state.jwtToken,
          };
          var body = {
            orderUnum: orderUnum,
            orderAddress: orderAddress
          };

          console.log(body);

          axios({
              url: 'http://localhost:8000/api/admin/deliverystart',
              method: 'post',
              headers: headers,
              data: body
            })
            .then(res => {
              console.log(res.data);
              alert('배송관리탭에서 확인해주세요.');
              this.showOrderAll();
            }, error => {
              console.log(error);
            });
        }
      },
      dateFormat(date) {
        var regdate = new Date(date);
        var year = regdate.getFullYear();
        var month = regdate.getMonth() + 1;
        var day = regdate.getDate();

        return year + "-" + month + "-" + day;
      },
      addressSubstring(str) {
        if (str.length > 10) {
          str = str.substring(0, 10) + "...";
        }
        return str;
      },
      messageSubstring(str) {
        if (str.length > 20) {
          str = str.substring(0, 20) + "...";
        }
        return str;
      },
      orderStatus(order) {
        var orderStatus = '';
        if (order == 0) {
          orderStatus = '정상';
        } else if (order == 1) {
          orderStatus = '주문취소';
        } else if (order == 3) {
          orderStatus = '환불';
        }
        return orderStatus;
      }


    },
    computed: {
      pageCount() {
        let listLeng = this.orderAlls.length,
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
        return this.orderAlls.slice(start, end);
      },
    },

    created() {
      this.showOrderAll();
    }
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