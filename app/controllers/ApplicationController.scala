package controllers

import play.api.mvc.{Action, Controller}
import plugins.MongoDB
import play.api.Play.current
import models.Region

object ApplicationController extends Controller {
  
  def index = Action { implicit request =>
    
    implicit val context = MongoDB.context
    
    Ok(Region.readJson(None).get)
  }
  
  def signupForm = Action { implicit request =>
    Ok("")
  }

  def signup = Action { implicit request =>
    Ok("")
  }

  def loginForm = Action { implicit request =>
    Ok("")
  }

  def login = Action { implicit request =>
    Ok("")
  }

  def logout = Action { implicit request =>
    Ok("")
  }
  
}

/*
@With(CurrentUser.class)
public class ApplicationController extends Controller {

    public static Result index() {
        return ok(views.html.index.render(Region.find.all()));
    }

    public static Result signupForm() {
        return ok(views.html.signupForm.render(form(User.class)));
    }

    public static Result signup() {
        Form<User> signupForm = form(User.class).bindFromRequest();
        if (signupForm.hasErrors()) {
            return badRequest(views.html.signupForm.render(signupForm));
        }
        else {
            
            User user = signupForm.get();
            
            if (User.findByEmailAddress(user.getEmailAddress()) != null) {
                signupForm.reject("Duplicate Email Address");
                return badRequest(views.html.signupForm.render(signupForm));
            }
            
            user.save();

            session("token", user.createToken()); // log the user in
            
            return redirect(routes.ApplicationController.index());
        }
    }

    public static Result loginForm() {
        return ok(views.html.loginForm.render(form(Login.class)));
    }

    public static Result login() {
        
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        
        if (loginForm.hasErrors()) {
            return badRequest(views.html.loginForm.render(loginForm));
        }
        
        Login login = loginForm.get();
        
        User user = User.findByEmailAddressAndPassword(login.emailAddress, login.password);

        if (user == null) {
            loginForm.reject("Invalid Login");
            return badRequest(views.html.loginForm.render(loginForm));
        }
        else {
            // todo: redirect back to the page the user was already on
            session("token", user.createToken());
            return redirect(controllers.routes.ApplicationController.index());
        }
    }

    @Security.Authenticated(Secured.class)
    public static Result logout() {
        session().remove("token");
        return redirect(routes.ApplicationController.index());
    }
    
    public static class Login {
        
        @Constraints.Required
        @Constraints.Email
        public String emailAddress;

        @Constraints.Required
        public String password;
        
    }

}
*/