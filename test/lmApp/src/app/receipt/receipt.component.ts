import { Component, OnInit } from '@angular/core';
import { CustomerdetailsService } from 'src/app/customerdetails.service';

@Component({
  selector: 'app-receipt',
  templateUrl: './receipt.component.html',
  styleUrls: ['./receipt.component.css']
})
export class ReceiptComponent implements OnInit {

  private OrderDetails;
  private foodName;
  private foodPrice;
  private orders;
 constructor(private CustomerdetailsService:CustomerdetailsService) { }


  ngOnInit() {
    let orderId = localStorage.getItem('orderId')
    this.foodName = localStorage.getItem('foodName');
    this.foodPrice = localStorage.getItem('foodPrice');
    console.log(localStorage.getItem('foodPrice'))
    console.log(localStorage.getItem('foodName'))
    this.CustomerdetailsService.getAllOrders(orderId).subscribe(orders=> this.orders = orders);
    console.log("ORDERS THING>>>>",this.orders)

  }

}
