package controllers

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

object ListControllerId extends Controller {

  val ListForm: Form[List] = Form {
  	mapping(
      "name" -> nonEmptyText,
      "description" -> text
  	)(List.apply)(List.unapply)
  }

  def post_list(id:Int) = Action { implicit request =>
    val item = ListForm.bindFromRequest.get
    println(request + " " + item)
  	DB.save(item)
    Redirect(routes.ListController.index)
  	//Redirect(routes.ListController.index)
  }

  def get_list(id:Int) = Action {
    Ok(views.html.index())
  }

  def delete_list(id:Int) = Action {
    val lists = DB.query[List].fetch()
    Ok(Json.toJson(lists))
  }

}