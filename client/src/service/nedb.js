var Datastore = require('nedb')
var path = require('path')
var db = new Datastore({ filename: path.join('.', 'nedb.db') })

db.loadDatabase()

function insert (handler) {
  var doc = {
    hello: 'world',
    n: 5,
    today: new Date(),
    nedbIsAwesome: true,
    notthere: null,
    notToBeSaved: undefined,  // Will not be saved
    fruits: [ 'apple', 'orange', 'pear' ],
    infos: { name: 'nedb' }
  }

  db.insert(doc, function (err, newDoc) {
    handler(err, newDoc)
  })
}

function find (handler) {
  db.find({ hello: 'world' }, function (err, newDoc) {
    handler(err, newDoc)
    // newDoc is an array containing documents Mars, Earth, Jupiter
    // If no document is found, docs is equal to []
  })
}

export default {
  insert,
  find
}
