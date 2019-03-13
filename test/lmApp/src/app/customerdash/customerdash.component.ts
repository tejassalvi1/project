import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from '../model/Customer';
import { CustomerdetailsService } from 'src/app/customerdetails.service';

@Component({
  selector: 'app-customerdash',
  templateUrl: './customerdash.component.html',
  styleUrls: ['./customerdash.component.css']
})
export class CustomerdashComponent implements OnInit {

  constructor(private router:ActivatedRoute, private customerdetailsService:CustomerdetailsService) { }
  private customerdetails:Customer;

  ngOnInit() {
    let id = this.router.snapshot.params.id;
    localStorage.setItem('cusId', id);

    let name = this.router.snapshot.params.id;
    this.customerdetailsService.getcustomerdetails(id)
    .subscribe(response=> {
      this.customerdetails = response[0];
      localStorage.setItem('loggedInUserName', this.customerdetails.cusName);
  }
);

  }
}
