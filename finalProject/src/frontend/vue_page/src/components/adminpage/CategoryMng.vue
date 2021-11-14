<template>

  <body>
    <div class="container mt-2" style="background-color: cadetblue">
      <div class="row">
        <div class="col-lg-12">
          <div class="card" v-for="(item, index ) in bigCates" :key="index">
            <div class="card-header">
              <div style="float: left">
                {{bigCates[index].categoryName}}
                <button @click="viewOnOff(index)"><i class="fas fa-list-alt"></i></button>
              </div>
              <div style="float: right">
                <span><button @click="addCategory()"><i class="fas fa-plus"></i></button></span>
                <span style="margin-left: 20px"><button><i class="fas fa-minus"></i></button></span>
              </div>
            </div>
            <ul class="list-group list-group-flush" v-if="viewlist[index]">
              <li v-if="addCategory"><textarea v-model="addCateogoryName" style="resize:none; border:none" rows="1" cols="153"></textarea>
                <span><button @click="categoryAdd()"><i class="fas fa-plus"></i></button></span>
                </li>
              <li class="list-group-item" v-for="(items,i) in smallCates[index]" :key="i">
                {{smallCates[index][i].categoryName}}
                <button style="float: right">
                  <i class="fas fa-tools"></i>
                </button>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
  import axios from "axios";

  export default {
    data() {
      return {
        viewlist: [],

        // Call Category
        bigCates: [],
        smallCates: [],

        addCategory:false,

        addCategoryName: '',
        categoryUsed: 0
      };
    },

    created() {
      this.showCategory();
    },
    methods: {
      viewOnOff(index) {
        if (this.viewlist[index]) {
          this.$set(this.viewlist, index, false);
        } else if (!this.viewlist[index]) {
          this.$set(this.viewlist, index, true);
        }
      },
      showCategory() {
        axios.get("http://localhost:8000/api/main/show/nav").then((res) => {
          var bigCate = new Array();
          var viewlist = new Array();

          for (var i = 0; i < res.data.length; i++) {
            if (res.data[i].categoryRef == null || res.data[i].categoryRef == "") {
              bigCate.push(res.data[i]);
              viewlist.push(false);
            }
          }
          this.viewlist = viewlist;

          var smallCate = new Array(bigCate.length);
          for (var i = 0; i < smallCate.length; i++) {
            smallCate[i] = new Array();
          }

          for (var i = 0; i < res.data.length; i++) {
            if (
              !res.data[i].categoryRef == null ||
              !res.data[i].categoryRef == ""
            ) {
              for (var j = 0; j < bigCate.length; j++) {
                if (res.data[i].categoryRef == bigCate[j].categoryUnum) {
                  smallCate[j].push(res.data[i]);
                }
              }
            }
          }

          this.bigCates = bigCate;
          this.smallCates = smallCate;

        });
      },
      addCategory(){
        this.addCategory= !this.addCategory;
      },
      cateogryAdd() {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        var body = {
          categoryName: this.categoryName,
          categoryRef: this.categoryRef
        }

        axios({
            url: 'http://localhost:8000/api/admin/category/add',
            method: 'post',
            headers: headers,
            data: body
          })
          .then(res => {
            alert('카테고리등록이 완료되었습니다.');
            this.showCategory();
          }, error => {
            alert('카테고리등록에 실패하였습니다.');
          })
      },

      deleteSure(categoryUnum) {
        if (confirm('카테고리를 삭제하시겠습니까?')) {
          this.categoryDelete(categoryUnum);
        } else {
          alert('카테고리삭제를 취소하셨습니다.')
        }
      },

      categoryDelete(categoryUnum) {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        axios({
            url: 'http://localhost:8000/api/admin/category/delete',
            method: 'delete',
            headers: headers,
            params: {
              categoryUnum: categoryUnum
            }
          })
          .then(res => {
            alert('카테고리삭제가 완료되었습니다.');
            this.showCategory();
          }, error => {
            alert('카테고리삭제에 실패하였습니다.');
          })
      },
      useornotSure(categoryUnum) {
        if (confirm('카테고리 사용여부를 변경하시겠습니까?')) {
          this.categoryUseorNot(categoryUnum);
        } else {
          alert('카테고리 사용여부변경을 취소하였습니다.')
        }
      },

      categoryUseorNot(categoryUnum) {
        var headers = {
          "Content-Type": "application/json",
          Authorization: "Bearer " + this.$store.state.jwtToken,
        };

        var body = {
          categoryUnum: categoryUnum,
          categoryUsed: this.categoryUsed
        }

        axios({
            url: 'http://localhost:8000/api/admin/category/useornot',
            method: 'patch',
            headers: headers,
            data: body
          })
          .then(res => {
            alert('카테고리사용여부 변경이 완료되었습니다.');
            this.showCategory();
          }, error => {
            alert('카테고리사용여부 변경에 실패하였습니다.');
          })
      }
    }
  };
</script>

<style>
</style>
