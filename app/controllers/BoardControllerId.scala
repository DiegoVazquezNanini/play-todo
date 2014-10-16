package controllers

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

object BoardControllerId extends Controller {

  val BoardForm: Form[Board] = Form {
  	mapping(
      "name" -> nonEmptyText,
      "description" -> text
  	)(Board.apply)(Board.unapply)
  }

  def post_board(id:Int) = Action { implicit request =>
    val item = BoardForm.bindFromRequest.get
    println(request + " " + item)
  	DB.save(item)
    Redirect(routes.BoardController.index)
  }

  def get_board(id:Int) = Action {
    val board = DB.query[Board].fetch()
    Ok(views.html.board(""))
  }

  def delete_board(id:Int) = Action {
    val boards = DB.query[Board].fetch()
    Ok(Json.toJson(boards))
  }

}