<template>
  <!-- top navbar -->
  <div class="navbar-top">
    <ul id="element" class="navbar-top__menu">
      <li v-for="(bigCate, index) in bigCates" v-bind:key="index" class="navbar-top__menu__iteam">
        <a href="#">{{bigCate.categoryName}}</a>
        <div class="dropdown-content">
          <router-link v-for="smallCate in smallCates[index]" v-bind:key="smallCate.categoryUnum" to="category"><a
              href="#">{{smallCate.categoryName}}</a></router-link>
        </div>
      </li>
      <li class="navbar-top__menu__iteam">/</li>
      <router-link to="seasonalProduct">
        <li class="navbar-top__menu__iteam">제철</li>
      </router-link>
      <router-link to="bestProduct">
        <li class="navbar-top__menu__iteam">BEST</li>
      </router-link>
      <router-link to="event">
        <li class="navbar-top__menu__iteam">이벤트</li>
      </router-link>
    </ul>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    data() {
      return {
        bigCates: [],
        smallCates: [
          []
        ]
      }
    },
    created() {
      axios.get('http://localhost:8000/api/main/show/nav')
        .then(res => {
          var bigCate = new Array();

          for (var i = 0; i < res.data.length; i++) {
            if (res.data[i].categoryRef == null || res.data[i].categoryRef == '') {
              bigCate.push(res.data[i]);
            }
          }

          var smallCate = new Array(bigCate.length);
          for (var i = 0; i < smallCate.length; i++) {
            smallCate[i] = new Array();
          }

          for (var i = 0; i < res.data.length; i++) {
            if (!res.data[i].categoryRef == null || !res.data[i].categoryRef == '') {
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
    }
  }
</script>

<style>
  /* Universal tags */
  * {
    box-sizing: border-box;
  }

  body {
    font-family: 'Open Sans', sans-serif;
    margin: 0;
  }

  a {
    text-decoration: none;
    color: var(--color-white);
  }

  ul {
    padding-left: 0;
  }

  li {
    list-style: none;
  }

  button {
    background-color: transparent;
    cursor: pointer;
    border: none;
    outline: none;
    padding: 0;
  }

  p {
    margin: 0;
  }

  .text1 {
    margin: 0;
    font-size: 12px;
    color: gray;
  }

  .text2 {
    margin: 0;
    font-size: 12px;
  }

  .text3 {
    margin: 0;
    font-size: 11px;
    color: gray;
  }

  /* navber top */
  .navbar-top {
    margin: 0;
    background-color: #132c7d;
    height: 60px;
  }

  .navbar-top__menu {
    margin-left: 16%;
    width: 66%;
    height: 60px;
    color: white;
    display: flex;
    justify-content: space-between;
    font-size: 20px;
  }

  .navbar-top__menu__iteam {
    justify-content: center;
    margin-left: 30px;
    margin-top: 15px;
    cursor: pointer;
  }

  /* navbar dropdown */
  .dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
    z-index: 1;
    margin-top: 15px;
  }

  .dropdown-content a {
    color: black;
    padding: 12px 0px;
    text-decoration: none;
    display: block;
  }

  .navbar-top__menu__iteam:hover .dropdown-content {
    display: block;
  }
</style>