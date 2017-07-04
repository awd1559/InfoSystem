<template>
  <vodal :show="show" animation="slideDown" @hide="hide">
    <div class="window">
      <header class="toolbar toolbar-header">
      </header>
      <div class="window-content">
        <div class="pane-group">
          <div class="pane-sm sidebar">...</div>
          <div class="pane">
          	<label>{{ message }}</label>
            <input type="password" class="form-control" placeholder="Password" v-model="password">
          </div>
        </div>
      </div>
      <footer class="toolbar toolbar-footer">
        <div class="toolbar-actions">
          <button class="btn btn-default" @click="hide">
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
        this.$emit('hide', this.password)
      }
    }
  }
</script>
