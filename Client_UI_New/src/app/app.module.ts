import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { TenantRegisterComponent } from './tenant-register/tenant-register.component';
import { LandlordRegisterComponent } from './landlord-register/landlord-register.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { SigninComponent } from './signin/signin.component';
import { HttpClientModule } from '@angular/common/http';
import {TenantUpdateComponent} from "./tenant-update/tenant-update.component";

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    TenantRegisterComponent,
    LandlordRegisterComponent,
    SigninComponent,
    UserHomeComponent,
    TenantUpdateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
