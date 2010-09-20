package com.robert42.mongolog

import net.liftweb.mongodb._
import net.liftweb.json._
import net.liftweb.json.JsonAST._
import net.liftweb.json.JsonDSL._
import net.liftweb.json.Extraction._

object Posts {
  if (!MongoRepo.isConfigured) MongoRepo.setup

  implicit val formats = DefaultFormats.lossless

  def create(json: String) = {
    MongoDB.useCollection(Post.collectionName)(coll => {
            coll.save(JObjectParser.parse(JsonParser.parse(json)
                    .asInstanceOf[JObject]))
    })
  }

  def get(id: String) = pretty(render(decompose(Post.find(("_id" -> id)).get)))

  def all() = pretty(render(decompose(Post.findAll)))
}

case class Post(_id: String, body: String) extends MongoDocument[Post] {
  def meta = Post
}
object Post extends MongoDocumentMeta[Post] {
  override val collectionName = "posts"

  override def mongoIdentifier = DefaultMongoIdentifier

  ensureIndex(("body" -> 1))
}
