<template>

  <body>
    <br>
    <h1>카테고리 관리</h1>
    <div class="information">
      * 맨 위의 <strong>' + '</strong>버튼을 누르시면 <strong>대분류 카테고리</strong>를 추가하실 수 있습니다.<br>
      * 대분류 카테고리 옆 아이콘을 클릭하시면 소분류 카테고리를 볼 수 있습니다.<br>
      * 오른쪽 끝의 <strong>' + ',' - '</strong>버튼을 누르시면 <strong>소분류 카테고리</strong>를 추가 또는 삭제하실 수 있습니다.
      <p style="color:red">** 주의 : 카테고리 삭제시, 카테고리 안에있는 상품이 모두 삭제됩니다. **</p>
    </div>
    <div class="container mt-2" style="background-color: cadetblue">
      <div class="row">
        <div class="col-lg-12">
          <div style="margin: 10px 10px;" @click="viewBigAdd = !viewBigAdd"><i class="fas fa-plus"
              style=" cursor: pointer;"></i></div>

          <div class="card" v-if="viewBigAdd">
            <div class="card-header">
              <div style="float: left">
                Insert Big Category Name :
                <textarea v-model="addCategoryName" style="resize:none; width : 1240px" rows="1" cols="153"></textarea>
                <div style="" @click="addCategory(null, index)">
                  <div class="add_button" style=" cursor: pointer;">추가</div>
                </div>
              </div>
            </div>
          </div>

          <div class="card" v-for="(item, index) in bigCates" :key="index">
            <div class="card-header" style="">
              <div style="float: left; display : inline-block">
                {{item.categoryName}}
              </div>
              <div @click="viewOnOff(index)"><i class="fas fa-list-alt big_cate_view_button"
                  style="float: left; margin-left:10px; cursor:pointer;"></i></div>
              <div style="float: right">
                <span @click="addOnOff(index)"><i class="fas fa-plus" style=" cursor:pointer;"></i></span>
                <span @click="delCategory(item.categoryUnum, true)"><i class="fas fa-minus"
                    style="margin-left:30px; cursor:pointer;"></i></span>
              </div>
            </div>
            <ul class="list-group list-group-flush" v-if="viewlist[index]">

              <li class="list-group-item" v-if="viewSmallAdd[index]">
                Insert Small Category Name :
                <textarea v-model="addCategoryName" style="resize:none; width : 1240px" rows="1" cols="153"></textarea>
                <div @click="addCategory(item.categoryUnum, index)">
                  <div class="add_button" style=" cursor:pointer;">추가</div>
                </div>
              </li>

              <li class="list-group-item" v-for="(items, i) in smallCates[index]" :key="i">
                {{items.categoryName}}
                <span style="float: right" @click="delCategory(items.categoryUnum, false)"><i class="fas fa-minus"
                    style=" cursor:pointer;"></i></span>
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
      this.pageCheck();
      this.showCategory();
    },
    methods: {
      pageCheck() {
        if (this.$store.state.userInfo.authorities.length < 2) {
          alert("관리자 외 출입금지");

          // this.moveScrollTop();
          if (this.$route.path !== "/") {
            this.$router.push("/");
            location.replace("#app");
          }
        }
      },
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
            if (categoryRef == null) {
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
  .information {
    font-size: 10pt;
  }

  .add_button {
    width: fit-content;
    height: fit-content;
    text-align: end;
    font-size: 18px;
    background: cadetblue;
    color: white;
    padding: 2px;
    border: none;
    border-radius: 5px;
    float: right;
    cursor: pointer;
  }

  .big_cate_view_button:hover {}
</style>
