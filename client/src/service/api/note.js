import http from './http'

class notecategory {
  static all (callback) {
    http.get('/notecategory/list', callback)
  }

  static add (item, callback) {
    http.post('/notecategory/add', item, callback)
  }

  static update (item, callback) {
    http.post('/notecategory/update', item, callback)
  }

  static remove (item, callback) {
    http.getparams('/notecategory/delete', {params: {id: item.id}}, callback)
  }
}

class note {
  static allByCateId (categoryId, pageIndex, callback) {
    http.getparams('/note/list', {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }

  static oneById (id, callback) {
    http.getparams('/note/one', {params: {id: id}}, callback)
  }

  static update (item, callback) {
    http.post('/note/update', item, callback)
  }
}

export default {
  notecategory,
  note
}
