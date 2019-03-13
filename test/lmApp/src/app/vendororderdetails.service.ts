import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VendororderdetailsService {
  vendororderdetails;
  constructor() { 
    this.vendororderdetails=[
      {
      orderId : 12,
      orderStatus : "ACCEPTED",
      orderPrice : 120,
      orderDate : new Date(2019,1,23),
      estimatedTime : "20Mins",
      cusId : 102,
      venId : 201,
      vendorName : "HexaCafe",
      qty : 1 ,
      comments : "order is available"
      },

      {
        orderId : 10,
        orderStatus : "ACCEPTED",
        orderPrice : 100,
        orderDate : new Date(2019,1,24),
        estimatedTime : "30Mins",
        cusId : 103,
        venId : 202,
        vendorName : "HexaRaunt",
        qty : 2 ,
        comments : "order is available"
        }
    ];
  }

  getOrderHistory(){
    return this.vendororderdetails;
}
}