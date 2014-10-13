package controllers

import play.api.mvc._

object Test extends Controller {

  def get_test = Action {
    Ok(views.html.diego("EH"))
  }

}