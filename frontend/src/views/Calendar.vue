<template>
<v-container>
  <div>
    <v-sheet tile height="54" class="d-flex">
      <v-btn icon class="ma-2" @click="$refs.calendar.prev()">
        <v-icon>mdi-chevron-left</v-icon>
      </v-btn>

      <v-spacer></v-spacer>
      <v-btn icon class="ma-2" @click="$refs.calendar.next()">
        <v-icon>mdi-chevron-right</v-icon>
      </v-btn>
    </v-sheet>
    <v-sheet height="600">
      <v-calendar ref="calendar" v-model="value" @click:event="(event)=>gotoBug(event)" :weekdays="weekday"  :events="events"  :event-overlap-threshold="30" :event-color="getEventColor" @change="getEvents"></v-calendar>
    </v-sheet>
  </div>
</v-container>
</template>

<script>
import axios from 'axios'

export default {
  data: () => ({
    type: 'month',
    weekday: [0, 1, 2, 3, 4, 5, 6],
    weekdays: [{
        text: 'Sun - Sat',
        value: [0, 1, 2, 3, 4, 5, 6]
      },
      {
        text: 'Mon - Sun',
        value: [1, 2, 3, 4, 5, 6, 0]
      },
      {
        text: 'Mon - Fri',
        value: [1, 2, 3, 4, 5]
      },
      {
        text: 'Mon, Wed, Fri',
        value: [1, 3, 5]
      },
    ],
    value: '',
    events: [],
    bugs: []
  }),
  methods: {
    getEvents() {
      const events = [];
      axios.get(`http://localhost:8080/api/v1/bugs`)
        .then(result => {
          this.bugs = result.data;
          this.bugs.forEach(b => {

            events.push({
              id: b.id,
              name: b.name,
              start: b.dueDate,
              color: b.complete ? 'green' : 'orange'
            });
          });
          this.events = events
        })

    },
    getEventColor(event) {
      return event.color
    },
    gotoBug(event) {
      this.$router.push('/bug/' + event.event.id);
    }
  },
}
</script>
