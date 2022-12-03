import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Landlord} from './landlord';

@Component({
  selector: 'app-landlord-register',
  templateUrl: './landlord-register.component.html',
  styleUrls: ['./landlord-register.component.css']
})
export class LandlordRegisterComponent implements OnInit {

  public landlord: Landlord;

  constructor(private httpClient: HttpClient) {
    this.landlord = new Landlord("", "", "", "");
  }

  ngOnInit(): void {
  }

  onRegister(name: string, password: string, email: string, phone: string) {
    let url1 = "http://127.0.0.1:8080/client/register";
    let url2 = "http://127.0.0.1:8080/landlord/insertLandlord";
    // const username = (<HTMLInputElement>document.getElementById('username')).value;
    // const password = (<HTMLInputElement>document.getElementById('password')).value;
    // const email = (<HTMLInputElement>document.getElementById('Email')).value;
    // const phone = (<HTMLInputElement>document.getElementById('lphone')).value;
    // this.landlord = new Landlord(username,
    //   password, email, phone);
    let params = new HttpParams()
    .append("name", name)
    .append("password", password)
    .append("email", email)
    .append("phone", phone);
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
