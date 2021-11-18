<template>

  <body>
    <!-- add modal -->
    <div class="black-bg" v-if="AddModal == true">
      <div class="white-bg">
        <h4>이벤트추가</h4>
        <table class="table table-bordered" style="border: 2px solid black">
          <thead>
            <tr>
              <th scope="col1">제목</th>
              <th scope="col2">내용</th>
              <th scope="col4">이미지추가</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input v-model="addEventTitle" type="text" /></td>
              <td><input v-model="addEventContent" type="text" /></td>
              <td>
                <input type="file" class="dd" />
              </td>
            </tr>
          </tbody>
        </table>
        <div style="float: right">
          <button @click="eventAdd()">확인</button>
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
        <h4>이벤트수정</h4>
        <table class="table table-bordered" style="border: 2px solid black">
          <thead>
            <tr>
              <th scope="col0">이벤트번호</th>
              <th scope="col1">제목</th>
              <th scope="col2">내용</th>
              <th scope="col3">시작일자</th>
              <th scope="col4">종료일자</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <textarea :value="eventShow.eventUnum" style="resize: none" readonly></textarea>
              </td>
              <td>
                <textarea :value="eventShow.eventTitle" style="resize: none" readonly></textarea>
              </td>
              <td>
                <textarea :value="eventShow.eventContent" style="resize: none" readonly></textarea>
              </td>
              <td>
                <textarea :value="dateFormat(eventShow.eventRegdate)" style="resize: none" readonly></textarea>
              </td>
              <td>
                <div class="block">
                  <!-- <span class="demonstration">Default</span> -->
                  <el-date-picker v-model="enddate" type="date" placeholder="Pick a day">
                  </el-date-picker>
                </div>
                <!-- <textarea :value="dateFormat(eventShow.eventEnddate)" style="resize: none"></textarea> -->
              </td>
            </tr>
          </tbody>
        </table>
        <div style="float: right">
          <button @click="eventDateChange(eventShow.eventUnum,eventShow.eventRegdate)" style="">확인</button>
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
      <h1>이벤트 관리</h1>

      <div class="information">
        * 이벤트번호 옆 <strong>' + '</strong>버튼을 누르시면 이벤트를 추가하실 수 있습니다.<br>
        * 이벤트번호(숫자) 옆 수정아이콘을 누르시면 이벤트 <strong>종료기간</strong>을 설정하실 수 있습니다. <br>
        * 맨 오른쪽 <strong>삭제버튼</strong>을 누르시면 이벤트가 삭제됩니다.<br><br>

      </div>
      <table class="table table-bordered" style="border: 2px solid black">
        <thead>
          <tr>
            <th scope="col5">
              이벤트번호
              <div style="float: right">
                <span>
                  <span @click="AddItem()" class="add_event_bt"><i class="fas fa-plus"
                      style="cursor:pointer;"></i></span>
                </span>
              </div>
            </th>
            <th scope="col1">제목</th>
            <th scope="col2">내용</th>
            <th scope="col3">시작일자</th>
            <th scope="col4">종료일자</th>
            <th scope="col4">삭제여부</th>

          </tr>
        </thead>
        <tbody>
          <tr v-for="(event, index) in paginatedData" :key="index">
            <td scope="row">
              {{event.eventUnum}}
              <span style="float: right; margin-right : 10px" @click="showMdfModal(index, event)">
                <i class="fas fa-tools " style="cursor:pointer;"></i>
              </span>
            </td>
            <td>{{titleSubstring(event.eventTitle)}}</td>
            <td>{{ contentSubstring(event.eventContent)}}</td>
            <td>{{ dateFormat(event.eventRegdate) }}</td>
            <td>{{ dateFormat(event.eventEnddate) }}</td>
            <td style="cursor:pointer;" @click="deleteSure(event.eventUnum)">삭제</td>
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
        events: [],
        eventShow: {},


        addEventTitle: '',
        addEventContent: '',
        addEventImage01: '',

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

        pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },
          shortcuts: [{
            text: 'Today',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: 'Yesterday',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: 'A week ago',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },
        enddate: '',



      }
    },


    methods: {

      AddItem() {
        this.AddModal = true;

      },
      showMdfModal(index, event) {
        this.MdfModal = true;
        this.ItemNum = index;
        this.eventShow = event;
      },

      nextPage() {
        this.pageNum += 1;
      },
      prevPage() {
        this.pageNum -= 1;
      },
      showEvent() {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        axios({
            url: 'http://localhost:8000/api/admin/event/all',
            method: 'get',
            headers: headers
          })
          .then(res => {
            // console.log(res.data);
            var eventAll = new Array();
            for (var i = 0; i < res.data.length; i++) {
              eventAll.push(res.data[i]);
            }
            this.events = eventAll;
          })
      },

      eventDateChange(eventUnum, eventRegdate) {
        var enddate = new Date(this.enddate);
        if (new Date(eventRegdate) < enddate) {
          var headers = {
            "Content-Type": "application/json",
            Authorization: "Bearer " + this.$store.state.jwtToken,
          };
          var body = {
            eventUnum: eventUnum,
            eventEnddate: enddate
          }

          axios({
              url: 'http://localhost:8000/api/admin/event/datechange',
              method: 'patch',
              headers: headers,
              data: body
            })
            .then(res => {
              this.MdfModal = false;
              this.showEvent()
            })
        } else {
          alert('시작날짜보다 큰 날짜를 넣어주세요')
        }

      },
      eventAdd() {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        var body = {
          eventTitle: this.addEventTitle,
          eventContent: this.addEventContent,
        }
        axios({
            url: 'http://localhost:8000/api/admin/event/add',
            method: 'post',
            headers: headers,
            data: body
          })
          .then(res => {
            this.AddModal = false;
            this.showEvent();
            alert('이벤트등록이 완료되었습니다.')
          }, error => {
            alert('이벤트등록이 실패하였습니다')
          })

      },
      deleteSure(eventUnum) {
        if (confirm('이벤트를 삭제하시겠습니까?')) {
          this.eventDelete(eventUnum);
        } else {
          alert('이벤트삭제를 취소합니다.')
        }
      },
      eventDelete(eventUnum) {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        axios({
            url: 'http://localhost:8000/api/admin/event/delete',
            method: 'delete',
            headers: headers,
            params: {
              eventUnum: eventUnum
            }
          })
          .then(res => {
            this.showEvent();
            alert('이벤트삭제가 완료되었습니다')
          })
      },




      dateFormat(date) {
        if (date != null) {
          var regdate = new Date(date);
          var year = regdate.getFullYear();
          var month = regdate.getMonth() + 1;
          var day = regdate.getDate();

          return year + "-" + month + "-" + day;
        }
      },
      contentSubstring(str) {
        if (str.length > 15) {
          str = str.substring(0, 15) + "...";
        }
        return str;
      },
      titleSubstring(str){
        if(str.length>10){
          str=str.substring(0,10) + "...";
        }
        return str;
      }
    },

    computed: {
      pageCount() {
        let listLeng = this.events.length,
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
        return this.events.slice(start, end);
      },
    },

    created() {
      this.showEvent();
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

  .add_event_bt {
    cursor: pointer;
  }

  .dd {

    margin-left: 100px;
  }
</style>