import {Component, OnInit} from '@angular/core';
import {Realtor} from "../realtor-register/realtor";
import {HttpClient, HttpParams} from "@angular/common/http";

@Component({
  selector: 'app-realtor-register',
  templateUrl: './realtor-register.component.html',
  styleUrls: ['./realtor-register.component.css']
})
export class RealtorRegisterComponent implements OnInit {

  public realtor: Realtor;

  constructor(private httpClient: HttpClient) {
    this.realtor = new Realtor("", "", "");
  }

  ngOnInit(): void {
  }

  onRegister(name: string, password: string, email: string) {
    let url1 = "http://127.0.0.1:8080/client/register";
    let url2 = "http://127.0.0.1:8080/realtor/insertRealtor";
    // const username = (<HTMLInputElement>document.getElementById('username')).value;
    // const password = (<HTMLInputElement>document.getElementById('password')).value;
    // const email = (<HTMLInputElement>document.getElementById('Email')).value;
    // const phone = (<HTMLInputElement>document.getElementById('lphone')).value;
    // this.landlord = new Landlord(username,
    //   password, email, phone);
    let params = new HttpParams()
      .append("name", name)
      .append("password", password)
      .append("email", email);
    console.log();
    this.httpClient.post(url1, "", {params: params}).subscribe({
      next: next => console.log("Success!", next),
      error: error => console.log("Error!", error)
    });
    this.httpClient.post(url2, "", {params: params}).subscribe({
      next: next => console.log("Success!", next),
      error: error => console.log("Error!", error)
    });
  }
}
