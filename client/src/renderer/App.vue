<template>
  <div id="app">
    <div class="window">
      <header class="toolbar toolbar-header">
        <div class="toolbar-actions">
          <div class="btn-group">
            <button class="btn btn-default active" @click="open('/elementui')">
              <span class="icon icon-home"></span>
            </button>
            <button class="btn btn-default" >
              <span class="icon icon-folder"></span>
            </button>
            <button class="btn btn-default">
              <span class="icon icon-cloud"></span>
            </button>
            <button class="btn btn-default" @click="showdialog">
              <span class="icon icon-popup"></span>
            </button>
            <button class="btn btn-default">
              <span class="icon icon-shuffle"></span>
            </button>
          </div>

          <button class="btn btn-default">
            <span class="icon icon-home icon-text"></span>
            Filters
          </button>

          <button class="btn btn-default btn-dropdown pull-right">
            <span class="icon icon-megaphone"></span>
          </button>
        </div>
      </header>

      <div class="tab-group">
        <div class="tab-item" v-for="tab in tabs" v-bind:class="{ active: tab.active}" @click="toActive(tab)">
          <span v-bind:class="['icon', tab.icon]"></span>
          {{tab.text}}
        </div>
      </div>

      <router-view :tabs="tabs"></router-view>

      <footer class="toolbar toolbar-footer">
        <span class="">@Personal Info System</span>
      </footer>
      <my-dialog :message="message" :show="show" @hide="hidedialog"></my-dialog>
    </div>
  </div>
</template>

<script>
  // import Vue from 'vue'
  // import 'vue-beauty/package/style/vue-beauty.min.css'
  // import vueBeauty from 'vue-beauty'
  // Vue.use(vueBeauty)
  import MyDialog from './components/Dialog'

  export default {
    name: 'client-vue',
    components: { MyDialog },
    data () {
      return {
        tabs: [
          { icon: 'icon-mail', text: '新知识', name: 'study', active: true },
          { icon: 'icon-note', text: '笔记', name: 'note', active: false },
          { icon: 'icon-music', text: '开源', name: 'coding', active: false },
          { icon: 'icon-sweden', text: '公司', name: 'company', active: false }
        ],
        message: '',
        show: false
      }
    },
    methods: {
      toActive (tab) {
        this.tabs.forEach(function (item) { item.active = false })
        tab.active = true
      },
      showdialog () {
        this.message = 'tst'
        this.show = true
      },
      hidedialog (password) {
        this.show = false
        alert(password)
      }
    }
  }

</script>

<style>
  @import "../../static/app.scss";
</style>
