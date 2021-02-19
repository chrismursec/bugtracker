<template>
  <v-card
    class="mx-auto"
    max-width="300"
    tile
  >
    <v-list rounded>
      <v-subheader>{{title}}</v-subheader>
      <v-list-item-group
        color="primary"
      >
        <v-list-item
          v-for="(bug, b) in bugs"
          :key="b"
          @click="clickB(bug.id)"
        >
          <v-list-item-icon>
            <v-icon>{{icon}}</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title v-text="bug.name"></v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-card>
</template>


<script>
import axios from 'axios'
export default {
  name: 'BugListMenu',
  props: ['bugs', 'title', 'icon', 'category', 'goTo'],

  methods: {
    clickB(id) {

    


    

    
     axios.post("http://localhost:8080/api/v1/bugs/toggleComplete/" + id)
      .then(() => {
        this.$parent.getBugs();
        if (this.goTo === 'complete') {
      this.$parent.todoBugs.forEach(b => {
      if (b.id === id) {
        let i = this.$parent.todoBugs.indexOf(b);
        this.$parent.todoBugs.splice(i, 1);
        console.log(this.$parent.todoBugs)
      }
    });
    }

    if (this.goTo === 'incomplete') {
      this.$parent.completedBugs.forEach(b => {
      if (b.id === id) {
        let i = this.$parent.completedBugs.indexOf(b);
        this.$parent.completedBugs.splice(i, 1);
        console.log(this.$parent.completedBugs)
      }
    });
    }
      }) 
    }
  }
}
</script>