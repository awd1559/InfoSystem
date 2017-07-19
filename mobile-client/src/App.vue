<template>
  <div style="height:100%;">
    <div v-transfer-dom>
      <loading v-model="isLoading"></loading>
    </div>
    <div v-transfer-dom>
      <actionsheet :menus="menus" v-model="showMenu"></actionsheet>
    </div>

    <drawer
    width="200px;"
    :show.sync="drawerVisibility"
    :show-mode="showModeValue"
    :placement="showPlacementValue"
    :drawer-style="{'background-color':'#35495e', width: '200px'}">

      <!-- drawer content -->
      <div slot="drawer">
        <group title="Drawer demo(beta)" style="margin-top:20px;">
          <cell title="Demo" link="/demo" value="演示" @click.native="drawerVisibility = false">
          </cell>
          <cell title="Buy me a coffee" link="project/donate" @click.native="drawerVisibility = false">
          </cell>
          <cell title="Github" link="http://github.com/airyland/vux" value="Star me" @click.native="drawerVisibility = false">
          </cell>
        </group>
        <group title="showMode">
          <radio v-model="showMode" :options="['push', 'overlay']" @on-change="onShowModeChange"></radio>
        </group>
        <group title="placement">
          <radio v-model="showPlacement" :options="['left', 'right']" @on-change="onPlacementChange"></radio>
        </group>
      </div>

      <!-- main content -->
      <view-box ref="viewBox" body-padding-top="46px" body-padding-bottom="55px">
        
        <x-header slot="header"
        style="width:100%;position:absolute;left:0;top:0;z-index:100;"
        :left-options="leftOptions"
        :right-options="rightOptions"
        :title="title"
        :transition="headerTransition"
        @on-click-more="onClickMore">
          <span v-if="route.path === '/' || route.path === '/study'" slot="overwrite-left" @click="drawerVisibility = !drawerVisibility">
            <x-icon type="navicon" size="35" style="fill:#fff;position:relative;top:-8px;left:-3px;"></x-icon>
          </span>
        </x-header>

        <transition :name="'vux-pop-' + (direction === 'forward' ? 'in' : 'out')">
          <router-view class="router-view"></router-view>
        </transition>

        <tabbar class="vux-demo-tabbar" icon-class="vux-center" slot="bottom">
          <tabbar-item :link="{path:'/study'}" :selected="route.path === '/study'">
            <span class="demo-icon-22 vux-demo-tabbar-icon-home" slot="icon" style="position:relative;top: -2px;">&#xe637;</span>
            <span slot="label">study</span>
          </tabbar-item>
          <tabbar-item :link="{path:'/note'}" :selected="route.path === '/note'" badge="9">
            <span class="demo-icon-22" slot="icon">&#xe633;</span>
            <span slot="label">Note</span>
          </tabbar-item>
          <tabbar-item :link="{path:'/coding'}" :selected="route.path === '/coding'" show-dot>
            <span class="demo-icon-22" slot="icon">&#xe630;</span>
            <span slot="label">开源</span>
          </tabbar-item>
          <tabbar-item :link="{path:'/company'}" :selected="route.path === '/company'" show-dot>
            <span class="demo-icon-22" slot="icon">&#xe630;</span>
            <span slot="label">company</span>
          </tabbar-item>
        </tabbar>

      </view-box>
    </drawer>
  </div>
</template>

