<template>
<div>
  <v-app-bar class="bar" color="blue" dark>
    <v-app-bar-nav-icon @click="drawer = true"></v-app-bar-nav-icon>

    <v-toolbar-title>Bug Tracker</v-toolbar-title>
  </v-app-bar>

  <v-navigation-drawer v-model="drawer" absolute temporary>
    <v-list nav dense>
      <v-list-item-group v-model="group" active-class="blue--text text--accent-4">
        <router-link class="nav-link" to="/">
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-home</v-icon>
            </v-list-item-icon>
            <v-list-item-title>
              Home
            </v-list-item-title>
          </v-list-item>
        </router-link>

        <router-link class="nav-link" to="/projectlist">
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-source-repository</v-icon>
            </v-list-item-icon>
            <v-list-item-title>
              Project List
            </v-list-item-title>
          </v-list-item>
        </router-link>

        <router-link class="nav-link" to="/addbug">
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-bug</v-icon>
            </v-list-item-icon>
            <v-list-item-title>
              Add bug
            </v-list-item-title>
          </v-list-item>
        </router-link>

        <router-link class="nav-link" to="/addproject">
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-source-repository</v-icon>
            </v-list-item-icon>
            <v-list-item-title>

              Add Project
            </v-list-item-title>
          </v-list-item>
        </router-link>

          <router-link class="nav-link" to="/calendar">
          <v-list-item>
            <v-list-item-icon>
              <v-icon>mdi-calendar</v-icon>
            </v-list-item-icon>
            <v-list-item-title>

              Calendar
            </v-list-item-title>
          </v-list-item>
        </router-link>

      </v-list-item-group>
    </v-list>
  </v-navigation-drawer>
</div>
</template>

<style>
.nav-link {
  text-decoration: none;
  color: #212121 !important;
}
</style>

<script>
export default {
  data: () => ({
    drawer: false,
    group: null,
  }),
}
</script>
