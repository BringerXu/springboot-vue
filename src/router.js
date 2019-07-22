import Vue from 'vue'
import Router from 'vue-router'
import Backstage from './components/Backstage.vue'
import Login from './components/Login.vue'
import error from './components/404.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      redirect:{name:"login"}
    },
    {
      path:'/login',
      name:'login',
      component:Login
    },
    {
      path: '/backstage',
      name: 'backstage',
      component: Backstage
    },
    {
      path:'*',
      name:'404',
      component: error
    }
    
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (about.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    // }
  ]
})
