import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-allvendororders',
  templateUrl: './allvendororders.component.html',
  styleUrls: ['./allvendororders.component.css']
})
export class AllvendorordersComponent implements OnInit {
  private vendorService:VendorService;
  private vendororderdetails;
  constructor (vendorService: VendorService)  {
    this.vendorService = vendorService;
   }

   ngOnInit() {
    let vendId = localStorage.getItem('vendId');
    console.log("Vendor"+vendId)
    let status = ""
    this.vendorService.vendororderdetails(vendId, status)
    .subscribe(response=> {
      this.vendororderdetails = response;
    console.log(response)});
  }
  predicate: string = 'orderDate'; 
  reverse: boolean = false;
  sort(predicate){
    this.predicate = predicate;
    this.reverse = !this.reverse;
  }
  p: number = 1;
}



