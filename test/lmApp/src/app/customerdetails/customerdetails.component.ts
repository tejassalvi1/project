import { Component, OnInit } from '@angular/core';
import { CustomerdetailsService } from 'src/app/customerdetails.service';
import { Customer } from 'src/app/model/Customer';
@Component({
  selector: 'app-customerdetails',
  templateUrl: './customerdetails.component.html',
  styleUrls: ['./customerdetails.component.css']
})

export class CustomerdetailsComponent implements OnInit {

  private customerdetailsService: CustomerdetailsService;

  private customerdetails: Customer;

  constructor(customerdetailsService: CustomerdetailsService) {
    this.customerdetailsService = customerdetailsService;
  }

  ngOnInit() {
    let custId = localStorage.getItem('cusId');
    this.customerdetailsService.getcustomerdetails(custId)
    .subscribe(response=> {
      this.customerdetails = response[0];
  });
 }
  
}
