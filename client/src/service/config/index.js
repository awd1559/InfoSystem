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

class studycategory {
  static all = getBaseUrl() + '/studycategory/all'
  static add = getBaseUrl() + '/studycategory/add'
  static update = getBaseUrl() + '/studycategory/update'
  static delete = getBaseUrl() + '/studycategory/delete'
}

class study {
  static list = getBaseUrl() + '/study/list'
  static one = getBaseUrl() + '/study/one'
  static update = getBaseUrl() + '/study/update'
}

class notecategory {
  static list = getBaseUrl() + '/notecategory/list'
  static add = getBaseUrl() + '/notecategory/add'
  static update = getBaseUrl() + '/notecategory/update'
  static delete = getBaseUrl() + '/notecategory/delete'
}

class note {
  static list = getBaseUrl() + '/note/list'
  static one = getBaseUrl() + '/note/one'
  static update = getBaseUrl() + '/note/update'
}

class codingcategory {
  static list = getBaseUrl() + '/codingcategory/list'
  static add = getBaseUrl() + '/codingcategory/add'
  static update = getBaseUrl() + '/codingcategory/update'
  static delete = getBaseUrl() + '/codingcategory/delete'
}

class coding {
  static list = getBaseUrl() + '/codingcategory/list'
  static add = getBaseUrl() + '/codingcategory/add'
  static update = getBaseUrl() + '/codingcategory/update'
  static delete = getBaseUrl() + '/codingcategory/delete'
}

export default {
  studycategory,
  study,
  notecategory,
  note,
  codingcategory,
  coding
}
