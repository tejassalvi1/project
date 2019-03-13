
import { Component, OnInit } from '@angular/core';
import { CustomerdetailsService } from 'src/app/customerdetails.service';
import { Wallet } from '../model/Wallet';
import { MenuService } from '../menu.service';
import { Menus } from '../model/Menus';
import { Vendor } from '../model/vendor';
import { Order } from '../model/Order';
import { Router } from '@angular/router';
import { ReceiptComponent } from '../receipt/receipt.component';

@Component({
  selector: 'app-placeorder',
  templateUrl: './placeorder.component.html',
  styleUrls: ['./placeorder.component.css']
})
export class PlaceorderComponent implements OnInit {

  private wallets: Wallet[];
  constructor(private menuService:MenuService, private customerService:CustomerdetailsService, private router:Router) { }
  private menus:Menus[];
  private vendors:Vendor[];
  private qty=[1,2,3,100];
  private selectedFoodId:number;
  private selectedVendorId:number;
  private selectedMenu;
  private validWallets:Wallet[];
  private totalPrice:number;
  private totalWalletBalance:number;
  private avilBal:number;
  private dumvalidWallets:Wallet[];
  private value:number;
  private printReceipt;
  private printMenu:Menus;
  private filterFoodName:string;
  private quantity:number = 1;
  private choosenWallet;
  private vendorId;

  ngOnInit() {

    this.menuService.getAllMenus().subscribe(menus=> this.menus = menus);
    this.customerService.getWallet(localStorage.getItem('cusId'))
    .subscribe(wallets=> this.wallets = wallets)

  }

  selectedFood(selectedFood){
    console.log(selectedFood);
     this.selectedFoodId =  +selectedFood.value;
     this.menuService.getAllVendorsByFoodId(this.selectedFoodId).subscribe(menus=> this.menus = menus);
     console.log("VENDORS   "+this.menus[0].vendorId);
     this.vendorId = this.menus[0].vendorId;
     console.log("FoodId",this.menus[0].foodId);
     console.log("NAME "+this.menus[0].foodName);
     console.log("price",this.menus[0].foodPrice)
  }

  selectedQuantity(selectedQty){
    // let custId = localStorage.getItem('cusId');
    // let qty = selectedQty;
    // let foodId = this.selectedFoodId;
    // let vendorId = this.selectedVendorId;
    // console.log('vendor id'+ this.selectedVendorId);
    // console.log(this.menus.filter(menus =>menus.vendorId === vendorId && menus.foodId === foodId));
    // this.selectedMenu = this.menus.filter(menus =>menus.vendorId === vendorId && menus.foodId === foodId);
    // console.log("Seleted Menu "+this.selectedMenu[0].foodPrice);
    // console.log('quantyty   '  +qty);
    // this.totalPrice = this.selectedMenu[0].foodPrice * qty;
    // console.log('total price thing------'+this.totalPrice);
    // console.log("Filtered Wallete"+ this.wallets.filter(wallets =>wallets.walBal > this.totalPrice));
    // this.validWallets = this.wallets.filter(wallets =>wallets.walBal > this.totalPrice);
    // console.log('wallet valids ones');
    // console.log(this.validWallets);
    // this.totalWalletBalance = this.wallets.map(wallet => wallet.walBal).reduce((old, newBal) => old +newBal);
    // console.log("Total Balance"+this.totalWalletBalance);
    // this.avilBal=(this.totalWalletBalance-this.totalPrice)
    // console.log("available balance="+this.avilBal);




  }  
    handleMenu(Menu){
    console.log("Came Inside Seleted Menu"+Menu.foodId)
    this.selectedMenu = Menu;
    console.log("VENDORS   "+Menu.vendorId);
    this.vendorId = Menu.vendorId;
    console.log("Came sfsdfsdf>>>>>>>>>>>"+this.selectedMenu.foodId)
    console.log("Came sfsdfsdf>>>>>>>>>>>"+this.selectedMenu.foodPrice)
    console.log("Name >>>>>"+this.selectedMenu.foodName)
    localStorage.setItem('foodPrice',this.selectedMenu.foodPrice);
    localStorage.setItem('foodName',this.selectedMenu.foodName);
    this.quantity = 1;
  }

