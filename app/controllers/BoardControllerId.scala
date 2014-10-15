package controllers

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

object BoardControllerId extends Controller {

  val ListForm: Form[Board] = Form {
  	mapping(
      "name" -> nonEmptyText,
      "description" -> text
  	)(Board.apply)(Board.unapply)
  }

  def post_list(id:Int) = Action { implicit request =>
    val item = ListForm.bindFromRequest.get
    println(request + " " + item)
  	DB.save(item)
    Redirect(routes.BoardController.index)
  	//Redirect(routes.ListController.index)
  }

  def get_list(id:Int) = Action {
    val board = DB.query[Board].fetch()
    Ok(views.html.board(board))
  }

  def delete_list(id:Int) = Action {
    val boards = DB.query[Board].fetch()
    Ok(Json.toJson(boards))
  }

}