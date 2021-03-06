import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: require('@/components/Home')
    },
    {
      path: '/study/:id',
      name: 'study',
      component: require('@/components/study/StudyPage')
    },

    {
      path: '/note/:id',
      name: 'note',
      component: require('@/components/note/NotePage')
    },
    {
      path: '*',
      redirect: '/'
    }
  ]
})
