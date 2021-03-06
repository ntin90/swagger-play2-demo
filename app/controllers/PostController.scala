package controllers

import javax.inject._
import models.Post
import play.api.libs.json.{Json, JsArray}
import play.api.mvc._

class PostController @Inject() extends Controller {

  /**
   * Example APIs for list, show, insert, update and remove Post
   */
  def list(offset: Int, size: Int) = Action {
    // List posts put here
    val query = Seq(Post("Title1", "Content1"), Post("Title2", "Content2"))

    Ok(JsArray(query.map(Json.toJson(_))))
  }

  def show(id: Int) = Action {
    // Show post put here
    val post = Post("Title1", "Content1")

    Ok(Json.toJson(post))
  }

  def insert = Action(Post.bodyParser) { request =>
    // Insert post put here
    val post = request.body

    Created(Json.toJson(post))
  }

  def update(id: Int) = Action(Post.bodyParser) { request =>
    // Update post put here
    val post = request.body

    Ok(Json.toJson(post))
  }

  def remove(id: Int) = Action {
    // Remove post put here
    val post = Post("Title1", "Content1")

    Ok("Post removed")
  }

}
