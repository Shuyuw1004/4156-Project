import { TenantRegisterComponent } from './tenant-register/tenant-register.component';
import { TenantUpdateComponent } from './tenant-update/tenant-update.component';
import { UserHomeComponent} from "./user-home/user-home.component";
import {RealtorRegisterComponent} from "./realtor-register/realtor-register.component";
import {RealtorSigninComponent} from "./realtor-signin/realtor-signin.component";
import {RealtorUserHomeComponent} from "./realtor-user-home/realtor-user-home.component";
import {LandlordSigninComponent} from "./landlord-signin/landlord-signin.component";
import {LandlordUserHomeComponent} from "./landlord-user-home/landlord-user-home.component";
import {SigninComponent} from "./signin/signin.component";
import {RegisterComponent} from "./register/register.component";
import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {LandlordRegisterComponent} from "./landlord-register/landlord-register.component";

const routes: Routes = [
  { component: RegisterComponent, path: "" },
  { component: LandlordRegisterComponent, path: "landlordRegister" },
  { component: LandlordSigninComponent, path: "landlordSignin"},
  { component: LandlordUserHomeComponent, path: "landlordUserHome"},
  { component: TenantRegisterComponent, path: "tenantRegister" },
  { component: RealtorRegisterComponent, path: "realtorRegister"},
  { component: RealtorSigninComponent, path: "realtorSignin"},
  { component: RealtorUserHomeComponent, path: "realtorUserHome"},
  { component: SigninComponent, path: "signin"},
  { component: UserHomeComponent, path: "userHome"},
  { component: TenantUpdateComponent, path: "tenantUpdate"}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
