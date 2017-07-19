import http from './http'

class studycategory {
  static all (callback) {
    http.get('/studycategory/all', callback)
  }

  static add (item, callback) {
    http.post('/studycategory/add', item, callback)
  }

  static update (item, callback) {
    http.post('/studycategory/update', item, callback)
  }

  static remove (item, callback) {
    http.getparams('/studycategory/delete', {params: {id: item.id}}, callback)
  }
}

class study {
  static allByCateId (categoryId, pageIndex, callback) {
    http.getparams('/study/list', {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }
}

export default {
  studycategory,
  study
}
