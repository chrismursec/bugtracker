<template>
<v-container>
  <form @submit.prevent="submit" class="elevation-3">

    <v-row>
      <v-text-field outlined v-model="form['name']" prepend-icon="mdi-source-repository" label="Name" required>
      </v-text-field>
    </v-row>

    <v-row>
      <v-textarea outlined v-model="form['description']" prepend-icon="mdi-card-text" name="input-7-1" label="Description" auto-grow required></v-textarea>

    </v-row>

    <v-row>
           <v-btn class="btn mr-4" type="submit" color="light-blue">
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
  form {
    padding: 2em;
  }
</style>


<script>
import axios from 'axios'

export default {

data() {
  return {
    form:{}
  }
},

methods: {

  submit() {
    const formData = {
      name: this.form.name,
      description: this.form.description
    };

    axios.post('http://localhost:8080/api/v1/projects', formData)
      .then(result => {
        console.log(result);
      })

  }
}

}
</script>
