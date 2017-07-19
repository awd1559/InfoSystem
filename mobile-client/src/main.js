// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import FastClick from 'fastclick'
import VueRouter from 'vue-router'
import { sync } from 'vuex-router-sync'

import App from './App'
import StudyTab from './components/study'
import StudyList from './components/study/list'
import NoteTab from './components/note'
import CodingTab from './components/coding'
import CompanyTab from './components/company'
import './mock/index.js'
import Vuex from 'vuex'

Vue.use(Vuex)

Vue.use(VueRouter)

import vuexI18n from 'vuex-i18n'

require('es6-promise').polyfill()

const routes = [
  {path: '/', component: StudyTab},
  {path: '/study', component: StudyTab},
  {path: '/studycategory/:id', name: 'studylist', component: StudyList},
  {path: '/note', component: NoteTab},
  {path: '/coding', component: CodingTab},
  {path: '/company', component: CompanyTab}
]

const router = new VueRouter({
  routes
})

let store = new Vuex.Store({
  modules: {
    i18n: vuexI18n.store
  }
})

store.registerModule('vux', {
  state: {
    demoScrollTop: 0,
    isLoading: false,
    direction: 'forward'
  },
  mutations: {
    updateDemoPosition (state, payload) {
      state.demoScrollTop = payload.top
    },
    updateLoadingStatus (state, payload) {
      state.isLoading = payload.isLoading
    },
    updateDirection (state, payload) {
      state.direction = payload.direction
    }
  },
  actions: {
    updateDemoPosition ({commit}, top) {
      commit({type: 'updateDemoPosition', top: top})
    }
  }
})

sync(store, router)

FastClick.attach(document.body)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app-box')
