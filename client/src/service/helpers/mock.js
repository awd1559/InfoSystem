// import Vue from 'vue'
// const bus = new Vue()

// const electron = require('electron')
// const shell = electron.shell
// const ipcRenderer = electron.ipcRenderer

class studycategory {
  static all (callback) {
    var err = null
    var data = [
      {id: '1', subject: 'javafx'},
      {id: '2', subject: 'tornadoFX'},
      {id: '3', subject: 'electron'}
    ]
    callback(err, data)
  }
}

class study {
  static allByCateId (categoryId, callback) {
    var err = null
    var data = []
    switch (categoryId) {
      case '1':
        data = [
          {id: '1', title: 'javafx_1', description: 'starter'},
          {id: '2', title: 'javafx_2', description: 'begin'},
          {id: '3', title: 'javafx_3', description: 'advanced'}
        ]
        break
      case '2':
        data = [
          {id: '1', title: 'tornadoFX_0', description: 'starter'},
          {id: '2', title: 'tornadoFX_1', description: 'begin'}
        ]
        break
      case '3':
        data = [
          {id: '1', title: 'electron_1', description: 'starter'},
          {id: '2', title: 'electron_3', description: 'begin'},
          {id: '3', title: 'electron_4', description: 'advanced'},
          {id: '4', title: 'electron_5', description: 'advanced'}
        ]
        break
    }
    callback(err, data)
  }
}

export default {
  studycategory,
  study
}
