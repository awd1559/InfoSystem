<template>
  <div class="window">
    <div v-for="item in items">
      <nav class="nav-group">
          <h5 class="nav-group-title">{{item.subject}}</h5>
          <span class="nav-group-item" v-for="child in item.children" v-bind:class="{ active: child.id == selectedId}" @click="item_click(child)" >
            <span class="icon icon-download"></span>
            {{child.subject}}
          </span>
      </nav>
    </div>

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
    name: 'coding-category-list',
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
    methods: {
      item_click (item) {
        this.selectedId = item.id
        this.notifyIndexChanged(this.selectedId)
      },
      resetUI () {
        helper.codingcategory.all((err, data) => {
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
            helper.codingcategory.add(this.editingItem.item, function (err, response) {
              if (err) console.log(err)
              self.items.push(response)
            })
            break
          case 'update':
            this.show = false
            helper.codingcategory.update(this.editingItem.item, function (err, response) {
              if (err) console.log(err)
            })
            break
          case 'delete':
            this.showconfirm = false
            var data = this.items
            var current = this.editingItem.item
            helper.codingcategory.remove(this.editingItem.item, function (err, response) {
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
