package code
package snippet

import scala.xml.{NodeSeq, Text}

import net.liftweb._
import util._
import common.Logger
import http.SHtml._
import http.js.JsCmds.{SetHtml, SetValueAndFocus}

import java.util.Date
import Helpers._

class SideBar extends Logger {

  /**
    * Generate the Versions sidebar section
    */

  def versions( xhtml: NodeSeq ): NodeSeq = {
    versions("%", xhtml)
  }

  def versions(prefix: String, xhtml: NodeSeq ) = {
    //val version_name_col: List[String]= Versions.getVersionList(prefix)
    val version_name_col: List[String]= List("2.3.4.00", "2.3.4.01")

    def bindConsumption(template: NodeSeq): NodeSeq = {
      version_name_col.flatMap{
        case (ver) => bind("version", template, "number" ->
          link("/index/" + ver, () => {}
          , <div>{ver}</div>)
        )


      }
    }
    bind("Versions",xhtml, "list" -> bindConsumption _)
  }


  

}

