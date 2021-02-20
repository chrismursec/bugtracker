<template>
<v-container>
  <h1>{{projectData.name}}</h1>
  <hr class="mb-5">
  <p>{{projectData.description}}</p>

  <v-data-table :headers="headers" :items="bugList" :items-per-page="5" class="elevation-5 mt-5">

    <template v-slot:[`item.name`]="{item}">
             <router-link class="nav-link" :to="{path: '/bug/' + item.id}">{{item.name}}</router-link>

    </template>

    <template v-slot:[`item.complete`]="{ item }">
      <v-chip :color="getColor(item.complete)" dark @click="completeTask(item.id)">
        {{ item.complete ? "Done" : "Open" }}
      </v-chip>
    </template>

    <template v-slot:[`item.severity`]="{ item }">
      <v-rating color="amber" dense half-increments readonly size="14" :value="item.severity"></v-rating>
    </template>

    <template v-slot-:[`item.logDate`]="{ item }">
      <p>item.logDate</p>
    </template>

  </v-data-table>

</v-container>
</template>

<style scoped>
.bugList {
  width: 100%;
}
</style>

<script>
import axios from 'axios';
export default {
  components: {

  },

  data() {
    return {
      projectId: Number,
      routeTitle: '',
      projectData: {},
      bugIdList: [],
      todoBugs: [],
      completedBugs: [],
      bugList: [],

      headers: [{
          text: 'Bug',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        {
          text: 'Description',
          value: 'description'
        },
        {
          text: 'Severity',
          value: 'severity'
        },
        {
          text: 'Log Date',
          value: 'logDate'
        },
        {
          text: 'Progress',
          value: 'complete'
        }
      ],
    }
  },

  created() {
    this.projectId = this.$route.params.id;

    axios.get('http://localhost:8080/api/v1/projects/' + this.projectId)
      .then(responseData => {
        this.projectData = responseData.data;
        this.bugIdList = this.projectData.bugs;
        this.getBugs();
      });

  },
  methods: {
    getBugs() {
      let bugs = [];
      this.todoBugs = [];
      this.completedBugs = [];
      this.bugList = [];

      this.bugIdList.forEach(x => {

        axios.get('http://localhost:8080/api/v1/bugs/' + x)
          .then(result => {

            bugs.push(result.data);
            this.bugList = this.filterArray(bugs);
            this.bugList.forEach(b => {
              if (!b.complete) {
                this.todoBugs.push(b);
              }

              if (b.complete) {
                this.completedBugs.push(b)
              }
            });

            this.todoBugs = this.filterArray(this.todoBugs);
            this.completedBugs = this.filterArray(this.completedBugs);
            this.bugList = this.filterArray(this.bugList)
          })
      });
    },

    filterArray(array) {
      return array.filter((item, pos, self) => {
        return self.indexOf(item) == pos;
      });
    },

    getColor(progress) {
      if (!progress) return 'orange'
      else return 'green'
    },

    completeTask(id) {
      axios.post('http://localhost:8080/api/v1/bugs/toggleComplete/' +id)
        .then(() => {
          this.getBugs();
        });
    }

  }

}
</script>
