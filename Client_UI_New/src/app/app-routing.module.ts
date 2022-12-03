import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LandlordRegisterComponent} from './landlord-register/landlord-register.component';
import {RegisterComponent} from './register/register.component';
import {SigninComponent} from './signin/signin.component';
import {TenantRegisterComponent} from './tenant-register/tenant-register.component';

const routes: Routes = [
  {component: RegisterComponent, path: ""},
  {component: LandlordRegisterComponent, path: "landlordRegister"},
  {component: TenantRegisterComponent, path: "tenantRegister"},
  {component: SigninComponent, path: "signin"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
