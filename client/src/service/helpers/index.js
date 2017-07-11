import config from '../config'
const axios = require('axios')

axios.defaults.headers.post['Content-Type'] = 'application/json'

class studycategory {
  static all (callback) {
    axios.get(config.getBaseUrl() + '/studycategory/list')
    .then(function (response) {
      callback(null, response.data)
    })
    .catch(function (error) {
      callback(error, [])
    })
  }

  static add (item, callback) {
    axios.post(config.getBaseUrl() + '/studycategory/add', JSON.stringify(item))
    .then(function (response) {
      callback(null, response.data)
    })
    .catch(function (error) {
      callback(error, {})
    })
  }

  static update (item, callback) {
    axios.post(config.getBaseUrl() + '/studycategory/update', JSON.stringify(item))
    .then(function (response) {
      callback(null, response.data)
    })
    .catch(function (error) {
      callback(error, {})
    })
  }

  static remove (item, callback) {
    axios.get(config.getBaseUrl() + '/studycategory/delete', {params: {id: item.id}})
    .then(function (response) {
      callback(null, response.data)
    })
    .catch(function (error) {
      callback(error, {})
    })
  }
}

class study {
  static allByCateId (categoryId, callback) {
    axios.get(config.getBaseUrl() + '/study/list', {params: {categoryId: categoryId}})
    .then(function (response) {
      callback(null, response.data)
    })
    .catch(function (error) {
      callback(error, [])
    })
  }
}

export default {
  studycategory,
  study
}