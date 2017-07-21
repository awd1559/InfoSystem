const axios = require('axios')
axios.defaults.headers.post['Content-Type'] = 'application/json'

function get (url, callback) {
  axios.get(url)
  .then(function (response) {
    callback(null, response.data)
  })
  .catch(function (error) {
    callback(error, [])
  })
}

function getparams (url, params, callback) {
  axios.get(url, params)
  .then(function (response) {
    callback(null, response.data)
  })
  .catch(function (error) {
    callback(error, [])
  })
}

function post (url, data, callback) {
  axios.post(url, JSON.stringify(data))
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
