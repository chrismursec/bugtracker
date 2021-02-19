<template>
  <div>
    <h1>{{bugData.name}}</h1>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      bugId: Number,
      bugData: {},
    }
  },

  created() {
    this.bugId = this.$route.params.id;

    axios.get('http://localhost:8080/api/v1/bugs/' + this.bugId)
      .then(result => {
      console.log(result)
        this.bugData = result.data;
      })
  },

  methods:{ 
  
  }
}
</script>