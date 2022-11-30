import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams, HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-tenant-register',
  templateUrl: './tenant-register.component.html',
  styleUrls: ['./tenant-register.component.css']
})
export class TenantRegisterComponent implements OnInit {
  username :string = "";
  password :string = "";
  email :string = "";
  phone :string = "";
  gender :string = "";
  age :number = 0;
  constellation :string = "";
  job :string = "";
  preferLocation :string = "";
  preferZipCode :string = "";
  preferType :string = "";
  expenditure :number = 0;
  numOfRoomates :number = 0;
  smoking :string = "";
  pet :string = "";
  cooking :string = "";
  tEarlyTimeSleep :string = "";
  tLateTimeSleep :string = "";
  uni :string = "";
  constructor() { }

  ngOnInit(): void {
  }
  parseRadio(names :string)  : string {
    let selector = document.querySelectorAll('[name=' + names + ']'), igender;
    for (igender = 0; igender < selector.length; igender++){
      let gender_element = <HTMLInputElement>selector[igender];
      if (gender_element.checked === true){
        return gender_element.value;
      }
    }
    return "";
  }
  onRegister () {
    let url1 = "http://127.0.0.1:8080/client/register";
    let url2 = "http://127.0.0.1:8080/tenant/insertTenant";
    this.username = (<HTMLInputElement>document.querySelector('[name="username"]')).value;
    this.password = (<HTMLInputElement>document.querySelector('[name="password"]')).value;
    this.email = (<HTMLInputElement>document.querySelector('[name="Email"]')).value;
    this.phone = (<HTMLInputElement>document.querySelector('[name="tPhone"]')).value;
    this.gender = this.parseRadio("tGender");
    this.age = (<HTMLInputElement>document.querySelector('[name="tAge"]')).valueAsNumber;
    this.constellation = this.parseRadio("constellation");
    this.job = (<HTMLInputElement>document.querySelector('[name="tJob"]')).value;
    this.preferLocation = (<HTMLInputElement>document.querySelector('[name="tPreferLocation"]')).value;
    this.preferZipCode = (<HTMLInputElement>document.querySelector('[name="tPreferZipCode"]')).value;
    this.preferType = this.parseRadio("tPreferType");
    this.expenditure = (<HTMLInputElement>document.querySelector('[name="tExpenditure"]')).valueAsNumber;
    this.numOfRoomates = (<HTMLInputElement>document.querySelector('[name="tNumOfRoomates"]')).valueAsNumber;
    this.smoking = this.parseRadio(("tSmoking"));
    this.pet = this.parseRadio(("tPet"));
    this.cooking = this.parseRadio(("tCooking"));
    let tEarlyTimeSleep_selector = <HTMLInputElement>document.querySelector('[name="tEarlyTimeSleep"]');
    this.tEarlyTimeSleep = tEarlyTimeSleep_selector.value;
    let tLateTimeSleep_selector = <HTMLInputElement>document.querySelector('[name="tLateTimeSleep"]');
    this.tLateTimeSleep = tLateTimeSleep_selector.value;
    this.uni = (<HTMLInputElement>document.querySelector('[name="uni"]')).value;
    console.log(this);
    return false;

  }

}
