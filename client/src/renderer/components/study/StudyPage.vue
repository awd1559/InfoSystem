<template>
  <div class="pane">
    <button class="btn btn-default" @click="back">back</button>
    <button class="btn btn-primary">this is {{$route.params.id }}</button>
  </div>
</template>

<script>
  import router from '../../router'

  export default {
    name: 'study-page',
    methods: {
      back () {
        router.go(-1)
      }
    }
  }
</script>
