<template>
  <!-- event -->
  <section class="event">
    <div class="event__img" v-for="(event, index) in events" v-bind:key="index">
      <img :src="event.eventImage01Path" alt=""><br>
      <strong>{{event.eventTitle}}</strong><br>
      {{event.eventContent}}
      <hr>
    </div>


  </section>
</template>

<script>
  import axios from 'axios'

  export default {
    data() {
      return {
        events: []
      }
    },
    created() {
      axios.get('http://localhost:8000/api/event/show/event')
        .then(res => {
          var event = new Array();
          for (var i = 0; i < res.data.length; i++) {
            event.push(res.data[i]);
          }
          this.events = event;

        })
    }
  }
</script>

<style scoped>
  /* Event */
  .event {
    margin-top: 5%;
  }

  .event__img {
    text-align: center;
    margin-bottom: 5%;
  }

  .event__img img {
    width: 1232px;
    height: 340px;
  }

  .event__img strong{
      font-size: 20px;
  }

</style>