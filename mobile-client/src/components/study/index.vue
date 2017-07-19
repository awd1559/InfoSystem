<template>
  <div>
    <group>
      <cell v-for="item in items" :key="item.id" :title="item.subject" is-link link="/coding"></cell>
    </group>
  </div>
</template>

<script>
import { Group, Cell, CellFormPreview } from 'vux'
import studyAPI from '../../api/study'

export default {
  components: {
    Group,
    Cell,
    CellFormPreview
  },
  data () {
    return {
      items: []
    }
  },
  created () {
    studyAPI.studycategory.all((err, data) => {
      if (err) {
        console.log(err)
      }
      this.items = data
    })
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
