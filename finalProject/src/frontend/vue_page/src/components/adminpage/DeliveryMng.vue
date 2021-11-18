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
      <h1>배송 관리</h1>
      <div class="information">
        * 맨 오른쪽 배송상태를 누르시면 배송상태를 변경하실 수 있습니다.<br>
        &nbsp; (결제완료 -> 상품준비중 -> 배송중 -> 배송완료)<br><br>

      </div>

      <table class="table table-bordered" style="border: 2px solid black">
        <thead>
          <tr>

            <th scope="col0">주문번호</th>
            <th scope="col1">배송번호</th>
            <th scope="col2">주소</th>
            <th scope="col3">배송날짜</th>
            <th scope="col5">배송상태</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(deliveryAll, index) in paginatedData" :key="index">
            <!-- <th scope="row">
            {{index}}
            <button style="float: right" @click="showMdfModal(index)">
              <i class="fas fa-tools"></i>
            </button>
          </th> -->
            <td>{{deliveryAll.orderUnum}}</td>
            <td>{{deliveryAll.deliveryUnum}}</td>
            <td>{{addressSubstring(deliveryAll.deliveryAddress)}}</td>
            <td>{{dateFormat(deliveryAll.deliveryRegdate)}}</td>
            <td style="cursor : pointer;"
              @click="changeStatus(deliveryAll.orderUnum, deliveryAll.deliveryUnum, deliveryAll.deliveryStatus)">
              {{deliveryStatus(deliveryAll.deliveryStatus)}}</td>
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
        deliveryAlls: [],


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
      showDliveryAll() {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        axios({
            url: 'http://localhost:8000/api/admin/delivery/all',
            method: 'get',
            headers: headers
          })
          .then(res => {
            var deliveryAll = new Array();
            for (var i = 0; i < res.data.length; i++) {
              deliveryAll.push(res.data[i]);
            }
            this.deliveryAlls = deliveryAll;
          })
      },
      changeStatus(orderUnum, deliveryUnum, beforeStatus) {
        var afterStatus = beforeStatus;
        if (beforeStatus >= 3) {
          alert(orderUnum + "번 주문의 배송 상태를 변경할 수 없습니다.");
        } else {
          if (confirm(orderUnum + '번 주문의 배송상태를 변경하시겠습니까?')) {
            if (beforeStatus == 0) {
              afterStatus = 1;
              this.patchStatus(deliveryUnum, afterStatus);
            } else if (beforeStatus == 1) {
              afterStatus = 2;
              this.patchStatus(deliveryUnum, afterStatus);
            } else if (beforeStatus == 2) {
              afterStatus = 3;
              this.patchStatus(deliveryUnum, afterStatus);
            }
          } else {
            alert('배송상태 변경을 취소하였습니다.')
          }
        }
      },
      patchStatus(deliveryUnum, deliveryStatus) {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        var body = {
          deliveryUnum: deliveryUnum,
          deliveryStatus: deliveryStatus
        }

        axios({
            url: 'http://localhost:8000/api/admin/deliverystatus',
            method: 'patch',
            headers: headers,
            data: body
          })
          .then(res => {
            alert('배송상태가 변경되었습니다.');
            this.showDliveryAll();
          })
      },
      dateFormat(date) {
        var regdate = new Date(date);
        var year = regdate.getFullYear();
        var month = regdate.getMonth() + 1;
        var day = regdate.getDate();

        return year + "-" + month + "-" + day;
      },
      addressSubstring(str) {
        if (str.length > 35) {
          str = str.substring(0, 35) + "...";
        }
        return str;
      },
      messageSubstring(str) {
        if (str.length > 20) {
          str = str.substring(0, 20) + "...";
        }
        return str;
      },
      deliveryStatus(delivery) {
        var status = '';
        if (delivery == 0) {
          status = '결제완료';
        } else if (delivery == 1) {
          status = '상품준비중';
        } else if (delivery == 2) {
          status = '배송중';
        } else if (delivery == 3) {
          status = '배송완료';
        } else if (delivery == 4) {
          status = '교환';
        } else if (delivery == 5) {
          status = '반품';
        }
        return status;
      }


    },
    computed: {
      pageCount() {
        let listLeng = this.deliveryAlls.length,
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
        return this.deliveryAlls.slice(start, end);
      },
    },

    created() {
      this.showDliveryAll();
    }
  };
</script>

<style scoped>


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


  .information {
    font-size: 10pt;
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