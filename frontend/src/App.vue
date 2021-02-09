<template>
  <v-app>

    <v-app-bar
      color="deep-purple"
      dark
      class="bar"
    >
      <v-app-bar-nav-icon @click="drawer = true"></v-app-bar-nav-icon>

      <v-toolbar-title>Bug Tracker</v-toolbar-title>
    </v-app-bar>

    

    <v-main>
      <BugList/>
    </v-main>
  </v-app>
</template>

<style scoped>
.bar {
  max-height: 64px !important;
}
</style>

<script>
import BugList from './components/BugList';

export default {
  name: 'App',

  components: {
    BugList,
  },

  data: () => ({
      drawer: false,
      group: null,
    }),
};
</script>
