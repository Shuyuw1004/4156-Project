import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams, HttpResponse} from "@angular/common/http";
import { Landlord } from './landlord';
@Component({
  selector: 'app-landlord-register',
  templateUrl: './landlord-register.component.html',
  styleUrls: ['./landlord-register.component.css']
})
export class LandlordRegisterComponent implements OnInit {

  public landlord: Landlord;
  showLog: boolean = false;
  ErrorLog :string = "";


  constructor(private httpClient: HttpClient) {
    this.landlord = new Landlord("", "", "", "");
  }

  ngOnInit(): void {
  }

  onRegister(name:string, password:string, email:string, phone:string) {
    let url1 = "http://127.0.0.1:8080/client/register";
    let url2 = "http://127.0.0.1:8080/landlord/insertLandlord";
    let params1 = new HttpParams()
                      .append("name", name)
                      .append("password", password)
                      .append("email", email);
    this.httpClient.post(url1,"",{params: params1, observe: 'body', responseType: 'text'}).subscribe(
      (data:string) => {
        console.log(data);
        let params2 = new HttpParams()
          .append("lClientId", data)
          .append("lPhone", phone);
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
