import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VendorService } from 'src/app/vendor.service';
import { Vendor } from '../model/Vendor';

@Component({
  selector: 'app-vendordash',
  templateUrl: './vendordash.component.html',
  styleUrls: ['./vendordash.component.css']
})
export class VendordashComponent implements OnInit {
  constructor(private router:ActivatedRoute,private vendorService:VendorService) { }
  private vendor:Vendor;
  ngOnInit() {
    let id = this.router.snapshot.params.id;
    localStorage.setItem('vendId',id);
    let name = this.router.snapshot.params.id;
    this.vendorService.getVendorDetails(id)
    .subscribe(response=> {
      this.vendor = response[0];
      localStorage.setItem('loggedInUserName', this.vendor.venName);
  }
    );
}
}