<script>
import { Radio, XHeader, Tabbar, TabbarItem, Actionsheet, Loading, TransferDom, Drawer, Group, Cell, ViewBox } from 'vux'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'app',
  directives: {
    TransferDom
  },
  components: {
    Radio,
    XHeader,
    Tabbar,
    TabbarItem,
    Actionsheet,
    TransferDom,
    Drawer,
    Group,
    Cell,
    ViewBox,
    Loading
  },
  data () {
    return {
      menus: {
        menu1: 'Take Photo',
        menu2: 'Choose from photos'
      },
      showMenu: false,
      showLeft: false,
      drawerVisibility: false,
      showMode: 'push',
      showModeValue: 'push',
      showPlacement: 'left',
      showPlacementValue: 'left'
    }
  },
  computed: {
    ...mapState({
      route: state => state.route,
      path: state => state.route.path,
      deviceready: state => state.app.deviceready,
      demoTop: state => state.vux.demoScrollTop,
      isLoading: state => state.vux.isLoading,
      direction: state => state.vux.direction
    }),
    leftOptions () {
      return {
        showBack: this.route.path !== '/'
      }
    },
    rightOptions () {
      return {
        showMore: true
      }
    },
    headerTransition () {
      return this.direction === 'forward' ? 'vux-header-fade-in-right' : 'vux-header-fade-in-left'
    },
    title () {
      if (this.route.path === '/' || this.route.path === '/study') return 'Study'
      if (this.route.path === '/note') return 'Note'
      if (this.route.path === '/coding') return '开源'
      if (this.route.path === '/company') return 'company'
      return 'InfoSystem'
    }
  },
  methods: {
    onClickMore () {
      this.showMenu = true
    },
    triggerdrawer () {
      this.showLeft = !this.showLeft
    },
    onShowModeChange (val) {
      /** hide drawer before changing showMode **/
      this.drawerVisibility = false
      setTimeout(one => {
        this.showModeValue = val
      }, 400)
    },
    onPlacementChange (val) {
      /** hide drawer before changing position **/
      this.drawerVisibility = false
      setTimeout(one => {
        this.showPlacementValue = val
      }, 400)
    },
    ...mapActions([
      'updateDemoPosition'
    ])
  }
}
</script>

<style lang="less">
@import '~vux/src/styles/reset.less';
@import '~vux/src/styles/1px.less';
@import '~vux/src/styles/tap.less';

body {
  background-color: #fbf9fe;
}
html, body {
  height: 100%;
  width: 100%;
  overflow-x: hidden;
}

.demo-icon-22 {
  font-family: 'vux-demo';
  font-size: 22px;
  color: #888;
}
.weui-tabbar.vux-demo-tabbar {
  /** backdrop-filter: blur(10px);
  background-color: none;
  background: rgba(247, 247, 250, 0.5);**/
}
.vux-demo-tabbar .weui-bar__item_on .demo-icon-22 {
  color: #F70968;
}
.vux-demo-tabbar .weui-tabbar_item.weui-bar__item_on .vux-demo-tabbar-icon-home {
  color: rgb(53, 73, 94);
}
.demo-icon-22:before {
  content: attr(icon);
}
.vux-demo-tabbar-component {
  background-color: #F70968;
  color: #fff;
  border-radius: 7px;
  padding: 0 4px;
  line-height: 14px;
}
.weui-tabbar__icon + .weui-tabbar__label {
  margin-top: 0!important;
}
.vux-demo-header-box {
  z-index: 100;
  position: absolute;
  width: 100%;
  left: 0;
  top: 0;
}

@font-face {
  font-family: 'vux-demo';  /* project id 70323 */
  src: url('https://at.alicdn.com/t/font_h1fz4ogaj5cm1jor.eot');
  src: url('https://at.alicdn.com/t/font_h1fz4ogaj5cm1jor.eot?#iefix') format('embedded-opentype'),
  url('https://at.alicdn.com/t/font_h1fz4ogaj5cm1jor.woff') format('woff'),
  url('https://at.alicdn.com/t/font_h1fz4ogaj5cm1jor.ttf') format('truetype'),
  url('https://at.alicdn.com/t/font_h1fz4ogaj5cm1jor.svg#iconfont') format('svg');
}

.demo-icon {
  font-family: 'vux-demo';
  font-size: 20px;
  color: #04BE02;
}

.demo-icon-big {
  font-size: 28px;
}

.demo-icon:before {
  content: attr(icon);
}

.router-view {
  width: 100%;
  top: 46px;
}
.vux-pop-out-enter-active,
.vux-pop-out-leave-active,
.vux-pop-in-enter-active,
.vux-pop-in-leave-active {
  will-change: transform;
  transition: all 500ms;
  height: 100%;
  top: 46px;
  position: absolute;
  backface-visibility: hidden;
  perspective: 1000;
}
.vux-pop-out-enter {
  opacity: 0;
  transform: translate3d(-100%, 0, 0);
}
.vux-pop-out-leave-active {
  opacity: 0;
  transform: translate3d(100%, 0, 0);
}
.vux-pop-in-enter {
  opacity: 0;
  transform: translate3d(100%, 0, 0);
}
.vux-pop-in-leave-active {
  opacity: 0;
  transform: translate3d(-100%, 0, 0);
}
.menu-title {
  color: #888;
}
</style>
