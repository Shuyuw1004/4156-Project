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
  showLog: boolean = false;
  ErrorLog :string = "";
  constructor(private httpClient: HttpClient) { }

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

    let params1 = new HttpParams()
      .append("name", this.username)
      .append("password", this.password)
      .append("email", this.email);
    this.httpClient.post(url1,"",{params: params1, observe: 'body', responseType: 'text'}).subscribe(
      (data:string) => {
        console.log(data);
        let params2 = new HttpParams()
          .append("lClientId", data)
          .append("tAge", this.age)
          .append("tConstellation", this.constellation)
          .append("tCooking", this.cooking)
          .append("tEarlyTimeSleep", this.tEarlyTimeSleep)
          .append("tExpenditure", this.expenditure)
          .append("tGender", this.gender)
          .append("tJob", this.job)
          .append("tLateTimeSleep", this.tLateTimeSleep)
          .append("tNumOfRoomates", this.numOfRoomates)
          .append("tPet", this.pet)
          .append("tPhone", this.phone)
          .append("tPreferLocation", this.preferLocation)
          .append("tPreferType", this.preferType)
          .append("tPreferZipCode", this.preferZipCode)
          .append("tSmoking", this.smoking);

        ;
        this.httpClient.post(url2, "",{params: params2, observe: 'body', responseType: 'text'}).subscribe({
          next: next => {
            this.ErrorLog = "registration successful!";
            window.location.replace("http://127.0.0.1:4200");
          },
          error: error => this.ErrorLog = error.error
        });
      },
      error => this.ErrorLog = error.error);

    this.showLog = true;
    return false;

  }

}
