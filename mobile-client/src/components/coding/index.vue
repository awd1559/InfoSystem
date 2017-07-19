<template>
  <div>
    <group>
      <cell is-link title="coding" link="/component/tabbar-simple"></cell>
      <cell is-link title="coding" link="/component/tabbar-icon"></cell>
    </group>
  </div>
</template>

<script>
import { Group, Cell } from 'vux'

export default {
  components: {
    Group,
    Cell
  },
  data () {
    return {
      msg: 'Hello World!'
    }
  }
}
</script>

<style>
.vux-demo {
  text-align: center;
}
.logo {
  width: 100px;
  height: 100px
}
</style>
