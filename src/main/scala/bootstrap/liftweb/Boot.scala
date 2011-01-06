package bootstrap.liftweb

import java.sql.{Connection, DriverManager}

import code.snippet._
import net.liftweb._
import util._
import Helpers._

import common._
import http._
import sitemap._
import Loc._
import mapper._



/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  
  // Set up a logger to use for startup messages
  val logger = Logger(classOf[Boot])
  def boot {
    

    // Use Lift's Mapper ORM to populate the database
    // you don't need to use Mapper to use Lift... use
    // any ORM you want

    // where to search snippet
    LiftRules.addToPackages("code")

    // Build SiteMap
    def sitemap(): SiteMap = SiteMap(
      Param.agentDetailsMenu,
      Param.overviewMenu
      ) 

    // set the sitemap.  Note if you don't want access control for
    // each page, just comment this line out.
    LiftRules.setSiteMapFunc(() => sitemap())

    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)
    
    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))


    



  }
}


