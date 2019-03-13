import { Component, OnInit } from '@angular/core';
import { CustomerdetailsService } from 'src/app/customerdetails.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {

 private wallets;

 
 constructor(private customerdetailsservice:CustomerdetailsService) {  }
  
 ngOnInit() {
   let custId = localStorage.getItem('cusId');

   this.customerdetailsservice.getWallet(custId)
  .subscribe(response=> {
    this.wallets = response;
   });

  }
}

