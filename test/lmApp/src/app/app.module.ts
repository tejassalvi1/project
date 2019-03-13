import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { VendorComponent } from './vendor/vendor.component';
import { CustomerorderdetailsComponent } from 'src/app/customerorderdetails/customerorderdetails.component';
import { MenuComponent } from './menu/menu.component';
import { CustomerdetailsComponent } from './customerdetails/customerdetails.component';
import { WalletComponent } from './wallet/wallet.component';
import { LoginComponent } from './login/login.component';
import { CustomerloginComponent } from './customerlogin/customerlogin.component';
import { VendorloginComponent } from './vendorlogin/vendorlogin.component';
import { CustomerdashComponent } from './customerdash/customerdash.component';
import { VendordashComponent } from './vendordash/vendordash.component';
import { PlaceorderComponent } from './placeorder/placeorder.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { VendororderdetailsComponent } from 'src/app/vendororderdetails/vendororderdetails.component';
import { AllvendorordersComponent } from './allvendororders/allvendororders.component';
import { FiltermenuPipe } from './filtermenu.pipe';
import {NgxPaginationModule} from 'ngx-pagination';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { ReceiptComponent } from './receipt/receipt.component';
@NgModule({
  declarations: [
    AppComponent,
    CustomerdetailsComponent,
    WalletComponent,
    VendorComponent,
    CustomerorderdetailsComponent,
    MenuComponent,
    LoginComponent,
    CustomerloginComponent,
    VendorloginComponent,
    CustomerdashComponent,
    VendordashComponent,
    PlaceorderComponent,
    NotFoundComponent,
    VendororderdetailsComponent,
    AllvendorordersComponent,
    ReceiptComponent,
    FiltermenuPipe,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    Ng2OrderModule,
    RouterModule.forRoot([
      {
        'path':'',
        component:MenuComponent
      },
      {
        'path':'login',
        component:LoginComponent,
        children: [
          
            {
              path: '', 
              redirectTo: 'customerlogin', 
              pathMatch: 'full' 
            },
            {
            'path': 'customerlogin',
            component:CustomerloginComponent
          },
          {
            'path': 'vendorlogin',
            component:VendorloginComponent
          }
        ]
      },
      {
        path:'AppComponent',
        component:AppComponent
      },
      {
        path:'customer/:id/dashboard',
        component:CustomerdashComponent,
        children :[
          {
            path:'',
            redirectTo: 'details', 
            pathMatch: 'full' 
          },
          {
            path:'details',
            component:CustomerdetailsComponent
          },
          {
            path:'wallet',
            component:WalletComponent
          },
          {
            path:'orders',
            component:CustomerorderdetailsComponent,
          },
         {
          path:'placeorder',
          component:PlaceorderComponent,
         },
        {
          path:'receipt',
          component:ReceiptComponent
        }]
      },
      {
        path:'vendor/:id/dashboard',
        component:VendordashComponent,
        children :[
          {
            path:'',
            redirectTo: 'details', 
            pathMatch: 'full' 
          },
          {
            path:'details',
            component:VendorComponent
          },
          {
            path:'pendingorders',
            component:VendororderdetailsComponent
          },
          {
            path:'allorders',
            component:AllvendorordersComponent,
          }
        ]
      },{
        path:'AppComponent',
        component:AppComponent
      },

      {
       path: '',
       component: NotFoundComponent,
        children:[
      {
        path: 'Menu',
        component: MenuComponent
    },
    {
        path: 'CustomerDetails',
        component: CustomerdetailsComponent
    },
    {
        path: 'VendorDetails',
        component: VendorComponent
    },
    {
      path: 'Wallet',
      component: WalletComponent
  },
  { 
        path: '404', 
      component: NotFoundComponent
  },
    { path: '**',
      component: NotFoundComponent
      
    },
  ]
  },
    ])
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
