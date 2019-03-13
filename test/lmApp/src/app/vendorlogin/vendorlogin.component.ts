import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { VendorService } from 'src/app/vendor.service';
@Component({
  selector: 'app-vendorlogin',
  templateUrl: './vendorlogin.component.html',
  styleUrls: ['./vendorlogin.component.css']
})
export class VendorloginComponent implements OnInit {

  constructor(private router:Router, private vendorService:VendorService) { }
  errorMessage:string;
  ngOnInit() {
  }
  public submit(form) {
    if (form.valid){
      let vendId = form.value.VendorId;
      let venPassword = form.value.password;
      this.vendorService.authentication(vendId, venPassword)
      .subscribe((data)=>{
        this.router.navigate(['/vendor', vendId,'dashboard']);
      },(error)=>{
        this.errorMessage = "Invalid Login credentials."
      })
    }
  }
}
