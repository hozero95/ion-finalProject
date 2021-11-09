<template>
<div class="container mt-2" style="background-color: cadetblue">
      <div class="row">
        <div class="col-lg-12">
            <div class="card">
            <div class="card-header">
              <div @click="viewOnOff" style="float: left" >
                Featured 
                <button><i class="fas fa-list-alt"></i></button>
              </div>
              <div style="float: right">
                <span><button><i class="fas fa-plus" @click=""></i></button></span>
                <span style="margin-left : 20px"><button><i class="fas fa-minus" @click=""></i></button></span>
              </div>
            </div>
            <ul class="list-group list-group-flush" v-if="viewlist == 1">
              <li class="list-group-item">item1 <button style="float : right"><i class="fas fa-tools" @click=""></i></button></li>
              <li class="list-group-item">item2 <button style="float : right"><i class="fas fa-tools" @click=""></i></button></li>
              <li class="list-group-item">item3 <button style="float : right"><i class="fas fa-tools" @click=""></i></button></li>
              <li class="list-group-item">item3 <button style="float : right"><i class="fas fa-tools" @click=""></i></button></li>
              <li class="list-group-item">item3 <button style="float : right"><i class="fas fa-tools" @click=""></i></button></li>
            </ul>
          </div>
        </div>
      </div>
</div>          
</template>

<script>
export default {
  data() {
    return {
      
      viewlist: 0,
    };
  },
  methods: {
    viewOnOff() {
      if (this.viewlist == 0) {
        this.viewlist = 1;
      } else if (this.viewlist == 1) {
        this.viewlist = 0;
      }
    },
  },
  
  methods: {
    viewOnOff(){
      if(this.viewlist == 0){
        this.viewlist = 1;
      }
      else if(this.viewlist ==1){
        this.viewlist = 0;
      }
    }
  },
}
</script>

<style>

</style>