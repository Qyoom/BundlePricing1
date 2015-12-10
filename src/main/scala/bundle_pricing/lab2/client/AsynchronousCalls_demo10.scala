package bundle_pricing.lab2.client

import bundle_pricing.lab2.app._
import bundle_pricing.lab2.app.CartService._
import bundle_pricing.lab2.app.BundleService._
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global

object AsynchronousCalls_demo10 extends App {
    
    /*
     * Combination of bundles of different types.
     * flat2 and fourForOne are applied. flat3 and pctOff are not.
     */
    
    val i1 = Item("One", 1.0)
    val i2 = Item("Two", 2.0)
    val i3 = Item("Three", 2.0)
    val addQual = Item("Something Extra", 1.0)

    val shoppingList = List((i1, 4), (i2, 3), (i3, 3), (addQual, 1))
    
    val cart = getCart
    
    val cart2 = addToCart(shoppingList, cart)
    
    val flat2 = bundlePrice(1.75, (i2, 2))()("2 i2 for $1.75")
    val flat3 = bundlePrice(4.00, (i1, 2),(i3, 2))()("2 i1 and 2 i3 for $4.00")
    val pctOff = percentPrice(i1, 4, 0.5)()("50% off 4 i1")
    val fourForOne = forPriceOfQty(i1, 4, 1)()_
    val dealOfTheDay = fourForOne("i1 4 for price of 1!")
    
    val bundles1 = List(flat2, flat3, pctOff, dealOfTheDay)
    val bundles2 = List(flat3, pctOff, dealOfTheDay)
    val bundles3 = List(flat2, flat3, pctOff)
    val bundles4 = List(flat2, flat3, dealOfTheDay)
    val bundles5 = List(flat2, pctOff, dealOfTheDay)
    val bundles6 = List(flat2, dealOfTheDay)
    val bundles7 = List(dealOfTheDay, flat2, flat3, pctOff)
    val bundles8 = List(pctOff, pctOff, pctOff)
    
    val bundles = List(bundles1, bundles2, bundles3, bundles4, 
                       bundles5, bundles6, bundles7, bundles8)
    
    // Fire off all bundles in separate checkouts
    bundles.foreach{                   
        checkout(cart2, _).onComplete {
            case Success(cart) => printReceipt(cart)
            case Failure(e) => println(e) 
        }
    }
    
    Thread.sleep(3000)
}