<template>
  <footer class="toolbar toolbar-footer" id="scroller">
    <div class="btn-group">
      <button v-if="pageIndex != 1" class="btn btn-default" @click="prev">
        <span class="icon icon-left"></span>
        Prev
      </button>

      <button v-for="n in currentWindow" class="btn btn-default" v-bind:class="{active: n == pageIndex}" @click="clickitem(n)">{{n}}</button>

      <button v-if="pageIndex != pageTotal" class="btn btn-default" @click="next">
        <span class="icon icon-right"></span>
        Next
      </button>
      <span>共{{pageTotal}}页</span>
    </div>
  </footer>
</template>

<script>
  export default {
    name: 'pagination',
    data () {
      return {
        pageWindow: [],
        currentWindow: [],
        maxWindowSize: 5,
        pageIndex: 1,
        pageTotal: 0
      }
    },
    methods: {
      setup (total) {
        this.pageTotal = total
        this.pageWindow = []
        for (var n = 1; n <= total; n++) {
          this.pageWindow.push(n)
        }

        this.setupWindow()
      },
      setupWindow () {
        var contained = false
        var i = this.currentWindow.length
        while (i--) {
          if (this.currentWindow[i] === this.pageIndex) {
            contained = true
            break
          }
        }

        if (!contained) {
          var start = this.pageIndex
          var end = this.pageTotal
          if ((end - start) < this.maxWindowSize && this.pageIndex !== 1) {
            if ((end - 1) > this.maxWindowSize) {
              start = end - this.maxWindowSize + 1
            } else {
              start = 1
            }
          }
          if ((end - start) >= this.maxWindowSize) {
            end = start + this.maxWindowSize - 1
          }

          this.currentWindow = []
          for (var n = start; n <= end; n++) {
            this.currentWindow.push(n)
          }
        }
      },
      clickitem (n) {
        this.pageIndex = n
        this.$emit('clickitem', n)
      },
      prev () {
        if (this.pageIndex === 1) return
        this.pageIndex = this.pageIndex - 1
        this.setupWindow()
      },
      next () {
        if (this.pageIndex === this.pageTotal) return
        this.pageIndex = this.pageIndex + 1
        this.setupWindow()
      }
    }
  }
</script>

<style>
  #scroller {
    margin: 0px auto;
    overflow: auto;
    max-height: 32px;
  }
</style>
