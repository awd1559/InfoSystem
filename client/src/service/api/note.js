import config from '../config'
import http from './http'

class notecategory {
  static all (callback) {
    http.get(config.notecategory.list, callback)
  }

  static add (item, callback) {
    http.post(config.notecategory.add, item, callback)
  }

  static update (item, callback) {
    http.post(config.notecategory.update, item, callback)
  }

  static remove (item, callback) {
    http.getparams(config.notecategory.delete, {params: {id: item.id}}, callback)
  }
}

class note {
  static allByCateId (categoryId, pageIndex, callback) {
    http.getparams(config.note.list, {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }

  static oneById (id, callback) {
    http.getparams(config.note.one, {params: {id: id}}, callback)
  }

  static update (item, callback) {
    http.post(config.note.update, item, callback)
  }
}

export default {
  notecategory,
  note
}
