var Datastore = require('nedb')
var path = require('path')
var db = new Datastore({ filename: path.join('.', 'config.db') })

db.loadDatabase()

function getBaseUrl () {
  var defaultUrl = {id: 'base_url', value: 'http://localhost:8080'}
  var url = defaultUrl.value

  db.findOne({id: 'base_url'}, function (error, doc) {
    if (doc === null) {
      console.log('read base url error: %s', error)
      db.insert(defaultUrl)
    } else {
      url = doc.value
    }
  })
  return url
}

export default {
  getBaseUrl
}
