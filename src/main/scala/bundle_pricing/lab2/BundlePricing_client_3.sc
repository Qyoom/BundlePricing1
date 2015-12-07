package bundle_pricing.lab2

import bundle_pricing.lab2.app._
import bundle_pricing.lab2.app.CartService._
import bundle_pricing.lab2.app.BundleService._

object BundlePricing_client_3 {

  /** Simple items with unit price */
  val alpo = Item("Alpo Chicken 3oz", 0.89)       //> alpo  : bundle_pricing.lab2.app.Item = Item(Alpo Chicken 3oz,0.89)
  val hotdogs = Item("Oscar Meyer Weiners 8 pack", 3.59)
                                                  //> hotdogs  : bundle_pricing.lab2.app.Item = Item(Oscar Meyer Weiners 8 pack,3.
                                                  //| 59)
  val charmin = Item("Charmin 4 roll", 3.00)      //> charmin  : bundle_pricing.lab2.app.Item = Item(Charmin 4 roll,3.0)
  val ipa = Item("Big Daddy IPA 6 pack", 7.99)    //> ipa  : bundle_pricing.lab2.app.Item = Item(Big Daddy IPA 6 pack,7.99)
  val bread = Item("Wonder Bread", 1.29)          //> bread  : bundle_pricing.lab2.app.Item = Item(Wonder Bread,1.29)
  val butter = Item("Butter Stick", 0.89)         //> butter  : bundle_pricing.lab2.app.Item = Item(Butter Stick,0.89)
  
  // Empty cart
  val cart1 = getCart                             //> cart1  : bundle_pricing.lab2.app.Cart = Cart(List())
  
  // Items with quantity
  val shoppingList = List(
    (alpo, 1),
    (hotdogs, 1),
    (charmin, 2)
  )                                               //> shoppingList  : List[(bundle_pricing.lab2.app.Item, Int)] = List((Item(Alpo 
                                                  //| Chicken 3oz,0.89),1), (Item(Oscar Meyer Weiners 8 pack,3.59),1), (Item(Charm
                                                  //| in 4 roll,3.0),2))
  
  // Add shopping list to cart
  val cart2 = addToCart(shoppingList, cart1)      //> cart2  : bundle_pricing.lab2.app.Cart = Cart(List(Item(Charmin 4 roll,3.0), 
                                                  //| Item(Charmin 4 roll,3.0), Item(Oscar Meyer Weiners 8 pack,3.59), Item(Alpo C
                                                  //| hicken 3oz,0.89)))
  
  
  val cart3 = addToCart(butter, 2, cart2)         //> cart3  : bundle_pricing.lab2.app.Cart = Cart(List(Item(Butter Stick,0.89), I
                                                  //| tem(Butter Stick,0.89), Item(Charmin 4 roll,3.0), Item(Charmin 4 roll,3.0), 
                                                  //| Item(Oscar Meyer Weiners 8 pack,3.59), Item(Alpo Chicken 3oz,0.89)))
  
  /** Bundles ***************/
  
  val breadAndButterBundle =
    forPriceOfQty(butter, 2, 4)((bread, 1))("Buy loaf of Wonder Bread with 2 sticks of butter and get the second stick free.")
                                                  //> breadAndButterBundle  : bundle_pricing.lab2.app.Bundle = Bundle(ForPriceOf(4
                                                  //| ),List(BundleItem(Item(Butter Stick,0.89),2)),List(BundleItem(Item(Wonder Br
                                                  //| ead,1.29),1)),Buy loaf of Wonder Bread with 2 sticks of butter and get the s
                                                  //| econd stick free.)
  bundleMatch(cart3, breadAndButterBundle)        //> -->bundleMatch cartItems: List(Item(Butter Stick,0.89), Item(Butter Stick,0
                                                  //| .89), Item(Charmin 4 roll,3.0), Item(Charmin 4 roll,3.0), Item(Oscar Meyer 
                                                  //| Weiners 8 pack,3.59), Item(Alpo Chicken 3oz,0.89))
                                                  //| -->bundleMatch bundle.appliedTo: List(BundleItem(Item(Butter Stick,0.89),2)
                                                  //| )
                                                  //| -->bundleMatch bundle.appliedTo: List(BundleItem(Item(Wonder Bread,1.29),1)
                                                  //| )
                                                  //| res0: Boolean = false
  val cart4 = addToCart(bread, 1, cart3)          //> cart4  : bundle_pricing.lab2.app.Cart = Cart(List(Item(Wonder Bread,1.29), 
                                                  //| Item(Butter Stick,0.89), Item(Butter Stick,0.89), Item(Charmin 4 roll,3.0),
                                                  //|  Item(Charmin 4 roll,3.0), Item(Oscar Meyer Weiners 8 pack,3.59), Item(Alpo
                                                  //|  Chicken 3oz,0.89)))
  
  bundleMatch(cart4, breadAndButterBundle)        //> -->bundleMatch cartItems: List(Item(Wonder Bread,1.29), Item(Butter Stick,0
                                                  //| .89), Item(Butter Stick,0.89), Item(Charmin 4 roll,3.0), Item(Charmin 4 rol
                                                  //| l,3.0), Item(Oscar Meyer Weiners 8 pack,3.59), Item(Alpo Chicken 3oz,0.89))
                                                  //| 
                                                  //| -->bundleMatch bundle.appliedTo: List(BundleItem(Item(Butter Stick,0.89),2)
                                                  //| )
                                                  //| -->bundleMatch bundle.appliedTo: List(BundleItem(Item(Wonder Bread,1.29),1)
                                                  //| )
                                                  //| res1: Boolean = true
  

  '''                                             //> res2: Char('\'') = '
}