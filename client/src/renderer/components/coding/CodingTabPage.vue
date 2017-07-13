<template>
	<div class="pane-group">
		<div class="pane pane-sm sidebar">
      <coding-category-list ref='catelist'></coding-category-list>
    </div>

    <div class="pane">
      <coding-list ref='codinglist'></coding-list>
    </div>
    </div>
</template>

<script>
  import CodingCategoryList from './CodingCategoryList'
  import CodingList from './CodingList'

  export default {
    name: 'coding-tab-page',
    components: { CodingCategoryList, CodingList }
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
