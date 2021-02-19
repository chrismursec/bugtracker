<template>
<v-container>

  <form @submit.prevent="submit" class="elevation-3">

    <v-row>
      <h1 class="mb-5">Add new bug</h1>    
    </v-row>

    <v-row>

      <v-text-field outlined v-model="form['name']" prepend-icon="mdi-bug" label="Name" required>
      </v-text-field>
    </v-row>

    <v-row>
      <v-textarea outlined v-model="form['description']" prepend-icon="mdi-card-text" name="input-7-1" label="Description" auto-grow></v-textarea>
    </v-row>

    <v-row>
      <v-textarea outlined v-model="form['notes']" prepend-icon="mdi-note-multiple" name="input-7-1" label="Recreation Steps" auto-grow></v-textarea>

    </v-row>

    <v-row justify="center">
      <v-col cols="12" sm="6">
        <v-select outlined prepend-icon="mdi-source-repository" v-model="form['project']" :items="projects" item-text="name" item-value="id" label="Parent Project" persistent-hint single-line></v-select>

      </v-col>
      <v-col cols="12" sm="6">
        <v-menu ref="menu" v-model="menu" :close-on-content-click="false" :return-value.sync="date" transition="scale-transition" offset-y min-width="auto">
          <template v-slot:activator="{ on, attrs }">
            <v-text-field outlined v-model="date" label="Log Date" prepend-icon="mdi-calendar" readonly v-bind="attrs" v-on="on"></v-text-field>
          </template>
          <v-date-picker v-model="date" no-title scrollable>
            <v-spacer></v-spacer>
            <v-btn text color="primary" @click="menu = false">
              Cancel
            </v-btn>
            <v-btn text color="primary" @click="$refs.menu.save(date)">
              OK
            </v-btn>
          </v-date-picker>
        </v-menu>
      </v-col>

    </v-row>
    <v-slider class="slider mt-8" prepend-icon="mdi-star" v-model="form['severity']" :label="ex3.label" :thumb-color="ex3.color" thumb-label="always" max="5" min="1"></v-slider>

    <v-row>
    </v-row>

    <v-row>
      <v-btn class="btn mt-4 " type="submit" color="light-blue">
        submit
      </v-btn>
    </v-row>

  </form>

</v-container>
</template>

<style scoped>
.btn {
  width: 100%;
}

.slider {}

form {
  padding: 2em;
  ;
}
</style>

<script>
import axios from 'axios'

export default {

  data() {
    return {
      date: new Date().toISOString().substr(0, 10),

      menu: false,
      form: {},

      ex3: {
        label: 'Severity',
        val: 50,
        color: 'red'
      },

      projects: []
    }
  },
  mounted() {

    axios.get('http://localhost:8080/api/v1/projects')
      .then(returnData => {
        this.projects = returnData.data;
        console.log(typeof returnData.data)
      });

  },

  methods: {

    submit() {
      const formData = {
        name: this.form.name,
        description: this.form.description,
        severity: this.form.severity,
        logDate: this.date,
        notes: this.form.notes,
        complete: false,
        projectId: this.form.project
      };
      console.log(formData)

      axios.post('http://localhost:8080/api/v1/bugs', formData)
        .then(response => {
          console.log(response);
        })

    },

  },
}
</script>
