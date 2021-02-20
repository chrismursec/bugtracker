import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import List from '../views/List.vue'
import AddBug from '../views/AddBug.vue'
import AddProject from '../views/AddProject.vue'
import ProjectList from '../views/ProjectList.vue';
import ViewProject from '../views/ViewProject.vue';
import ViewBug from '../views/ViewBug.vue';
import Calendar from '../views/Calendar.vue';
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/list',
    name: 'List',
    
    component: List
  },

  {
    path: '/projectlist',
    name: 'ProjectList',
    component: ProjectList
  },
  {
    path: '/addbug',
    name: 'AddBug',
    component: AddBug
  },
  {
    path: '/addproject',
    name: 'AddProject',
    component: AddProject
  },
  {
    path: '/project/:id',
    name: 'Project',
    component: ViewProject
  },
  {
    path: '/bug/:id',
    name: "Bug",
    component: ViewBug
  },
  {
    path: '/calendar',
    name: 'Calendar',
    component: Calendar 
  }
]

const router = new VueRouter({
  routes
})

export default router
