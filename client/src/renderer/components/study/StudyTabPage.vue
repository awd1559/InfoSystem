<template>
	<div class="pane-group">
		<div class="pane pane-sm sidebar">
      <study-category-list :items="categorys"></study-category-list>
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
  import StudyCategoryList from './StudyCategoryList'
  import StudyList from './StudyList'

  export default {
    name: 'study-tab-page',
    components: { StudyCategoryList, StudyList },
    data () {
      return {
        categorys: [],
        studys: [
          'good', 'linux', 'wang'
        ]
      }
    },
    created () {
      this.refreshui()
    },
    methods: {
      refreshui () {
        // this.categorys =
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
