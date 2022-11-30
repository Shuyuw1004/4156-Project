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
  age :string = "";
  constellation :string = "";
  job :string = "";
  preferLocation :string = "";
  preferZipCode :string = "";
  preferType :string = "";
  expenditure :string = "";
  numOfRoomates :string = "";
  smoking :string = "";
  pet :string = "";
  cooking :string = "";
  tEarlyTimeSleep :string = "";
  tLateTimeSleep :string = "";
  uni :string = "";
  constructor() { }

  ngOnInit(): void {
  }

  onRegister () {
    let url1 = "http://127.0.0.1:8080/client/register";
    let url2 = "http://127.0.0.1:8080/tenant/insertTenant";
    this.username = (<HTMLInputElement>document.querySelector('[name="username"]')).value;
    this.password = (<HTMLInputElement>document.querySelector('[name="password"]')).value;
    this.email = (<HTMLInputElement>document.querySelector('[name="Email"]')).value;
    this.phone = (<HTMLInputElement>document.querySelector('[name="tPhone"]')).value;
    let gender_selector = document.querySelectorAll('[name="tGender"]'), igender;
    for (igender = 0; igender < gender_selector.length; igender++){
      let gender_element = <HTMLInputElement>gender_selector[igender];
      if (gender_element.checked === true){
        this.gender = gender_element.value;
      }
    }
    this.age = (<HTMLInputElement>document.querySelector('[name="tAge"]')).value;
    let constellation_selector = document.querySelectorAll('[name="constellation"]'), i;
    for (i = 0; i < constellation_selector.length; i++){
      let constellation_element = <HTMLInputElement>constellation_selector[i];
      if (constellation_element.checked === true){
        this.constellation = constellation_element.value;
      }
    }
    this.job = (<HTMLInputElement>document.querySelector('[name="tJob"]')).value;
    this.preferLocation = (<HTMLInputElement>document.querySelector('[name="tPreferLocation"]')).value;
    this.preferZipCode = (<HTMLInputElement>document.querySelector('[name="tPreferZipCode"]')).value;
    this.preferType = (<HTMLInputElement>document.querySelector('[name="tPreferType"]')).value;
    this.expenditure = (<HTMLInputElement>document.querySelector('[name="tExpenditure"]')).value;
    this.numOfRoomates = (<HTMLInputElement>document.querySelector('[name="tNumOfRoomates"]')).value;
    this.smoking = (<HTMLInputElement>document.querySelector('[name="tSmoking"]')).value;
    this.pet = (<HTMLInputElement>document.querySelector('[name="tPet"]')).value;
    this.cooking = (<HTMLInputElement>document.querySelector('[name="tCooking"]')).value;
    let tEarlyTimeSleep_selector = <HTMLInputElement>document.querySelector('[name="tEarlyTimeSleep"]');
    this.tEarlyTimeSleep = tEarlyTimeSleep_selector.value;
    let tLateTimeSleep_selector = <HTMLInputElement>document.querySelector('[name="tLateTimeSleep"]');
    this.tLateTimeSleep = tLateTimeSleep_selector.value;
    this.uni = (<HTMLInputElement>document.querySelector('[name="uni"]')).value;
    return false;

  }

}
