<template>
  <div>
    <h1>{{msg}}</h1>
    <p>here is test page 입니다.</p>
    <p>here is test page 입니다.</p>
    <div>
      test video123
    </div>
    




</div>



  </div>
  
  
</template>

<script>
export default {
  name: "Test",
  data() {
    return {
      msg: "test page",
    };
  },
  methods: {
    fetchData: function () {
      axios
        .get("http://localhost:8000/api/main/show/nav")
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    getdata: function () {},
  },
};
</script>

<style scoped>
.video-box {
  height: 800px;
  width: 100%;
  overflow: hidden;
  position: relative;
}

.video-container {
  position: absolute;
  width : 100%;
  top: 50%;
  left: 50%;
  transform : translate(-50%,-50%);
  z-index: -1;
}
</style>