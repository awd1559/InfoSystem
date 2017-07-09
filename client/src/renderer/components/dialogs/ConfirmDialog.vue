<template>
  <vodal :show="show" animation="slideDown" @hide="cancel" width="200" height="120">
    <div class="window">
      <header class="toolbar toolbar-header">
      </header>
      <div class="window-content">
          <div class="pane center">
          	<label>{{ message }}</label>
          </div>
      </div>
      <footer class="toolbar toolbar-footer">
        <div class="toolbar-actions">
          <button class="btn btn-default" @click="cancel">
            Cancel
          </button>
          <button class="btn btn-primary pull-right" @click="hide">
            Save
          </button>
        </div>
      </footer>
    </div>
  </vodal>
</template>

<script>
  import Vodal from 'vodal'
  export default {
    name: 'dialog',
    components: { Vodal },
    props: ['message', 'show'],
    data () {
      return {
        password: ''
      }
    },
    methods: {
      hide () {
        this.$emit('update:show', false)
      },
      cancel () {
        this.$emit('cancel')
      }
    }
  }
</script>

<style>
  .center {
    text-align: center;
    margin: 0 auto;
    width: 100%;
  }
</style>
