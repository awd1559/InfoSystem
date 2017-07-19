
class studycategory {
  static all () {
    var data = [
      {id: '1', subject: 'javafx'},
      {id: '2', subject: 'tornadoFX'},
      {id: '3', subject: 'electron'}
    ]
    return data
  }
}

class study {
  static allByCateId (url) {
    var data = []
    // /study/list?categoryId=1&page=1
    var params = url.url.split('?')[1]
    var categoryId = params.split('&')[0].split('=')[1]
    var pageIndex = params.split('&')[1].split('=')[1]

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
    return response
  }
}

export default {
  studycategory,
  study
}
