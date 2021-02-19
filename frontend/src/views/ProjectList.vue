<template>
<v-container class="">
  <v-row no-gutters>
    <v-col v-for="post of posts" :key="post.id" cols="12" sm="4">

      <v-card class="mx-auto my-5" max-width="374">
        <template slot="progress">
          <v-progress-linear color="deep-purple" height="10" indeterminate></v-progress-linear>
        </template>

        <v-card-title>{{post.name}}</v-card-title>
        <v-card-title>{{post.logDate}}</v-card-title>

        <v-card-text>

          <div class="my-4 subtitle-1">
          </div>

          <div>{{post.description}}</div>
        </v-card-text>

        <v-divider class="mx-4"></v-divider>

        <v-card-actions>
          <router-link class="nav-link" :to="{path: '/project/' + post.id}">
            <v-btn color="deep-purple lighten-2" text>
              View Project
            </v-btn>
          </router-link>

        </v-card-actions>
      </v-card>

    </v-col>
  </v-row>
</v-container>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      posts: [],
      errors: []
    }
  },
  name: "BugList",

  created() {
    axios.get(`http://localhost:8080/api/v1/projects`)
      .then(response => {
        this.posts = response.data
        console.log(typeof response.data)
      })
      .catch(e => {
        this.errors.push(e)
      })
  },

  methods: {

  }
}
</script>
