
<template>
  <v-app>

   <HeaderBar/>

    

    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>



<script>
import HeaderBar from './components/HeaderBar';

export default {
  name: 'App',
  components: {
    HeaderBar
  }
  
    
};
</script>