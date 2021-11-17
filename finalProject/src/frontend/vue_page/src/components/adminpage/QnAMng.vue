<template>

  <body>
    <!-- add modal -->
    <div class="black-bg" v-if="AddModal == true">
      <div class="white-bg">
        <h4>답변 관리</h4>
        <div class="add_comment">
          <div class="add_comment_box">
            <div class="qnatitle">
              <strong>제목 : </strong>{{ contComm.qnaTitle }}
            </div>

            <strong>내용 : </strong>
            <div class="qnacontent">
              <textarea name="ta_qna_modify" id="qna_modify" cols="135" rows="3" style="resize: none; border: none"
                :value="contComm.qnaContent" readonly></textarea><br />
            </div>
            <div class="contentres">
              <br><br>

              <textarea name="ta_qna_modify" placeholder="답변제목" id="qna_modify" cols="158" rows="1" style="resize: none"
                v-model="qna_title"></textarea><br />
              <textarea name="ta_qna_modify" placeholder="답변내용" id="qna_modify" cols="158" rows="5"
                style="resize: none" v-model="qna_content"></textarea><br />
            </div>

          </div>
        </div>
        <div style="float: right">
          <button @click="registComment(contComm.qnaUnum)">확인</button>
          <button @click="AddModal = false" style="margin-left: 40px">
            취소
          </button>
        </div>
      </div>
    </div>
    <!-- add modal end -->



    <!-- table area start -->

    <div>
      <h1>QnA 관리</h1>
      <div class="information">
        * 맨 오른쪽 <strong>답변 ' X '</strong>를 누르시면 질문에대한 답변을 남길 수 있습니다.<br><br>
      </div>
      <table class="table table-bordered" style="border: 2px solid black">
        <thead>
          <tr>
            <th scope="col0">질문번호</th>
            <th scope="col1">회원번호</th>
            <th scope="col2">제목</th>
            <th scope="col3">내용</th>
            <th scope="col4">등록일자</th>
            <th scope="col5">답변</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(qnaAll, index) in paginatedData" :key="index">
            <td>{{qnaAll.qnaUnum }}</td>
            <td>{{ qnaAll.userUnum }}</td>
            <td>{{ titleSubstring(qnaAll.qnaTitle) }}</td>
            <td>{{ contentSubstring(qnaAll.qnaContent)}}</td>
            <td>{{ dateFormat(qnaAll.qnaRegdate) }}</td>
            <td v-if="qnaAll.resComment != null">O</td>
            <td style="cursor:pointer;" v-if="qnaAll.resComment == null" @click="AddItem(qnaAll)">X</td>
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
        qnaAlls: [],

        qna_title: "",
        qna_content: "",

        contComm: {},

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

      AddItem(qnaAll) {
        this.AddModal = true;
        this.contComm = qnaAll;
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
      showqnaAll() {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };
        axios({
            url: 'http://localhost:8000/api/admin/qna/all',
            method: "get",
            headers: headers,
          })
          .then(res => {
            var qnaAll = new Array();
            for (var i = 0; i < res.data.length; i++) {
              qnaAll.push(res.data[i]);
            }
            this.qnaAlls = qnaAll;
          })
      },
      registComment(qnaUnum) {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };
        var body = {
          userUnum: this.$store.state.userInfo.userUnum,
          qnaTitle: this.qna_title,
          qnaContent: this.qna_content,
          qnaComment: qnaUnum
        }
        console.log(body);
        axios({
            url: 'http://localhost:8000/api/admin/qnareply',
            method: 'post',
            headers: headers,
            data: body
          })
          .then(res => {
            alert('답변등록이 완료되었습니다.');
            this.AddModal=false;
            this.showqnaAll();
            this.qna_title="";
            this.qna_content="";
          }, error => {
            alert('답변등록에 실패하였습니다.');
          })
      },
      dateFormat(date) {
        var regdate = new Date(date);
        var year = regdate.getFullYear();
        var month = regdate.getMonth() + 1;
        var day = regdate.getDate();

        return year + "-" + month + "-" + day;
      },
      contentSubstring(str) {
        if (str.length > 20) {
          str = str.substring(0, 20) + "...";
        }
        return str;
      },
      titleSubstring(str) {
        if (str.length > 15) {
          str = str.substring(0, 15) + "...";
        }
        return str;
      },

    },

    computed: {
      pageCount() {
        let listLeng = this.qnaAlls.length,
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
        return this.qnaAlls.slice(start, end);
      },
    },
    created() {
      this.showqnaAll();
    },

  }
</script>

<style scoped>
  body {
    margin: 30px;
  }

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
