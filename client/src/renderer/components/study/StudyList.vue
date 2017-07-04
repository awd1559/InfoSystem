<template>
  <ul class="list-group">
    <li class="list-group-item" v-for="item in items" @click="item_click(item)">
      <img class="img-circle media-object pull-left" src="static/img/avatar3.jpg" width="32" height="32">
      <div class="media-body">
        <strong>List item title</strong>
        <p>Lorem ipsum dolor sit amet.</p>
      </div>
    </li>
  </ul>
</template>

<script>
  import router from '../../router'

  export default {
    name: 'study-list',
    props: ['items'],
    methods: {
      item_click (item) {
        console.log(router)
        router.push({name: 'study', params: { id: item }})
      }
    }
  }
</script>
