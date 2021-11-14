<template>

  <body>
    <div> test area</div>

    <div>bigcates 0 </div>
    <div>{{ bigCates[0] }}</div>
    <div>smallcates 0 </div>
    <div>{{smallCates[0]}}</div>

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
                <span><button><i class="fas fa-plus"></i></button></span>
                <span style="margin-left: 20px"><button><i class="fas fa-minus"></i></button></span>
              </div>
            </div>
            <ul class="list-group list-group-flush" v-if="viewlist[index]">
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

        // add Category
        addCategoryUnum: null,
        addCategoryName: null,
        addCategoryRef: null,
        addCategoryUsed: null,
      };
    },

    created() {
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
    methods: {
      viewOnOff(index) {
        if (this.viewlist[index]) {
          this.$set(this.viewlist, index, false);
        } else if (!this.viewlist[index]) {
          this.$set(this.viewlist, index, true);
        }
      },
      // CategoryAdd() {
      //   var body = {
      //     categoryUnum: this.addCategoryUnum,
      //     categoryName: this.addCategoryName,
      //     categoryRef: this.addCategoryRef,
      //     categoryUsed: this.addCategoryUsed,
      //   };

      //   axios.defaults.headers.post = null;
      //   axios({
      //     url: "http://localhost:8000/api/admin/product/add",
      //     method: "post",
      //     headers: headers,
      //     data: body,
      //   })
      //     .then((res) => {
      //       alert("상품 등록 " + res.data);
      //       this.AddModal = false;
      //     })
      //     .catch((err) => {
      //       alert("이미 있는 상품이거나, 등록할 수 없는 상품입니다.");
      //       this.AddModal = false;
      //     });
      // },
    }
  };

</script>

<style>
</style>
