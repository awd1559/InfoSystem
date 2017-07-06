<template>
  <div class="pane">
    <button class="btn btn-default" @click="insertdb">insert</button>
    <button class="btn btn-primary" @click="finddb">find</button>

    <ul class="list-group">
      <li class="list-group-header">
        <input class="form-control" type="text" placeholder="Search for someone">
      </li>
      <li class="list-group-item" v-for="item in items">
        <img class="img-circle media-object pull-left" src="/static/img/avatar.jpg" width="32" height="32">
        <div class="media-body">
          <strong>{{ item.hello }}</strong>
          <p>{{ item.fruits }}</p><span>{{ item._id }}</span>
        </div>
      </li>
</ul>
  </div>
</template>

<script>
  // import router from '../../router'
  import nedb from '../../../service/nedb'

  export default {
    name: 'study-page',
    data () {
      return {
        items: []
      }
    },
    created () {
      console.log('created')
      this.finddb()
    },
    methods: {
      insertdb () {
        nedb.insert((err, newDoc) => {
          if (err) { console.log(err) }
          this.finddb()
        })
      },
      finddb () {
        nedb.find((err, doc) => {
          if (err) {
            console.log(err)
          } else {
            console.log('find no error')
          }
          this.items = doc
        })
      }
    }
  }
</script>
