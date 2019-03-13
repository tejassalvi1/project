import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VendorService } from 'src/app/vendor.service';
import { Order } from '../model/Order';

@Component({
  selector: 'app-vendororderdetails',
  templateUrl: './vendororderdetails.component.html',
  styleUrls: ['./vendororderdetails.component.css']
})
export class VendororderdetailsComponent implements OnInit {
  private vendorService:VendorService;
  private vendororderdetails;
  private status="ACCEPTED";
    private ids = [];
   constructor (vendorService: VendorService, private router:Router)  {
    this.vendorService = vendorService;
   }

   ngOnInit() {
    let vendId = localStorage.getItem('vendId');
    console.log("Vendor"+vendId)
    let status = "pending"
    this.vendorService.vendororderdetails(vendId, status)
    .subscribe(response=> {
      this.vendororderdetails = response;
    console.log(response)});
  }

  clicked(orderId)
  {
    console.log(" OrderValue  "+orderId)
    this.ids.push(orderId);
    console.log("order ids >>>>" +this.ids);
  }
  
  submitForm(form)
 {
   let vendId = localStorage.getItem('vendId');
   console.log('came inside the submit method of form');
   console.log(form);
   console.log("OrderId>>>>>>>"+form.value.orderId);
   console.log("comments...."+form.value.comment);
   

console.log("status>>", this.status)
   let comment = form.value.comment;
   for (let i = 0; i < this.ids.length; i++) {
    this.vendorService.UpdateStatus(vendId, this.ids[i], this.status,comment).subscribe(data=>{ console.log("Order Status Updated")});
  console.log("at end of submit");
  this.router.navigate(['/vendor', vendId,'dashboard','allorders']);
  }

 }
 onTest()
    {
  if (document.getElementById('onToggleswitchId').click) {
    this.status= "ACCEPTED"
    console.log(this.status)
  }
  }
offTest()
{
  if (document.getElementById('offToggleswitchId').click) {
    this.status= "REJECTED"
    console.log(this.status)
  }

}
 key: string = 'orderDate';
 reverse: boolean = false;
 sort(key){
   this.key = key;
   this.reverse = !this.reverse;
 }
 p: number = 1;
}
 