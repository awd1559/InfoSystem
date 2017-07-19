import config from '../config'
const axios = require('axios')

axios.defaults.headers.post['Content-Type'] = 'application/json'

function getdata(url, callback) {
  axios.get(conig.getBaseUrl() + url)
  .then(function (response) {
    callback(null, response.data)
  })
  .catch(function (error) {
    callback(error, [])
  })
}

function getdata(url, params, callback) {
  axios.get(conig.getBaseUrl() + url, params)
  .then(function (response) {
    callback(null, response.data)
  })
  .catch(function (error) {
    callback(error, [])
  })
}

function postdata(url, data, callback) {
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
    getdata('/studycategory/list', callback)
  }

  static add (item, callback) {
    postdata('/studycategory/add', item, callback)
  }

  static update (item, callback) {
    postdata('/studycategory/update', item, callback)
  }

  static remove (item, callback) {
    getdata('/studycategory/delete', {params: {id: item.id}}, callback)
  }
}

class study {
  static allByCateId (categoryId, pageIndex, callback) {
    getdata('/study/list', {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }

  static oneById (id, callback) {
    getdata('/study/one', {params: {id: id}}, callback)
  }

  static update (item, callback) {
    postdata('/study/update', item, callback)
  }
}

class notecategory {
  static all (callback) {
    getdata('/notecategory/list', callback)
  }

  static add (item, callback) {
    postdata('/notecategory/add', item, callback)
  }

  static update (item, callback) {
    postdata('/notecategory/update', item, callback)
  }

  static remove (item, callback) {
    getdata('/notecategory/delete', {params: {id: item.id}}, callback)
  }
}

class note {
  static allByCateId (categoryId, pageIndex, callback) {
    getdata('/note/list', {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }

  static oneById (id, callback) {
    getdata('/note/one', {params: {id: id}}, callback)
  }

  static update (item, callback) {
    postdata('/note/update', item, callback)
  }
}

class codingcategory {
  static all (callback) {
    getdata('/codingcategory/list', callback)
  }

  static add (item, callback) {
    postdata('/codingcategory/add', item, callback)
  }

  static update (item, callback) {
    postdata('/codingcategory/update', item, callback)
  }

  static remove (item, callback) {
    getdata('/codingcategory/delete', {params: {id: item.id}}, callback)
  }
}

class coding {
  static allByCateId (categoryId, pageIndex, callback) {
    getdata('/coding/list', {params: {categoryId: categoryId, page: pageIndex}}, callback)
  }

  static oneById (id, callback) {
    getdata('/coding/one', {params: {id: id}})
  }

  static update (item, callback) {
    axios.post(config.getBaseUrl() + '/coding/update', item, callback)
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
