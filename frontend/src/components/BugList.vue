<template>
<v-container class="">
    <v-row no-gutters>
      <v-col
        v-for="post of posts"
        :key="post"
        cols="12"
        sm="4"
      >

      <v-card
    :loading="loading"
    class="mx-auto my-5"
    max-width="374"
  >
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>


    <v-card-title>{{post.name}}</v-card-title>

    <v-card-text>
      <v-row
        align="center"
        class="mx-0"
      >
      <div class="grey--text mr-2">
          Urgency: 
        </div>
        <v-rating
          :value="post.severity"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        
      </v-row>

      <div class="my-4 subtitle-1">
      </div>

      <div>{{post.description}}</div>
    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-actions>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="completeTask(post.id)"
      >
        Complete
      </v-btn>
    </v-card-actions>
  </v-card>
      
        
      </v-col>
    </v-row>
  </v-container>


  


  
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      posts: [],
      errors: []
    }
  },
  name: "BugList",

  created() {
    axios.get(`http://localhost:8080/api/v1/bugs`)
      .then(response => {
        this.posts = response.data
      })
      .catch(e => {
        this.errors.push(e)
      })
  },

  methods: {
    completeTask(id) {
      axios.delete('http://localhost:8080/api/v1/bugs/' + id)
        .then(response => {
          console.log(response);
          axios.get(`http://localhost:8080/api/v1/bugs`)
            .then(response => {
              this.posts = response.data
            });
        });
    }
  }
}
</script>