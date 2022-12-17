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

  showLog: boolean = false;
  ErrorLog :string = "";
  constructor(private httpClient: HttpClient) {
    this.realtor = new Realtor("", "", "");
  }

  ngOnInit(): void {
  }

  onRegister() {
    let url1 = "http://127.0.0.1:8080/client/register";
    const username = (<HTMLInputElement>document.getElementById('username')).value;
    const password = (<HTMLInputElement>document.getElementById('password')).value;
    const email = (<HTMLInputElement>document.getElementById('Email')).value;

    let params = new HttpParams()
      .append("name", username)
      .append("password", password)
      .append("email", email);
    this.httpClient.post(url1, "", {params: params}).subscribe({
      next: next => {
        this.ErrorLog = "registration successful!";
        window.location.replace("http://127.0.0.1:4200");
      },
      error: error => this.ErrorLog = error.error
    });
    this.showLog = true;
    return false;
  }
}
