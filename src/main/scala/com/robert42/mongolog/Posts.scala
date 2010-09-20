package com.robert42.mongolog

import net.liftweb.mongodb._
import net.liftweb.json._
import net.liftweb.json.JsonAST._
import net.liftweb.json.JsonDSL._
import net.liftweb.json.Extraction._

object Posts extends Storable {
  if (!MongoRepo.isConfigured) MongoRepo.setup

  implicit val formats = DefaultFormats.lossless

  override def create(json: String) = {
    MongoDB.useCollection(Post.collectionName)(coll => {
            coll.save(JObjectParser.parse(JsonParser.parse(json)
                    .asInstanceOf[JObject]))
    })
  }

  // TODO: impl.
  override def update(json: String) = None

  // TODO: impl.
  override def remove(json: String) = None

  override def get(id: String) =
          pretty(render(decompose(Post.find(("_id" -> id)).get)))

  override def all() = pretty(render(decompose(Post.findAll)))
}

case class Post(_id: String, body: String) extends MongoDocument[Post] {
  def meta = Post
}

object Post extends MongoDocumentMeta[Post] {
  override val collectionName = "posts"

  override def mongoIdentifier = DefaultMongoIdentifier

  ensureIndex(("body" -> 1))
}