  selectedwallet(selectedWallet){
    let selectedwallet:number = selectedWallet.value;
    this.choosenWallet = selectedWallet.value;
    console.log("Seleted Wallet"+ selectedwallet);
    let dumTotal = this.totalPrice;
    console.log("Seleted Wallet=========="+ this.validWallets);
    this.validWallets.filter(validWallets =>validWallets.walId === +selectedwallet);
    console.log(this.validWallets.filter(validWallets =>validWallets.walId === +selectedwallet));
    this.dumvalidWallets = this.validWallets.filter(validWallets =>validWallets.walId === +selectedwallet);
    this.value = this.dumvalidWallets[0].walBal-dumTotal;
    console.log("Dummy value of after Calculation"+this.value);
  }

  submitForm(form){
    console.log('form');
    console.log(form);
     console.log(this.selectedFoodId);
     let custId = localStorage.getItem('cusId');
     console.log("CUSTOMER ID>>"+custId)
     let qty = form.value.quantity;
     let totalPrice = this.totalPrice;
     let selectedwallet = form.value.selectedWallet;
     console.log("Seleted Wallet "+ selectedwallet);
    this.printReceipt = this.customerService.placeOrder(custId, this.selectedFoodId, this.vendorId, qty, totalPrice, selectedwallet)
    .subscribe(response=>{ this.printReceipt = response;
    localStorage.setItem('orderId',this.printReceipt.orderId)
    console.log("orderId",this.printReceipt.orderId);});
    this.router.navigate(['/customer', custId,'dashboard','receipt']);
    console.log("After Placede Order"+this.printReceipt)
  }

  increment(selectedFood, quantity){
    console.log('came inside the selectedFood method>>>>>>>>>>>>' +selectedFood.foodPrice)
    this.selectedMenu=selectedFood;
    this.selectedFoodId = selectedFood.foodId
    this.quantity ++;
    console.log('came inside the selectedFood method')
    console.log(selectedFood);
    console.log(quantity)
   console.log('came inside the selectedFood method')
   console.log(selectedFood);
    this.menuService.getAllVendorsByFoodId(selectedFood.foodId).subscribe(menus=> this.menus = menus);
    let custId = localStorage.getItem('cusId');
    let qty = quantity;
    console.log('food price   '  +selectedFood.foodPrice);
    console.log('quantyty   '  +qty);
    this.totalPrice = selectedFood.foodPrice * qty;
    console.log('total price thing------'+this.totalPrice);
    console.log("Filtered Wallete"+ this.wallets.filter(wallets =>wallets.walBal > this.totalPrice));
    this.validWallets = this.wallets.filter(wallets =>wallets.walBal > this.totalPrice);
    console.log('wallet valids ones');
    console.log(this.validWallets);
    this.totalWalletBalance = this.wallets.map(wallet => wallet.walBal).reduce((old, newBal) => old +newBal);
    console.log("Total Balance"+this.totalWalletBalance);
    this.avilBal=(this.totalWalletBalance-this.totalPrice)
    console.log("available balance="+this.avilBal);
    this.dumvalidWallets = this.validWallets.filter(validWallets =>validWallets.walId === +this.choosenWallet);
    let dumTotal = this.totalPrice;
    this.value = this.dumvalidWallets[0].walBal-dumTotal;
 }

 decrement(selectedFood, quantity){
  this.selectedMenu=selectedFood;
   if (this.quantity > 1){
     this.quantity --;
   }
   console.log(quantity)
     console.log('came inside the selectedFood method')
     console.log(selectedFood);
      this.menuService.getAllVendorsByFoodId(selectedFood.foodId).subscribe(menus=> this.menus = menus);
      let custId = localStorage.getItem('cusId');
      let qty = quantity;
      console.log('food price  '  +selectedFood.foodPrice);
      console.log('quantyty  '  +qty);
      this.totalPrice = selectedFood.foodPrice * qty;
      console.log('total price thing------'+this.totalPrice);
      console.log("Filtered Wallete"+ this.wallets.filter(wallets =>wallets.walBal > this.totalPrice));
      this.validWallets = this.wallets.filter(wallets =>wallets.walBal > this.totalPrice);
      console.log('wallet valids ones');
      console.log(this.validWallets);
      this.totalWalletBalance = this.wallets.map(wallet => wallet.walBal).reduce((old, newBal) => old +newBal);
      console.log("Total Balance"+this.totalWalletBalance);
      this.avilBal=(this.totalWalletBalance-this.totalPrice)
      console.log("available balance="+this.avilBal);
      this.dumvalidWallets = this.validWallets.filter(validWallets =>validWallets.walId === +this.choosenWallet);
      let dumTotal = this.totalPrice;
      console.log("Selected Food Pice"+selectedFood.foodPrice);
      this.value = this.value+selectedFood.foodPrice;
   }
  }
