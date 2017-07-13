<template>
	<div class="pane-group">
		<div class="pane pane-sm sidebar">
      <note-category-list ref='catelist'></note-category-list>
    </div>

    <div class="pane">
      <note-list ref='notelist'></note-list>
    </div>
    </div>
</template>

<script>
  import NoteCategoryList from './NoteCategoryList'
  import NoteList from './NoteList'

  export default {
    name: 'note-tab-page',
    components: { NoteCategoryList, NoteList }
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
