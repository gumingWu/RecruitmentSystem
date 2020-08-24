import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      redirect:'intro/introhome',
    },
    {
      path:'/intro',
      component:()=>import("../views/introduce"),
      children:[
        {
          path:'introhome', 
          name:'introhome',
          component:()=>import("../views/introduce/introhome")
        },
        { 
          path:'company',
          name:'company',
          component:()=>import("../views/introduce/company")
        },
        {
          path:'school',
          name:'school',
          component:()=>import("../views/introduce/school")
        }
      ],
    }
  ]
})
