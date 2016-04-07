package controllers

import javax.inject._
import io.swagger.annotations._
import models.Post
import play.api.libs.json.{Json, JsArray}
import play.api.mvc._

@Api(value="Post")
class PostController @Inject() extends Controller {

  /**
   * Example APIs for list, show, insert, update and remove Post
   */
  @ApiOperation(value="List posts", notes = "Query posts by offset and size", response = classOf[Post], responseContainer = "List")
  def list(offset: Int, size: Int) = Action {
    // List posts put here
    val query = Seq(Post("Title1", "Content1"), Post("Title2", "Content2"))

    Ok(JsArray(query.map(Json.toJson(_))))
  }

  @ApiOperation(value="Show post", notes = "Show details for one post, by provided ID", response = classOf[Post])
  def show(id: Int) = Action {
    // Show post put here
    val post = Post("Title1", "Content1")

    Ok(Json.toJson(post))
  }

  @ApiOperation(value="Insert post", notes = "Insert new post", response = classOf[Post], code = 201)
  def insert = Action(Post.bodyParser) { request =>
    // Insert post put here
    val post = request.body

    Created(Json.toJson(post))
  }

  @ApiOperation(value="Update post", notes = "Update existed post, by provided ID", response = classOf[Post])
  def update(id: Int) = Action(Post.bodyParser) { request =>
    // Update post put here
    val post = request.body

    Ok(Json.toJson(post))
  }

  @ApiOperation(value="Remove post", notes = "Remove one post, by provided ID", response = classOf[Post])
  def remove(id: Int) = Action {
    // Remove post put here
    val post = Post("Title1", "Content1")

    Ok("Post removed")
  }

}
