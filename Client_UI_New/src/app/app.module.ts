import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { TenantRegisterComponent } from './tenant-register/tenant-register.component';
import { LandlordRegisterComponent } from './landlord-register/landlord-register.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { SigninComponent } from './signin/signin.component';
import { HttpClientModule } from '@angular/common/http';
import {TenantUpdateComponent} from "./tenant-update/tenant-update.component";
import { RealtorRegisterComponent } from './realtor-register/realtor-register.component';
import { LandlordSigninComponent } from './landlord-signin/landlord-signin.component';
import { LandlordUserHomeComponent } from './landlord-user-home/landlord-user-home.component';
import { RealtorSigninComponent } from './realtor-signin/realtor-signin.component';
import { RealtorUserHomeComponent } from './realtor-user-home/realtor-user-home.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    TenantRegisterComponent,
    LandlordRegisterComponent,
    SigninComponent,
    UserHomeComponent,
    TenantUpdateComponent,
    RealtorRegisterComponent,
    LandlordSigninComponent,
    LandlordUserHomeComponent,
    RealtorSigninComponent,
    RealtorUserHomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
