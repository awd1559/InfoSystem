<template>
  <div class="window">
    <header class="toolbar toolbar-header">
      <input class="form-control" type="text" placeholder="Search for list">
    </header>
            
    <div class="window-content">
      <div class="window">
        <h5 class="nav-group-title">列表</h5>
        <div class="window-content">
          <ul class="list-group">
            <li class="list-group-item" v-for="n in 20" v-bind:class="{ active: n==selectedListItem }" @click="item_click(n)">
              <img class="img-circle media-object pull-left" src="static/img/avatar4.jpg" width="32" height="32">
              <div class="media-body">
                <strong>List item title</strong>
                <p>Lorem ipsum dolor sit amet.</p>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div><h6></h6></div>

    <footer class="toolbar toolbar-footer">
      <div class="tab-group">
        <div class="tab-item">
          <span class="icon icon-plus"></span>
            Add
        </div>
        <div class="tab-item">
          <span class="icon icon-minus"></span>
            Del
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
  export default {
    name: 'study-category-list',
    props: ['items'],
    data () {
      return {
        selectedListItem: 0
      }
    },
    methods: {
      item_click (n) {
        this.selectedListItem = n
      }
    }
  }
</script>
