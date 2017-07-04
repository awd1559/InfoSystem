<template>
	<div class="pane-group">
		<div class="pane pane-sm sidebar">
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
        </div>

        <div class="pane">
          <div class="window">
            <header class="search">
              <div class="pane">
                <div class="btn-group pull-left">
                    <button class="btn btn-large btn-default">
                      <span class="icon icon-plus"></span>
                    </button>
                    <button class="btn btn-large btn-default">
                      <span class="icon icon-minus"></span>
                    </button>
                </div>
                <div class="btn-group pull-right">
                  <input class="form-control" type="text" placeholder="Search for list">
                </div>
              </div>
            </header>
            
            <div class="window-content">
              <study-list :items="studys"></study-list>
            </div>
          </div>
        </div>
    </div>
</template>

<script>
  import StudyList from './StudyList'

  export default {
    name: 'study-tab-page',
    components: { StudyList },
    data () {
      return {
        selectedListItem: 0,
        studys: [
          'good', 'linux', 'wang'
        ]
      }
    },
    methods: {
      item_click (n) {
        this.selectedListItem = n
      },
      item_menu (n) {
        alert(n)
      }
    }
  }
</script>

<style>
  .center {
  	text-align: center;
  	width: 100%;
  }
  .search {
    min-height: 35px;
    box-shadow: inset 0 1px 0 #ffffff;
    background-color: #cccccc;
    padding-top: 5px;
    padding-bottom: 5px;
    padding-left: 10px;
    padding-right: 25px;
  }
  .search:before, .search:after {
    display: table;
    content: " ";
  }
  .search:after {
    clear: both;
  }
</style>
