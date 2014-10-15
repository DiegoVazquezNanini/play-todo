package controllers

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

object BoardController extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  val BoardForm: Form[Board] = Form {
  	mapping(
      "name" -> nonEmptyText,
      "description" -> text
    )(Board.apply)(Board.unapply)
  }

  def post_list = Action { implicit request =>
    val board = BoardForm.bindFromRequest.get
    println(request + " " + board)
  	DB.save(board)
    Redirect(routes.BoardController.index)
  }

  def get_lists = Action {
    val boards = DB.query[Board].fetch()
    Ok(Json.toJson(boards)).withHeaders(
      CACHE_CONTROL -> "max-age=3600",
      ETAG -> "bla"
    )
  }

}