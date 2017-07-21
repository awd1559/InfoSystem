import config from '../config'
import http from './http'

class studycategory {
  static all (callback) {
    http.get(config.studycategory.all, callback)
  }

  static add (item, callback) {
    http.post(config.studycategory.add, item, callback)
  }

  static update (item, callback) {
    http.post(config.studycategory.update, item, callback)
  }

  static remove (item, callback) {
    http.getparams(config.studycategory.delete, {params: {id: item.id}}, callback)
  }
}

class study {
  static allByCateId (categoryId, pageIndex, callback) {
    http.getparams(config.study.list, {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }

  static oneById (id, callback) {
    http.getparams(config.study.one, {params: {id: id}}, callback)
  }

  static update (item, callback) {
    http.post(config.study.update, item, callback)
  }
}

export default {
  studycategory,
  study
}
