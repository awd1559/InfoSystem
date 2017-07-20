<template>
  <div>
    <a href="#">{{study.content}}</a>
  </div>
</template>

<script>
import studyAPI from '../../api/study'

export default {
  name: 'study',
  data () {
    return {
      study: {},
      id: ''
    }
  },
  created () {
    this.id = this.$route.params.id

    studyAPI.study.getById(this.id, (err, data) => {
      if (err) {
        console.log(err)
      }
      console.log(data)
      this.study = data
    })
  }
}
</script>
