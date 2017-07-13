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
  static allByCateId (categoryId, pageIndex, callback) {
    var err = null
    var data = []
    switch (categoryId) {
      case '1':
        for (var n = 0; n < 200; n++) {
          var id = n.toString()
          var title = 'javafx_' + n.toString()
          var item = {id: id, title: title, description: 'advanced'}
          data.push(item)
        }
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
    var left = data.length % 10
    var total = 0
    if (left !== 0) {
      total = (data.length - left) / 10 + 1
    } else {
      total = data.length / 10
    }
    var start = (pageIndex - 1) * 10
    var end = pageIndex * 10 - 1
    var response = {items: data.slice(start, end), pageTotal: total}
    callback(err, response)
  }
}

class codingcategory {
  static all (callback) {
    var data = [
      {
        'id': '402847fc5d39e2a4015d39e2ac7c0000',
        'subject': 'web应用',
        'children': [
          {
            'id': '402847fc5d39e2a4015d39e2acf6000b',
            'subject': '微信',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2acff000c',
            'subject': 'rest',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2acee0009',
            'subject': 'spdy',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2acf2000a',
            'subject': 'api',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad03000d',
            'subject': 'htm5',
            'children': [],
            'when_created': null,
            'when_updated': null
          }
        ],
        'when_created': null,
        'when_updated': null
      },
      {
        'id': '402847fc5d39e2a4015d39e2accd0001',
        'subject': '手机开发',
        'children': [
          {
            'id': '402847fc5d39e2a4015d39e2ad07000e',
            'subject': 'android',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad160011',
            'subject': 'mobile game',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad0d000f',
            'subject': 'Native',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad120010',
            'subject': 'WP',
            'children': [],
            'when_created': null,
            'when_updated': null
          }
        ],
        'when_created': null,
        'when_updated': null
      },
      {
        'id': '402847fc5d39e2a4015d39e2acd20002',
        'subject': 'ios',
        'children': [
          {
            'id': '402847fc5d39e2a4015d39e2ad270014',
            'subject': '标签',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad2b0015',
            'subject': '地图',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad190012',
            'subject': 'active',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad1d0013',
            'subject': '图像',
            'children': [],
            'when_created': null,
            'when_updated': null
          }
        ],
        'when_created': null,
        'when_updated': null
      },
      {
        'id': '402847fc5d39e2a4015d39e2acd80003',
        'subject': '程序开发',
        'children': [
          {
            'id': '402847fc5d39e2a4015d39e2ad380019',
            'subject': '图标',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad340018',
            'subject': '报表',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad2e0016',
            'subject': 'UI组件',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad310017',
            'subject': 'GUI框架',
            'children': [],
            'when_created': null,
            'when_updated': null
          }
        ],
        'when_created': null,
        'when_updated': null
      },
      {
        'id': '402847fc5d39e2a4015d39e2acdb0004',
        'subject': '开发工具',
        'children': [
          {
            'id': '402847fc5d39e2a4015d39e2ad3f001b',
            'subject': 'PHP',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad51001e',
            'subject': 'python',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad3c001a',
            'subject': 'Git',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad43001c',
            'subject': '项目构建',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad4e001d',
            'subject': 'ruby',
            'children': [],
            'when_created': null,
            'when_updated': null
          }
        ],
        'when_created': null,
        'when_updated': null
      },
      {
        'id': '402847fc5d39e2a4015d39e2acde0005',
        'subject': 'jquery',
        'children': [
          {
            'id': '402847fc5d39e2a4015d39e2ad5c0021',
            'subject': 'tabs',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad54001f',
            'subject': 'picker',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad590020',
            'subject': 'dialog',
            'children': [],
            'when_created': null,
            'when_updated': null
          }
        ],
        'when_created': null,
        'when_updated': null
      },
      {
        'id': '402847fc5d39e2a4015d39e2ace20006',
        'subject': '建站工具',
        'children': [
          {
            'id': '402847fc5d39e2a4015d39e2ad6a0024',
            'subject': 'bbs',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad630023',
            'subject': '邮件列表',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad5f0022',
            'subject': '搜索引擎',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad6e0025',
            'subject': 'wiki',
            'children': [],
            'when_created': null,
            'when_updated': null
          }
        ],
        'when_created': null,
        'when_updated': null
      },
      {
        'id': '402847fc5d39e2a4015d39e2ace50007',
        'subject': '企业应用',
        'children': [
          {
            'id': '402847fc5d39e2a4015d39e2ad7a0028',
            'subject': 'ERP',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad770027',
            'subject': 'BI',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad7f002a',
            'subject': 'Doc',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad7c0029',
            'subject': 'POS',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad740026',
            'subject': 'OA',
            'children': [],
            'when_created': null,
            'when_updated': null
          }
        ],
        'when_created': null,
        'when_updated': null
      },
      {
        'id': '402847fc5d39e2a4015d39e2acea0008',
        'subject': '数据库',
        'children': [
          {
            'id': '402847fc5d39e2a4015d39e2ad87002c',
            'subject': 'Paas',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad93002f',
            'subject': 'CGI',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad89002d',
            'subject': 'Docker',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad84002b',
            'subject': 'FastCGI',
            'children': [],
            'when_created': null,
            'when_updated': null
          },
          {
            'id': '402847fc5d39e2a4015d39e2ad90002e',
            'subject': 'apache',
            'children': [],
            'when_created': null,
            'when_updated': null
          }
        ],
        'when_created': null,
        'when_updated': null
      }
    ]
    callback(null, data)
  }
}

export default {
  studycategory,
  study,
  codingcategory
}
