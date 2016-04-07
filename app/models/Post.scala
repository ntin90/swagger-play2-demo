package models

import io.swagger.annotations._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc.BodyParsers
import play.api.mvc.Results._
import play.api.i18n.Messages.Implicits._
import play.api.Play.current

@ApiModel(description = "A post of user, which has Title and Content")
case class Post(
  @ApiModelProperty(value="Title of post", required=true) title: String,
  @ApiModelProperty(value="Content of post", required=true) content: String) {
  @ApiModelProperty(hidden=true) var id: Int = 0
}

object Post extends BodyParsers {

  implicit val format = Json.format[Post]

  val form = Form(
    mapping(
      "title" -> text,
      "content" -> text
    )(Post.apply)(Post.unapply)
  )

  val bodyParser = parse.form[Post](form, onErrors = x => BadRequest(x.errorsAsJson))

}

