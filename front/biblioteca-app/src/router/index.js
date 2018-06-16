import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Dash from '@/components/Dash'
import Curso from '@/components/Curso'
import Aluno from '@/components/Aluno'
import Item from '@/components/Item'

Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/dash',
      name: 'Dash',
      component: Dash
    },
    {
      path: '/curso',
      name: 'curso',
      component: Curso
    },
    {
      path: '/item',
      name: 'item',
      component: Item
    },
    {
      path: '/aluno',
      name: 'aluno',
      component: Aluno
    }
  ]
})
