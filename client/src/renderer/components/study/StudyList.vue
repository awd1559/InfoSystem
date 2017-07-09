<template>
  <div class="window">
    <header class="search">
      <div class="pane">
        <div class="btn-group pull-left">
          <button class="btn btn-large btn-default">
            <span class="icon icon-plus"></span>
          </button>
          <button class="btn btn-large btn-default">
            <span class="icon icon-minus"></span>
          </button>
        </div>
        <div class="btn-group pull-right">
          <input class="form-control" type="text" placeholder="Search for list" v-model="searchKey">
        </div>
      </div>
    </header>
            
    <div class="window-content">
      <ul class="list-group">
        <li class="list-group-item" v-for="item in items" @click="item_click(item)">
          <img class="img-circle media-object pull-left" src="static/img/avatar3.jpg" width="32" height="32" style="display:none">
          <div class="media-body">
            <strong>{{item.title}}</strong>
            <p>{{item.description}}</p>
          </div>
        </li>
      </ul>
    </div>

  </div>
</template>

<script>
  import router from '../../router'
  import helper from '../../../service/helpers'

  export default {
    name: 'study-list',
    data () {
      return {
        items: [],
        searchKey: ''
      }
    },
    created () {
      this.$parent.$on('CATEGORYLISTITEMCHANGED', this.resetUI)
    },
    methods: {
      item_click (item) {
        router.push({name: 'study', params: { id: item._id }})
      },
      resetUI (listid) {
        helper.study.allByCateId(listid, (err, studys) => {
          if (err) { console.log(err) }
          this.items = studys
        })
      }
    }
  }
</script>
