import { Component, OnInit } from '@angular/core';
import { CustomerdetailsService } from 'src/app/customerdetails.service';

@Component({
  selector: 'app-customerorderdetails',
  templateUrl: './customerorderdetails.component.html',
  styleUrls: ['./customerorderdetails.component.css']
})
export class CustomerorderdetailsComponent implements OnInit {

  private customerdetailsService:CustomerdetailsService;
  private customerorderdetails;
  
  constructor(customerdetailsService:CustomerdetailsService) {
    this.customerdetailsService = customerdetailsService;
   }

  ngOnInit() {
    let custId = localStorage.getItem('cusId');
    this.customerdetailsService.getcustomerorderdetails(custId)
    .subscribe(response=> {
      this.customerorderdetails = response;
      console.log('customerdetails things');
    console.log(response)});
  }





key1: string = 'orderDate'; //set default
reverse: boolean = false;
sort(key1){
  this.key1 = key1;
  this.reverse = !this.reverse;
}
//initializing p to one
p: number = 1;
}