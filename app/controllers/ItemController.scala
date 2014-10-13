package controllers

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

object ItemController extends Controller {

  val ListForm: Form[List] = Form {
  	mapping(
      "name" -> nonEmptyText,
      "description" -> text
    )(List.apply)(List.unapply)
  }

  def post_item = Action { implicit request =>
    val item = ListForm.bindFromRequest.get
    println(request + " " + item)
  	DB.save(item)
    Redirect(routes.ListController.index)
  	//Redirect(routes.ListController.index)
  }

  def get_item = Action {
  	val items = DB.query[List].fetch()
  	Ok(Json.toJson(items))
  }

  def put_item(id:String) = Action {
    Ok(views.html.index())
  }
  
  def delete_item(id:String) = Action {
    Ok(views.html.index())
  }

}