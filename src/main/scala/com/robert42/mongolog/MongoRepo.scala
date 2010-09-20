package com.robert42.mongolog

import net.liftweb.mongodb._

object MongoRepo {
  var isConfigured = false

  def setup = {
    MongoDB.defineDb(DefaultMongoIdentifier,
            MongoAddress(MongoHost("localhost", 27017), "mongolog"))
    isConfigured = true
  }
}