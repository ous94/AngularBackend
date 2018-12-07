import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustDetailComponent } from './cust-detail/cust-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerDetailComponent,
    CustDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
