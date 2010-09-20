package com.robert42.mongolog

trait Storable {
  def create(json: String)

  def update(json: String)

  def remove(json: String)

  def get(id: String): String

  def all(): String
}
