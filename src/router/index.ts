import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Home from '../views/Home.vue'
import Student from '../views/Student.vue'
import Grade from '../views/Grade.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [

    {
      path: '/',
      name: 'login',
      component: Login,
    },
    {
      path: '/home',
      name: 'home',
      component: Home,
      redirect: '/student', // 默认跳转到 /student
      children:[
        {
          path: '/student',
          name: 'student',
          component: Student,
        },
        {
          path: '/grade',
          name: 'grade',
          component: Grade,
        },
      ]
    },
  ],
})

export default router
