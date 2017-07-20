import config from '../config'
const axios = require('axios')

axios.defaults.headers.post['Content-Type'] = 'application/json'

function get (url, callback) {
  axios.get(config.getBaseUrl() + url)
  .then(function (response) {
    callback(null, response.data)
  })
  .catch(function (error) {
    callback(error, [])
  })
}

function getparams (url, params, callback) {
  axios.get(config.getBaseUrl() + url, params)
  .then(function (response) {
    callback(null, response.data)
  })
  .catch(function (error) {
    callback(error, [])
  })
}

function post (url, data, callback) {
  axios.post(config.getBaseUrl() + url, JSON.stringify(data))
  .then(function (response) {
    callback(null, response.data)
  })
  .catch(function (error) {
    callback(error, {})
  })
}

class studycategory {
  static all (callback) {
    get('/studycategory/list', callback)
  }

  static add (item, callback) {
    post('/studycategory/add', item, callback)
  }

  static update (item, callback) {
    post('/studycategory/update', item, callback)
  }

  static remove (item, callback) {
    getparams('/studycategory/delete', {params: {id: item.id}}, callback)
  }
}

class study {
  static allByCateId (categoryId, pageIndex, callback) {
    getparams('/study/list', {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }

  static oneById (id, callback) {
    getparams('/study/one', {params: {id: id}}, callback)
  }

  static update (item, callback) {
    post('/study/update', item, callback)
  }
}

class notecategory {
  static all (callback) {
    get('/notecategory/list', callback)
  }

  static add (item, callback) {
    post('/notecategory/add', item, callback)
  }

  static update (item, callback) {
    post('/notecategory/update', item, callback)
  }

  static remove (item, callback) {
    getparams('/notecategory/delete', {params: {id: item.id}}, callback)
  }
}

class note {
  static allByCateId (categoryId, pageIndex, callback) {
    getparams('/note/list', {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }

  static oneById (id, callback) {
    getparams('/note/one', {params: {id: id}}, callback)
  }

  static update (item, callback) {
    post('/note/update', item, callback)
  }
}

class codingcategory {
  static all (callback) {
    get('/codingcategory/list', callback)
  }

  static add (item, callback) {
    post('/codingcategory/add', item, callback)
  }

  static update (item, callback) {
    post('/codingcategory/update', item, callback)
  }

  static remove (item, callback) {
    getparams('/codingcategory/delete', {params: {id: item.id}}, callback)
  }
}

class coding {
  static allByCateId (categoryId, pageIndex, callback) {
    getparams('/coding/list', {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }

  static oneById (id, callback) {
    getparams('/coding/one', {params: {id: id}})
  }

  static update (item, callback) {
    post('/coding/update', item, callback)
  }
}

export default {
  studycategory,
  study,
  notecategory,
  note,
  codingcategory,
  coding
}
