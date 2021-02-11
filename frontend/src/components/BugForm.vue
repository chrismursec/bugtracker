<template>
<v-container>
  <form @submit.prevent="submit">

    <v-row>
      <v-col cols="12" sm="6" md="8">
        <v-text-field v-model="form['name']" prepend-icon="mdi-account" label="Name" required>
        </v-text-field>
      </v-col>
      <v-col cols="6" md="4">
        <v-menu ref="menu" v-model="menu" :close-on-content-click="false" :return-value.sync="date" transition="scale-transition" offset-y min-width="auto">
          <template v-slot:activator="{ on, attrs }">
            <v-text-field v-model="date" label="Picker in menu" prepend-icon="mdi-calendar" readonly v-bind="attrs" v-on="on"></v-text-field>
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

    <v-row>
      <v-col cols="6" d="4">
        <v-textarea v-model="form['description']" name="input-7-1" label="Description" auto-grow></v-textarea>
      </v-col>

      <v-col cols="6" d="4">
        <v-textarea v-model="form['notes']" name="input-7-1" label="Notes" auto-grow></v-textarea>
      </v-col>

    </v-row>

    <v-row justify="center">
      <v-slider v-model="form['severity']" :label="ex3.label" :thumb-color="ex3.color" thumb-label="always" max="5" min="1"></v-slider>
    </v-row>

    <v-row>
      <v-btn class="btn mr-4" type="submit">
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
</style>

<script>
import axios from 'axios'

export default {

  data: () => ({
    date: new Date().toISOString().substr(0, 10),

    menu: false,
    form: {},

    ex3: {
      label: 'Severity',
      val: 50,
      color: 'red'
    },

  }),

  methods: {
    submit() {
      const formData = {
        name: this.form.name,
        description: this.form.description,
        severity: this.form.severity,
        logDate: this.date,
        notes: this.form.notes,
        complete: false
      };

      axios.post('http://localhost:8080/api/v1/bugs', formData)
        .then(response => {
          console.log(response);
        })

    },

  },
}
</script>
