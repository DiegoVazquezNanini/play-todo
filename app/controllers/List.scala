package controllers

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

object List extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  val ListForm: Form[List] = Form {
  	mapping(
      "name" -> text,
      "description" -> text
  	)(List.apply)(List.unapply)
  }

  def post_list = Action { implicit request =>
    val person = ListForm.bindFromRequest.get
    println(request + " " + person)
  	DB.save(person)
  	Redirect(routes.Application.index)
  }

  def get_lists = Action {
  	val lists = DB.query[List].fetch()
  	Ok(Json.toJson(lists))
  }
}