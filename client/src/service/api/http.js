import config from '../config'
const axios = require('axios')
axios.defaults.headers.post['Content-Type'] = 'application/json'

// const BASE_URL = 'http://localhost:8080'

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

export default {
  get,
  getparams,
  post
}
