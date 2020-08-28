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
    },
    {
      path:'/admin',
      rdirect:'admin/login',
      component:()=>import("@/views/admin"),
      children:[
        { 
          path:'login',
          name:'login',
          component:()=>import("@/views/admin/login")
        },
        { 
          path:'register',
          name:'register',
          component:()=>import("@/views/admin/register")
        }
      ]
    },
  ]
})
