<template>
  <div class="window">
    <header class="toolbar toolbar-header">
      <input class="form-control" type="text" placeholder="Search for list" v-model="searchKey">
    </header>
            
    <div class="window-content">
      <div class="window">
        <h5 class="nav-group-title">列表</h5>
        <div class="window-content">
          <ul class="list-group">
            <li class="list-group-item" v-for="item in filterItems" v-bind:class="{ active: item.id == selectedId}" @click="item_click(item)" @contextmenu.prevent="$refs.ctx.open($event, {item: item})">
              <img class="img-circle media-object pull-left" src="static/img/avatar4.jpg" width="32" height="32" style="display:none">
              <div class="media-body">
                <strong>{{item.subject}}</strong>
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

    <context-menu id="context-menu" ref="ctx" @ctx-open="onCtxOpen">
      <li class="ctx-item" @click="newItem">新增</li>
      <li class="ctx-item" @click="editItem(editingItem)">修改</li>
      <li class="ctx-item" @click="deleteItem(editingItem)">删除</li>
    </context-menu>

    <main-dialog :show="show" @update:show="hidedialog" @cancel="show = false" ref="dialog">
      <form slot="main">
        <div class="form-group">
          <label>subject</label>
          <input class="form-control" placeholder="subject" v-model="editingItem.item.subject">
        </div>
      </form>
    </main-dialog>
    <confirm-dialog :show="showconfirm" @update:show="hidedialog" @cancel="showconfirm = false" :message="confirmmessage"></confirm-dialog>
  </div>
</template>

<script>
  import helper from '../../../service/helpers'
  import ContextMenu from 'vue-context-menu'
  import MainDialog from '../dialogs/MainDialog'
  import ConfirmDialog from '../dialogs/ConfirmDialog'

  export default {
    name: 'note-category-list',
    components: { ContextMenu, MainDialog, ConfirmDialog },
    data () {
      return {
        items: [],
        selectedId: '',
        searchKey: '',
        editingItem: {item: {id: '-1', subject: 'no name'}},
        show: false,
        showconfirm: false,
        confirmmessage: '确定删除?',
        type: ''
      }
    },
    mounted () {
      this.resetUI()
    },
    computed: {
      filterItems (items, searchKey) {
        var self = this
        if (self.items.length === 0) {
          return self.items
        }

        return self.items.filter(function (item) {
          return item.subject.toLowerCase().indexOf(self.searchKey.toLowerCase()) !== -1
        })
      }
    },
    methods: {
      item_click (item) {
        this.selectedId = item.id
        this.notifyIndexChanged(this.selectedId)
      },
      resetUI () {
        helper.notecategory.all((err, data) => {
          if (err) { console.log(err) }
          this.items = data
          if (this.items.length === 0) {
          } else {
            this.notifyIndexChanged(this.items[0].id)
          }
        })
      },
      notifyIndexChanged (id) {
        this.$parent.$emit('CATEGORYLISTITEMCHANGED', id)
      },
      newItem () {
        this.editingItem = {item: {id: '', subject: 'no-name'}}
        this.show = true
        this.type = 'new'
      },
      editItem (data) {
        this.show = true
        this.type = 'update'
      },
      deleteItem (data) {
        this.showconfirm = true
        this.type = 'delete'
      },
      onCtxOpen (locals) {
        this.editingItem = locals
      },
      hidedialog () {
        switch (this.type) {
          case 'new':
            this.show = false
            var self = this
            helper.notecategory.add(this.editingItem.item, function (err, response) {
              if (err) console.log(err)
              self.items.push(response)
            })
            break
          case 'update':
            this.show = false
            helper.notecategory.update(this.editingItem.item, function (err, response) {
              if (err) console.log(err)
            })
            break
          case 'delete':
            this.showconfirm = false
            var data = this.items
            var current = this.editingItem.item
            helper.notecategory.remove(this.editingItem.item, function (err, response) {
              if (err) console.log(err)
              data.forEach(function (item, i) {
                if (item === current) {
                  data.splice(i, 1)
                }
              })
            })
            break
        }
      }
    }
  }
</script>
