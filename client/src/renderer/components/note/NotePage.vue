<template>
  <div class="pane">
    <div class="window">
    <header class="search">
      <div class="pane" id="top-title">
        <div class="btn-group pull-left">
          <button class="btn btn-large btn-default" v-bind:class="{active: editing}" @click="switchEditing">
            <span class="icon icon-plus"></span>
            edit
          </button>
          <button class="btn btn-large btn-default">
            <span class="icon icon-minus"></span>
            del
          </button>
          <button class="btn btn-large btn-default">
            <span class="icon icon-minus"></span>
            pdf
          </button>
        </div>
        <div class="btn-group pull-right">
          <div class="media-body">
            <strong>{{item.title}}</strong>
            <p>{{item.when_updated}}</p>
          </div>
        </div>
      </div>
    </header>

    <div class="window-content" id="mark-content">
      <mavon-editor v-model="item.description" style="height: 100%;width:100%"
        :editable="editor.editable"
        :default_open="editor.defaultopen"
        :toolbarsFlag="editor.toolbarsFlag"
        :toolbars="editor.toolbars"
        :subfield="editor.twocolumn"
        :ishljs="editor.codehilight"
        @change="change"
        @save="save" />
    </div>
    </div>
  </div>
</template>

<script>
  import api from '../../../service/api/note'

  export default {
    name: 'note-page',
    data () {
      return {
        editor: {
          editable: false,
          defaultopen: 'preview',
          codehilight: true,
          twocolumn: false,
          toolbarsFlag: false,
          toolbars: {
            bold: true, // 粗体
            italic: true, // 斜体
            header: true, // 标题
            underline: true, // 下划线
            strikethrough: true, // 中划线
            mark: true, // 标记
            superscript: true, // 上角标
            subscript: true, // 下角标
            quote: true, // 引用
            ol: true, // 有序列表
            ul: true, // 无序列表
            link: true, // 链接
            imagelink: true, // 图片链接
            code: true, // code
            table: true, // 表格
            subfield: true, // 是否需要分栏
            fullscreen: true, // 全屏编辑
            readmodel: true, // 沉浸式阅读
            htmlcode: true, // 展示html源码
            help: true, // 帮助
            /* 1.3.5 */
            undo: true, // 上一步
            redo: true, // 下一步
            trash: true, // 清空
            save: true, // 保存（触发events中的save事件）
            /* 1.4.2 */
            navigation: true // 导航目录
          }
        },
        editing: false,
        dirty: false,
        item: {id: '', category: {id: '', subject: ''}, title: '', description: ''}
      }
    },
    mounted () {
      this.resetUI()
    },
    methods: {
      resetUI () {
        api.note.oneById(this.$route.params.id, (err, note) => {
          if (err) { console.log(err) }
          this.item = note
        })
      },
      switchEditing () {
        this.save()
        this.editing = !this.editing
        this.editor.toolbarsFlag = this.editing
        this.editor.editable = this.editing
        this.editor.twocolumn = this.editing
      },
      change () {
        this.dirty = true
      },
      save () {
        if (this.dirty) {
          api.note.update(this.item, (err, data) => {
            if (err) { console.log(err) }
            console.log(data)
            this.dirty = false
          })
        }
      }
    }
  }
</script>

<style>
  #top-title {
    margin: 5px;
  }
  #mark-content {
    margin: 10px;
    padding:  10px;
  }
</style>
