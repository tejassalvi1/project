import { Component, OnInit, ɵConsole } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerdetailsService } from 'src/app/customerdetails.service';


@Component({
  selector: 'app-customerlogin',
  templateUrl: './customerlogin.component.html',
  styleUrls: ['./customerlogin.component.css']
})
export class CustomerloginComponent implements OnInit {

  constructor(private router:Router, private customerService:CustomerdetailsService) { }
  errorMessage:string;
  ngOnInit() {
  }

public submit(form) {
  if (form.valid){
    let custId = form.value.customerId;
    let custPassword = form.value.password;
    this.customerService.authenticate(custId, custPassword)
    .subscribe((data)=>{
      this.router.navigate(['/customer', custId,'dashboard']);
    },(error)=>{
      this.errorMessage = "Invalid Login credentials."
    })
  }
}




}

