import { Component, OnInit } from '@angular/core';
import { VendorService } from 'src/app/vendor.service';
@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css']
})
export class VendorComponent implements OnInit {
  private vendorDetails;
  private vendorService :  VendorService;
  
  constructor(vendorService: VendorService ) {
    this.vendorService = vendorService;
   }
   ngOnInit() {
    let venId = localStorage.getItem('vendId');
    console.log("vendor id" +venId) 
    this.vendorService.getVendorDetails(venId)
    .subscribe(response=> {
      this.vendorDetails = response[0];
      console.log('Vendor Details');
      console.log(this.vendorDetails)
    });
  } 
}
