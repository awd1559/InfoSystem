<template>
  <div>
    <group>
      <cell v-for="item in items" :key="item.id" :title="item.title" :is-link=true :link="{name: 'study', params: {id: item.id}}"></cell>
    </group>
  </div>
</template>

<script>
import { Group, Cell, CellFormPreview } from 'vux'
import studyAPI from '../../api/study'

export default {
  name: 'study-list',
  components: {
    Group,
    Cell,
    CellFormPreview
  },
  data () {
    return {
      items: [],
      parentId: ''
    }
  },
  created () {
    this.parentId = this.$route.params.id

    studyAPI.study.allByCateId(this.parentId, 1, (err, data) => {
      if (err) {
        console.log(err)
      }
      this.items = data.items
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
