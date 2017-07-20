import http from './http'

class codingcategory {
  static all (callback) {
    http.get('/codingcategory/list', callback)
  }

  static add (item, callback) {
    http.post('/codingcategory/add', item, callback)
  }

  static update (item, callback) {
    http.post('/codingcategory/update', item, callback)
  }

  static remove (item, callback) {
    http.getparams('/codingcategory/delete', {params: {id: item.id}}, callback)
  }
}

class coding {
  static allByCateId (categoryId, pageIndex, callback) {
    http.getparams('/coding/list', {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }

  static oneById (id, callback) {
    http.getparams('/coding/one', {params: {id: id}})
  }

  static update (item, callback) {
    http.post('/coding/update', item, callback)
  }
}

export default {
  codingcategory,
  coding
}
