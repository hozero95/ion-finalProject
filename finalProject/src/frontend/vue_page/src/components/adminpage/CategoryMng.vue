<template>

  <body>
    <div class="container mt-2" style="background-color: cadetblue">
      <div class="row">
        <div class="col-lg-12">
          <span><button style="margin: 10px 10px" @click="viewBigAdd = !viewBigAdd"><i
                class="fas fa-plus"></i></button></span>

          <div class="card" v-if="viewBigAdd">
            <div class="card-header">
              <div style="float: left">
                Insert Big Category Name :
                <textarea v-model="addCategoryName" style="resize:none" rows="1" cols="153"></textarea>
                <button style="float: right" @click="addCategory(null, index)">추가</button>
              </div>
            </div>
          </div>

          <div class="card" v-for="(item, index) in bigCates" :key="index">
            <div class="card-header">
              <div style="float: left">
                {{item.categoryName}}
                <button @click="viewOnOff(index)"><i class="fas fa-list-alt"></i></button>
              </div>
              <div style="float: right">
                <span><button @click="addOnOff(index)"><i class="fas fa-plus"></i></button></span>
                <span style="margin-left: 20px"><button @click="delCategory(item.categoryUnum, true)"><i
                      class="fas fa-minus"></i></button></span>
              </div>
            </div>
            <ul class="list-group list-group-flush" v-if="viewlist[index]">

              <li class="list-group-item" v-if="viewSmallAdd[index]">
                Insert Small Category Name :
                <textarea v-model="addCategoryName" style="resize:none" rows="1" cols="153"></textarea>
                <button style="float: right" @click="addCategory(item.categoryUnum, index)">추가</button>
              </li>

              <li class="list-group-item" v-for="(items, i) in smallCates[index]" :key="i">
                {{items.categoryName}}
                <button style="float: right" @click="delCategory(items.categoryUnum, false)"><i class="fas fa-minus"></i></button>
                <!-- <button style="float: right" @click="modSmallCategory()"><i class="fas fa-tools"></i></button> -->
              </li>
            </ul>
          </div>
          <br>
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
        viewSmallAdd: [],
        viewBigAdd: false,

        // Call Category
        bigCates: [],
        smallCates: [],

        addCategoryName: null
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
      addOnOff(index) {
        if (this.viewSmallAdd[index]) {
          this.$set(this.viewSmallAdd, index, false);
        } else if (!this.viewSmallAdd[index]) {
          this.$set(this.viewSmallAdd, index, true);
        }
      },
      showCategory() {
        axios.get("http://localhost:8000/api/main/show/nav").then((res) => {
          var bigCate = new Array();
          var viewlist = new Array();
          var addlist = new Array();

          for (var i = 0; i < res.data.length; i++) {
            if (res.data[i].categoryRef == null || res.data[i].categoryRef == "") {
              bigCate.push(res.data[i]);
              viewlist.push(false);
              addlist.push(false);
            }
          }
          this.viewlist = viewlist;
          this.viewSmallAdd = addlist;

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
      addCategory(categoryRef, index) {
        var headers = {
          "Content-Type": "application/json",
          "Authorization": "Bearer " + this.$store.state.jwtToken,
        };

        var body = {
          categoryName: this.addCategoryName,
          categoryRef: categoryRef
        }

        axios({
            url: 'http://localhost:8000/api/admin/category/add',
            method: 'post',
            headers: headers,
            data: body
          })
          .then(res => {
            alert('카테고리 등록이 완료되었습니다.');
            this.showCategory();
            this.addCategoryName = null;
            if(categoryRef == null) {
              this.viewBigAdd = !this.viewBigAdd;
            } else {
              this.addOnOff(index);
            }
          }, error => {
            alert('카테고리 등록에 실패하였습니다.');
          });
      },
      delCategory(categoryUnum, flag) {
        var isDel = false;

        if (flag) {
          if (confirm("해당 카테고리 삭제 시 모든 하위 카테고리와 상품들이 함께 삭제됩니다. 삭제 하시겠습니까?")) {
            isDel = true;
          }
        } else {
          if (confirm("해당 카테고리 삭제 시 모든 하위 상품들이 함께 삭제됩니다. 삭제 하시겠습니까?")) {
            isDel = true;
          }
        }

        if (isDel) {
          var headers = {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + this.$store.state.jwtToken,
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
              alert('카테고리 삭제가 완료되었습니다.');
              this.showCategory();
            }, error => {
              alert('카테고리 삭제에 실패하였습니다.');
            });
        } else {
          alert("삭제가 취소되었습니다.");
        }
      }
    }
  };

</script>

<style>
</style>
